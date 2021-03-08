package org.cph.vhr.mapper;

import org.apache.ibatis.annotations.Select;
import org.cph.vhr.model.PoliticsStatus;

import java.util.List;

public interface PoliticsStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PoliticsStatus record);

    int insertSelective(PoliticsStatus record);

    PoliticsStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PoliticsStatus record);

    int updateByPrimaryKey(PoliticsStatus record);

    @Select("select * from politicsstatus")
    List<PoliticsStatus> getAllPoliticsStatus();
}