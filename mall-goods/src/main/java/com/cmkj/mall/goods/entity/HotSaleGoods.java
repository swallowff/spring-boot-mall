package com.cmkj.mall.goods.entity;


import com.cmkj.mall.model.pms.PmsProduct;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author:zhangli
 * @Version 1.0
 * 每日热售商品
 * 新品推荐
 */
@Getter
@Setter
public class HotSaleGoods implements Serializable{

    @ApiModelProperty(value = "商品id")
    private Long id;

    @ApiModelProperty(value = "商品名字")
    private String name;

    @ApiModelProperty(value = "图片")
    private String pic;

    @ApiModelProperty(value = "新品状态:0->不是新品；1->新品")
    private Integer newStatus;

    @ApiModelProperty(value = "热售状态:0->不是热售；1->热售")
    private Integer hotSaleStatus;

    @ApiModelProperty(value = "销量")
    private Integer sale;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

}
