package org.cph.vhr.service;

import org.cph.vhr.mapper.EmployeeMapper;
import org.cph.vhr.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author cph
 * @create 2020-12-13 12:06
 */
@Service
public class EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private RabbitTemplate rabbitTemplate;
    @Resource
    private MailSendLogService mailSendLogService;
    @Resource
    private EmployeeRemoveService employeeRemoveService;
    @Resource
    private SalaryTableService salaryTableService;
    @Resource
    private SalaryService salaryService;

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    private SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    private DecimalFormat decimalFormat = new DecimalFormat("#.00");

    public Integer updateEmployeeWithSalary(Integer eid, Integer sid) {
        // 查询sid的工资账套
        Salary oldSalary = salaryService.getSalary(sid);
        // 更新员工账套时新增薪资数据至工资表
        Integer basicSalary = oldSalary.getBasicSalary();
        Integer bonus = oldSalary.getBonus();
        Integer lunchSalary = oldSalary.getLunchSalary();
        Integer trafficSalary = oldSalary.getTrafficSalary();
        Integer pensionBase = oldSalary.getPensionBase();
        Float pensionPer = oldSalary.getPensionPer();
        Integer medicalBase = oldSalary.getMedicalBase();
        Float medicalPer = oldSalary.getMedicalPer();
        Integer accumulationFundBase = oldSalary.getAccumulationFundBase();
        Float accumulationFundPer = oldSalary.getAccumulationFundPer();
        Float allSalary = calculateSalary(basicSalary, bonus, lunchSalary, trafficSalary, pensionBase, pensionPer, medicalBase, medicalPer, accumulationFundBase, accumulationFundPer);

        SalaryTable salaryTable = new SalaryTable(null, eid, sid, basicSalary, bonus, lunchSalary, trafficSalary, allSalary);
        salaryTableService.saveSalaryTable(salaryTable);

        return employeeMapper.updateEmployeeWithSalary(eid, sid);
    }

    public Map getEmployeesByPage(Integer page, Integer size, Employee employee, Date[] beginDateScope) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> employeeList = employeeMapper.getEmployeesByPage(page, size, employee, beginDateScope);
        Long countEmployee = employeeMapper.getAllCount(employee, beginDateScope);
        HashMap<String, Object> respPageBean = new HashMap<>();
        respPageBean.put("total", countEmployee);
        respPageBean.put("data", employeeList);
//        RespPageBean respPageBean = new RespPageBean();
//        respPageBean.setData(employeeList);
//        respPageBean.setTotal(countEmployee);
        return respPageBean;
    }

    public Integer addEmployee(Employee employee) {
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        Double month = (Double.parseDouble(yearFormat.format(endContract)) - Double.parseDouble(yearFormat.format(beginContract)))
                * 12 + (Double.parseDouble(monthFormat.format(endContract)) - Double.parseDouble(monthFormat.format(beginContract)));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(month / 12)));
        int result = employeeMapper.insertSelective(employee);
        // 添加完成后给消息中间件发送消息，中间件再发送邮件
        if (result == 1) {
            Integer empId = employee.getId();
            Employee toBeSentEmployee = employeeMapper.getEmployeesById(empId);
            // 发送前先保存这条消息记录
            String msgId = UUID.randomUUID().toString();
            MailSendLog mailSendLog = new MailSendLog();
            mailSendLog.setMsgId(msgId);
            mailSendLog.setEmpId(empId);
            mailSendLog.setRouteKey(MailConstants.MAIL_ROUTING_KEY_NAME);
            mailSendLog.setExchange(MailConstants.MAIL_ROUTING_KEY_NAME);
            mailSendLog.setCreateTime(new Date());
            // 消息没被收到，可以开始重新投递的时间
            mailSendLog.setTryTime(new Date(System.currentTimeMillis() + 1000 * 60 * MailConstants.MSG_TIMEOUT));
            mailSendLogService.insertMailSendLog(mailSendLog);
            rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME, MailConstants.MAIL_ROUTING_KEY_NAME, toBeSentEmployee, new CorrelationData(msgId));
        }
        return result;
    }

    public Integer updateEmployee(Employee employee) {
        Integer id = employee.getId();
        Employee oldEmp = employeeMapper.selectByPrimaryKey(id);
        // 部门职位有变更的时候新增调动表记录
        if (!oldEmp.equals(employee)) {
            employeeRemoveService.saveEmpRemove(new EmployeeRemove(null, employee.getId(), employee.getDepartmentId(),
                    employee.getJobLevelId(), new Date(), "部门职称变动"));
        }
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public Integer deleteEmployee(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteEmployees(Integer[] ids) {
        return employeeMapper.deleteEmployees(ids);
    }

    public Integer getMaxWordID() {
        return employeeMapper.getMaxWordID();
    }

    public List<EmpOnlyHaveNameAndWorkID> getEmpWithNameAndWorkID() {
        return employeeMapper.getEmpWithNameAndWorkID();
    }

	public Integer getEmployeeCountByPosId(Integer id) {
        return employeeMapper.getEmployeeCountByPosId(id);
	}

    public Integer getEmployeeCountByJobLevelId(Integer id) {
        return employeeMapper.getEmployeeCountByJobLevelId(id);
    }

    public Integer saveEmployees(List<Employee> list) {
        return employeeMapper.saveEmployees(list);
    }

    public RespPageBean listEmployeesByPageWithSalary(Integer page, Integer size) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> employeeList =  employeeMapper.listEmployeesByPageWithSalary(page, size);
        Long countEmployeeWithSalary = employeeMapper.getAllCount(new Employee(), null);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(employeeList);
        respPageBean.setTotal(countEmployeeWithSalary);
        return respPageBean;
    }

    public Employee getEmployeesById(Integer empId) {
        return employeeMapper.getEmployeesById(empId);
    }

    /**
     * 计算工资
     *
     * @param
     * @return
     */
    public Float calculateSalary(Integer basicSalary, Integer bonus, Integer lunchSalary, Integer trafficSalary,
                                   Integer pensionBase, Float pensionPer, Integer medicalBase, Float medicalPer, Integer accumulationFundBase,
                                   Float accumulationFundPer) {
        return ((basicSalary + bonus + lunchSalary + trafficSalary) - (pensionBase * pensionPer + medicalBase * medicalPer + accumulationFundBase * accumulationFundPer));
    }
}
