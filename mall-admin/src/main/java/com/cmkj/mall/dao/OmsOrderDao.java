package com.cmkj.mall.dao;

import com.cmkj.mall.dto.OmsOrderDeliveryParam;
import com.cmkj.mall.dto.OmsOrderDetail;
import com.cmkj.mall.dto.OmsOrderQueryParam;
import com.cmkj.mall.model.oms.OmsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单自定义查询Dao
 * Created by cmkj on 2018/10/12.
 */
public interface OmsOrderDao {
    /**
     * 条件查询订单
     */
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);

    /**
     * 批量发货
     */
    int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 获取订单详情
     */
    OmsOrderDetail getDetail(@Param("id") Long id);
}
