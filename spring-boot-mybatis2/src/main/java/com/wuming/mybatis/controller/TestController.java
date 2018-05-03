package com.wuming.mybatis.controller;

import com.wuming.mybatis.model.User;
import com.wuming.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wuming
 * Created on 2018/5/2 17:57
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public Long createUser(User user) {
        Long uid = userService.createUser(user);
        return uid;
    }

    @GetMapping("/{uid}")
    public User findUser(@PathVariable Long uid) {
        return userService.findById(uid);
    }


}
