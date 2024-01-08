package com.wuming.starter;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.wuming.starter.handler.Handler;
import com.wuming.starter.util.ApplicationContextProvider;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;

/**
 * 抽象服务路由处理器
 * 具体实现
 * 1. 定义 Table存储器，扫描带 @Handler 注解有类，并将实例记录在Table中
 * <p>
 * <p>
 * 引入及使用
 * 1. 引入方需要注意启动时初始化该类
 * 2. 使用方根据type 和key 从Table中索引对应的服务，索引到对应的服务，则处理后续业务逻辑
 *
 * @author manji
 * @date 2024/1/4
 */
@Component
public class AbstractRouter {

    private Logger logger = LoggerFactory.getLogger(AbstractRouter.class);

    /**
     * 处理器窗口
     */
    private Table<String, String, Handler> routerMaps = HashBasedTable.create();

    @Resource
    private ApplicationContextProvider applicationContextProvider;

    /**
     * 初始化路由器
     */
    @PostConstruct
    public void init() throws Exception {
        Map<String, Object> beans = applicationContextProvider.getBeansWithAnnotation(com.wuming.starter.annotation.Handler.class);
        if (MapUtils.isNotEmpty(beans)) {
            beans.forEach((beanName, bean) -> {
                com.wuming.starter.annotation.Handler annotation = bean.getClass().getAnnotation(com.wuming.starter.annotation.Handler.class);
                String[] keys = annotation.keys();
                String type = annotation.type();
                for (String key : keys) {
                    routerMaps.put(type, key, (Handler) (applicationContextProvider.getBean(beanName)));
                }
            });
        }
        logger.info("init finish routerMaps={}", routerMaps);
    }

    /**
     * 路由获取处理器
     *
     * @param type
     * @param key
     * @return
     */
    @Deprecated
    public Handler router(String type, String key) {
        Map<String, Handler> abstractHandlerMap = routerMaps.row(type);
        if (MapUtils.isNotEmpty(abstractHandlerMap)) {
            return abstractHandlerMap.get(key);
        }
        return null;
    }

    /**
     * 返回指定类型的handler
     *
     * @param type
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T router(String type, String key, Class<T> clazz) {
        Handler abstractHandler = this.router(type, key);
        if (abstractHandler != null) {
            return (T) abstractHandler;
        }
        return null;
    }

    /**
     * 路由获取处理器(带默认值)
     *
     * @param type
     * @param key
     * @param defaultHandler
     * @return
     */
    public Handler router(String type, String key, Handler defaultHandler) {
        return this.router(type, key) == null ? defaultHandler : this.router(type, key);
    }

    /**
     * 调用路由方法，如果不存在就返回空值
     *
     * @param type
     * @param key
     * @param param
     * @param <T>
     * @return
     */
    public <R, T> R invokeWithEmptyDefault(String type, String key, T param) {
        Handler abstractHandler = this.router(type, key);

        if (abstractHandler == null) {
            return null;
        }
        return (R) abstractHandler.handle(param);
    }

    /**
     * 调用路由方法，如果不存在就返回默认处理器
     *
     * @param type
     * @param key
     * @param param
     * @param defaultParamHandler
     * @param <T>
     * @return
     */
    public <R, T> R invokeWithDefault(String type, String key, T param, Handler<R, T> defaultParamHandler) {
        Handler abstractHandler = this.router(type, key);
        if (abstractHandler == null) {
            return defaultParamHandler.handle(param);
        }
        return (R) abstractHandler.handle(param);
    }

}
