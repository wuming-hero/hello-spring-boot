package com.wuming.spring.init;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * BeanFactoryPostProcessor 实现
 *
 * @author manji
 * Created on 2025/3/9 11:03
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcessor() {
        System.out.println("【BeanFactoryPostProcessor接口】调用BeanFactoryPostProcessor实现类构造方法");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("【BeanFactoryPostProcessor接口】调用BeanFactoryPostProcessor接口的postProcessBeanFactory方法");
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("studentBean");
        // xml配置的age属性是18，此处设置的值会覆盖xml配置的值
        beanDefinition.getPropertyValues().addPropertyValue("age", "21");
    }
}
