package com.cmkj.mall.goods.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author:zhangli
 * @Version 1.0
 * 商品spu
 */
@Getter
@Setter
public class ProductSpu implements Serializable {

    @ApiModelProperty(value = "商品id")
    private Long productId;

    @ApiModelProperty(value = "sku编码")
    private String skuCode;

    @ApiModelProperty(value = "销售属性1")
    private String sp1;

    @ApiModelProperty(value = "规格属性2")
    private String sp2;

    @ApiModelProperty(value = "规格属性3")
    private String sp3;
}
