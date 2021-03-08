package org.cph.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.cph.vhr.model.JobLevel;

import java.util.List;

public interface JobLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobLevel record);

    int insertSelective(JobLevel record);

    JobLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobLevel record);

    int updateByPrimaryKey(JobLevel record);

    List<JobLevel> getAllJobLevels(Boolean enabled);

    Integer deleteJobLevels(@Param("ids") Integer[] ids);

    JobLevel getJobLevel(@Param("jobLevel") JobLevel jobLevel);
}