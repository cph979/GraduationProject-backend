package org.cph.vhr.web.system.basic;

import org.cph.vhr.model.Department;
import org.cph.vhr.model.RespBean;
import org.cph.vhr.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cph
 * @date 2021/01/12
 */
@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {
	@Resource
	DepartmentService departmentService;

	/**
	 * 递归查询部门，使用mybatis的分步查询，根据父id查询部门再根据查询出的id嵌套查询
	 * @return
	 */
	@GetMapping
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}

	/**
	 * 添加部门
	 * 1、添加：部门名、父部门id添加，自动生成id，enabled改为true，如果添加则父部门isPrent为true，代表有子部门
	 * 2、更新：查询父部门depPath再追加生成的id更新到新加的部门depPath
	 * @param department 部门对象
	 * @return
	 */
	@PostMapping
	public RespBean addDepartment(@RequestBody Department department) {
		Department newDepartment = departmentService.addDepartment(department);
		if (newDepartment != null) {
			return RespBean.ok("添加成功", newDepartment);
		}
		return RespBean.error("添加失败");
	}

	@DeleteMapping("/{id}")
	public RespBean deleteDepartment(@PathVariable Integer id) {
		Integer result = departmentService.deleteDepartment(id);
		if (result == -2) {
			return RespBean.error("该部门下有子部门，删除失败");
		}
		if (result == -1) {
			return RespBean.error("该部门下有员工，删除失败");
		}
		if (result == 1) {
			return RespBean.ok("删除成功");
		}
		return RespBean.error("删除失败");
	}
}
