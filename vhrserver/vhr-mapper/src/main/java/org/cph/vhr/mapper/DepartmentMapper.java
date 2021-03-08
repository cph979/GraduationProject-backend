package org.cph.vhr.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.cph.vhr.model.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getAllDepartmentsByParentId(Integer pid);

    @Select("select count(*) from department where parentId = #{parentId}")
    Integer selectDepartmentByParentId(Integer parentId);

    @Update("update department set isParent = 0 where id = #{parentId}")
    void updateByParentId(Integer parentId);

    @Select("select id, name from department")
	List<Department> getAllDepartmentsWithOutChildren();
}