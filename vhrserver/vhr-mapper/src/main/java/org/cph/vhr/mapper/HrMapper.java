package org.cph.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.cph.vhr.model.Role;
import org.cph.vhr.model.Hr;

import java.util.List;

public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(String username);

    @Select("select * from role where id in(select rid from hr_role where hrid = #{id})")
    List<Role> getHrRolesById(Integer id);

	List<Hr> getAllHr(@Param("id") Integer id, @Param("name") String name);

	@Update("update hr set password = #{password} where id = #{id}")
	Integer updateHrPwd(@Param("id") Integer id, @Param("password") String password);

	@Update("update hr set userface = #{url} where id = #{id}")
	Integer updateAvatarUrl(@Param("url") String url, @Param("id") Integer id);

	Hr getHrWithRoleById(Integer id);
}