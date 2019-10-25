package com.cmkj.mall.goods.controller;

import com.cmkj.mall.common.annotation.ApiVersion;
import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.common.api.CommonResult;
import com.cmkj.mall.goods.entity.ProductComment;
import com.cmkj.mall.goods.entity.ProductDetails;
import com.cmkj.mall.goods.entity.ProductSpu;
import com.cmkj.mall.goods.entity.PushProduct;
import com.cmkj.mall.goods.service.GoodsTagCentreService;
import com.cmkj.mall.goods.service.ProductDetailsService;
import com.cmkj.mall.model.pms.PmsProductService;
import com.cmkj.mall.model.pms.PmsProductTag;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Author:zhangli
 * @Version 1.0
 */
@Api(tags = {"正常商品详情"},value = "正常商品详情接口")
@ApiVersion(1)
@RestController
@RequestMapping(value = "{version}/api/mall/goods/class")
public class ProductDetailsController {

    @Autowired
    private ProductDetailsService productDetailsService;

    @Autowired
    private GoodsTagCentreService goodsTagCentreService;
    /**
     * 正常商品详情
     * @param pageSize
     * @param pageNum
     * @return
     */
    @ApiOperation(httpMethod = "GET",value = "正常商品详情",notes = "正常商品详情")
    @RequestMapping(value = "details",method = RequestMethod.GET)
    public CommonResult<CommonPage<ProductDetails>> getGoodsList(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        return CommonResult.success(productDetailsService.getProductDetailsList(pageSize,pageNum));
    }

    /**
     * 根据商品id，拿到商品对应的spu
     * @param pageSize
     * @param pageNum
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "POST",value = "正常商品Spu",notes = "正常商品Spu")
    @RequestMapping(value = "spu",method = RequestMethod.POST)
    @ApiImplicitParam(required = true,name = "id",value = "商品ID",paramType = "query")
    public CommonResult<CommonPage<ProductSpu>> getSpuList(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Long id){
        return CommonResult.success(productDetailsService.getSpuList(pageSize,pageNum,id));
    }

    /**
     * 根据商品id，拿到商品对应的Comment
     * @param pageSize
     * @param pageNum
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "POST",value = "商品详情评论",notes = "商品详情评论")
    @RequestMapping(value = "comment",method = RequestMethod.POST)
    @ApiImplicitParam(required = true,name = "id",value = "商品ID",paramType = "query")
    public CommonResult<CommonPage<ProductComment>> getCommentList(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Long id){
        return CommonResult.success(productDetailsService.getCommentList(pageSize,pageNum,id));
    }

    /**
     * 根据当前商品id，拿到商品对应的分类下的商品
     * @param pageSize
     * @param pageNum
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "POST",value = "商品推荐",notes = "商品推荐")
    @RequestMapping(value = "push",method = RequestMethod.POST)
    @ApiImplicitParam(required = true,name = "id",value = "当前商品ID",paramType = "query")
    public CommonResult<CommonPage<PushProduct>> getPushGoodstList(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Long id){
        return CommonResult.success(productDetailsService.getPushGoodsList(pageSize,pageNum,id));
    }
    /**
     * 分享当前商品

     * @return
     */
    @ApiOperation(httpMethod = "GET",value = "商品分享二维码",notes = "商品分享二维码")
    @RequestMapping(value = "qr",method = RequestMethod.GET)
    public CommonResult getGoodsQrCode() {
        productDetailsService.getGoodsQrCode();
        return CommonResult.success("二维码生成成功！");
    }

    /**
     * 根据商品id,拿到商品所属的标签
     * @param pageSize
     * @param pageNum
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "POST",value = "商品所属标签",notes = "商品所属标签")
    @RequestMapping(value = "more",method = RequestMethod.POST)
    @ApiImplicitParam(required = true,name = "id",value = "商品id",paramType = "query")
    public CommonResult<CommonPage<PmsProductTag>> getGoodsTag(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Long id){
        return  CommonResult.success(goodsTagCentreService.getGoodsTag(pageSize,pageNum,id));
    }

    /**
     * 根据商品id,拿到商品所属的服务
     * @param pageSize
     * @param pageNum
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "POST",value = "商品所属服务",notes = "商品所属服务")
    @RequestMapping(value = "pservice",method = RequestMethod.POST)
    @ApiImplicitParam(required = true,name = "id",value = "商品id",paramType = "query")
    public CommonResult<CommonPage<PmsProductService>> getGoodsService(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Long id){
        return  CommonResult.success(productDetailsService.getGoodsServiceList(pageSize,pageNum,id));
    }

}
