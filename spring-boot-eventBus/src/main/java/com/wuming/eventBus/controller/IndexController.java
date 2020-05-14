package com.wuming.eventBus.controller;

import com.wuming.eventBus.component.EventBusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 最简单的一个Spring-boot web示例
 *
 * @author wuming
 * Created on 2018/3/5 20:57
 */
@Slf4j
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private EventBusService eventBusService;

    @GetMapping
    public String index() {
        return "Hello World!";
    }

    /**
     * 记录student 信息
     *
     * @param id
     * @param name
     * @param age
     */
    @PutMapping("/student")
    public void recordStudent(@RequestParam Long id, @RequestParam String name, @RequestParam Integer age) {
        log.info("record student, id: {}, date: {}", id, new Date());
        eventBusService.recordStudent(id, name, age);
    }

    /**
     * 发送消息
     *
     * @param id
     * @param email
     * @param content
     */
    @PutMapping("/sendMsg")
    public void sendMessage(@RequestParam Long id, @RequestParam String email, @RequestParam String content) {
        log.info("send msg, id: {}, date: {}", id, new Date());
        eventBusService.sendMessage(id, email, content);
    }

}
