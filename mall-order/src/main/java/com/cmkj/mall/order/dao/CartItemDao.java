package com.cmkj.mall.order.dao;

import com.cmkj.mall.order.vo.CartItemsListVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author swallowff
 * @create 2019/10/16
 */
@Repository
public interface CartItemDao {

    List<CartItemsListVO> selectItemsWithSkuInfo(@Param(value = "memberId") Long memberId);

}
