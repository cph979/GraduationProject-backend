package org.cph.vhr.web;

import org.cph.vhr.config.VerificationCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author cph
 * @date 2021/02/25
 */
@RestController
public class LoginController {
	/**
	 * 提供验证码，无需被security拦截
	 *
	 * @param session
	 * @param resp
	 * @throws IOException
	 */
	@GetMapping("/verify")
	public void verifyCode(HttpSession session, HttpServletResponse resp) throws IOException {
		VerificationCode code = new VerificationCode();
		// 获取图片
		BufferedImage image = code.getImage();
		// 获取图片上的文本
		String text = code.getText();
		session.setAttribute("verify_code", text);
		// 图片写出
		VerificationCode.output(image, resp.getOutputStream());
	}
}
