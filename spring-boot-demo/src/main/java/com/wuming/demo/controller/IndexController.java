package com.wuming.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
