package org.cph.mailserver.config;

import org.cph.vhr.model.MailConstants;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cph
 * @date 2021/02/23
 */
@Configuration
public class RabbitMQConfig {
	@Bean
	Queue queue() {
		return new Queue(MailConstants.MAIL_QUEUE_NAME);
	}
}
