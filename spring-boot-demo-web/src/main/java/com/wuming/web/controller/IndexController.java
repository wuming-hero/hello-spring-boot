package com.wuming.web.controller;

import com.wuming.web.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuming
 * Created on 2018/4/25 21:18
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping
    public String index(Model model) {
        model.addAttribute("name", "wuming");
        List<User> userList = new ArrayList<>();
        User user;
        for (int i = 0; i < 5; i++) {
            user = new User();
            user.setName("无名" + i + "号");
            user.setUid((long) i);
            user.setAge(28 + i);
            userList.add(user);
        }
        model.addAttribute("userList", userList);
        return "index";
    }

    @RequestMapping("/test2")
    public String index2(Model model) {
        model.addAttribute("name", "wuming");
        return "indexTest";
    }

}
