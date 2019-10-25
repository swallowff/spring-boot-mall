package com.cmkj.mall.common.constant.resultcode;

import com.cmkj.mall.common.api.IErrorCode;

/**
 * @author swallowff
 * @create 2019/10/15
 */
public enum GoodsResultCode implements IErrorCode {
    GOODS_EXPIRED(1000,"商品已过期");


    private Integer code;
    private String message;

    GoodsResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
