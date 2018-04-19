package com.wuming.event.listener;


import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author wuming
 * Created on 2018/3/24 17:33
 */
public class SpringApplicationListener2 implements ApplicationListener<SpringApplicationEvent> {

    @Override
    public void onApplicationEvent(SpringApplicationEvent event) {
        System.out.println("====SpringApplicationEvent listener====");
    }

}
