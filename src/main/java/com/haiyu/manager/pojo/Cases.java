package com.haiyu.manager.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName Cases
 * @Description
 * @Author 李策
 * @Date 2021-5-09 18:19
 */
@Table(name="cases")
public class Cases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "picture")
    private String picture;
    @Column(name = "student_id")
    private Integer student_id;
    @Column(name = "date")
    private String date;
    @Column(name = "flag")
    private Integer flag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Cases{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", student_id=" + student_id +
                ", date='" + date + '\'' +
                ", flag=" + flag +
                '}';
    }
}
