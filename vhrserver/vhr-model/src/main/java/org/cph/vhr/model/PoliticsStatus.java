package org.cph.vhr.model;

import java.io.Serializable;

public class PoliticsStatus implements Serializable {
    private static final long serialVersionUID = 3821747390491921626L;
    private Integer id;

    private String name;

    public PoliticsStatus() {
    }

    public PoliticsStatus(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PoliticsStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PoliticsStatus that = (PoliticsStatus) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}