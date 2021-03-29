package org.cph.vhr.web.personnel;

import org.cph.vhr.annotations.Encrypt;
import org.cph.vhr.model.EmployeeEC;
import org.cph.vhr.model.RespBean;
import org.cph.vhr.service.EmployeeECService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工奖惩CRUD
 * @author cph
 * @date 2020/12/15
 */
@RestController
@RequestMapping("/personnel/ec")
public class EmployeeECController {
    @Resource
    EmployeeECService employeeECService;

    @GetMapping
    @Encrypt
    public RespBean getAllEmployeeECs() {
        List<EmployeeEC> employeeECs = employeeECService.getAllEmployeeECs();
        return RespBean.build().setStatus(200).setObj(employeeECs).setEncryptStatus(true);
    }

    @PostMapping
    public RespBean addEmployeeEC(@RequestBody EmployeeEC employeeEC) {
        if (employeeECService.getEmpECByEidAndECReason(employeeEC.getEid(), employeeEC.getEcReason()) != null) {
            return RespBean.error("已存在该员工相同奖惩原因的记录");
        }
        if (employeeECService.addEmployeeEC(employeeEC) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping
    public RespBean updateEmployeeEC(@RequestBody EmployeeEC employeeEC) {
        if (employeeECService.updateEmployeeEC(employeeEC) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmployeeEC(@PathVariable Integer id) {
        if (employeeECService.deleteEmployeeEC(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping
    public RespBean deleteEmployeeECs(@RequestBody Integer[] ids) {
        if (employeeECService.deleteEmployeeECs(ids) == ids.length) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
