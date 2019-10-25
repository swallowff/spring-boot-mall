package com.cmkj.mall.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cmkj.mall.member.util.PageData;
@Mapper
public interface UmsMemberPersonalDao {

	@Select("SELECT UF_SHOP_COIN FROM user_finance WHERE member_id = #{memberId}")
	Double getMyShopCoin(Long memberId);

	@Select("SELECT UF_AWARD_COIN FROM user_finance WHERE member_id = #{memberId}")
	Double getMyAwardCoin(Long memberId);

	Integer getMyCouponNum(Long memberId);

	@Select("SELECT COUNT(id) FROM pms_product_collect WHERE member_id = #{memberId} AND deleted = 0")
	Integer getMyProductCollectNum(Long memberId);

	@Select("SELECT UF_VOUCHER FROM user_finance WHERE member_id = #{memberId}")
	Integer getMyVoucherNum(Long memberId);

	List<PageData> getMyOrderStatusNum(Long memberId);

}
