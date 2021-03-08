package org.cph.vhr.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class EmployeeEC {
    private Integer id;

    private Integer eid;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date ecDate;

    private String ecReason;

    private Integer ecPoint;

    private Integer ecType;

    // 员工名 -- 新增属性
    private String name;

    // 员工号 -- 新增属性
    private String workID;

    @Override
    public String toString() {
        return "EmployeeEC{" +
                "id=" + id +
                ", eid=" + eid +
                ", ecDate=" + ecDate +
                ", ecReason='" + ecReason + '\'' +
                ", ecPoint=" + ecPoint +
                ", ecType=" + ecType +
                ", name='" + name + '\'' +
                ", workID='" + workID + '\'' +
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

    public Date getEcDate() {
        return ecDate;
    }

    public void setEcDate(Date ecDate) {
        this.ecDate = ecDate;
    }

    public String getEcReason() {
        return ecReason;
    }

    public void setEcReason(String ecReason) {
        this.ecReason = ecReason;
    }

    public Integer getEcPoint() {
        return ecPoint;
    }

    public void setEcPoint(Integer ecPoint) {
        this.ecPoint = ecPoint;
    }

    public Integer getEcType() {
        return ecType;
    }

    public void setEcType(Integer ecType) {
        this.ecType = ecType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkID() {
        return workID;
    }

    public void setWorkID(String workID) {
        this.workID = workID;
    }
}