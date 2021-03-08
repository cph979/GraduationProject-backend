package org.cph.vhr.service;

import org.cph.vhr.mapper.EmployeeTrainMapper;
import org.cph.vhr.model.EmployeeTrain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author cph
 * @create 2020-12-24 10:17
 */
@Service
public class EmployeeTrainService {
    @Resource
    EmployeeTrainMapper employeeTrainMapper;

    public List<EmployeeTrain> getAllEmployeeTrains() {
        return employeeTrainMapper.getAllEmployeeTrains();
    }

    public EmployeeTrain getEmployeeTrainByEidAndTrainContent(Integer eid, String trainContent) {
        return employeeTrainMapper.getEmployeeTrainByEidAndTrainContent(eid, trainContent);
    }

    public Integer addEmployeeTrain(EmployeeTrain employeeTrain) {
        employeeTrain.setTrainDate(new Date());
        return employeeTrainMapper.insertSelective(employeeTrain);
    }

    public Integer updateEmployeeTrain(EmployeeTrain employeeTrain) {
        return employeeTrainMapper.updateByPrimaryKeySelective(employeeTrain);
    }

    public Integer deleteEmployeeTrain(Integer id) {
        return employeeTrainMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteEmployeeTrains(Integer[] ids) {
        return employeeTrainMapper.deleteEmployeeTrains(ids);
    }
}
