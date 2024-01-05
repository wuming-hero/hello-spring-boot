package com.wuming.starter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 通用处理器注解定义
 *
 * @author manji
 * @date 2024/1/5
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface Handler {

    /**
     * 路由到handler的key
     */
    String[] keys();

    /**
     * handler的类型
     */
    String type();

    /**
     * 自定义handlder的名称，方便用户识别
     */
    String name();

}
