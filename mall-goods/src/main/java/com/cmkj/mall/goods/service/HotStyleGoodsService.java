package com.cmkj.mall.goods.service;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.goods.entity.HotStyleGoods;

/**
 * @Author:zhangli
 * @Version 1.0
 */
public interface HotStyleGoodsService {

    /**
     * 获取爆款商品
     * @param pageSize
     * @param pageNum
     * @return
     */
    CommonPage<HotStyleGoods> getHotStyle(Integer pageSize,Integer pageNum);
}
