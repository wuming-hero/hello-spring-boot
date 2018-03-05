package com.wuming.properties.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Spring Boot的@ConfigurationProperties注解对这种属性注入方式的key校验不是很严格，
 * 你可以在属性配置文件中配置DB.IP或DB_IP，Spring Boot都可以处理。
 * 注：需要提供类成员的setter()方法，不然，无法绑定值，但不会报错。。。
 *
 * @author wuming
 * Created on 2018/3/5 15:55
 */

@Component
@ConfigurationProperties(prefix = "db")
public class PropertiesConfig {
    private String ip;
    private String port;
    private String displayName;
    // Page 不可以为内部类
    private Page page;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "PropertiesConfig{" +
                "ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", displayName='" + displayName + '\'' +
                ", page=" + page +
                '}';
    }
}

