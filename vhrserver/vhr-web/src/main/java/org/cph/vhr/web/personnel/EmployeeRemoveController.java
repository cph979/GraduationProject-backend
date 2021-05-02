package org.cph.vhr.web.personnel;

import org.cph.vhr.annotations.Encrypt;
import org.cph.vhr.model.EmployeeRemove;
import org.cph.vhr.model.RespBean;
import org.cph.vhr.service.EmployeeRemoveService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工调动
 *
 * @author cph
 * @date 2021/03/18
 */
@RestController
@RequestMapping("/personnel/remove")
public class EmployeeRemoveController {
	@Resource
	EmployeeRemoveService employeeRemoveService;

	/**
	 * 查询员工调动表
	 *
	 * @return
	 */
	@GetMapping
	@Encrypt
	public RespBean getEmployeeRemoves() {
		List<EmployeeRemove> listEmployeeRemoves =  employeeRemoveService.listEmployeeRemoves();
		return RespBean.build().setStatus(200).setObj(listEmployeeRemoves).setEncryptStatus(true);
	}

	/**
	 * 修改调动原因
	 *
	 * @return
	 */
	@PostMapping
	public RespBean updateEmployeeRemove(@RequestBody EmployeeRemove employeeRemove) {
		if (employeeRemoveService.updateEmployeeRemove(employeeRemove) == 1) {
			return RespBean.ok("更新成功");
		}
		return RespBean.error("更新失败");
	}

	/**
	 * 删除员工调动记录
	 *
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public RespBean deleteEmployeeRemove(@PathVariable Integer id) {
		if (employeeRemoveService.deleteEmployeeRemove(id) == 1) {
			return RespBean.ok("删除成功");
		}
		return RespBean.error("删除失败");
	}
}
