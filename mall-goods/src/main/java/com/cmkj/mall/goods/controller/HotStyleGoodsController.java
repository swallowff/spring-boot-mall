package com.cmkj.mall.goods.controller;

import com.cmkj.mall.common.annotation.ApiVersion;
import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.common.api.CommonResult;
import com.cmkj.mall.goods.entity.HotStyleGoods;
import com.cmkj.mall.goods.service.HotStyleGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:zhangli
 * @Version 1.0
 */
@Api(tags = {"爆款商品展示"},value = "爆款商品展示")
@ApiVersion(1)
@RestController
@RequestMapping(value = "{version}/api/mall/goods/style")
public class HotStyleGoodsController {

    @Autowired
    private HotStyleGoodsService hotStyleGoodsService;

    /**
     * 爆款商品
     * @param pageSize
     * @param pageNum
     * @return
     */
    @ApiOperation(httpMethod = "GET",value = "爆款商品",notes = "爆款商品")
    @RequestMapping(value = "hot",method = RequestMethod.GET)
    public CommonResult<CommonPage<HotStyleGoods>> getHotStyleGoods(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        return CommonResult.success(hotStyleGoodsService.getHotStyle(pageSize,pageNum));
    }
}
