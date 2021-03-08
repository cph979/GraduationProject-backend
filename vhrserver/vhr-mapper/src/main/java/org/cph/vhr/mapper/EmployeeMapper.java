package org.cph.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.cph.vhr.model.Employee;
import org.cph.vhr.model.EmpOnlyHaveNameAndWorkID;
import org.cph.vhr.model.RespPageBean;

import java.util.Date;
import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> getEmployeesByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("employee") Employee employee,
                                      @Param("beginDateScope") Date[] beginDateScope);

    Long getAllCount(@Param("employee") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Integer deleteEmployees(@Param("ids") Integer[] ids);

    @Select("select max(workID) from employee")
    Integer getMaxWordID();

    @Select("select id,name,workID from employee")
    List<EmpOnlyHaveNameAndWorkID> getEmpWithNameAndWorkID();

    @Select("select count(*) from employee where departmentId = #{id}")
    Integer getEmployeeCountByDepartmentID(Integer id);

    @Select("select count(*) from employee where posId = #{id}")
	Integer getEmployeeCountByPosId(Integer id);

    @Select("select count(*) from employee where jobLevelId = #{id}")
    Integer getEmployeeCountByJobLevelId(Integer id);

	Integer saveEmployees(@Param("list") List<Employee> list);

	Employee getEmployeesById(Integer id);

    List<Employee> listEmployeesByPageWithSalary(@Param("page") Integer page, @Param("size") Integer size);

	Integer updateEmployeeWithSalary(@Param("eid") Integer eid, @Param("sid") Integer sid);

}