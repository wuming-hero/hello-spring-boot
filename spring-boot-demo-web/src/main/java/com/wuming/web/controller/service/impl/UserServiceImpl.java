package com.wuming.web.controller.service.impl;

import com.wuming.starter.AbstractRouter;
import com.wuming.web.controller.common.CommonConstant;
import com.wuming.web.controller.handler.AbstractUserHandler;
import com.wuming.web.controller.service.UserService;
import com.wuming.web.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author manji
 * Created on 2024/1/5 23:15
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private AbstractRouter abstractRouter;


    @Override
    public User getUserById(Long userId) {
        // TODO manji 2024/1/5 23:37 根据对应的key 获取相应的处理器
        String mockBusinessKey = "adult";
        AbstractUserHandler userHandler = abstractRouter.router(CommonConstant.USER_HANDLER_TYPE, mockBusinessKey, AbstractUserHandler.class);
        if (Objects.isNull(userHandler)) {
            log.info("UserServiceImpl#getUserById failed, userHandler is null, userId={}", userId);
            return null;
        }
        User user = userHandler.handle(userId);
        log.info("UserServiceImpl#getUserById finished, userId={}, user={}", userId, user);
        return user;
    }

}
