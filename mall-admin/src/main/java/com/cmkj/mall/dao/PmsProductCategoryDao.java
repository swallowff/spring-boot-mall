package com.cmkj.mall.dao;

import com.cmkj.mall.dto.PmsProductCategoryWithChildrenItem;
import com.cmkj.mall.dto.PmsProductCategoryWithChildrenItem;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品分类自定义Dao
 * Created by cmkj on 2018/5/25.
 */
@Repository
public interface PmsProductCategoryDao {
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
