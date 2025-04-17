package com.wuming.spring;

import com.wuming.spring.handler.WorkInvocationHandler;
import com.wuming.spring.impl.Leader;

import java.lang.reflect.Proxy;

/**
 * JDK 动态代理是利用反射机制生成一个实现代理接口的类，在调用具体方法前调用InvokeHandler来处理。
 * CGlib 动态代理是利用ASM（开源的Java字节码编辑库，操作字节码）开源包，将代理对象类的class文件加载进来，通过修改其字节码生成子类来处理。
 * <p>
 * 区别：
 * JDK代理只能对实现接口的类生成代理；
 * CGlib是针对类实现代理，对指定的类生成一个子类，并覆盖其中的方法，这种通过继承类的实现方式，不能代理final修饰的类。
 *
 * @author manji
 * Created on 2025/4/17 16:56
 */
public class JdkAopTest {

    /**
     * jdk代理调用
     *
     * @param args
     */
    public static void main(String[] args) {
        // 创建老板类实例
        Leader leader = new Leader();
        // 创建老板对象的代理
        IWork proxy = (IWork) Proxy.newProxyInstance(
                // 获取代理类加载器,与要代理的类保持一致
                Leader.class.getClassLoader(),
                // 要代理类接口
                new Class[]{IWork.class},
                // 代理类回调类，需要实现InvocationHandler
                new WorkInvocationHandler(leader));

        proxy.meeting();
        // 回调方法没有处理，继续调用老板类执行
        proxy.evaluate("Joy");
        // 回调方法中算定义逻辑
        proxy.evaluate("James");
    }
}
