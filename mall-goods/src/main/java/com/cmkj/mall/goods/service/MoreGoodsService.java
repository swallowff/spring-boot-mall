package com.cmkj.mall.goods.service;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.goods.entity.MoreGoods;

import java.util.List;

/**
 * @Author:zhangli
 * @Version 1.0
 *
 * 更多热售，新上商品Service
 */
public interface MoreGoodsService {

    /**
     * 分页获取热售商品
     * @return
     */
    CommonPage<MoreGoods> getMoreHotSaleGoodsList(Integer pageSize, Integer pageNum);
    /**
     * 分页获取新品商品
     * @return
     */
    CommonPage<MoreGoods> getMoreNewGoodsList(Integer pageSize, Integer pageNum);
}
