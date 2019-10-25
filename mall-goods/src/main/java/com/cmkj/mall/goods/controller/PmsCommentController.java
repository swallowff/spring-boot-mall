package com.cmkj.mall.goods.controller;

import com.cmkj.mall.common.annotation.ApiVersion;
import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.common.api.CommonResult;
import com.cmkj.mall.goods.service.PmsCommentService;
import com.cmkj.mall.model.pms.PmsComment;
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
 * 商品评论表Controller
 */
@Api(tags = {"商品评论"},value = "商品评论")
@ApiVersion(1)
@RestController
@RequestMapping(value = "{version}/api/mall/goods/comment")
public class PmsCommentController {

    @Autowired
    private PmsCommentService pmsCommentService;

    /**
     * 商品评论的添加
     * @param entity
     * @return
     */
    @ApiOperation(httpMethod = "PUT",value = "商品评论添加",notes = "商品评论添加")
    @RequestMapping(value = "addCom",method = RequestMethod.PUT)
    @ApiImplicitParam(required = true,name = "entity",value = "评论",paramType = "add")
    public CommonResult save(PmsComment entity) {
        pmsCommentService.save(entity);
        return CommonResult.success("商品评论添加成功！");
    }
    /**
     * 商品评论的删除
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE",value = "商品评论删除",notes = "商品评论删除")
    @RequestMapping(value = "deleteCom",method = RequestMethod.DELETE)
    @ApiImplicitParam(required = true,name = "id",value = "标签ID",paramType = "delete")
    public CommonResult delete(Long id) {
        pmsCommentService.delete(id);
        return CommonResult.success("商品评论删除成功！");
    }
    /**
     * 商品评论的修改
     * @param entity
     * @return
     */
    @ApiOperation(httpMethod = "POST",value = "商品评论修改",notes = "商品评论修改")
    @RequestMapping(value = "updateCom",method = RequestMethod.POST)
    public CommonResult updata(PmsComment entity) {
        pmsCommentService.update(entity);
        return CommonResult.success("商品评论修改成功！");
    }
    /**
     * 商品评论的查询
     * @return
     */
    @ApiOperation(httpMethod = "GET",value = "商品评论查询",notes = "商品评论查询")
    @RequestMapping(value = "selectAllCom",method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsComment>> selectAll(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonResult.success(pmsCommentService.selectAll(pageNum,pageSize));
    }

}
