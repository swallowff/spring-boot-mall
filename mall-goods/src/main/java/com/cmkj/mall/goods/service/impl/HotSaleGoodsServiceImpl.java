package com.cmkj.mall.goods.service.impl;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.goods.dao.HotSaleGoodsDao;
import com.cmkj.mall.goods.entity.HotSaleGoods;
import com.cmkj.mall.goods.service.HotSaleGoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 热售，新上商品ServiceImpl
 * @Author:zhangli
 * @Version 1.0
 */
@Service
public class HotSaleGoodsServiceImpl implements HotSaleGoodsService {

    @Autowired
    private HotSaleGoodsDao hotSaleGoodsDao;


    @Override
    public CommonPage<HotSaleGoods> getHotSaleGoodsList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        //获取热售商品
        List<HotSaleGoods> hotSaleGoodsList = hotSaleGoodsDao.getHotSaleGoodsList();
        //如果没有符合的热售商品就，推荐商品到热门商品
        if (hotSaleGoodsList.size()== 0){
            List<HotSaleGoods> goodsList = hotSaleGoodsDao.getGoodsList();
            return CommonPage.restPage(goodsList);
        }
        return CommonPage.restPage(hotSaleGoodsList);
    }

    @Override
    public CommonPage<HotSaleGoods> getNewGoodsList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        //获取新上商品
        List<HotSaleGoods> newGoodsList= hotSaleGoodsDao.getNewGoodsList();
        //如果没有新上商品
        if (newGoodsList.size()== 0){
            List<HotSaleGoods> goodsList = hotSaleGoodsDao.getGoodsList();
            return CommonPage.restPage(goodsList);
        }
        return CommonPage.restPage(newGoodsList);
    }
}
