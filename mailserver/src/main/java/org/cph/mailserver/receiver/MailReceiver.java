package org.cph.mailserver.receiver;

import com.rabbitmq.client.Channel;
import org.cph.vhr.model.Employee;
import org.cph.vhr.model.MailConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;

/**
 * @author cph
 * @date 2021/02/23
 */
@Component
public class MailReceiver {
	private static final Logger LOGGER = LoggerFactory.getLogger(MailReceiver.class);

	@Resource
	private JavaMailSender javaMailSender;
	@Resource
	private MailProperties mailProperties;
	@Resource
	private TemplateEngine templateEngine;
	@Resource
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * 存在重复消费的情况，收到多次仍然只收一封邮件
	 *
	 * @param message 封装员工对象和消息id
	 * @param channel 改为手动确定消息的接收，默认自动确认消息
	 */
	@RabbitListener(queues = MailConstants.MAIL_QUEUE_NAME)
	public void handler(Message message, Channel channel) throws IOException {
		Employee employee = (Employee) message.getPayload();
		MessageHeaders headers = message.getHeaders();
		// 消息标记，用来确认消息
		Long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
		// 消息id
		String msgId = (String) headers.get("spring_returned_message_correlation");
		if (stringRedisTemplate.opsForHash().entries("mail_log").containsKey(msgId)) {
			// 如果redis存在此key说明该消息已被消费
			LOGGER.info(msgId + "：消息已经被消费");
			// 如果不消费此条消息又会回到队列所以需要手动确认
			channel.basicAck(tag, false);
			return;
		}
		LOGGER.info(employee.toString());
		// 消费者收到消息，发送邮件
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg);
		try {
			helper.setSubject("入职欢迎");
			helper.setFrom(mailProperties.getUsername());
			helper.setTo(employee.getEmail());
			helper.setSentDate(new Date());
			Context context = new Context();
			context.setVariable("name", employee.getName());
			context.setVariable("posName", employee.getPosition().getName());
			context.setVariable("jobLevelName", employee.getJobLevel().getName());
			context.setVariable("departmentName", employee.getDepartment().getName());
			String mail = templateEngine.process("mail", context);
			helper.setText(mail, true);
			javaMailSender.send(msg);

			stringRedisTemplate.opsForHash().put("mail_log", msgId, "uselessMsg");
			LOGGER.info(msgId + "：邮件发送成功");

			channel.basicAck(tag, false);
		} catch (MessagingException e) {
			e.printStackTrace();
			channel.basicNack(tag, false, true);
			LOGGER.error("邮件发送失败：" + e.getMessage());
		}

	}
}
