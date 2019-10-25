package com.cmkj.mall.goods.entity;

import com.cmkj.mall.model.pms.PmsProductCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:zhangli
 * @Version 1.0
 * 全部分类实体
 */
@Getter
@Setter
public class AllClassify implements Serializable{

    @ApiModelProperty(value = "分类id")
    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "一级分类下的二级分类")
    private List<AllClassify> allClassify;


}
