package com.cmkj.mall.goods.service.impl;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.goods.dao.MoreGoodsDao;
import com.cmkj.mall.goods.entity.MoreGoods;
import com.cmkj.mall.goods.service.MoreGoodsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * 更多热售，新上商品ServiceImpl
 * @Author:zhangli
 * @Version 1.0
 */
@Service
public class MoreGoodsServiceImpl implements MoreGoodsService {

    @Autowired
    private MoreGoodsDao moreGoodsDao;


    @Override
    public CommonPage<MoreGoods> getMoreHotSaleGoodsList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        //获取热售商品，展示图片，名称，原价，折扣价，销量，库存属性
        List<MoreGoods>  moreHotSaleGoodsList = moreGoodsDao.getMoreHotSaleGoodsList();
        //如果没有符合的热售商品，则推荐商品到热售商品
        if (moreHotSaleGoodsList.size()==0){
            List<MoreGoods>  moreGoodsList= moreGoodsDao.getMoreGoodsList();
            return CommonPage.restPage(moreGoodsList);
        }
        return CommonPage.restPage(moreHotSaleGoodsList);
    }

    @Override
    public CommonPage<MoreGoods> getMoreNewGoodsList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        //获取新上商品，展示图片，名称，原价，折扣价，销量，库存属性
        List<MoreGoods> moreNewGoodsList = moreGoodsDao.getMoreNewGoodsList();
        //如果没有符合的热售商品，则推荐商品到新上商品
        if (moreNewGoodsList.size()==0){
            List<MoreGoods>  moreGoodsList= moreGoodsDao.getMoreGoodsList();
            return CommonPage.restPage(moreGoodsList);
        }
        return CommonPage.restPage(moreNewGoodsList);
    }
}
