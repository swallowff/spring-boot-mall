package com.cmkj.mall.goods.service;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.goods.entity.AllClassify;

import java.util.List;

/**
 * @Author:zhangli
 * @Version 1.0
 */
public interface AllClassifyService {
    /**
     * 拿到商品全部分类
     * @return
     */
    CommonPage<AllClassify> getAllClassifyList();
}
