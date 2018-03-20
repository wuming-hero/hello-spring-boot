package com.wuming;

import com.wuming.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.exit;

/**
 * 在Spring Boot中，要创建一个非Web应用程序，实现CommandLineRunner并覆盖run()方法
 *
 * @author wuming
 * Created on 2018/3/20 21:19
 */
@SpringBootApplication
public class NonWebApplication implements CommandLineRunner {

    @Autowired
    private HelloService helloService;

    public static void main(String[] args) {
//        SpringApplication application = new SpringApplication(NonWebApplication.class);
//        application.run(args);
        SpringApplication.run(NonWebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0) {
            System.out.println(helloService.getMessage(args[0].toString()));
        } else {
            System.out.println(helloService.getMessage());
        }
        exit(0);
    }
}
