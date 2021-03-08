package org.cph.vhr.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class JobLevel implements Serializable {
    private static final long serialVersionUID = 4515851060637047388L;
    private Integer id;

    private String name;

    private String titleLevel;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date createDate;

    private Boolean enabled;

    public JobLevel() {
    }

    public JobLevel(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobLevel jobLevel = (JobLevel) o;

        return name != null ? name.equals(jobLevel.name) : jobLevel.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "JobLevel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", titleLevel='" + titleLevel + '\'' +
                ", createDate=" + createDate +
                ", enabled=" + enabled +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTitleLevel() {
        return titleLevel;
    }

    public void setTitleLevel(String titleLevel) {
        this.titleLevel = titleLevel;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}