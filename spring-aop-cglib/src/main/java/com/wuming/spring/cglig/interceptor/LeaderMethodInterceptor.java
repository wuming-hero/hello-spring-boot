package com.wuming.spring.cglig.interceptor;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author manji
 * Created on 2025/4/17 16:54
 */
public class LeaderMethodInterceptor implements MethodInterceptor {

    /**
     * 该方法用于拦截指定的方法调用，并根据方法名进行相应处理。
     *
     * <p>当调用的为"meeting"方法时，将打印会议材料准备的信息；
     * 当调用的为"evaluate"方法时，检查传入参数，如果参数为"James"，则返回特定的评分。
     *
     * @param o           被代理对象
     * @param method      被拦截的方法
     * @param objects     被拦截方法的参数
     * @param methodProxy 用于调用父类方法的代理对象
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if ("meeting".equals(method.getName())) {
            System.out.println("代理先准备会议材料...");
            return methodProxy.invokeSuper(o, objects);
        } else if ("evaluate".equals(method.getName())) {
            if (objects[0] instanceof String) {
                if ("James".equals(objects[0])) {
                    System.out.println("James 犯过错误，所以考评分数较低...");
                    return 70;
                }
            }
            return methodProxy.invokeSuper(o, objects);
        }
        return null;
    }
}
