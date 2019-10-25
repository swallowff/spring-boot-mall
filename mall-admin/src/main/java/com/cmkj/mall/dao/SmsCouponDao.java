package com.cmkj.mall.dao;

import com.cmkj.mall.dto.SmsCouponParam;
import com.cmkj.mall.dto.SmsCouponParam;
import org.apache.ibatis.annotations.Param;

/**
 * 优惠券管理自定义查询Dao
 * Created by cmkj on 2018/8/29.
 */
public interface SmsCouponDao {
    SmsCouponParam getItem(@Param("id") Long id);
}
