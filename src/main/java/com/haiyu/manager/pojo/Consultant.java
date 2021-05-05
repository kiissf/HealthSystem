package com.haiyu.manager.pojo;

import javax.persistence.*;

/**
 * @ClassName Consult
 * @Description
 * @Author 李策
 * @Date 2021-3-03 22:29
 */
@Table(name="consult")
public class Consultant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "option")
    private String option;
    @Column(name = "number")
    private String number;
    @Column(name = "time")
    private String time;

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

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", option='" + option + '\'' +
                ", number='" + number + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
