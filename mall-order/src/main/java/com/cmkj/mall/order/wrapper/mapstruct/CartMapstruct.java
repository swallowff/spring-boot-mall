package com.cmkj.mall.order.wrapper.mapstruct;

import com.cmkj.mall.model.oms.OmsCartItem;
import com.cmkj.mall.order.vo.CartItemsListVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapstruct {
    CartMapstruct INSTANCE = Mappers.getMapper(CartMapstruct.class);

    @Mapping(source = "id",target = "itemId")
    @Mapping(source = "productId",target = "spuId")
    @Mapping(source = "productSkuId",target = "skuId")
    CartItemsListVO cartItemsRes(OmsCartItem cartItem);


}
