package org.cph.vhr.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.cph.vhr.model.MenuRole;

public interface MenuRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuRole record);

    int insertSelective(MenuRole record);

    MenuRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuRole record);

    int updateByPrimaryKey(MenuRole record);

	@Delete("delete from menu_role where rid = #{rid}")
	Integer deleteMenuRoleByRid(@Param("rid") Integer id);

	/**
	 * 保存menu_role的记录
	 * @param rid 角色id
	 * @param mid 菜单id数组
	 * @return
	 */
	Integer insertRecord(@Param("rid") Integer rid, @Param("mid") Integer[] mid);
}