package com.wuming.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wuming
 * Created on 2018/4/25 21:17
 */
@SpringBootApplication(scanBasePackages={"com.wuming.web", "com.wuming.starter"})
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WebApplication.class);
        application.run(args);
    }
}
