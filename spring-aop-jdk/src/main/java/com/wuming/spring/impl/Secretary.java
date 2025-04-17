package com.wuming.spring.impl;

import com.wuming.spring.IWork;

/**
 * 静态代理实现：
 * 代理类和被代理类实现了同样的接口，代理类同时持有被代理类的引用，这样，当我们需要调用被代理类的方法时，可以通过调用代理类的方法来做到。
 * <p>
 * 1. 秘书类，持有老板类的的引用
 * 2. 调用秘书类中的方法，实际调用的是领导的方法，相当于秘书代理了老板
 *
 * @author manji
 * Created on 2025/4/17 16:51
 */
public class Secretary implements IWork {

    private Leader mLeader;

    public Secretary(Leader mLeader) {
        this.mLeader = mLeader;
    }

    @Override
    public void meeting() {
        System.out.println("秘书先给老板准备材料");
        mLeader.meeting();
    }

    @Override
    public int evaluate(String name) {
        return mLeader.evaluate(name);
    }
}
