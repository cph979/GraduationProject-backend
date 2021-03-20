package org.cph.vhr.service;

import org.cph.vhr.mapper.EmployeeRemoveMapper;
import org.cph.vhr.model.EmployeeRemove;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cph
 * @date 2021/03/18
 */
@Service
public class EmployeeRemoveService {
	@Resource
	EmployeeRemoveMapper employeeRemoveMapper;

	public List<EmployeeRemove> listEmployeeRemoves() {
		return employeeRemoveMapper.listEmployeeRemoves();
	}

	public Integer updateEmployeeRemove(EmployeeRemove employeeRemove) {
		return employeeRemoveMapper.updateEmployeeRemove(employeeRemove);
	}

	public Integer deleteEmployeeRemove(Integer id) {
		return employeeRemoveMapper.deleteByPrimaryKey(id);
	}

	public void saveEmpRemove(EmployeeRemove employeeRemove) {
		employeeRemoveMapper.insertEmpRemove(employeeRemove);
	}
}
