package com.cmkj.mall.goods.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author:zhangli
 * @Version 1.0
 * 品牌馆展示Brand实体
 */
@Setter
@Getter
public class BrandPavilion implements Serializable {

    @ApiModelProperty(value = "品牌id")
    private Long id;

    @ApiModelProperty(value = "品牌名称")
    private String name;

    @ApiModelProperty(value = "品牌logo")
    private String logo;
}
