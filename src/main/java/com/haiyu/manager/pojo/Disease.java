package com.haiyu.manager.pojo;

import javax.persistence.*;

/**
 * @ClassName Disease
 * @Description
 * @Author 李策
 * @Date 2021-3-01 21:49
 */
@Table(name="disease")
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "dis_name")
    private String disName;
    @Column(name = "dis_description")
    private String disDescription;
    @Column(name = "dis_taboo")
    private String disTaboo;
    @Column(name = "dis_prevention")
    private String disPrevention;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisName() {
        return disName;
    }

    public void setDisName(String disName) {
        this.disName = disName;
    }

    public String getDisDescription() {
        return disDescription;
    }

    public void setDisDescription(String disDescription) {
        this.disDescription = disDescription;
    }

    public String getDisTaboo() {
        return disTaboo;
    }

    public void setDisTaboo(String disTaboo) {
        this.disTaboo = disTaboo;
    }

    public String getDisPrevention() {
        return disPrevention;
    }

    public void setDisPrevention(String disPrevention) {
        this.disPrevention = disPrevention;
    }

    @Override
    public String toString() {
        return "Disease{" +
                "id=" + id +
                ", disName='" + disName + '\'' +
                ", disDescription='" + disDescription + '\'' +
                ", disTaboo='" + disTaboo + '\'' +
                ", disPrevention='" + disPrevention + '\'' +
                '}';
    }
}
