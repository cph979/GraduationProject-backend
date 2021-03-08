package org.cph.vhr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class EmployeeRemove {
    private Integer id;

    private Integer eid;

    private Integer afterDepId;

    private Integer afterJobId;

    private Date removeDate;

    private String reason;

    @Override
    public String toString() {
        return "EmployeeRemove{" +
                "id=" + id +
                ", eid=" + eid +
                ", afterDepId=" + afterDepId +
                ", afterJobId=" + afterJobId +
                ", removeDate=" + removeDate +
                ", reason='" + reason + '\'' +
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
        this.reason = reason == null ? null : reason.trim();
    }
}