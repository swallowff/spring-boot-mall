package com.cmkj.mall.goods.service.impl;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.goods.dao.ProductDetailsDao;
import com.cmkj.mall.goods.entity.ProductComment;
import com.cmkj.mall.goods.entity.ProductDetails;
import com.cmkj.mall.goods.entity.ProductSpu;
import com.cmkj.mall.goods.entity.PushProduct;
import com.cmkj.mall.goods.service.ProductDetailsService;
import com.cmkj.mall.mapper.pms.PmsProductTagMapper;
import com.cmkj.mall.model.pms.PmsProductService;
import com.cmkj.mall.model.pms.PmsProductTag;
import com.github.pagehelper.PageHelper;
import org.iherus.codegen.qrcode.QrcodeGenerator;
import org.iherus.codegen.qrcode.SimpleQrcodeGenerator;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


/**
 * @Author:zhangli
 * @Version 1.0
 */
@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

    @Autowired
    private ProductDetailsDao productDetailsDao;



    /**
     * 获取正常详情商品页的属性
     * @param pageSize
     * @param pageNum
     * @return
     */
    @Override
    public CommonPage<ProductDetails> getProductDetailsList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return CommonPage.restPage(productDetailsDao.getDetailsList());
    }

    /**
     * 获取商品对应的spu属性
     * @param pageSize
     * @param pageNum
     * @param id
     * @return
     */
    @Override
    public CommonPage<ProductSpu> getSpuList(Integer pageSize, Integer pageNum, Long id) {
        PageHelper.startPage(pageNum,pageSize);
        return CommonPage.restPage(productDetailsDao.getSpuList(id));
    }

    /***
     * 获取商品对应的Comment
     * @param pageSize
     * @param pageNum
     * @param id
     * @return
     */
    @Override
    public CommonPage<ProductComment> getCommentList(Integer pageSize, Integer pageNum, Long id) {
        PageHelper.startPage(pageNum,pageSize);
        return CommonPage.restPage(productDetailsDao.getCommentList(id));
    }

    /**
     * 根据商品id拿到对应的商品分类下的商品
     * @param pageSize
     * @param pageNum
     * @param id
     * @return
     */
    @Override
    public CommonPage<PushProduct> getPushGoodsList(Integer pageSize, Integer pageNum, Long id) {
        PageHelper.startPage(pageNum,pageSize);
        return CommonPage.restPage(productDetailsDao.getPushGoodsList(id));
    }

    /**
     * 商品分享二维码生成
     */
    @Override
    public void getGoodsQrCode(){
        try {
            //随机生成二维码的名字前缀
            String  uuid = UUID.randomUUID().toString();
            //二维码连接的商品地址 TODO:需要改成商品的地址
            String content="https://item.jd.com/54763223132.html?extension_id=eyJhZCI6IjE0NzYiLCJjaCI6IjIiLCJza3UiOiI1NDc2MzIyMzEzMiIsInRzIjoiMTU3MTM2MTc3NiIsInVuaXFpZCI6IntcImNsaWNrX2lkXCI6XCI3MTRkOTQ5MC0yNDZkLTQ1YzUtYjE0Ny01ZDVhNzViZGY3NTBcIixcIm1hdGVyaWFsX2lkXCI6XCI5MDQ1MzkwOTc5MTA3NjU2NTMxXCIsXCJwb3NfaWRcIjpcIjE0NzZcIixcInNpZFwiOlwiOTcxYzViNWMtY2I3Mi00MjJjLTgzN2UtNTZhMDM2N2U3N2MxXCJ9In0=&jd_pop=714d9490-246d-45c5-b147-5d5a75bdf750&abt=0";
            QrcodeGenerator generator = new SimpleQrcodeGenerator();
            //二维码生成存放的位置，加二维码名称
            Assert.assertTrue(generator.generate(content).toFile("F:\\360Downloads\\"+uuid+".png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 根据商品id，查询到该商品的服务
     * @param pageSize
     * @param pageNum
     * @param id
     * @return
     */
    @Override
    public CommonPage<PmsProductService> getGoodsServiceList(Integer pageSize, Integer pageNum, Long id) {
        PageHelper.startPage(pageNum,pageSize);
        return CommonPage.restPage(productDetailsDao.getGoodsService(id));
    }
}
