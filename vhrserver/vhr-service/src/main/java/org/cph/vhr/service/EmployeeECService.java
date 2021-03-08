package org.cph.vhr.service;

import org.cph.vhr.mapper.EmployeeECMapper;
import org.cph.vhr.model.EmployeeEC;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author cph
 * @create 2020-12-15 18:41
 */
@Service
public class EmployeeECService {
    @Resource
    EmployeeECMapper employeeECMapper;

    public List<EmployeeEC> getAllEmployeeECs() {
        return employeeECMapper.getAllEmployeeECs();
    }

    public Integer addEmployeeEC(EmployeeEC employeeEC) {
        employeeEC.setEcDate(new Date());
        return employeeECMapper.insertSelective(employeeEC);
    }

    public Integer updateEmployeeEC(EmployeeEC employeeEC) {
        return employeeECMapper.updateByPrimaryKeySelective(employeeEC);
    }

    public Integer deleteEmployeeEC(Integer id) {
        return employeeECMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteEmployeeECs(Integer[] ids) {
        return employeeECMapper.deleteEmployeeECs(ids);
    }

    public EmployeeEC getEmpECByEidAndECReason(Integer eid, String ecReason) {
        return employeeECMapper.getEmpECByEidAndECReason(eid, ecReason);
    }
}
