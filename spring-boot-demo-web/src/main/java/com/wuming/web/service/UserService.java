package com.wuming.web.service;

import com.wuming.web.model.ResultDTO;
import com.wuming.web.model.User;
import com.wuming.web.model.UserRequest;

/**
 * @author manji
 * Created on 2024/1/5 23:14
 */
public interface UserService {

    User getUserById(Long userId);

    ResultDTO<User> queryUser(UserRequest userRequest);

}
