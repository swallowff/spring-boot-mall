package com.cmkj.mall.dao;

import com.cmkj.mall.model.pms.PmsProductAttributeValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品参数，商品自定义规格属性Dao
 * Created by cmkj on 2018/4/26.
 */
public interface PmsProductAttributeValueDao {
    int insertList(@Param("list")List<PmsProductAttributeValue> productAttributeValueList);
}
