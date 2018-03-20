package com.wuming.properties.demo;

import com.wuming.properties.PropertiesApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试
 *
 * @author wuming
 * Created on 2018/3/5 14:41
 * <p>
 * @SpringBootTest 注解，它是在1.4.0版本加入的单元测试辅助注解， 使用这个注解会在单元测试执行的时候
 * 自动搜索@SpringBootConfiguration注解标注的启动类，进而启动Spring容器。
 * @SpringBootTest 注解的webEnvironment属性用于指定创建的ApplicationContext是否是WebApplicationContext，
 * 默认值是WebEnvironment.MOCK，即创建WebApplicationContext，
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PropertiesApplication.class)
public class PropertiesTest {

    @Autowired
    private Environment environment;
    @Autowired
    private Properties properties;
    @Autowired
    private PropertiesConfig propertiesConfig;
    @Autowired
    private PropertiesConfig2 propertiesConfig2;

    /**
     * 通过 Environment 获取变量并不支持变量 Key 的Relaxed binding模式
     */
    @Test
    public void envTest() {
        System.out.println("name: " + environment.getProperty("server.display-name"));
        System.out.println("address: " + environment.getProperty("server.address"));
    }

    /**
     * @Value 方式test
     */
    @Test
    public void atValueTest() {
        System.out.println("----" + properties.toString());
    }

    /**
     * ConfigurationProperties 方式test
     */
    @Test
    public void configurationPropertiesTest() {
        System.out.println("----configurationProperties properties: " + propertiesConfig.toString());
    }

    /**
     * ConfigurationProperties 方式test
     */
    @Test
    public void PropertySourceTest() {
        System.out.println("----PropertySource properties: " + propertiesConfig2.toString());
    }

}