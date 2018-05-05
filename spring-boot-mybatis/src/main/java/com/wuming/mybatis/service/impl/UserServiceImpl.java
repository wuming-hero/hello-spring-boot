package com.wuming.mybatis.service.impl;

import com.wuming.mybatis.mapper.UserMapper;
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
    private UserMapper userMapper;

    @Override
    public User findById(Long uid) {
        return userMapper.findById(uid);
    }

    @Override
    public Long createUser(User user) {
        userMapper.create(user);
        return user.getId();
    }
}
