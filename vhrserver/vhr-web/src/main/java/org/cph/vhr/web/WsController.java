package org.cph.vhr.web;

import org.cph.vhr.model.ChatMsg;
import org.cph.vhr.model.Hr;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.Date;

/**
 * @author cph
 * @date 2021/02/24
 */
@Controller
public class WsController {
	@Resource
	SimpMessagingTemplate simpMessagingTemplate;

	/**
	 * 处理消息
	 *
	 * @param authentication 登录身份信息，目的获取当前登录用户
	 * @param chatMsg 聊天对象
	 */
	@MessageMapping("/ws/chat")
	public void handleMsg(Authentication authentication, ChatMsg chatMsg) {
		Hr hr = (Hr) authentication.getPrincipal();
		chatMsg.setFrom(hr.getUsername());
		chatMsg.setName(hr.getName());
		chatMsg.setDate(new Date());
		simpMessagingTemplate.convertAndSendToUser(chatMsg.getTo(), "/queue/chat", chatMsg);
	}
}
