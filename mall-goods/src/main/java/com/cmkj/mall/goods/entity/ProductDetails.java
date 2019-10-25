package com.cmkj.mall.goods.entity;

import com.cmkj.mall.model.pms.PmsProduct;
import com.cmkj.mall.model.pms.PmsProductTag;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author:zhangli
 * @Version 1.0
 * 商品详情
 */
@Setter
@Getter
public class ProductDetails implements Serializable {

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

    @ApiModelProperty(value = "库存")
    private Integer stock;

    @ApiModelProperty(value = "商品描述")
    private String description;

    @ApiModelProperty(value = "标签信息")
    private List<PmsProductTag> tagName;
}
