package com.cmkj.mall.order.wrapper;

import com.cmkj.mall.common.wrapper.BaseWrapper;
import com.cmkj.mall.model.oms.OmsCartItem;
import com.cmkj.mall.order.wrapper.mapstruct.CartMapstruct;

import java.util.List;

/**
 * @author swallowff
 * @create 2019/10/14
 */
public class CartItemsResWrapper extends BaseWrapper<OmsCartItem> {

    public CartItemsResWrapper(OmsCartItem cartItem) {
        super(cartItem);
    }

    public CartItemsResWrapper(List<OmsCartItem> entityList) {
        super(entityList);
    }

    @Override
    protected <R> R wrapEntity(OmsCartItem cartItem) {
        return (R) CartMapstruct.INSTANCE.cartItemsRes(cartItem);
    }
}
