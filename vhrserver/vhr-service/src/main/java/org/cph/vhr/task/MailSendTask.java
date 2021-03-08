package org.cph.vhr.task;

import org.cph.vhr.model.Employee;
import org.cph.vhr.model.MailConstants;
import org.cph.vhr.model.MailSendLog;
import org.cph.vhr.service.EmployeeService;
import org.cph.vhr.service.MailSendLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 定时任务不停的查看发送失败的消息，拿出来再度投递
 *
 * @author cph
 * @date 2021/02/27
 */
@Component
public class MailSendTask {
	private static final Logger LOGGER = LoggerFactory.getLogger(MailSendTask.class);

	@Resource
	MailSendLogService mailSendLogService;
	@Resource
	RabbitTemplate rabbitTemplate;
	@Resource
	EmployeeService employeeService;

	/**
	 * 每隔十秒执行一次
	 */
	@Scheduled(cron = "0/10 * * * * ?")
	public void mailReSendTask() {
		// 查看一直在发送，并且超过1min的还未投递的消息
		List<MailSendLog> mailSendLogs = mailSendLogService.listMailSendLogByStatus();
		if (mailSendLogs == null || mailSendLogs.isEmpty()) {
			return;
		}
		mailSendLogs.forEach(mailSendLog -> {
			String msgId = mailSendLog.getMsgId();
			if (mailSendLog.getCount() >= 3) {
				// 如果重试次数>=3，更改消息状态，发送失败
				mailSendLogService.updateMailSendLogStatus(msgId, 2);
			} else {
				// 消息重发，重试次数+1
				mailSendLogService.updateMainSendLogCount(msgId, new Date());
				Employee employee = employeeService.getEmployeesById(mailSendLog.getEmpId());
				rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME, MailConstants.MAIL_ROUTING_KEY_NAME, employee, new CorrelationData(mailSendLog.getMsgId()));
			}
		});
	}
}
