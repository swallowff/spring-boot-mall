package com.cmkj.mall.goods.controller;

import com.cmkj.mall.common.annotation.ApiVersion;
import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.common.api.CommonResult;
import com.cmkj.mall.goods.service.ProductTagService;
import com.cmkj.mall.model.pms.PmsProductTag;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:zhangli
 * @Version 1.0
 */
@Api(tags = {"商品标签"},value = "商品标签")
@ApiVersion(1)
@RestController
@RequestMapping(value = "{version}/api/mall/goods/tag")
public class ProductTagController {

    @Autowired
    private ProductTagService productTagService;


    /**
     * 商品标签的添加
     * @param tagName
     * @return
     */
    @ApiOperation(httpMethod = "PUT",value = "商品标签添加",notes = "商品标签添加")
    @RequestMapping(value = "addTag",method = RequestMethod.PUT)
    @ApiImplicitParam(required = true,name = "tagName",value = "标签名字",paramType = "add")
    public CommonResult addTag(String tagName) {
        productTagService.addTag(tagName);
        return CommonResult.success("商品标签添加成功！");
    }
    /**
     * 商品标签的删除
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE",value = "商品标签删除",notes = "商品标签删除")
    @RequestMapping(value = "deleteTag",method = RequestMethod.DELETE)
    @ApiImplicitParam(required = true,name = "id",value = "标签ID",paramType = "delete")
    public CommonResult deleteTag(Long id) {
        productTagService.deleteTag(id);
        return CommonResult.success("商品标签删除成功！");
    }
    /**
     * 商品标签的修改
     * @param pmsProductTag
     * @return
     */
    @ApiOperation(httpMethod = "POST",value = "商品标签修改",notes = "商品标签修改")
    @RequestMapping(value = "updateTag",method = RequestMethod.POST)
    public CommonResult updataTag(PmsProductTag pmsProductTag) {
        productTagService.updataTag(pmsProductTag);
        return CommonResult.success("商品标签修改成功！");
    }
    /**
     * 商品标签的查询
     * @return
     */
    @ApiOperation(httpMethod = "GET",value = "商品标签查询",notes = "商品标签查询")
    @RequestMapping(value = "selectAllTag",method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsProductTag>> selectAllTag() {
        return CommonResult.success(productTagService.selectAllTag());
    }




}
