package com.wuming.web.util;

import com.alibaba.fastjson.JSON;
import com.wuming.web.common.BizException;
import com.wuming.web.enums.BizErrorEnum;
import com.wuming.web.model.ResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * hsf调用工具类
 * 适用
 *
 * 1.单个入参对象
 *
 * @author manji 
 * @Date 2025/1/16
 */
public class HsfResultUtil {

    private static final Logger logger = LoggerFactory.getLogger(HsfResultUtil.class);

    public static <T, R> R call(T request, Function<T, R> function) {
        R result = null;
        try {
            result = function.apply(request);
        } catch (BizException e) {
            logger.error("call hsf service timeout", e);
        } catch (Throwable t) {
            logger.error("call hsf service error", t);
        }
        return result;
    }


    public static <R, T> ResultDTO<R> callBizProcess(T request, Consumer<T> checkFunction, Function<T, R> bizFunction) {
        ResultDTO<R> hsfResult = null;
        try {
            if (checkFunction != null) {
                checkFunction.accept(request);
            }
            R resp = bizFunction.apply(request);
            hsfResult = ResultUtil.success(resp);
        } catch (BizException bizException) {
            hsfResult = ResultUtil.failed(bizException);
        } catch (Throwable t) {
            logger.error("callBizProcess exception, req=" + JSON.toJSONString(request), t);
            hsfResult = ResultUtil.failed(BizErrorEnum.SYSTEM_ERROR);
        }
        return hsfResult;
    }

}
