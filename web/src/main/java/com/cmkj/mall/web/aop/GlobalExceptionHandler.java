package com.cmkj.mall.web.aop;

import com.cmkj.mall.common.api.CommonResult;
import com.cmkj.mall.common.api.ResultCode;
import com.cmkj.mall.common.exception.CheckedServiceException;
import com.cmkj.mall.common.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @author swallowff
 * @create 2019/10/14
 */
@ControllerAdvice
@Order(-1)
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CommonResult serviceException(ServiceException e, HttpServletRequest request){
        if (log.isInfoEnabled()){
            log.info("业务异常:",e);
        }
        return CommonResult.of(e.getErrorCode(),e.getErrorMsg());
    }

    @ExceptionHandler(CheckedServiceException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CommonResult checkedServiceException(CheckedServiceException e, HttpServletRequest request){
        if (log.isInfoEnabled()){
            log.error("受检业务异常:",e);
        }
        return CommonResult.of(e.getErrorCode(),e.getErrorMsg());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public CommonResult runtimeException(RuntimeException e, HttpServletRequest request){
        if (log.isInfoEnabled()){
            log.error("运行时异常:",e);
        }
        CommonResult commonResult = CommonResult.failed(ResultCode.SERVER_ERROR);
        commonResult.setData(e.getMessage());
        return commonResult;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public CommonResult exception(Exception e, HttpServletRequest request){
        if (log.isInfoEnabled()){
            log.error("未受检异常:",e);
        }
        CommonResult commonResult = CommonResult.failed(ResultCode.SERVER_ERROR);
        commonResult.setData(e.getMessage());
        return commonResult;
    }


}
