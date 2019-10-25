package com.cmkj.mall.goods.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author:zhangli
 * @Version 1.0
 * 商品详情页，推荐商品
 */
@Setter
@Getter
public class PushProduct implements Serializable {

    @ApiModelProperty(value = "商品id")
    private Long id;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "图片")
    private String pic;

    @ApiModelProperty(value = "销量")
    private Integer sale;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

}
