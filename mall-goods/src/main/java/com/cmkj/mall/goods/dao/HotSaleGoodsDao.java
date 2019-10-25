package com.cmkj.mall.goods.dao;

import com.cmkj.mall.goods.entity.HotSaleGoods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:zhangli
 * @Version 1.0
 * 热售，新上商品Dao
 */
@Mapper
@Repository
public interface HotSaleGoodsDao {
    /**
     * 根据热售状态获取热售商品
     * @return
     */
    List<HotSaleGoods> getHotSaleGoodsList();

    /**
     * 如果热门，新上没有达到要求，就推荐商品过去
     */
    List<HotSaleGoods> getGoodsList();
    /**
     * 获取新上商品
     * @return
     */
    List<HotSaleGoods> getNewGoodsList();
}
