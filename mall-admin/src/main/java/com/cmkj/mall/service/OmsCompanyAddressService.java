package com.cmkj.mall.service;

import com.cmkj.mall.model.oms.OmsCompanyAddress;

import java.util.List;

/**
 * 收货地址管Service
 * Created by cmkj on 2018/10/18.
 */
public interface OmsCompanyAddressService {
    /**
     * 获取全部收货地址
     */
    List<OmsCompanyAddress> list();
}
