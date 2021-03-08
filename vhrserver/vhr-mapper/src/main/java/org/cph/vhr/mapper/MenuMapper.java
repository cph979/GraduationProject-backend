package org.cph.vhr.mapper;

import org.apache.ibatis.annotations.Select;
import org.cph.vhr.model.Menu;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getMenusById(Integer hrId);

    List<Menu> getAllMenusWithRole();

    List<Menu> getAllMenus();

    @Select("select mid from menu_role where rid = #{rid}")
    List<Integer> getAllMidByRid(Integer rid);
}