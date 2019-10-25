package com.cmkj.mall.goods.service;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.goods.entity.ProductComment;
import com.cmkj.mall.goods.entity.ProductDetails;
import com.cmkj.mall.goods.entity.ProductSpu;
import com.cmkj.mall.goods.entity.PushProduct;
import com.cmkj.mall.model.pms.PmsProductService;
import com.cmkj.mall.model.pms.PmsSkuStock;

import java.io.IOException;

/**
 * @Author:zhangli
 * @Version 1.0
 */
public interface ProductDetailsService {
    /**
     * 拿到正常商品详情所需要的属性
     * @param pageSize
     * @param pageNum
     * @return
     */
    CommonPage<ProductDetails> getProductDetailsList(Integer pageSize, Integer pageNum);

    /**
     * 根据商品id拿到对应的spu属性
     * @param pageSize
     * @param pageNum
     * @return
     */
    CommonPage<ProductSpu> getSpuList(Integer pageSize, Integer pageNum, Long id);

    /**
     * 根据商品id拿到对应的Comment
     * @param pageSize
     * @param pageNum
     * @param id
     * @return
     */
    CommonPage<ProductComment> getCommentList(Integer pageSize, Integer pageNum, Long id);

    /**
     * 根据商品id拿到对应的商品分类下的商品
     * @param pageSize
     * @param pageNum
     * @param id
     * @return
     */
    CommonPage<PushProduct> getPushGoodsList(Integer pageSize, Integer pageNum, Long id);

    /**
     * 商品分享生成的二维码
     */
    void getGoodsQrCode() ;

    /**
     * 根据商品id拿到对应的商品分类下的商品
     * @param pageSize
     * @param pageNum
     * @param id
     * @return
     */
    CommonPage<PmsProductService> getGoodsServiceList(Integer pageSize, Integer pageNum, Long id);

}
