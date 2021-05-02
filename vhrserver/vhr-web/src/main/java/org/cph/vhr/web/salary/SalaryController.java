package org.cph.vhr.web.salary;

import org.cph.vhr.model.RespBean;
import org.cph.vhr.model.Salary;
import org.cph.vhr.service.SalaryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cph
 * @date 2021/02/23
 */
@RestController
@RequestMapping("/salary/sob")
public class SalaryController {
	@Resource
	private SalaryService salaryService;

	/**
	 * 查询全部工资套账
	 *
	 * @return
	 */
	@GetMapping
	public List<Salary> listSalaries() {
		return salaryService.listSalaries();
	}

	/**
	 * 添加单个套账
	 *
	 * @param salary 账套对象
	 * @return
	 */
	@PostMapping
	public RespBean insertSalary(@RequestBody Salary salary) {
		if (salaryService.insertSalary(salary) == 1) {
			return RespBean.ok("添加成功");
		}
		return RespBean.error("添加失败");
	}

	/**
	 * 删除单个工资账套
	 *
	 * @param id 账套id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public RespBean deleteSalary(@PathVariable Integer id) {
		if (salaryService.deleteSalary(id) == 1) {
			return RespBean.ok("删除成功");
		}
		return RespBean.error("删除失败");
	}

	@PutMapping
	public RespBean updateSalary(@RequestBody Salary salary) {
		if (salaryService.updateSalary(salary) == 1) {
			return RespBean.ok("更新成功");
		}
		return RespBean.error("更新失败");
	}
}
