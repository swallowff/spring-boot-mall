package com.cmkj.mall.goods.dao;

import com.cmkj.mall.goods.entity.MoreGoods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:zhangli
 * @Version 1.0
 * 热售商品，新上商品点击更多商品的展示
 */
@Mapper
@Repository
public interface MoreGoodsDao {

    /**
     * 热售商品，更多商品展示
     * @return
     */
    List<MoreGoods> getMoreHotSaleGoodsList();
    /**
     * 新上商品，更多商品展示
     * @return
     */
    List<MoreGoods> getMoreNewGoodsList();

    /**
     * 如果热门，新上没有达到要求，就推荐商品过去
     */
    List<MoreGoods> getMoreGoodsList();
}
