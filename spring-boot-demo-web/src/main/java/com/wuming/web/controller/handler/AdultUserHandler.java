package com.wuming.web.controller.handler;

import com.wuming.starter.annotation.Handler;
import com.wuming.web.controller.common.CommonConstant;
import com.wuming.web.model.User;
import org.springframework.stereotype.Service;

/**
 * @author manji
 * Created on 2024/1/5 23:25
 */
@Service
@Handler(
        type = CommonConstant.USER_HANDLER_TYPE,
        keys = {"adult"},
        name="成人处理器"
)
public class AdultUserHandler extends AbstractUserHandler{

    @Override
    public User handle(Long uid) {
        User user = new User();
        user.setUid(1L);
        user.setAge(18);
        user.setName("中年人小强");
        return user;
    }
}
