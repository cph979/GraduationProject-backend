package org.cph.vhr.mapper;

import org.apache.ibatis.annotations.Select;
import org.cph.vhr.model.Salary;

import java.util.List;

public interface SalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);

	List<Salary> listSalaries();

	@Select("select * from salary where id = #{sid}")
	Salary getSalary(Integer sid);
}