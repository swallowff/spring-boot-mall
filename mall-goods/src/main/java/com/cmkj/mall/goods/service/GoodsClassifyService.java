package com.cmkj.mall.goods.service;

import com.cmkj.mall.goods.entity.GoodsClassify;

import java.util.List;

/**
 * 分类Service
 * @Author:zhangli
 * @Version 1.0
 */
public interface GoodsClassifyService {

    /***
     * 拿到所有一级分类
     * @return
     */
    List<GoodsClassify> getFirstGoodsClass();
}
