package org.cph.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.cph.vhr.model.EmployeeTrain;

import java.util.List;

public interface EmployeeTrainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeTrain record);

    int insertSelective(EmployeeTrain record);

    EmployeeTrain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeeTrain record);

    int updateByPrimaryKey(EmployeeTrain record);

    @Select("SELECT et.*,e.name,e.workID FROM employeetrain et inner join employee e on et.eid = e.id")
    List<EmployeeTrain> getAllEmployeeTrains();

    @Select("select * from employeetrain where eid = #{eid} and trainContent = #{trainContent}")
    EmployeeTrain getEmployeeTrainByEidAndTrainContent(Integer eid, String trainContent);

    Integer deleteEmployeeTrains(@Param("ids") Integer[] ids);
}