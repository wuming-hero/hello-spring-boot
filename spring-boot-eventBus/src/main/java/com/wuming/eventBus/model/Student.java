package com.wuming.eventBus.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wuming
 * Created on 2018/4/19 17:07
 */
@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 6564596383287424048L;

    private Long id;
    private String name;
    private Integer age;

    public Student(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

}
