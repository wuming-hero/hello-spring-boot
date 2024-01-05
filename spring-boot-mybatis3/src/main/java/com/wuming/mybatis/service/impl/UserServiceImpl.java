package com.wuming.mybatis.service.impl;

import com.wuming.mybatis.mapper.UserDao;
import com.wuming.mybatis.model.User;
import com.wuming.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wuming
 * Created on 2018/5/2 17:55
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findById(Long uid) {
//        return userDao.findById(uid);
        return new User();
    }

    @Override
    public Long createUser(User user) {
//        userDao.create(user);
        return user.getId();
    }
}
