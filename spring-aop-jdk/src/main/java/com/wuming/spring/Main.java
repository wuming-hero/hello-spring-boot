package com.wuming.spring;

import com.wuming.spring.impl.Leader;
import com.wuming.spring.impl.Secretary;

/**
 * @author manji
 * Created on 2025/4/17 16:49
 */
public class Main {
    /**
     * 正常调用
     *
     * @param args
     */
    public static void main(String[] args) {
        Leader leader = new Leader();
        Secretary secretary = new Secretary(leader);
        secretary.meeting();
        secretary.evaluate("Joy");
    }
}