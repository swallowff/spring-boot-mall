package com.cmkj.mall.goods.service.impl;

import com.cmkj.mall.goods.dao.GoodsClassifyDao;
import com.cmkj.mall.goods.entity.GoodsClassify;
import com.cmkj.mall.goods.service.GoodsClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 分类ServiceImpl
 * @Author:zhangli
 * @Version 1.0
 */
@Service
public class GoodsClassifyServiceImpl implements GoodsClassifyService {

    @Autowired
    private GoodsClassifyDao goodsClassifyDao;

    @Override
    public List<GoodsClassify> getFirstGoodsClass() {
        return goodsClassifyDao.getFirstClass();
    }
}
