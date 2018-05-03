package com.wuming.mybatis.dao;

import com.wuming.mybatis.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 此处使用 @Repository 对数据库层操作进行注释
 *
 * @author wuming
 * Created on 2018/5/3 14:15
 */
@Repository
public class UserDao {

    @Autowired
    private SqlSession sqlSession;

    public Boolean create(User user) {
        return sqlSession.insert("create", user) == 1;
    }

    public User findById(Long uid) {
        return sqlSession.selectOne("findById", uid);
    }
}
