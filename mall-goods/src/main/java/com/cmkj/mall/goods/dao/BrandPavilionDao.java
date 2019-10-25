package com.cmkj.mall.goods.dao;

import com.cmkj.mall.goods.entity.BrandPavilion;
import com.cmkj.mall.goods.entity.ClassGoods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:zhangli
 * @Version 1.0
 * 品牌馆Dao
 */
@Mapper
@Repository
public interface BrandPavilionDao {

    /**
     * 拿到热售的品牌
     * @return
     */
    List<BrandPavilion> getHotBrandList();

    /**
     * 拿到所有的商品品牌
     * @return
     */
    List<BrandPavilion> getBrandList();

    /**
     * 根据商品品牌的id，拿到该品牌所归属的商品
     * @param id
     * @return
     */
    List<ClassGoods>  getBrandGoodsList(Long id);

}
