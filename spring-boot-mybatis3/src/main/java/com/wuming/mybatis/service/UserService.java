package com.wuming.mybatis.service;

import com.wuming.mybatis.model.User;

/**
 * @author wuming
 * Created on 2018/4/27 22:07
 */
public interface UserService {

    User findById(Long uid);

    Long createUser(User user);

}
