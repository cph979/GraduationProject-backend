package org.cph.vhr.service;

import org.cph.vhr.mapper.DepartmentMapper;
import org.cph.vhr.mapper.EmployeeMapper;
import org.cph.vhr.model.Department;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentService {
    @Resource
    DepartmentMapper departmentMapper;
    @Resource
	EmployeeMapper employeeMapper;

    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartmentsByParentId(-1);
    }

	/**
	 * 添加部门
	 * 1、添加：部门名、父部门id添加，自动生成id，enabled改为true，如果添加则父部门isPrent为true，代表有子部门
	 * 2、更新：查询父部门depPath再追加生成的id更新到新加的部门depPath
	 * @param department 部门对象
	 * @return
	 */
	@Transactional
	public Department addDepartment(Department department) {
		// 查询父部门记录
		Department parentDept = departmentMapper.selectByPrimaryKey(department.getParentId());
		// 新增部门
		department.setEnabled(true);
		department.setParent(false);
		departmentMapper.insertSelective(department);
		// 更新新部门depPath
		department.setDepPath(parentDept.getDepPath() + "." + department.getId());
		departmentMapper.updateByPrimaryKeySelective(department);
		// 更新父部门isParent为true
		parentDept.setParent(true);
		departmentMapper.updateByPrimaryKeySelective(parentDept);
		return department;
	}

	public Integer deleteDepartment(Integer id) {
		Department currentDepartment = departmentMapper.selectByPrimaryKey(id);
		Boolean isParent = currentDepartment.getParent();
		Integer parentId = currentDepartment.getParentId();
		if (isParent) {
			return -2;
		}
		if (employeeMapper.getEmployeeCountByDepartmentID(id) > 0) {
			return -1;
		}
		int result = departmentMapper.deleteByPrimaryKey(id);
		// 当删除只剩下一个父部门时，父部门成为子部门，否则前端删不掉
		if (departmentMapper.selectDepartmentByParentId(parentId) == 0) {
			departmentMapper.updateByParentId(parentId);
		}
		return result;
	}

	public List<Department> getAllDepartmentsWithOutChildren() {
		return departmentMapper.getAllDepartmentsWithOutChildren();
	}
}
