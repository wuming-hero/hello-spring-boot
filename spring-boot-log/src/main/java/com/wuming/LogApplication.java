package com.wuming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wuming
 * Created on 2018/3/20 20:39
 */
@SpringBootApplication
public class LogApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(LogApplication.class);
        application.run(args);
    }
}
