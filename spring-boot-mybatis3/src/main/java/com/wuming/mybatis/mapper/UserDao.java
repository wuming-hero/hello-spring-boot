package com.wuming.mybatis.mapper;

//import com.ixiye.boot.mybatis.mysql.dao.MyBatisDao;
import com.wuming.mybatis.model.User;
import org.springframework.stereotype.Repository;

/**
 * 此处使用 @Repository 对数据库层操作进行注释
 * 前题1参考spring-boot-mybatis2：使用Dao层访问mapper.xml进行数据库操作，mapper.xml的限定名不能为空，
 * 且dao层必须使用全限定名，即namespace.findById
 * <p>
 * 因为此处继承MyBatisDao<T>传入参数化对象为 User，所以UserMapper.xml的namespace必须为User。
 * MyBatisDao中对一此常用的操作进行了封装，且使用ParameterizedType接口，运用java反射技术对参数类型进行了判断，
 * 获取当前Dao层的namespace(与mapper.xml中的namespaces值相同)。
 * 所以
 * if ((getClass().getGenericSuperclass() instanceof ParameterizedType)) {
 *     this.nameSpace = ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
 * } else {
 *     this.nameSpace = ((Class) ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
 * }
 *
 * protected String sqlId(String id) {
 *     return this.nameSpace + "." + id;
 * }
 *
 * @author wuming
 * Created on 2018/5/3 14:15
 */
@Repository
//public class UserDao extends MyBatisDao<User> {
public class UserDao {

}
