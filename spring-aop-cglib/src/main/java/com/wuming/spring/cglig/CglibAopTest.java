package com.wuming.spring.cglig;

import com.wuming.spring.cglig.interceptor.LeaderMethodInterceptor;
import net.sf.cglib.proxy.Enhancer;


/**
 * 动态代理根据实现方式的不同可以分为 JDK 动态代理和 CGlib 动态代理。
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
public class CglibAopTest {

    /**
     * jdk代理调用
     *
     * @param args
     */
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer(); // 通过CGLIB动态代理获取代理对象的过程
        enhancer.setSuperclass(Leader.class); // 设置enhancer对象的父类
        enhancer.setCallback(new LeaderMethodInterceptor()); // 设置enhancer的回调对象
        Leader proxy= (Leader)enhancer.create(); // 创建代理对象
        // 通过代理对象调用目标方法
        proxy.meeting();
        proxy.evaluate("Joy");
        proxy.evaluate("James");
    }
}
