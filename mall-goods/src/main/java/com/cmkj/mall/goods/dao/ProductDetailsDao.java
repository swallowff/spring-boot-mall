package com.cmkj.mall.goods.dao;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.goods.entity.ProductComment;
import com.cmkj.mall.goods.entity.ProductDetails;
import com.cmkj.mall.goods.entity.ProductSpu;
import com.cmkj.mall.goods.entity.PushProduct;
import com.cmkj.mall.model.pms.PmsProductService;
import com.cmkj.mall.model.pms.PmsProductTag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:zhangli
 * @Version 1.0
 * 商品详情Dao
 */
@Mapper
@Repository
public interface ProductDetailsDao {
    /**
     * 拿到正常商品详情也所需要的属性
     * @return
     */
    List<ProductDetails> getDetailsList();

    /**
     * 根据已选商品id，获取sp属性
     */
    List<ProductSpu> getSpuList(Long id);

    /**
     * 根据已选商品id,获取评论数据
     */
    List<ProductComment> getCommentList(Long id);

    /**
     * 根据商品id找到他同分类的商品到推荐商品
     */
    List<PushProduct> getPushGoodsList(Long id);

    /**
     * 根据商品的id，拿到商品所属的标签
     * @param
     * @return
     */
    List<PmsProductTag> getGoodsTag(Long id);

    /**
     * 根据商品的id，获取到商品拥有的服务
     * @param id
     * @return
     */
    List<PmsProductService> getGoodsService(Long id);
}
