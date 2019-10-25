package com.cmkj.mall.dto;

import com.cmkj.mall.model.pms.PmsProduct;
import com.cmkj.mall.model.sms.SmsFlashPromotionProductRelation;
import lombok.Getter;
import lombok.Setter;

/**
 * 限时购及商品信息封装
 * Created by cmkj on 2018/11/16.
 */
public class SmsFlashPromotionProduct extends SmsFlashPromotionProductRelation{
    @Getter
    @Setter
    private PmsProduct product;
}
