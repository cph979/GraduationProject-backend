package org.cph.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.cph.vhr.model.EmployeeEC;

import java.util.List;

public interface EmployeeECMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeEC record);

    int insertSelective(EmployeeEC record);

    EmployeeEC selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeeEC record);

    int updateByPrimaryKey(EmployeeEC record);

    @Select("SELECT ec.*,e.NAME,e.workID FROM `employeeec` ec INNER JOIN employee e ON ec.eid = e.id")
    List<EmployeeEC> getAllEmployeeECs();

    Integer deleteEmployeeECs(@Param("ids") Integer[] ids);

    @Select("select * from employeeec where eid = #{eid} and ecReason = #{ecReason}")
    EmployeeEC getEmpECByEidAndECReason(Integer eid, String ecReason);
}