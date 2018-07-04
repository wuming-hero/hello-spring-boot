package com.wuming.web.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wuming
 * Created on 2018/4/25 21:48
 */
public class User implements Serializable {

    private static final long serialVersionUID = 291885591964622330L;
    private Long uid;
    private String name;
    private Integer age;
//    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    private String startTime;
    private String endTime;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
