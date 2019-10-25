package com.cmkj.mall.goods.service;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.goods.entity.ClassGoods;
import com.cmkj.mall.model.pms.PmsProductTag;

import java.util.List;

/**
 * @Author:zhangli
 * @Version 1.0
 */
public interface ClassGoodsService {
    /**
     * 根据一级分类的id找到所归属的所有商品
     * @param
     * @return
     */
    CommonPage<ClassGoods> getGoods(Integer pageSize,Integer pageNum,Long id);



}
