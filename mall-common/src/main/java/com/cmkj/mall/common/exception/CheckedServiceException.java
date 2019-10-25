package com.cmkj.mall.common.exception;

import com.cmkj.mall.common.api.IErrorCode;

/**
 * @author swallowff
 * @create 2019/10/11
 */
public class CheckedServiceException extends Exception {
    protected Integer errorCode;
    protected String errorMsg;

    public CheckedServiceException() {
    }

    public CheckedServiceException(Integer errorCode,String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public CheckedServiceException(String message) {
        super(message);
        this.errorMsg = message;
    }

    public CheckedServiceException(String message, Throwable cause) {
        super(message, cause);
        this.errorMsg = message;
    }

    public CheckedServiceException(Throwable cause) {
        super(cause);
    }

    public CheckedServiceException(IErrorCode errorCode){
        super(errorCode.getCode() + ":" + errorCode.getMessage());
        this.errorCode = errorCode.getCode();
        this.errorMsg = errorCode.getMessage();
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
