package com.wuming.mybatis.mapper;

import com.wuming.mybatis.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;

/**
 * 此处使用 @Repository 对数据库层操作进行注释
 * <p>
 * 在使用sqlSession直接执行Mapper.xml对应ID的查询时，如果不指定ID对应的全限定名，则会报如下错：
 * Cause: java.lang.IllegalArgumentException: findById is ambiguous in Mapped Statements collection
 * (try using the full name including the namespace, or rename one of the entries)
 *
 * @author wuming
 * Created on 2018/5/3 14:15
 */
@Repository
public class UserDao {

    private final String nameSpace;

    @Autowired
    private SqlSession sqlSession;

    public UserDao() {
        if (this.getClass().getGenericSuperclass() instanceof ParameterizedType) {
            this.nameSpace = ((Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
        } else {
            this.nameSpace = ((Class) ((ParameterizedType) this.getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
        }
    }

    public Boolean create(User user) {
        return sqlSession.insert("create", user) == 1;
    }

    public User findById(Long uid) {
        return sqlSession.selectOne("xxx.findById", uid);
    }

    public String sqlId(String id) {
        System.out.println(this.nameSpace);
        return this.nameSpace + "." + id;
    }

}
