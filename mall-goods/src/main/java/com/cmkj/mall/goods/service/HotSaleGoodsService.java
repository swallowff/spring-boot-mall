package com.cmkj.mall.goods.service;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.goods.entity.HotSaleGoods;

import java.util.List;

/**
 * @Author:zhangli
 * @Version 1.0
 * 热售，新上商品Service
 */
public interface HotSaleGoodsService {

    /**
     * 分页获取热售商品
     * @return
     */
    CommonPage<HotSaleGoods> getHotSaleGoodsList(Integer pageSize, Integer pageNum);
    /**
     * 分页获取新品商品
     * @return
     */
    CommonPage<HotSaleGoods> getNewGoodsList(Integer pageSize, Integer pageNum);
}
