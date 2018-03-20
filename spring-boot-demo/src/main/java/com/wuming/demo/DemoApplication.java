package com.wuming.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wuming
 * Created on 2018/3/1 19:04
 */
@SpringBootApplication
public class DemoApplication {

    /**
     * SpringApplication用来启动整个应用程序，其功能如下：
     * <p>
     * 1.根据 classpath 创建合适的 ApplicationContext
     * 2.注册 CommandLinePropertySource 生成命令行参数
     * 3.刷新 application context，载入所有 bean
     * 4.运行 CommandLineRunner bean
     *
     * @param args
     */
    public static void main(String[] args) {
        //实例化--使用当前类作为source(带有@Configuration的配置类)
        SpringApplication application = new SpringApplication(DemoApplication.class);
        // 启动应用
        application.run(args);
    }

}
