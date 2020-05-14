package com.wuming.eventBus.component;

import com.google.common.eventbus.AsyncEventBus;
import com.wuming.eventBus.component.listener.MessageSubscriber;
import com.wuming.eventBus.component.listener.StudentSubscriber;
import com.wuming.eventBus.model.Message;
import com.wuming.eventBus.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author wuming
 * Created on 2020-05-12 20:23
 */
@Slf4j
@Component
public class EventBusService {

    private AsyncEventBus eventBus;
    private MessageSubscriber messageSubscriber;
    private StudentSubscriber studentSubscriber;

    @Autowired
    public EventBusService(AsyncEventBus eventBus, MessageSubscriber messageSubscriber, StudentSubscriber studentSubscriber) {
        this.eventBus = eventBus;
        this.messageSubscriber = messageSubscriber;
        this.studentSubscriber = studentSubscriber;
    }

    @PostConstruct
    public void pre() {
        eventBus.register(messageSubscriber);
        eventBus.register(studentSubscriber);
    }

    @PreDestroy
    public void preDestroy() {
        eventBus.unregister(messageSubscriber);
        eventBus.unregister(studentSubscriber);
    }

    /**
     * 发送消息API 封装
     *
     * @param id
     * @param email
     * @param content
     */
    public void sendMessage(Long id, String email, String content) {
        Message message = new Message(id, email, content);
        eventBus.post(message);
    }

    /**
     * 记录学生信息API封装
     *
     * @param id
     * @param name
     * @param age
     */
    public void recordStudent(Long id, String name, Integer age) {
        Student student = new Student(id, name, age);
        eventBus.post(student);
    }

}
