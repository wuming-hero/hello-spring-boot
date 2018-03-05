package com.wuming.properties.demo;

import com.wuming.properties.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
    private Properties properties;
    @Autowired
    private DbProperties dbProperties;


    /**
     * @Value 方式test
     */
    @Test
    public void test() {
        System.out.println("----" + properties.toString());;
    }

    /**
     * ConfigurationProperties 方式test
     */
    @Test
    public void test2() {
        System.out.println("====db ip: " + dbProperties.getIp());
        System.out.println("====page.min: " + dbProperties.getPage().getMin());
    }
}