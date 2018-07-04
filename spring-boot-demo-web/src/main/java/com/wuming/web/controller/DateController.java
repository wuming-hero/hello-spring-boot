package com.wuming.web.controller;

import com.wuming.web.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 已生日：2000-01-01 00:00:00 为例子进行测试
 *
 * @author wuming
 * Created on 2018/5/12 15:21
 */
@RestController
@RequestMapping("/date")
public class DateController {

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
        return;
    }

    /*******************从上面可以看到，GET 或 POST 方法普通传参方式，在不做其他配置的前题下，是无法正常处理时间字符串的，包括时间戳字符串*******************/

    /**
     * 普通POST、PUT方法通过Body传递参数
     * 1.UTC 字符串 "birthday": "2000-01-01T00:00:00.000Z"
     * 可以正常转换为时间格式,但在参数表示的时间上自动加了8个小时
     *
     * @param user
     */
    @PostMapping("/body")
    public void bodyTest(@RequestBody User user) {
        System.out.println("birthday: " + user.getBirthday()); // Sat Jan 01 08:00:00 CST 2000
        return;
    }


}
