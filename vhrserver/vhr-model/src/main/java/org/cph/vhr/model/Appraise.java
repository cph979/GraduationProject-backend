package org.cph.vhr.model;

import java.util.Date;

public class Appraise {
    private Integer id;

    private Integer eid;

    private Date appDate;

    private String appResult;

    private String appContent;

    @Override
    public String toString() {
        return "Appraise{" +
                "id=" + id +
                ", eid=" + eid +
                ", appDate=" + appDate +
                ", appResult='" + appResult + '\'' +
                ", appContent='" + appContent + '\'' +
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

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public String getAppResult() {
        return appResult;
    }

    public void setAppResult(String appResult) {
        this.appResult = appResult;
    }

    public String getAppContent() {
        return appContent;
    }

    public void setAppContent(String appContent) {
        this.appContent = appContent;
    }
}