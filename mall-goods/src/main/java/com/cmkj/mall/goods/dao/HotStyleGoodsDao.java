package com.cmkj.mall.goods.dao;

import com.cmkj.mall.goods.entity.HotStyleGoods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:zhangli
 * @Version 1.0
 * 爆款商品Dao
 */
@Mapper
@Repository
public interface HotStyleGoodsDao {

    /**
     * 根据爆款状态找到爆款商品，属性为:商品id，商品名字，商品价格，商品销量
     * @return
     */
    List<HotStyleGoods> getHotStyleList();
}
