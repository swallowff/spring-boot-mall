package com.cmkj.mall.goods.service.impl;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.goods.dao.BrandPavilionDao;
import com.cmkj.mall.goods.entity.BrandPavilion;
import com.cmkj.mall.goods.entity.ClassGoods;
import com.cmkj.mall.goods.service.BrandPavilionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:zhangli
 * @Version 1.0
 */
@Service
public class BrandPavilionServiceImpl  implements BrandPavilionService{

    @Autowired
    private BrandPavilionDao brandPavilionDao;

    /**
     * 拿到热售品牌
     * @param pageSize
     * @param pageNum
     * @return
     */
    @Override
    public CommonPage<BrandPavilion> getHotBrandList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return CommonPage.restPage(brandPavilionDao.getHotBrandList());
    }

    /**
     * 拿到所有的商品品牌
     * @return
     */
    @Override
    public CommonPage<BrandPavilion> getBrandList(Integer pageSize,Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<BrandPavilion> list = brandPavilionDao.getBrandList();
        return CommonPage.restPage(list);
    }

    /**
     * 根据品牌id，拿到该品牌下所属的商品
     * @param pageSize
     * @param pageNum
     * @param id
     * @return
     */
    @Override
    public CommonPage<ClassGoods> getBrandGoodsList(Integer pageSize, Integer pageNum, Long id) {
        PageHelper.startPage(pageNum,pageSize);
        return CommonPage.restPage(brandPavilionDao.getBrandGoodsList(id));
    }
}
