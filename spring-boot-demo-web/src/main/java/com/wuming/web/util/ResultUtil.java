package com.wuming.web.util;

import com.wuming.web.common.BizException;
import com.wuming.web.common.ErrorEnum;
import com.wuming.web.enums.BizErrorEnum;
import com.wuming.web.model.ResultDTO;


/**
 * @author manji
 * Created on 2025/3/1 10:38
 */
public class ResultUtil {

        public static <T> ResultDTO<T> success(T data) {
            ResultDTO<T> successResult = new ResultDTO();
            successResult.setSuccess(true);
            successResult.setErrorCode("SUCCESS");
            successResult.setErrorMessage("成功");
            successResult.setData(data);
            return successResult;
        }

        public static <T> ResultDTO<T> success() {
            ResultDTO<T> successResult = new ResultDTO();
            successResult.setSuccess(true);
            successResult.setErrorCode("SUCCESS");
            successResult.setErrorMessage("成功");
            return successResult;
        }

        public static <T> ResultDTO<T> failed(BizErrorEnum businessErrorEnum) {
            ResultDTO<T> errorResult = new ResultDTO();
            errorResult.setSuccess(false);
            errorResult.setErrorCode(businessErrorEnum.getErrorCode());
            errorResult.setErrorMessage(businessErrorEnum.getErrorMsg());
            return errorResult;
        }
        public static <T> ResultDTO<T> failed(BizException bizException) {
            ResultDTO<T> errorResult = new ResultDTO();
            errorResult.setSuccess(false);
            errorResult.setErrorCode(bizException.getErrorCode());
            errorResult.setErrorMessage(bizException.getErrorMsg());
            return errorResult;
        }

        public static <T> ResultDTO<T> failed(ErrorEnum errorEnum) {
            ResultDTO<T> errorResult = new ResultDTO();
            errorResult.setSuccess(false);
            errorResult.setErrorCode(errorEnum.getErrorCode());
            errorResult.setErrorMessage(errorEnum.getErrorMsg());
            return errorResult;
        }
}
