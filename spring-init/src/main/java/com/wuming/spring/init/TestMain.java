package com.wuming.spring.init;

import com.wuming.spring.init.model.StudentBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 生命周期和该生命周期所涉及的方法调用，分为以下三类 ：
 * 1. Bean自身的方法	        配置文件中的init-method和destroy-method配置的方法、Bean对象自己调用的方法
 * 2. Bean级生命周期接口方法	BeanNameAware、BeanFactoryAware、InitializingBean、DiposableBean等接口中的方法
 * 3. 容器级生命周期接口方法	后置处理器BeanPostProcessor实现类中重写的方法
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