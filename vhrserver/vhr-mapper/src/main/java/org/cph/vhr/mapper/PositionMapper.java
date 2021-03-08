package org.cph.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.cph.vhr.model.Position;

import java.util.List;

public interface  PositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    List<Position> getAllPositions(Boolean enabled);

    Integer deletePositions(@Param("ids") Integer[] ids);

	Position getPosition(@Param("position") Position position);
}