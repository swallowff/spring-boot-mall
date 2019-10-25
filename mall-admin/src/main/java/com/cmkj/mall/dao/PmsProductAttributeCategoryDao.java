package com.cmkj.mall.dao;

import com.cmkj.mall.dto.PmsProductAttributeCategoryItem;
import com.cmkj.mall.dto.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * 自定义商品属性分类Dao
 * Created by cmkj on 2018/5/24.
 */
public interface PmsProductAttributeCategoryDao {
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
