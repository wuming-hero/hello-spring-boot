package com.wuming.eventBus;

import com.google.common.eventbus.AsyncEventBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Spring Boot 推荐将Application启动类放在根包下，
 * 例如包层级划分如com.example.controller、com.example.service、com.example.dao等，
 * com.example则是根包，Application启动类推荐放在com.example包下
 * <p>
 * 这样做的好处是使用@SpringBootApplication注解标注Application类的时可以省略指定scanBasePackages属性，
 * 并且应用启动时默认只扫描Application类所在的包及其子包。
 *
 * @author wuming
 * Created on 2018/3/1 19:04
 */
@SpringBootApplication
public class EventBusApplication {

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
        SpringApplication application = new SpringApplication(EventBusApplication.class);
        // 启动应用
        application.run(args);
    }

    /**
     * AsyncEventBus注册
     */
    @Bean
    public AsyncEventBus asyncEventBus() {
        // 创建一个核心3线程，最大10线程的线程池，配置DiscardPolicy策略，抛弃当前任务
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 10, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10), new ThreadPoolExecutor.DiscardPolicy());
        return new AsyncEventBus(threadPoolExecutor);
    }

}
