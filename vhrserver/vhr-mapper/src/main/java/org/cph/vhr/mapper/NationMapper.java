package org.cph.vhr.mapper;

import org.apache.ibatis.annotations.Select;
import org.cph.vhr.model.Nation;

import java.util.List;

public interface NationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Nation record);

    int insertSelective(Nation record);

    Nation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Nation record);

    int updateByPrimaryKey(Nation record);

    @Select("select * from nation")
    List<Nation> getAllNations();
}