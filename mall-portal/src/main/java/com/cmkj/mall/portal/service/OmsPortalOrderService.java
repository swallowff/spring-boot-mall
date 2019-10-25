package com.cmkj.mall.portal.service;

import com.cmkj.mall.common.api.CommonResult;
import com.cmkj.mall.portal.domain.ConfirmOrderResult;
import com.cmkj.mall.portal.domain.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * 前台订单管理Service
 * Created by cmkj on 2018/8/30.
 */
public interface OmsPortalOrderService {
    /**
     * 根据用户购物车信息生成确认单信息
     */
    ConfirmOrderResult generateConfirmOrder();

    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 支付成功后的回调
     */
    @Transactional
    CommonResult paySuccess(Long orderId);

    /**
     * 自动取消超时订单
     */
    @Transactional
    CommonResult cancelTimeOutOrder();

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);

    /**
     * 发送延迟消息取消订单
     */
    void sendDelayMessageCancelOrder(Long orderId);
}
