package org.cph.vhr.web.system.basic;

import org.cph.vhr.model.JobLevel;
import org.cph.vhr.model.RespBean;
import org.cph.vhr.service.EmployeeService;
import org.cph.vhr.service.JobLevelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cph
 * @date 2020/12/14
 * 职称管理CRUD
 */
@RestController
@RequestMapping("/system/basic/jobLevel")
public class JobLevelController {
    @Resource
    JobLevelService jobLevelService;
    @Resource
    EmployeeService employeeService;

    @GetMapping
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @PostMapping
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.getJobLevelByNameAndTitleLevel(jobLevel) != null) {
            return RespBean.error("职称数据重复");
        }
        if (jobLevelService.addJobLevel(jobLevel) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping
    public RespBean updateJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.getJobLevelByNameAndTitleLevelAndStatus(jobLevel) != null) {
            return RespBean.error("职称数据重复");
        }
        if (employeeService.getEmployeeCountByJobLevelId(jobLevel.getId()) > 0) {
            return RespBean.error("该职称已经存在员工，禁用失败");
        }
        if (jobLevelService.updateJobLevel(jobLevel) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteJobLevel(@PathVariable Integer id) {
        if (jobLevelService.deleteJobLevel(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping
    public RespBean deleteJobLevels(@RequestBody Integer[] ids) {
        if (jobLevelService.deleteJobLevels(ids) == ids.length) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
