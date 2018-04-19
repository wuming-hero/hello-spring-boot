package com.wuming.event.listener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author wuming
 * Created on 2018/3/24 17:33
 */
public class ReadyListener implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("====ApplicationReadyEvent listener====");
    }

}
