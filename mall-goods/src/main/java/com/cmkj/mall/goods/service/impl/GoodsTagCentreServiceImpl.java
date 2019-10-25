package com.cmkj.mall.goods.service.impl;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.goods.dao.ProductDetailsDao;
import com.cmkj.mall.goods.service.GoodsTagCentreService;
import com.cmkj.mall.model.pms.PmsProductTag;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:zhangli
 * @Version 1.0
 * 商品跟商品标签的中间表ServiceImpl
 */
@Service
public class GoodsTagCentreServiceImpl implements GoodsTagCentreService {

    @Autowired
    private ProductDetailsDao productDetailsDao;
    /**
     * 根据商品的id，拿到商品所属的标签
     * @param pageSize
     * @param pageNum
     * @param id
     * @return
     */
    @Override
    public CommonPage<PmsProductTag> getGoodsTag(Integer pageSize, Integer pageNum, Long id) {
        PageHelper.startPage(pageNum,pageSize);
        return CommonPage.restPage(productDetailsDao.getGoodsTag(id));
    }
}
