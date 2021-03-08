package org.cph.vhr.model;

/**
 * @author cph
 * @create 2020-12-16 14:24
 */
public class EmpOnlyHaveNameAndWorkID {
    private Integer id;
    private String name;
    private String workID;

    @Override
    public String toString() {
        return "EmpOnlyHaveNameAndWorkID{" +
                "id=" + id +
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
