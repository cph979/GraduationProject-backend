package org.cph.vhr.model;

public class MenuRole {
    private Integer id;

    private Integer mid;

    private Integer rid;

    @Override
    public String toString() {
        return "MenuRole{" +
                "id=" + id +
                ", mid=" + mid +
                ", rid=" + rid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}