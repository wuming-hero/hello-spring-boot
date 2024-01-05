package com.wuming.starter.handler;

/**
 * 处理器抽象类
 * 泛型 R代表出参类型
 * 泛型 T代表入参类型，多个入参的可以考虑放到一个wrapper对象里
 *
 * @author manji
 * @date 2024/1/5
 */
public interface Handler<R, T> {

    /**
     * 抽象处理器
     *
     * @param t 入参
     * @return
     */
    R handle(T t);

}
