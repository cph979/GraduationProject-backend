package org.cph.vhr.service;

import org.cph.vhr.mapper.JobLevelMapper;
import org.cph.vhr.model.JobLevel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author cph
 * @create 2020-12-14 13:56
 */
@Service
public class JobLevelService {
    @Resource
    JobLevelMapper jobLevelMapper;

    public List<JobLevel> getAllJobLevels() {
        return jobLevelMapper.getAllJobLevels(null);
    }

    public List<JobLevel> getAllEnabledPositions(Boolean enabled) {
        return jobLevelMapper.getAllJobLevels(enabled);
    }

    public Integer addJobLevel(JobLevel jobLevel) {
        jobLevel.setCreateDate(new Date());
        jobLevel.setEnabled(true);
        return jobLevelMapper.insertSelective(jobLevel);
    }

    public Integer updateJobLevel(JobLevel jobLevel) {
        return jobLevelMapper.updateByPrimaryKeySelective(jobLevel);
    }

    public Integer deleteJobLevel(Integer id) {
        return jobLevelMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteJobLevels(Integer[] ids) {
        return jobLevelMapper.deleteJobLevels(ids);
    }

    public JobLevel getJobLevelByNameAndTitleLevel(JobLevel jobLevel) {
        return jobLevelMapper.getJobLevel(jobLevel);
    }

    public JobLevel getJobLevelByNameAndTitleLevelAndStatus(JobLevel jobLevel) {
        return jobLevelMapper.getJobLevel(jobLevel);
    }
}
