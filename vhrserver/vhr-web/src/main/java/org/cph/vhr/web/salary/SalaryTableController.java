package org.cph.vhr.web.salary;

import org.cph.vhr.model.RespBean;
import org.cph.vhr.model.SalaryTable;
import org.cph.vhr.service.SalaryTableService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 工资表详情处理器
 *
 * @author cph
 * @date 2021/03/19
 */
@RestController
@RequestMapping("/salary/table")
public class SalaryTableController {
	@Resource
	SalaryTableService salaryTableService;

	/**
	 * 获取工资表详情
	 *
	 * @return
	 */
	@GetMapping
	public RespBean getSalaryTables() {
		List<SalaryTable> listSalaryTables = salaryTableService.listSalaryTables();
		return RespBean.ok(null, listSalaryTables);
	}

	/**
	 * 删除工资表一条记录
	 *
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}/{eid}")
	public RespBean deleteSalaryTable(@PathVariable Integer id, @PathVariable Integer eid) {
		if (salaryTableService.deleteSalaryTable(id, eid)) {
			return RespBean.ok("删除成功");
		}
		return RespBean.error("删除失败");
	}

	/**
	 * 更新工资表
	 *
	 * @param salaryTable
	 * @return
	 */
	@PutMapping
	public RespBean updateSalaryTable(@RequestBody SalaryTable salaryTable) {
		if (salaryTableService.updateSalaryTable(salaryTable) == 1) {
			return RespBean.ok("更新成功");
		}
		return RespBean.error("更新失败");
	}
}
