package com.wuming.properties.demo;

import com.wuming.properties.Application;
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
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
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