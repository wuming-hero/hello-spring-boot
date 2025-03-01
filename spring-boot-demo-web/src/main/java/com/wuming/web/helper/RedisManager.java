package com.wuming.web.helper;

import org.springframework.stereotype.Component;

/**
 * mock redis
 *
 * @author manji
 * Created on 2025/3/1 11:05
 */
@Component
public class RedisManager {

    /**
     * 锁定方法
     *
     * <p>根据指定的key和过期时间来锁定资源
     *
     * @param key    锁定资源的键值
     * @param expire 锁定的过期时间
     * @return true，表示成功锁定资源
     */
    public boolean lock(String key, int expire) {
        return true;
    }

    public boolean unlock(String key) {
        return true;
    }
}
