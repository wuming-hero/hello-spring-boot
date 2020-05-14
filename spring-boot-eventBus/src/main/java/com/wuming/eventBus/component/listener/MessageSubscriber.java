package com.wuming.eventBus.component.listener;

import com.google.common.eventbus.Subscribe;
import com.wuming.eventBus.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author wuming
 * Created on 2020-05-12 20:30
 */
@Slf4j
@Component
public class MessageSubscriber {

//    @Autowired
//    protected AsyncEventBus asyncEventBus;
//
//    @PostConstruct
//    public void pre() {
//        asyncEventBus.register(this);
//    }
//
//    @PreDestroy
//    public void destroy() {
//        asyncEventBus.unregister(this);
//    }

    @Subscribe
    public void msgSubscriber(Message message) {
        log.info("message subscriber: {}", message);
    }

}
