package com.cmkj.mall.goods.entity;

import com.cmkj.mall.model.pms.PmsComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:zhangli
 * @Version 1.0
 * 商品详情评论
 */
@Getter
@Setter
public class ProductComment implements Serializable{

    @ApiModelProperty(value = "评价id")
    private Long id;

    @ApiModelProperty(value = "商品id")
    private Long productId;

    @ApiModelProperty(value = "会员昵称")
    private String memberNickName;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "评价星数：0->5")
    private Integer star;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "是否显示")
    private Integer showStatus;

    @ApiModelProperty(value = "阅读数")
    private Integer readCount;

    @ApiModelProperty(value = "评论用户头像")
    private String memberIcon;

    @ApiModelProperty(value = "回复数")
    private Integer replayCount;

    @ApiModelProperty(value = "内容")
    private String content;

}
