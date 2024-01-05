package com.wuming.web.controller.handler;

import com.wuming.starter.annotation.Handler;
import com.wuming.web.controller.common.CommonConstant;
import com.wuming.web.model.User;
import org.springframework.stereotype.Service;

/**
 * @author manji
 * Created on 2024/1/5 23:17
 */
@Service
@Handler(
        type = CommonConstant.USER_HANDLER_TYPE,
        keys = {"default"},
        name = "默认用户处理器"
)
public class UserHandler extends AbstractUserHandler {

    @Override
    public User handle(Long userId) {
        User user = new User();
        user.setUid(1L);
        user.setAge(16);
        user.setName("青少年-小明");
        return user;
    }
}
