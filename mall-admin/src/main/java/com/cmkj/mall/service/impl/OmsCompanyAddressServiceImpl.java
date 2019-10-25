package com.cmkj.mall.service.impl;

import com.cmkj.mall.model.oms.OmsCompanyAddressExample;
import com.cmkj.mall.mapper.oms.OmsCompanyAddressMapper;
import com.cmkj.mall.model.oms.OmsCompanyAddress;
import com.cmkj.mall.service.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收货地址管理Service实现类
 * Created by cmkj on 2018/10/18.
 */
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressMapper companyAddressMapper;
    @Override
    public List<OmsCompanyAddress> list() {
        return companyAddressMapper.selectByExample(new OmsCompanyAddressExample());
    }
}
