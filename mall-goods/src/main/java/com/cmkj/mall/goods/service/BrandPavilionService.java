package com.cmkj.mall.goods.service;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.goods.entity.BrandPavilion;
import com.cmkj.mall.goods.entity.ClassGoods;

/**
 * @Author:zhangli
 * @Version 1.0
 * 品牌馆Service
 */
public interface BrandPavilionService {

    /**
     * 拿到热售品牌
     * @param pageSize
     * @param pageNum
     * @return
     */
    CommonPage<BrandPavilion> getHotBrandList(Integer pageSize,Integer pageNum);

    /**
     * 拿到所有的品牌
     * @return
     */
    CommonPage<BrandPavilion> getBrandList(Integer pageSize,Integer pageNum);

    /**
     * 根据品牌id，拿到该品牌下所属的商品
     * @param pageSize
     * @param pageNum
     * @param id
     * @return
     */
    CommonPage<ClassGoods> getBrandGoodsList(Integer pageSize,Integer pageNum,Long id);
}
