package org.cph.vhr.mapper;

import org.apache.ibatis.annotations.Delete;
import org.cph.vhr.model.EmpSalary;

public interface EmpSalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmpSalary record);

    int insertSelective(EmpSalary record);

    EmpSalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmpSalary record);

    int updateByPrimaryKey(EmpSalary record);

    @Delete("delete from empsalary where eid = #{eid}")
	void deleteEmpSalaryByEid(Integer eid);
}