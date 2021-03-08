package org.cph.vhr.web.system.basic;

import org.cph.vhr.model.Position;
import org.cph.vhr.model.RespBean;
import org.cph.vhr.service.EmployeeService;
import org.cph.vhr.service.PositionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cph
 * @date 2020/12/11
 */
@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {
    @Resource
    PositionService positionService;
    @Resource
    EmployeeService employeeService;

    @GetMapping
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @PostMapping
    public RespBean addPosition(@RequestBody Position position) {
        if (positionService.getPositionByName(position) != null) {
            return RespBean.error("职位名重复");
        }
        if (positionService.addPosition(position) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping
    public RespBean updatePosition(@RequestBody Position position) {
        if (positionService.getPositionByNameAndStatus(position) != null) {
            return RespBean.error("职位名重复");
        }
        if (employeeService.getEmployeeCountByPosId(position.getId()) > 0) {
            return RespBean.error("该职位已经存在员工，禁用失败");
        }
        if (positionService.updatePosition(position) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable Integer id) {
        if (positionService.deletePosition(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping
    public RespBean deletePositions(@RequestBody Integer[] ids) {
        if (positionService.deletePositions(ids) == ids.length) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
