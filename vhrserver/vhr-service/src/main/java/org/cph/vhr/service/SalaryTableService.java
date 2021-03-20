package org.cph.vhr.service;

import org.cph.vhr.mapper.EmpSalaryMapper;
import org.cph.vhr.mapper.SalaryMapper;
import org.cph.vhr.mapper.SalaryTableMapper;
import org.cph.vhr.model.Salary;
import org.cph.vhr.model.SalaryTable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cph
 * @date 2021/03/19
 */
@Service
public class SalaryTableService {
	@Resource
	private SalaryTableMapper salaryTableMapper;
	@Resource
	private EmpSalaryMapper empSalaryMapper;
	@Resource
	SalaryMapper salaryMapper;

	public void saveSalaryTable(SalaryTable salaryTable) {
		salaryTableMapper.saveSalaryTable(salaryTable);
	}

	public List<SalaryTable> listSalaryTables() {
		return salaryTableMapper.listSalaryTables();
	}

	/**
	 * 一同删除empsalary表的记录
	 *
	 * @param id
	 * @param eid
	 * @return
	 */
	public Boolean deleteSalaryTable(Integer id, Integer eid) {
		empSalaryMapper.deleteEmpSalaryByEid(eid);
		return salaryTableMapper.deleteSalaryTable(id) == 1;
	}

	public Integer updateSalaryTable(SalaryTable salaryTable) {
		Integer sid = salaryTable.getSid();
		Salary salary = salaryMapper.getSalary(sid);
		Integer pensionBase = salary.getPensionBase();
		Float pensionPer = salary.getPensionPer();
		Integer medicalBase = salary.getMedicalBase();
		Float medicalPer = salary.getMedicalPer();
		Integer accumulationFundBase = salary.getAccumulationFundBase();
		Float accumulationFundPer = salary.getAccumulationFundPer();

		Integer basicSalary = salaryTable.getBasicSalary();
		Integer bonus = salaryTable.getBonus();
		Integer lunchSalary = salaryTable.getLunchSalary();
		Integer trafficSalary = salaryTable.getTrafficSalary();
		// 计算总工资
		Float allSalary = new EmployeeService().calculateSalary(basicSalary, bonus, lunchSalary, trafficSalary, pensionBase,
				pensionPer, medicalBase, medicalPer, accumulationFundBase, accumulationFundPer);

		salaryTable.setAllSalary(allSalary);
		return salaryTableMapper.updateSalaryTable(salaryTable);
	}
}
