package com.cmkj.mall.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmkj.mall.common.annotation.ApiVersion;
import com.cmkj.mall.common.api.CommonResult;
import com.cmkj.mall.member.dao.UmsMemberPersonalDao;
import com.cmkj.mall.member.service.UmsMemberPersonalService;
import com.cmkj.mall.member.util.PageData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@ApiVersion(1)
@Api(tags = "UmsMemberPersonalController", description = "用户个人中心")
@RestController
@RequestMapping(value = "{version}/api/mall/member/personal")
@SuppressWarnings("rawtypes")
public class UmsMemberPersonalController {

	@Autowired
	private UmsMemberPersonalDao memberPersonalDao;
	
	@Autowired
	private UmsMemberPersonalService memberPersonalService;


	@ApiOperation("个人财务展示")
	@PostMapping(value = "getMyFinanceInfo")
	public CommonResult getMyFinanceInfo(@ApiParam(value = "会员id") @RequestParam(value = "memberId", required = true) Long memberId) {
		List<PageData> orderStatusNum = memberPersonalDao.getMyOrderStatusNum(memberId);//不同状态订单数量
		Double shopCoin = memberPersonalDao.getMyShopCoin(memberId);//获取用户积分
		Double awardCoin = memberPersonalDao.getMyAwardCoin(memberId);//获取用户余额
		Integer couponNum = memberPersonalDao.getMyCouponNum(memberId);//优惠券数量
		Integer collectNum = memberPersonalDao.getMyProductCollectNum(memberId);//产品收藏数
		Integer voucherNum = memberPersonalDao.getMyVoucherNum(memberId);//金豆数量
		PageData pd = new PageData();
		pd.put("shopCoin", shopCoin==null?0:shopCoin);
		pd.put("awardCoin", awardCoin==null?0:awardCoin);
		pd.put("couponNum", couponNum==null?0:couponNum);
		pd.put("collectNum", collectNum==null?0:collectNum);
		pd.put("voucherNum", voucherNum==null?0:voucherNum);
		pd.put("orderStatusNum", orderStatusNum);
		return CommonResult.success(pd);
	}
	
}
