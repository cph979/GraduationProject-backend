package org.cph.vhr.web.salary;

import org.cph.vhr.model.RespBean;
import org.cph.vhr.model.RespPageBean;
import org.cph.vhr.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author cph
 * @date 2021/02/23
 */
@RestController
@RequestMapping("/salary/sobcfg")
public class SobConfigController {
	@Resource
	EmployeeService employeeService;


	/**
	 * 查询员工工资账套
	 *
	 * @param page 页码
	 * @param size 页数
	 * @return
	 */
	@GetMapping
	public RespPageBean listEmployeesByPageWithSalary(@RequestParam(defaultValue = "1") Integer page,
													  @RequestParam(defaultValue = "10") Integer size) {
		return employeeService.listEmployeesByPageWithSalary(page, size);
	}

	/**
	 * 更新员工工资账套
	 *
	 * @param eid 员工id
	 * @param sid 账套表id
	 * @return
	 */
	@PutMapping
	public RespBean updateEmployeeWithSalary(Integer eid, Integer sid) {
		Integer result = employeeService.updateEmployeeWithSalary(eid, sid);
		if (result > 0) {
			return RespBean.ok("更新成功");
		}
		return RespBean.error("更新失败");
	}
}
