package com.cmkj.mall.goods.entity;

import com.cmkj.mall.model.pms.PmsProductCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author:zhangli
 * @Version 1.0
 * 分类级别
 */
@Getter
@Setter
public class GoodsClassify implements Serializable {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "上机分类的编号：0表示一级分类")
    private Long parentId;

    @ApiModelProperty(value = "名称")
    private String name;

}
