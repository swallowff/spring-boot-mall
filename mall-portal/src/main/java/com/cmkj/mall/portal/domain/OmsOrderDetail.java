package com.cmkj.mall.portal.domain;

import com.cmkj.mall.model.oms.OmsOrder;
import com.cmkj.mall.model.oms.OmsOrderItem;

import java.util.List;

/**
 * 包含订单商品信息的订单详情
 * Created by cmkj on 2018/9/4.
 */
public class OmsOrderDetail extends OmsOrder {
    private List<OmsOrderItem> orderItemList;

    public List<OmsOrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OmsOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
