package com.wuming.spring.init;

import com.wuming.spring.init.model.StudentBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author manji
 * Created on 2025/3/9 10:53
 */
public class TestMain {

    public static void main(String[] args) {
        System.out.println("--------------【初始化容器】---------------");

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("-------------------【容器初始化成功】------------------");

        //得到studentBean，并显示其信息
        StudentBean studentBean = context.getBean("studentBean", StudentBean.class);
        System.out.println(studentBean);

        System.out.println("--------------------【销毁容器】----------------------");
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();
    }
}