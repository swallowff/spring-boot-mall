package com.cmkj.mall.goods.controller;

import com.cmkj.mall.common.annotation.ApiVersion;
import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.common.api.CommonResult;
import com.cmkj.mall.goods.entity.BrandPavilion;
import com.cmkj.mall.goods.entity.ClassGoods;
import com.cmkj.mall.goods.service.BrandPavilionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:zhangli
 * @Version 1.0
 * 品牌馆Controller
 */
@Api(tags = {"品牌馆"},value = "品牌馆接口")
@ApiVersion(1)
@RestController
@RequestMapping(value = "{version}/api/mall/goods/brand")
public class BrandPavilionController {

    @Autowired
    private BrandPavilionService brandPavilionService;

    /**
     * 拿到热售品牌
     * @param pageSize
     * @param pageNum
     * @return
     */
    @ApiOperation(httpMethod = "GET",value = "商品热售品牌",notes = "商品热售品牌")
    @RequestMapping(value = "hotBrand",method = RequestMethod.GET)
    public CommonResult<CommonPage<BrandPavilion>>  getHotBrand(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        return  CommonResult.success(brandPavilionService.getHotBrandList(pageSize,pageNum));
    }


    /**
     * 拿到所有商品品牌分类
     * @return
     */
    @ApiOperation(httpMethod = "GET",value = "商品品牌全部分类",notes = "商品品牌全部分类")
    @RequestMapping(value = "all",method = RequestMethod.GET)
    public CommonResult<CommonPage<BrandPavilion>> getAllBrand(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        return CommonResult.success(brandPavilionService.getBrandList(pageSize,pageNum));
    }
    /**
     * 拿到商品品牌下归属的商品
     * @return
     */
    @ApiOperation(httpMethod = "POST",value = "商品品牌下所属商品",notes = "商品品牌下所属商品")
    @RequestMapping(value = "id",method = RequestMethod.POST)
    @ApiImplicitParam(required = true,name = "id",value = "品牌ID",paramType = "query")
    public CommonResult<CommonPage<ClassGoods>> getGoods(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Long id){
        return  CommonResult.success(brandPavilionService.getBrandGoodsList(pageSize,pageNum,id));
    }
}
