package com.wuming.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wuming.web.common.BizException;
import com.wuming.web.common.ErrorEnum;
import com.wuming.web.common.InvokeWrapper;
import com.wuming.web.util.ResultUtil;
import com.wuming.web.enums.BizErrorEnum;
import com.wuming.web.helper.RedisManager;
import com.wuming.web.model.ResultDTO;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * 抽象模板工具类
 * <p>
 * 1. 统一处理方法运行异常 && 封装返回错误信息
 * 2. 支持分布式锁
 *
 * @author manji
 * Created on 2025/3/1 10:37
 */
@Slf4j
public abstract class BaseService {

    @Resource
    private RedisManager redisManager;

    /**
     * 默认2s
     */
    private static final Integer DEFAULT_EXPIRE = 2;



    /**
     * service 层通过wrapper层封装， 不需要分布式锁
     *
     * @param invokeWrapper
     * @param methodName
     * @param args
     * @param <T>
     * @return
     */
    protected <T> ResultDTO<T> invoke(InvokeWrapper<T> invokeWrapper, String methodName, LoggerArgs args) {
        return invoke(invokeWrapper, methodName, args, new LockEntry());
    }


    /**
     * service 层通过wrapper层封装，需要分布式锁
     *
     * @param invokeWrapper
     * @param methodName
     * @param args
     * @param lockEntry
     * @param <T>
     * @return
     */
    protected <T> ResultDTO<T> invoke(InvokeWrapper<T> invokeWrapper, String methodName, LoggerArgs args, LockEntry lockEntry) {
        // 返回的对象
        ResultDTO<T> result = null;
        boolean locked = false;
        try {
            doLock(lockEntry);
            locked = true;
            result = ResultUtil.success(invokeWrapper.invoke());
        } catch (BizException se) {
            log.error(getClassName() + "." + methodName + " error, args:{}", args.argsString(), se);
            result = ResultUtil.failed(se.getErrorEnum());
        } catch (IllegalArgumentException ie) {
            log.error(getClassName() + "." + methodName + " error, args:{}", args.argsString(), ie);
            result = ResultUtil.failed(new ErrorEnum() {
                @Override
                public String getErrorCode() {
                    return BizErrorEnum.MISS_PARAMS.getErrorCode();
                }

                @Override
                public String getErrorMsg() {
                    return ie.getMessage();
                }
            });
        } catch (Throwable t) {
            log.error(getClassName() + "." + methodName + " error, args:{}", args.argsString(), t);
            result = ResultUtil.failed(BizErrorEnum.SYSTEM_ERROR);
        } finally {
            if (lockEntry.needLock && locked) {
                redisManager.unlock(lockEntry.lockKey);
            }
            log.info(getClassName() + "." + methodName + " args:{}, res:{}", args.argsString(), JSONObject.toJSONString(result));
        }
        return result;
    }

    /**
     * 内部类锁对象
     */
    protected class LockEntry {
        private boolean needLock;
        private String lockKey;
        private Integer expireTime;

        public LockEntry() {
            this.needLock = false;
        }

        public LockEntry(String lockKey, Integer expireTime) {
            this.needLock = true;
            this.lockKey = lockKey;
            this.expireTime = expireTime;
        }

        public LockEntry(String lockKey) {

            this.needLock = true;
            this.lockKey = lockKey;
            this.expireTime = DEFAULT_EXPIRE;
        }
    }

    /**
     * 加锁
     *
     * @param lockEntry
     */
    private void doLock(LockEntry lockEntry) {

        if (lockEntry.needLock && !redisManager.lock(lockEntry.lockKey, lockEntry.expireTime)) {
            log.warn("BaseBenefitService.invoke lock error lockKey{}.", lockEntry.lockKey);
            throw new BizException(BizErrorEnum.CONCURRENT_LIMIT);
        }
    }

    /**
     * 内部类参数对象
     */
    public static class LoggerArgs {
        Object[] args;

        public LoggerArgs(Object... args) {
            this.args = args;
        }

        public String argsString() {
            StringBuffer stringBuffer = new StringBuffer();
            for (Object arg : args) {
                stringBuffer.append(JSON.toJSONString(arg)).append("|");
            }
            return stringBuffer.toString();
        }
    }

    private String getClassName() {
        return getClass().getSimpleName();
    }

}
