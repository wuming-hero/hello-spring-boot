package com.wuming.mybatis.dao;

import com.wuming.mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 此处使用 @Mapper 对接口进行注解，且对应的xxMapper.xml的nameSpace必须指定为本接口限定名
 *
 * @author wuming
 * Created on 2018/5/2 17:53
 */
@Mapper
public interface UserMapper {

    Long create(User user);

    User findById(Long uid);
}
