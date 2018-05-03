package com.wuming.mybatis.dao;

import com.wuming.mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wuming
 * Created on 2018/5/2 17:53
 */
@Mapper
public interface UserMapper {

    Long create(User user);

    User findById(Long uid);
}
