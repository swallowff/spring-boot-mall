package com.cmkj.mall.portal.domain;

import com.cmkj.mall.model.pms.PmsProductAttribute;
import com.cmkj.mall.model.pms.PmsSkuStock;
import com.cmkj.mall.model.pms.PmsProduct;

import java.util.List;

/**
 * 购物车中选择规格的商品信息
 * Created by cmkj on 2018/8/2.
 */
public class CartProduct extends PmsProduct {
    private List<PmsProductAttribute> productAttributeList;
    private List<PmsSkuStock> skuStockList;

    public List<PmsProductAttribute> getProductAttributeList() {
        return productAttributeList;
    }

    public void setProductAttributeList(List<PmsProductAttribute> productAttributeList) {
        this.productAttributeList = productAttributeList;
    }

    public List<PmsSkuStock> getSkuStockList() {
        return skuStockList;
    }

    public void setSkuStockList(List<PmsSkuStock> skuStockList) {
        this.skuStockList = skuStockList;
    }
}
