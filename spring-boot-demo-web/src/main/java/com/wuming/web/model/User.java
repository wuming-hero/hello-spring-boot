package com.wuming.web.model;

import java.io.Serializable;

/**
 * @author wuming
 * Created on 2018/4/25 21:48
 */
public class User implements Serializable {

    private static final long serialVersionUID = 291885591964622330L;
    private Long uid;
    private String name;
    private Integer age;

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

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
