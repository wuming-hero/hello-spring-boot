package com.wuming.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 通过dao层对数据库进行操作
 * dao层需要注入SqlSession，使用使用sqlSession 执行相关的相关的sql语句
 * <p>
 * 1.mapper.xml的 namespace 必需指定，但可以是任意值，不同mapper.xml不重复即可。（建议使用当前实体类的名字）
 * 2.要执行的sql语句ID必需是全限定名的，即namespace.findById。
 * 举例：namespace="User",则查询语句为 sqlSession.selectOne("User.findById");
 *
 * @author wuming
 * Created on 2018/4/27 14:53
 */
@SpringBootApplication
public class MybatisApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication2.class, args);
    }
}
