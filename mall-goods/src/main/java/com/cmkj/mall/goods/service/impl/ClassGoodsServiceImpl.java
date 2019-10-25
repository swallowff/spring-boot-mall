package com.cmkj.mall.goods.service.impl;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.goods.dao.ClassGoodsDao;
import com.cmkj.mall.goods.entity.ClassGoods;
import com.cmkj.mall.goods.entity.GoodsClassify;
import com.cmkj.mall.goods.service.ClassGoodsService;
import com.cmkj.mall.goods.service.GoodsClassifyService;
import com.cmkj.mall.model.pms.PmsProductTag;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zhangli
 * @Version 1.0
 */
@Service
public class ClassGoodsServiceImpl implements ClassGoodsService {

    @Autowired
    private ClassGoodsDao classGoodsDao;

    @Autowired
    private GoodsClassifyService goodsClassifyService;

    @Override
    public CommonPage<ClassGoods> getGoods(Integer pageSize,Integer pageNum,Long id) {
        PageHelper.startPage(pageNum,pageSize);
       /*
        //拿到所有一级分类
        List<GoodsClassify> firstGoodsList =goodsClassifyService.getFirstGoodsClass();
        //创建一个新的数组用来，装遍历出来的不同一级分类得到的商品。
        List<ClassGoods> list = new ArrayList<>();
        //遍历一级分类数组，拿到id。在根据parent_id=id找到一级分类下的所有对应商品
        for (GoodsClassify goodsClassify : firstGoodsList) {
            List<ClassGoods> list2= classGoodsDao.getGoods(goodsClassify.getId());
            //添加到新的数组里面
            list.addAll(list2);
        }
        return CommonPage.restPage(list);
        */
        return CommonPage.restPage(classGoodsDao.getGoods(id));
    }


}
