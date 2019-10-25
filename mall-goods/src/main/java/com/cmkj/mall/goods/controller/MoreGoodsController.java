package com.cmkj.mall.goods.controller;

import com.cmkj.mall.common.annotation.ApiVersion;
import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.common.api.CommonResult;
import com.cmkj.mall.goods.entity.MoreGoods;
import com.cmkj.mall.goods.service.MoreGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 更多热售，新上 商品Controller
 * @Author:zhangli
 * @Version 1.0
 */
@Api(tags = {"首页热售，新上商品多属性展示"},value = "热售，新上更多商品展示接口")
@ApiVersion(1)
@RestController
@RequestMapping(value = "{version}/api/mall/goods/more")
public class MoreGoodsController {

    @Autowired
    private MoreGoodsService moreGoodsService;

    /**
     * 热售商品 ，展示图片，名称，原价，折扣价，热售状态，库存属性
     * @param pageSize
     * @param pageNum
     * @return
     */
    @ApiOperation(httpMethod = "GET",value = "热售商品",notes = "热售商品")
    @RequestMapping(value = "hotSale",method = RequestMethod.GET)
    public CommonResult<CommonPage<MoreGoods>> getMoreHotSaleGoodsList(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        return  CommonResult.success(moreGoodsService.getMoreHotSaleGoodsList(pageSize,pageNum));
    }
    /**
     * 新上商品 ，展示图片，名称，原价，折扣价，新品状态，库存属性
     * @param pageSize
     * @param pageNum
     * @return
     */
    @ApiOperation(httpMethod = "GET",value = "新上商品",notes = "新上商品")
    @RequestMapping(value = "newGood",method = RequestMethod.GET)
    public CommonResult<CommonPage<MoreGoods>> getMoreNewGoodsList(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        return CommonResult.success(moreGoodsService.getMoreNewGoodsList(pageSize,pageNum));
    }
}
