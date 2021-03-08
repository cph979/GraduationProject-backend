package org.cph.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.cph.vhr.model.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    @Select("select id, name, nameZh from role")
    List<Role> getAllRoles();

    @Select("select id, name, nameZh from role where nameZh = #{role.nameZh}")
    Role getRole(@Param("role") Role role);
}