package com.cmkj.mall.order.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author swallowff
 * @create 2019/10/14
 */
@ApiModel
public class CartItemsListVO {
    @ApiModelProperty(value = "主键")
    private Long itemId;
    @ApiModelProperty(value = "spuId")
    private Long spuId;
    @ApiModelProperty(value = "skuId")
    private Long skuId;
    @ApiModelProperty(value = "商品图片地址")
    private String productPic;
    @ApiModelProperty(value = "产品名称")
    private String productName;
    @ApiModelProperty(value = "sku属性1")
    private String sp1;
    @ApiModelProperty(value = "sku属性2")
    private String sp2;
    @ApiModelProperty(value = "sku属性3")
    private String sp3;
    @ApiModelProperty(value = "商品数量")
    private Integer quantity;
    @ApiModelProperty(value = "是否上架")
    private Boolean isOnShelf;
    @ApiModelProperty(value = "售价")
    private BigDecimal price;
    @ApiModelProperty(value = "库存数量")
    private BigDecimal stock;


    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getSp1() {
        return sp1;
    }

    public void setSp1(String sp1) {
        this.sp1 = sp1;
    }

    public String getSp2() {
        return sp2;
    }

    public void setSp2(String sp2) {
        this.sp2 = sp2;
    }

    public String getSp3() {
        return sp3;
    }

    public void setSp3(String sp3) {
        this.sp3 = sp3;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getOnShelf() {
        return isOnShelf;
    }

    public void setOnShelf(Boolean onShelf) {
        isOnShelf = onShelf;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }
}
