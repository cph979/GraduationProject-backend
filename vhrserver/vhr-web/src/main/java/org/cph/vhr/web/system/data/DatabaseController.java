package org.cph.vhr.web.system.data;

import org.cph.vhr.model.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据库备份还原
 *
 * @author cph
 * @date 2021/03/17
 */
@RestController
public class DatabaseController {
	@GetMapping("backup")
	public RespBean backupDatabase() {
		return null;
	}
}
