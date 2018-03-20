package com.wuming.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author wuming
 * Created on 2018/3/20 21:25
 */
@Service
public class HelloService {

    @Value("${server.name:unknown}")
    private String name;

    public String getMessage() {
        return getMessage(name);
    }

    public String getMessage(String name) {
        return "----Hello " + name;
    }
}
