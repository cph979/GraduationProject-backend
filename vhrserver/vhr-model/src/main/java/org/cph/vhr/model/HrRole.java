package org.cph.vhr.model;

public class HrRole {
    private Integer id;

    private Integer hrid;

    private Integer rid;

    @Override
    public String toString() {
        return "HrRole{" +
                "id=" + id +
                ", hrid=" + hrid +
                ", rid=" + rid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHrid() {
        return hrid;
    }

    public void setHrid(Integer hrid) {
        this.hrid = hrid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}