package com.wuming.web.enums;

import com.wuming.web.common.ErrorEnum;

/**
 * @author manji
 * Created on 2025/3/1 10:50
 */
public enum BusinessErrorEnum implements ErrorEnum  {
    SYSTEM_ERROR("0000", "服务器开小差了，请稍后再试"),
    MISS_PARAMS("0001", "缺少必要参数"),
    PARAM_ILLEGAL("0002", "参数无效" ),
    CONCURRENT_LIMIT("0003", "请求遇到并发问题，请稍后重试"),
    ;

    private String errorCode;

    private String errorMsg;

    BusinessErrorEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    @Override
    public String getErrorCode() {
        return null;
    }

    @Override
    public String getErrorMsg() {
        return null;
    }
}
