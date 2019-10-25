package com.cmkj.mall.goods.controller;

import com.cmkj.mall.common.annotation.ApiVersion;
import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.common.api.CommonResult;
import com.cmkj.mall.goods.service.PmsProductServiceService;
import com.cmkj.mall.model.pms.PmsProductService;
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
 * 商品服务表Controller
 */
@Api(tags = {"商品服务"},value = "商品服务")
@ApiVersion(1)
@RestController
@RequestMapping(value = "{version}/api/mall/goods/service")
public class PmsProductServiceController {

    @Autowired
    private PmsProductServiceService pmsProductServiceService;


    /**
     * 商品服务的添加
     * @param entity
     * @return
     */
    @ApiOperation(httpMethod = "PUT",value = "商品服务添加",notes = "商品服务添加")
    @RequestMapping(value = "addSer",method = RequestMethod.PUT)
    @ApiImplicitParam(required = true,name = "entity",value = "评论",paramType = "add")
    public CommonResult save(PmsProductService entity) {
        pmsProductServiceService.save(entity);
        return CommonResult.success("商品服务添加成功！");
    }
    /**
     * 商品评论的删除
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE",value = "商品服务删除",notes = "商品服务删除")
    @RequestMapping(value = "deleteSer",method = RequestMethod.DELETE)
    @ApiImplicitParam(required = true,name = "id",value = "标签ID",paramType = "delete")
    public CommonResult delete(Long id) {
        pmsProductServiceService.delete(id);
        return CommonResult.success("商品服务删除成功！");
    }
    /**
     * 商品服务的修改
     * @param entity
     * @return
     */
    @ApiOperation(httpMethod = "POST",value = "商品服务修改",notes = "商品服务修改")
    @RequestMapping(value = "updateSer",method = RequestMethod.POST)
    public CommonResult updata(PmsProductService entity) {
        pmsProductServiceService.update(entity);
        return CommonResult.success("商品服务修改成功！");
    }
    /**
     * 商品服务的查询
     * @return
     */
    @ApiOperation(httpMethod = "GET",value = "商品服务查询",notes = "商品服务查询")
    @RequestMapping(value = "selectAllSer",method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsProductService>> selectAll(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonResult.success(pmsProductServiceService.selectAll(pageNum,pageSize));
    }

}
