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
    private String heatAm;
    @Column(name = "heat_pm")
    private String heatPm;
    @Column(name = "date")
    private String date;
    @Column(name = "student_id")
    private Integer studentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeatAm() {
        return heatAm;
    }

    public void setHeatAm(String heatAm) {
        this.heatAm = heatAm;
    }

    public String getHeatPm() {
        return heatPm;
    }

    public void setHeatPm(String heatPm) {
        this.heatPm = heatPm;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "id=" + id +
                ", heatAm='" + heatAm + '\'' +
                ", heatPm='" + heatPm + '\'' +
                ", date='" + date + '\'' +
                ", studentId=" + studentId +
                '}';
    }
}
