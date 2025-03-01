package com.wuming.web.controller;

import com.wuming.web.service.UserService;
import com.wuming.web.model.User;
import com.wuming.web.model.User2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * spring-boot处理时间问题
 * 1.非body传参，建议使用格式化字符串，实体类中使用String类型进行接收
 * 2.以body方式接收，前端传入时间戳或UTC格式字符串(注意时区问题)实体类中使用Date类型进行接收
 * <p>
 * 使用日期：2000-01-01 00:00:00 为例子进行测试
 *
 * @author wuming
 * Created on 2018/5/12 15:21
 */
@RestController
@RequestMapping("/restful")
public class RestfulController {

    @Resource
    private UserService userService;

    /*******************字段 birthday 设计为 Date 类型*******************/

    /**
     * 普通GET查询，参数拼接在URL后面
     * 1.UTC 字符串
     * 2.时间戳字符串
     * 3.时间格式字符串
     * 都无法转换，都会报如下错误
     * <p>
     * Failed to convert property value of type [java.lang.String] to required type [java.util.Date] for property 'birthday';
     * nested exception is org.springframework.core.convert.ConversionFailedException:
     * Failed to convert from type [java.lang.String] to type [java.util.Date] for value '2000-01-01T00:00:00.000Z';
     * nested exception is java.lang.IllegalArgumentException
     *
     * @param user
     */
    @RequestMapping("/getParam")
    public void getParam(User user) {
        System.out.println("birthday: " + user.getBirthday());
        return;
    }

    /**
     * 普通Post方法传递参数 "birthday": "2000-01-01T00:00:00.000Z"
     * 1.UTC 字符串
     * 2.时间戳字符串
     * 3.时间格式字符串
     * 都无法转换，都会报如下错误
     * <p>
     * Failed to convert property value of type [java.lang.String] to required type [java.util.Date] for property 'birthday';
     * nested exception is org.springframework.core.convert.ConversionFailedException:
     * Failed to convert from type [java.lang.String] to type [java.util.Date] for value '2000-01-01T00:00:00.000Z';
     * nested exception is java.lang.IllegalArgumentException
     *
     * @param user
     */
    @PostMapping("/postParam")
    public void postParam(User user) {
        System.out.println("birthday: " + user.getBirthday());
    }

    /*******************从上面可以看到，GET 或 POST 方法普通传参方式，在不做其他配置的前题下，是无法正常处理时间字符串的，包括时间戳字符串*******************/

    /**
     * 普通POST、PUT方法通过Body传递参数
     * 1.UTC 字符串 "birthday": "2000-01-01T00:00:00.000Z"
     * 可以正常转换为时间格式,但在参数表示的时间上自动加了8个小时
     * <p>
     * 2. 时间戳数字或字符串 1532509377543，可以正确转换为时间
     *
     * @param
     * @return birthday 返回
     */
    @PostMapping("/body")
    public Date body(@RequestBody User user) {
        System.out.println("birthday: " + user.getBirthday()); // Sat Jan 01 08:00:00 CST 2000
        return user.getBirthday();
    }

    /*******************使用@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")，只有body参数有效，GET 和POST方法都无法正常转换*******************/

    /**
     * 字符串、时间戳、UTC格式的字符串都无法正常转换
     * <p>
     * Failed to convert property value of type [java.lang.String] to required type [java.util.Date] for property 'birthday';
     * nested exception is org.springframework.core.convert.ConversionFailedException:
     * Failed to convert from type [java.lang.String] to type [@com.fasterxml.jackson.annotation.JsonFormat java.util.Date]
     * for value '2000-01-01 00:00:00'; nested exception is java.lang.IllegalArgumentException
     *
     * @param user
     */
    @RequestMapping("/getParam2")
    public void getParam2(User2 user) {
        System.out.println("birthday: " + user.getBirthday());
        return;
    }

    /**
     * 错误同上
     *
     * @param user
     */
    @PostMapping("/postParam2")
    public void postParam2(User2 user) {
        System.out.println("birthday: " + user.getBirthday());
        return;
    }

    /**
     * 使用@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")，只有body参数有效，GET 和POST方法都无法正常转换
     * body参数可以正常转换
     *
     * @param
     * @return birthday 返回
     */
    @PostMapping("/body2")
    public Date body2(@RequestBody User2 user) {
        System.out.println("birthday: " + user.getBirthday()); // Sat Jan 01 08:00:00 CST 2000
        return user.getBirthday();
    }

    /*********************************@JsonFormat 方法结束****************************************/

    @PostMapping("/query/user")
    public User queryUser(@RequestParam Long userId) {
        return userService.getUserById(userId);
    }

}
