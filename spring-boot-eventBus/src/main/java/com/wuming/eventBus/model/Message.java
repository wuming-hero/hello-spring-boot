package com.wuming.eventBus.model;

import lombok.Data;

/**
 * 消息类
 *
 * @author wuming
 * Created on 2020-05-12 20:29
 */
@Data
public class Message {

    private Long id;
    private String email;
    private String content;

    public Message(Long id, String email, String content) {
        this.id = id;
        this.email = email;
        this.content = content;
    }

}
