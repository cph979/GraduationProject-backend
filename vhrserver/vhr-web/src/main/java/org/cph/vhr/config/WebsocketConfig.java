package org.cph.vhr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @author cph
 * @date 2021/02/24
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {
	/**
	 * 注册连接点，websocket连接服务端先建立连接，即为此点
	 *
	 * @param registry
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws/emp").setAllowedOrigins("http://localhost:8089").withSockJS();
	}


	/**
	 * 配置消息代理
	 *
	 * @param registry
	 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// 消息代理前缀，如果发送的消息的前缀为queue，那么这个消息就会转发给代理，代理将消息发送给连接的客户端
		registry.enableSimpleBroker("/queue");
	}
}
