package com.cmkj.mall.order.dto.ctrl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author swallowff
 * @create 2019/10/15
 */
@ApiModel
public class CartItemAddQuery {
    @ApiModelProperty(required = true,value = "会员ID")
    @NotNull(message = "memberId不能为空")
    private Long memberId;
    @ApiModelProperty(required = true,value = "商品sku-ID")
    @NotNull(message = "商品skuId不能为空")
    private Long skuId;
    @ApiModelProperty(required = true,value = "购买数量")
    @Min(value = 1,message = "数量有误")
    private Integer quantity = 1;    //数量

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
