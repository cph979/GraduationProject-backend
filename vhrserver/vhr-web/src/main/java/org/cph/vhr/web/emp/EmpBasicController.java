package org.cph.vhr.web.emp;

import org.cph.vhr.annotations.Encrypt;
import org.cph.vhr.model.*;
import org.cph.vhr.service.*;
import org.cph.vhr.utils.POIUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author cph
 * @date 2020/12/13
 */
@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {
    @Resource
    EmployeeService employeeService;
    @Resource
    PoliticsStatusService politicsStatusService;
    @Resource
    NationService nationService;
    @Resource
    PositionService positionService;
    @Resource
    JobLevelService jobLevelService;
    @Resource
    DepartmentService departmentService;

    @GetMapping
    @Encrypt
    public RespBean getEmployeesByPage(@RequestParam(defaultValue = "1") Integer page,
										   @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope) {
        Map employeesByPage = employeeService.getEmployeesByPage(page, size, employee, beginDateScope);
        return RespBean.build().setStatus(200).setObj(employeesByPage);
    }

    @PostMapping
    public RespBean addEmployee(@RequestBody Employee employee) {
        if (employeeService.addEmployee(employee) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping
    public RespBean updateEmployee(@RequestBody Employee employee) {
        if (employeeService.updateEmployee(employee) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmployee(@PathVariable Integer id) {
        if (employeeService.deleteEmployee(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping
    public RespBean deleteEmployees(@RequestBody Integer[] ids) {
        if (employeeService.deleteEmployees(ids) == ids.length) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @GetMapping("/politicsStatus")
    public List<PoliticsStatus> getAllPoliticsStatus() {
        return politicsStatusService.getAllPoliticsStatus();
    }

    @GetMapping("/nations")
    public List<Nation> getAllNations() {
        return nationService.getAllNations();
    }

    @GetMapping("/positions")
    public List<Position> getAllPositions(Boolean enabled) {
        if (enabled != null) {
            return positionService.getAllEnabledPositions(enabled);
        }
        return positionService.getAllPositions();
    }

    @GetMapping("/jobLevels")
    public List<JobLevel> getAllJobLevels(Boolean enabled) {
        if (enabled != null) {
            return jobLevelService.getAllEnabledPositions(enabled);
        }
        return jobLevelService.getAllJobLevels();
    }

    @GetMapping("/maxWorkID")
    public RespBean getMaxWordID() {
        return RespBean
                .build()
                .setStatus(200)
                .setObj(String.format("%08d", employeeService.getMaxWordID() + 1));
    }

    @GetMapping("/empWithNameAndWordID")
    public List<EmpOnlyHaveNameAndWorkID> getEmpWithNameAndWorkID() {
        return employeeService.getEmpWithNameAndWorkID();
    }

    /**
     * 以excel导出数据
     *
     * @return
     */
    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData() {
        // 先查询所有员工数据，再生成excel，返回指定对象
        List<Employee> list = (List<Employee>) employeeService.getEmployeesByPage(null, null, new Employee(), null).get("data");
        return POIUtils.employee2Excel(list);
    }

    /**
     * 前端导入excel分为三步:
     * 1、前端文件上传
     * 2、后端excel解析
     * 3、后端将解析后的数据存入数据库
     */

    /**
     * 前端文件上传处理接口
     *
     * @param file
     * @return
     */
    @PostMapping("/import")
    public RespBean importData(MultipartFile file) {
        List<Employee> list =  POIUtils.excel2Employee(file, nationService.getAllNations(), politicsStatusService.getAllPoliticsStatus(), departmentService.getAllDepartmentsWithOutChildren(), jobLevelService.getAllJobLevels(), positionService.getAllPositions());
        if (employeeService.saveEmployees(list) == list.size()) {
            return RespBean.ok("上传成功");
        }
        return RespBean.error("上传失败");
    }
}
