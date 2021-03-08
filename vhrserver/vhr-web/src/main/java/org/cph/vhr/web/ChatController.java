package org.cph.vhr.web;

import org.cph.vhr.model.Hr;
import org.cph.vhr.service.HrService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cph
 * @date 2021/02/24
 */
@RestController
@RequestMapping("/chat")
public class ChatController {
	@Resource
	HrService hrService;

	/**
	 * 获取除了自己的所有用户
	 *
	 * @return
	 */
	@GetMapping("/hrs")
	public List<Hr> listHrs() {
		return hrService.getAllHr(null);
	}
}
