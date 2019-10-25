package com.cmkj.mall.dto;

import com.cmkj.mall.model.oms.OmsOrder;
import com.cmkj.mall.model.oms.OmsOrderItem;
import com.cmkj.mall.model.oms.OmsOrderOperateHistory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单详情信息
 * Created by cmkj on 2018/10/11.
 */
public class OmsOrderDetail extends OmsOrder {
    @Getter
    @Setter
    private List<OmsOrderItem> orderItemList;
    @Getter
    @Setter
    private List<OmsOrderOperateHistory> historyList;
}
