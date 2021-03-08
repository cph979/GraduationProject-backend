package org.cph.vhr.web.personnel;

import org.cph.vhr.model.EmployeeTrain;
import org.cph.vhr.model.RespBean;
import org.cph.vhr.service.EmployeeTrainService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工培训CRUD
 * @author cph
 * @date 2020/12/24
 */
@RestController
@RequestMapping("/personnel/train")
public class EmployeeTrainController {
    @Resource
    EmployeeTrainService employeeTrainService;

    @GetMapping
    public List<EmployeeTrain> getAllEmployeeTrains() {
        return employeeTrainService.getAllEmployeeTrains();
    }

    @PostMapping
    public RespBean addEmployeeTrain(@RequestBody EmployeeTrain employeeTrain) {
        if (employeeTrainService.getEmployeeTrainByEidAndTrainContent(employeeTrain.getEid(), employeeTrain.getTrainContent()) != null) {
            return RespBean.error("已存在该员工相同培训内容的记录");
        }
        if (employeeTrainService.addEmployeeTrain(employeeTrain) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping
    public RespBean updateEmployeeTrain(@RequestBody EmployeeTrain employeeTrain) {
        if (employeeTrainService.getEmployeeTrainByEidAndTrainContent(employeeTrain.getEid(), employeeTrain.getTrainContent()) != null) {
            return RespBean.error("已存在该员工相同培训内容的记录");
        }
        if (employeeTrainService.updateEmployeeTrain(employeeTrain) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmployeeTrain(@PathVariable Integer id) {
        if (employeeTrainService.deleteEmployeeTrain(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping
    public RespBean deleteEmployeeECs(@RequestBody Integer[] ids) {
        if (employeeTrainService.deleteEmployeeTrains(ids) == ids.length) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
