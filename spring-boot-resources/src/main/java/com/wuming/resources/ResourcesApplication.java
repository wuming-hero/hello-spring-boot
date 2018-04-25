package com.wuming.resources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wuming
 * Created on 2018/4/23 17:38
 */
@SpringBootApplication
public class ResourcesApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ResourcesApplication.class);
        application.run(args);
    }
}
