package org.cph.vhr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class EmployeeTrain {
    private Integer id;

    private Integer eid;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date trainDate;

    private String trainContent;

    // 员工名 -- 新增属性
    private String name;

    // 员工号 -- 新增属性
    private String workID;

    @Override
    public String toString() {
        return "EmployeeTrain{" +
                "id=" + id +
                ", eid=" + eid +
                ", trainDate=" + trainDate +
                ", trainContent='" + trainContent + '\'' +
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

    public Date getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    public String getTrainContent() {
        return trainContent;
    }

    public void setTrainContent(String trainContent) {
        this.trainContent = trainContent == null ? null : trainContent.trim();
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