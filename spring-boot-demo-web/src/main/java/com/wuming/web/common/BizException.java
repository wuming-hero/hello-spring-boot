package com.wuming.web.common;

/**
 * 系统异常类
 * @author manji
 * Created on 2025/3/1 10:48
 */
public class BizException extends RuntimeException {

    private ErrorEnum errorEnum;
    private String errorCode;
    private String errorMsg;

    public BizException() {
        super();
    }

    public BizException(Throwable e) {
        super(e);
    }

    public BizException(String errorMsg, Throwable e) {
        super(errorMsg, e);
    }

    public BizException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(ErrorEnum errorEnum, String errorMsg) {
        super(errorMsg);
        this.errorEnum = errorEnum;
        this.errorCode = errorEnum.getErrorCode();
        this.errorMsg = errorMsg;
    }

    public BizException(ErrorEnum errorEnum) {
        super("[" + errorEnum.getErrorCode() + "]" + ":" + errorEnum.getErrorMsg());
        this.errorEnum = errorEnum;
        this.errorCode = errorEnum.getErrorCode();
        this.errorMsg = errorEnum.getErrorMsg();
    }

    public ErrorEnum getErrorEnum() {
        return errorEnum;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
