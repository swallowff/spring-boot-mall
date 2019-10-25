package com.cmkj.mall.goods.service.impl;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.goods.dao.HotSaleGoodsDao;
import com.cmkj.mall.goods.dao.HotStyleGoodsDao;
import com.cmkj.mall.goods.entity.HotStyleGoods;
import com.cmkj.mall.goods.service.HotStyleGoodsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:zhangli
 * @Version 1.0
 */
@Service
public class HotStyleGoodsServiceImpl implements HotStyleGoodsService {

    @Autowired
    private HotStyleGoodsDao hotStyleGoodsDao;

    /**
     * 获取爆款商品
     * @param pageSize
     * @param pageNum
     * @return
     */
    @Override
    public CommonPage<HotStyleGoods> getHotStyle(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return CommonPage.restPage(hotStyleGoodsDao.getHotStyleList());
    }
}
