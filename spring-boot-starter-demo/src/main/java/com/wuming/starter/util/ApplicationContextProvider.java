package com.wuming.starter.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author manji
 * @date 2024/1/5
 */
@Component
public class ApplicationContextProvider
        implements ApplicationContextAware {

    /**
     * 上下文对象实例
     */
    
    protected ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 获取applicationContext
     *
     * @return
     */
    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 通过name获取 Bean.
     *
     * @param name
     * @return
     */
    public Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * 通过class获取Bean.
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过name,以及Clazz返回指定的Bean
     *
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

    /**
     * 获取包含该注解的所有的spring的bean
     * @param clazz
     * @return
     */
    public Map<String,Object> getBeansWithAnnotation(Class clazz){
        return getApplicationContext().getBeansWithAnnotation(clazz);
    }
}
