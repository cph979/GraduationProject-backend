package org.cph.vhr.service;

import org.cph.vhr.mapper.SalaryMapper;
import org.cph.vhr.model.Salary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author cph
 * @date 2021/02/23
 */
@Service
public class SalaryService {
	@Resource
	SalaryMapper salaryMapper;

	public List<Salary> listSalaries() {
		return salaryMapper.listSalaries();
	}

	public Integer insertSalary(Salary salary) {
		salary.setCreateDate(new Date());
		return salaryMapper.insertSelective(salary);
	}

	public Integer deleteSalary(Integer id) {
		return salaryMapper.deleteByPrimaryKey(id);
	}

	public Integer updateSalary(Salary salary) {
		return salaryMapper.updateByPrimaryKeySelective(salary);
	}
}
