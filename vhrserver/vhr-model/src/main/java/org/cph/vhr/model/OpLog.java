package org.cph.vhr.model;

import java.util.Date;

public class OpLog {
    private Integer id;

    private Date addDate;

    private String operate;

    private Integer hrid;

    @Override
    public String toString() {
        return "OpLog{" +
                "id=" + id +
                ", addDate=" + addDate +
                ", operate='" + operate + '\'' +
                ", hrid=" + hrid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate == null ? null : operate.trim();
    }

    public Integer getHrid() {
        return hrid;
    }

    public void setHrid(Integer hrid) {
        this.hrid = hrid;
    }
}