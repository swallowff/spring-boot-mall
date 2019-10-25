package com.cmkj.mall.goods.service;


import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.model.pms.PmsProductTag;


/**
 * @Author:zhangli
 * @Version 1.0
 * 商品跟商品标签的中间表Service
 */
public interface GoodsTagCentreService {

    /**
     * 根据商品的id，获取到商品拥有的商品标签
     * @param id
     * @return
     */
    CommonPage<PmsProductTag> getGoodsTag(Integer pageSize, Integer pageNum,Long id);

}
