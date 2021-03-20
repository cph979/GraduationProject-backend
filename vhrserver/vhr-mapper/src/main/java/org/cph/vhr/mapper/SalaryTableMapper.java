package org.cph.vhr.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.cph.vhr.model.SalaryTable;

import java.util.List;

/**
 * @author cph
 * @date 2021/03/19
 */
public interface SalaryTableMapper {
	/**
	 * 工资表保存
	 *
	 * @param salaryTable
	 */
	void saveSalaryTable(@Param("salaryTable") SalaryTable salaryTable);

	/**
	 * 查询全部工资表
	 *
	 * @return
	 */
	List<SalaryTable> listSalaryTables();

	/**
	 * 根据id删除工资表一条记录
	 *
	 * @param id
	 * @return
	 */
	@Delete("delete from salarytable where id = #{id}")
	Integer deleteSalaryTable(Integer id);

	/**
	 * 选择性更新工资表
	 *
	 * @param salaryTable
	 * @return
	 */
	Integer updateSalaryTable(@Param("salaryTable") SalaryTable salaryTable);
}
