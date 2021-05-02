package org.cph.vhr.config;

import org.cph.vhr.model.MailConstants;
import org.cph.vhr.service.MailSendLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * 不用SpringBoot提供的rabbitTemplate发送模板，使用自己配置的消息发送模板
 *
 * @author cph
 * @date 2021/02/27
 */
@Configuration
public class RabbitConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitConfig.class);

	@Resource
	private CachingConnectionFactory cachingConnectionFactory;
	@Resource
	private MailSendLogService mailSendLogService;

	/**
	 * 当消息从这里发送到rabbitMQ上，如果这条消息被成功收到
	 * 那么rabbitMQ可以返回收到的确认
	 *
	 * @return
	 */
	@Bean
	RabbitTemplate rabbitTemplate() {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
		// ack为是否发送成功的标识
		rabbitTemplate.setConfirmCallback((data, ack, cause) -> { // 这个回调只能确保消息是否到达broker
			// 获得消息发送时消息的唯一id
			String msgId = data.getId();
			if (ack) {
				// 消息发送成功
				LOGGER.info(msgId + "：消息发送成功");
				// 更新消息状态表，mail_send_log
				mailSendLogService.updateMailSendLogStatus(msgId, 1);
			} else {
				LOGGER.info(msgId + "：消息发送失败");
			}
		});
		// 2.消息从交换机发送到队列失败
		rabbitTemplate.setReturnCallback((msg, repCode, repText, exchange, routingKey) -> { // 这个回调确保消息是否投递到队列里
			LOGGER.info("消息发送失败");
		});
		return rabbitTemplate;
	}

	@Bean
	Queue mailQueue() {
		return new Queue(MailConstants.MAIL_QUEUE_NAME, true);
	}

	@Bean
	DirectExchange mailExchange() {
		return new DirectExchange(MailConstants.MAIL_EXCHANGE_NAME, true, false);
	}

	/**
	 * 队列和交换机的绑定
	 *
	 * @return
	 */
	@Bean
	Binding mainBinding() {
		return BindingBuilder.bind(mailQueue()).to(mailExchange()).with(MailConstants.MAIL_ROUTING_KEY_NAME);
	}
}
