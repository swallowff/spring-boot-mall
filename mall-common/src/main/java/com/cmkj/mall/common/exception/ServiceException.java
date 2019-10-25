package com.cmkj.mall.common.exception;

import com.cmkj.mall.common.api.IErrorCode;

/**
 * @author swallowff
 * @create 2019/10/11
 */
public class ServiceException extends RuntimeException {
    protected Integer errorCode;
    protected String errorMsg;

    public ServiceException() {
    }

    public ServiceException(Integer errorCode,String errorMsg){
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ServiceException(String message) {
        super(message);
        this.errorMsg = message;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        this.errorMsg = message;
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(IErrorCode errorCode){
        super(errorCode.getMessage());
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
