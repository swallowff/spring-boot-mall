package com.cmkj.mall.service;

import com.cmkj.mall.model.pms.PmsProductAttributeCategory;
import com.cmkj.mall.dto.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * 商品属性分类Service
 * Created by cmkj on 2018/4/26.
 */
public interface PmsProductAttributeCategoryService {
    int create(String name);

    int update(Long id, String name);

    int delete(Long id);

    PmsProductAttributeCategory getItem(Long id);

    List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageNum);

    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
