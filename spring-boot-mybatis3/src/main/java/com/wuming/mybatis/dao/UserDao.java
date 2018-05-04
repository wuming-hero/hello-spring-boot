package com.wuming.mybatis.dao;

import com.ixiye.boot.mybatis.mysql.dao.MyBatisDao;
import com.wuming.mybatis.model.User;
import org.springframework.stereotype.Repository;

/**
 * 此处使用 @Repository 对数据库层操作进行注释
 *
 * @author wuming
 * Created on 2018/5/3 14:15
 */
@Repository
public class UserDao extends MyBatisDao<User> {

}
