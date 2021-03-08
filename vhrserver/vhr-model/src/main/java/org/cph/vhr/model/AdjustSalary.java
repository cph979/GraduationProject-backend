package org.cph.vhr.model;

import java.util.Date;

public class AdjustSalary {
    private Integer id;

    private Integer eid;

    private Date asDate;

    private Integer beforeSalary;

    private Integer afterSalary;

    private String reason;

    @Override
    public String toString() {
        return "AdjustSalary{" +
                "id=" + id +
                ", eid=" + eid +
                ", asDate=" + asDate +
                ", beforeSalary=" + beforeSalary +
                ", afterSalary=" + afterSalary +
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

    public Date getAsDate() {
        return asDate;
    }

    public void setAsDate(Date asDate) {
        this.asDate = asDate;
    }

    public Integer getBeforeSalary() {
        return beforeSalary;
    }

    public void setBeforeSalary(Integer beforeSalary) {
        this.beforeSalary = beforeSalary;
    }

    public Integer getAfterSalary() {
        return afterSalary;
    }

    public void setAfterSalary(Integer afterSalary) {
        this.afterSalary = afterSalary;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}