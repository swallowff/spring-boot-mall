package com.cmkj.mall.goods.controller;

import com.cmkj.mall.common.annotation.ApiVersion;
import com.cmkj.mall.common.api.CommonResult;
import com.cmkj.mall.goods.entity.GoodsClassify;
import com.cmkj.mall.goods.service.GoodsClassifyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 分类Controller
 * @Author:zhangli
 * @Version 1.0
 */
@Api(tags = {"首页一级分类"},value = "商品一级分类接口")
@ApiVersion(1)
@RestController
@RequestMapping(value = "{version}/api/mall/goods/class")
public class GoodsClassifyController {

    @Autowired
    private GoodsClassifyService goodsClassifyService;

    @ApiOperation(httpMethod = "GET",value = "商品一级分类",notes = "商品一级分类")
    @RequestMapping(value = "first",method = RequestMethod.GET)
    public CommonResult<List<GoodsClassify>>  getFirstGoodsClass(){
        //获取产品分类表的一级分类
        return  CommonResult.success(goodsClassifyService.getFirstGoodsClass());
    }
}
