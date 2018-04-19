package com.wuming.event.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author wuming
 * Created on 2018/3/24 17:33
 */
public class StarterListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println("====ApplicationStartedEvent listener====");
    }
}
