package com.cmkj.mall.order.controller;

import com.cmkj.mall.common.annotation.ApiVersion;
import com.cmkj.mall.common.api.BaseApiCtrl;
import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.common.api.CommonResult;
import com.cmkj.mall.common.api.ResultCode;
import com.cmkj.mall.order.dto.ctrl.CartItemAddQuery;
import com.cmkj.mall.order.dto.ctrl.PageQuery;
import com.cmkj.mall.order.vo.CartItemsListVO;
import com.cmkj.mall.order.service.CartApiService;
import io.swagger.annotations.*;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swallowff
 * @create 2019/10/13
 */
@Api(tags = {"购物车"},value = "购物车接口")
@ApiVersion(1)
@RestController
@RequestMapping(value = "{version}/api/mall/order/cart")
public class CartApiCtrl extends BaseApiCtrl {
    @Autowired
    private CartApiService cartApiService;

    @ApiOperation(value = "添加商品", notes = "添加商品")
    @RequestMapping(value = "item", method = RequestMethod.PUT)
    @ApiResponses({
            @ApiResponse(code = 1000, message = "商品已过期")
    })
    public CommonResult addItem(@Validated CartItemAddQuery query, BindingResult bindingResult) {
        validBindingResult(bindingResult);
        int result = cartApiService.addOrUpdateItem(query.getMemberId(), query.getSkuId(), query.getQuantity());
        if (result == 1) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "商品列表", notes = "商品列表")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 901, message = "没有更多数据了")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "memberId", value = "会员ID", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "pageNum", value = "页码", paramType = "query", defaultValue = "1", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", defaultValue = "15", dataType = "Integer")
    })
    public CommonResult<CommonPage<CartItemsListVO>> listItems(@RequestParam(value = "memberId") Long memberId,
                                                               PageQuery pageQuery) {
        if (null == memberId) {
            return CommonResult.validateFailed("memberId不能为空");
        }
        CommonPage<CartItemsListVO> resPage = cartApiService.selectItemsWithSkuInfo(memberId, pageQuery.getPageNum(), pageQuery.getPageSize());
        if (resPage.isEmpty()) {
            return CommonResult.of(ResultCode.EMPTY_RESULT);
        } else {
            return CommonResult.success(resPage);
        }
    }

    //删除商品(可批量)
    @ApiOperation(value = "删除商品", notes = "删除商品")
    @RequestMapping(value = "item", method = RequestMethod.DELETE)
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "memberId", value = "会员ID", paramType = "query"),
            @ApiImplicitParam(required = true, name = "ids", value = "主键数组", paramType = "query")
    })
    public CommonResult deleteItems(@RequestParam(value = "memberId") Long memberId,
                                    @RequestParam(value = "ids") Long[] ids) {
        if (null == memberId) {
            return CommonResult.validateFailed("memberId不能为空");
        }
        if (ArrayUtils.isEmpty(ids)) {
            return CommonResult.validateFailed("ids不能为空");
        }
        int count = cartApiService.deleteMemberItems(ids, memberId);
        return CommonResult.success(count);
    }

    //清空购物车
    @ApiOperation(value = "清空购物车", notes = "清空购物车")
    @RequestMapping(value = "clear", method = RequestMethod.DELETE)
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "memberId", value = "会员ID", paramType = "query")
    })
    public CommonResult clearAll(@RequestParam(value = "memberId") Long memberId) {
        if (null == memberId) {
            return CommonResult.validateFailed("memberId不能为空");
        }
        int count = cartApiService.deleteByMemberId(memberId);
        return CommonResult.success(count);
    }




}