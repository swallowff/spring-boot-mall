package com.cmkj.mall.common.api;

import com.cmkj.mall.common.exception.ServiceException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * @author swallowff
 * @create 2019/10/14
 */
public class BaseApiCtrl {

    public void validBindingResult(BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError error : errors){
                sb.append(error.getDefaultMessage()+";");
            }
            throw new ServiceException(ResultCode.REQUEST_PARAM_VALID_FAILED.getCode(),sb.toString());
        }
    }

}
