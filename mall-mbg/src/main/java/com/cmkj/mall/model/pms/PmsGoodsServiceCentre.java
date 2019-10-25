package com.cmkj.mall.model.pms;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class PmsGoodsServiceCentre implements Serializable {
    @ApiModelProperty(value = "商品id")
    private Long productId;

    @ApiModelProperty(value = "服务id")
    private Long serviceId;

    private static final long serialVersionUID = 1L;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}