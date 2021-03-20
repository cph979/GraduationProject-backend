package org.cph.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.cph.vhr.model.EmployeeRemove;

import java.util.List;

public interface EmployeeRemoveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeRemove record);

    int insertSelective(EmployeeRemove record);

    EmployeeRemove selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeeRemove record);

    int updateByPrimaryKey(EmployeeRemove record);

	List<EmployeeRemove> listEmployeeRemoves();

    Integer updateEmployeeRemove(@Param("employeeRemove") EmployeeRemove employeeRemove);

    void insertEmpRemove(@Param("employeeRemove") EmployeeRemove employeeRemove);
}