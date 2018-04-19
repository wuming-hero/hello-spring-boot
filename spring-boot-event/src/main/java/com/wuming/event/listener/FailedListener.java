package com.wuming.event.listener;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author wuming
 * Created on 2018/3/24 17:33
 */
public class FailedListener implements ApplicationListener<ApplicationFailedEvent> {

    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        System.out.println("====ApplicationFailedEvent listener====");
    }

}
