package com.wuming.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring框架提供了YamlPropertiesFactoryBean将YAML加载为Properties文件，
 * 提供了YamlMapFactoryBean将YAML加载为一个Map，使用这两个类可以实现对YAML文件进行自定义操作
 *
 * @author wuming
 * Created on 2018/3/5 13:48
 */
@SpringBootApplication
public class PropertiesApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(PropertiesApplication.class);
        application.run(args);
    }

}
