package com.wuming.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuming
 * Created on 2018/3/1 19:04
 */
@RestController
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        System.out.println("Hello World!");
        application.run(args);
    }

    /**
     * 简单的 spring-boot web方式 Hello World
     *
     * @return
     */
    @RequestMapping("/test")
    public String test() {
        return "Hello World!";
    }


}
