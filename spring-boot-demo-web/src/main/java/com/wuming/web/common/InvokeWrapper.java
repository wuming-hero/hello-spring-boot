package com.wuming.web.common;

/**
 * 自定义函数式接口，用来处理业务逻辑
 *
 * @author manji
 * Created on 2025/3/1 10:42
 */
@FunctionalInterface
public interface InvokeWrapper<T> {
    /**
     * 具体执行
     * @return
     */
    T invoke();
}
