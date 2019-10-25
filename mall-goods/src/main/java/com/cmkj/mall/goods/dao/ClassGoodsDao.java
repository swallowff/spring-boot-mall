package com.cmkj.mall.goods.dao;

import com.cmkj.mall.goods.entity.ClassGoods;
import com.cmkj.mall.model.pms.PmsProductTag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:zhangli
 * @Version 1.0
 * 一级分类下，所属商品Dao
 */
@Mapper
@Repository
public interface ClassGoodsDao {

    /**
     * 根据一级分类的id找到所归属的所有商品
     * @param
     * @return
     */
    List<ClassGoods> getGoods(Long id);


}
