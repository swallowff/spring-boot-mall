package com.cmkj.mall.goods.dao;

import com.cmkj.mall.goods.entity.GoodsClassify;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:zhangli
 * @Version 1.0
 */
@Mapper
@Repository
public interface GoodsClassifyDao {

    /**
     * 首页一级分类展示
     * @return
     */
    List<GoodsClassify> getFirstClass();



}
