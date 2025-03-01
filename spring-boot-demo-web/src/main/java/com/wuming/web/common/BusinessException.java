package com.wuming.web.common;

/**
 * 系统异常类
 * @author manji
 * Created on 2025/3/1 10:48
 */
public class BusinessException extends RuntimeException {

    private ErrorEnum errorEnum;
    private String errorCode;
    private String errorMsg;

    public BusinessException() {
        super();
    }

    public BusinessException(Throwable e) {
        super(e);
    }

    public BusinessException(String errorMsg, Throwable e) {
        super(errorMsg, e);
    }

    public BusinessException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BusinessException(ErrorEnum errorEnum, String errorMsg) {
        super(errorMsg);
        this.errorEnum = errorEnum;
        this.errorCode = errorEnum.getErrorCode();
        this.errorMsg = errorMsg;
    }

    public BusinessException(ErrorEnum errorEnum) {
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
