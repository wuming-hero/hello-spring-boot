package com.wuming.demo.model;

import java.io.Serializable;

/**
 * @author wuming
 * Created on 2018/4/19 17:07
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 6564596383287424048L;

    private Long id;
    private String name;
    private Integer age;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
