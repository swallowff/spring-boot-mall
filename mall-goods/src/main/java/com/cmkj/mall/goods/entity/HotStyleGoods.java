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
 * 爆款商品
 */
@Setter
@Getter
public class HotStyleGoods  implements Serializable {

    private Long id;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "图片")
    private String pic;

    @ApiModelProperty(value = "销量")
    private Integer sale;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "爆款状态:0->不是爆款；1->爆款")
    private Integer hotStyleStatus;
}
