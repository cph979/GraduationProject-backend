package org.cph.vhr.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class EmployeeRemove {
    private Integer id;

    private Integer eid;

    private Integer afterDepId;

    private Integer afterJobId;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date removeDate;

    private String reason;

    private Employee employee;

    private Department department;

    private JobLevel jobLevel;

    public EmployeeRemove() {};

    public EmployeeRemove(Integer id, Integer eid, Integer afterDepId, Integer afterJobId, Date removeDate, String reason) {
        this.id = id;
        this.eid = eid;
        this.afterDepId = afterDepId;
        this.afterJobId = afterJobId;
        this.removeDate = removeDate;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "EmployeeRemove{" +
                "id=" + id +
                ", eid=" + eid +
                ", afterDepId=" + afterDepId +
                ", afterJobId=" + afterJobId +
                ", removeDate=" + removeDate +
                ", reason='" + reason + '\'' +
                ", employee=" + employee +
                ", department=" + department +
                ", jobLevel=" + jobLevel +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getAfterDepId() {
        return afterDepId;
    }

    public void setAfterDepId(Integer afterDepId) {
        this.afterDepId = afterDepId;
    }

    public Integer getAfterJobId() {
        return afterJobId;
    }

    public void setAfterJobId(Integer afterJobId) {
        this.afterJobId = afterJobId;
    }

    public Date getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(Date removeDate) {
        this.removeDate = removeDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public JobLevel getJobLevel() {
        return jobLevel;
    }

    public void setJobLevel(JobLevel jobLevel) {
        this.jobLevel = jobLevel;
    }
}