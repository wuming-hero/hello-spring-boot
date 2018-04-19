package com.wuming.event;

import com.wuming.event.listener.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 从启动运行日志可以看出，顺序如下：
 * <p>
 * 1.SpringApplicationEvent
 * 2.ApplicationStartedEvent
 * 3.ApplicationEnvironmentPreparedEvent ：可以通过ConfigurableEnvironment实例对象来修改以及获取默认的环境信息。
 * 4.SpringApplicationEvent
 * 5.初始化图标（banner）
 * 6.ApplicationPreparedEvent ：这个时候spring容器中的bean还没有被完全的加载，如果通过ConfigurableApplicationContext获取bean会报错的
 * 7.SpringApplicationEvent
 * 8.映射基本的servlet URL： [/][/*]
 * 9.初始化Spring容器中的beans
 * 10.ApplicationReadyEvent ：可以通过ApplicationReadyEvent获取ConfigurableApplicationContext，然后通过ConfigurableApplicationContext 获取bean的信息
 *
 * @author wuming
 * Created on 2018/3/26 09:29
 */
@SpringBootApplication
public class EventApplication {


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(EventApplication.class);
        application.addListeners(new EnvironmentPreparedListener());
        application.addListeners(new FailedListener());
        application.addListeners(new PreparedListener());
        application.addListeners(new ReadyListener());
        application.addListeners(new SpringApplicationListener2());
        application.addListeners(new StarterListener());
        application.run(args);
    }
}
