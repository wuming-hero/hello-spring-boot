package com.wuming.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 通过 Mapper 接口直接查询mapper.xml对行数库进行操作，
 * mapper.xml中的namespace必须指定为Mapper接口的全限定名
 *
 * @author wuming
 * Created on 2018/4/27 14:53
 */
@SpringBootApplication
public class MybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }
}
