package com.wuming.demo.controller;

import com.wuming.demo.model.Student;
import org.springframework.web.bind.annotation.*;

/**
 * 最简单的一个Spring-boot web示例
 *
 * @author wuming
 * Created on 2018/3/5 20:57
 */
@RestController
@RequestMapping("/index")
public class IndexController {


    @GetMapping
    public String index() {
        return "Hello World!";
    }


    /**
     * 如果没有传id的值，springMVC会自动将PathVariable中同名的变量值赋值给 student.id
     *
     * @param id
     * @param student
     */
    @PutMapping("/{id}/update")
    public void create(@PathVariable Long id, Student student) {
        System.out.println("id: " + id);
        System.out.println("student: " + student);
    }
}
