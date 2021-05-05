package com.haiyu.manager.pojo;

import javax.persistence.*;

/**
 * @ClassName Temperature
 * @Description
 * @Author 李策
 * @Date 2021-3-05 18:05
 */
@Table(name = "temperature")
public class Temperature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "heat_am")
    private Double heat_am;
    @Column(name = "heat_pm")
    private Double heat_pm;
    @Column(name = "date")
    private String date;
    @Column(name = "student_id")
    private Integer student_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Double getHeat_am() {
        return heat_am;
    }

    public void setHeat_am(Double heat_am) {
        this.heat_am = heat_am;
    }

    public Double getHeat_pm() {
        return heat_pm;
    }

    public void setHeat_pm(Double heat_pm) {
        this.heat_pm = heat_pm;
    }


    @Override
    public String toString() {
        return "Temperature{" +
                "id=" + id +
                ", heat_am=" + heat_am +
                ", heat_pm=" + heat_pm +
                ", date='" + date + '\'' +
                ", student_id=" + student_id +
                '}';
    }
}
