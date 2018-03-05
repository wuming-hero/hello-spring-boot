package com.wuming.properties.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 通过@Value方式直接注入值，不需要使用setter()方法
 * 此方式不支持 Key 的Relaxed binding模式，key的值需与配置中的字符串一致
 */
@Component
public class Properties {

    @Value("${server.display-name}")
    private String serverName;
    @Value("${server.full.display-name}")
    private String serverFullName;
    @Value("${server.address}")
    private String address;
    @Value(("${server.port}"))
    private String port;
    @Value("${my.secret}")
    private String secret;

    @Override
    public String toString() {
        return "Properties{" +
                "serverName='" + serverName + '\'' +
                ", serverFullName='" + serverFullName + '\'' +
                ", address='" + address + '\'' +
                ", port='" + port + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}