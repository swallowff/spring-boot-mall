package com.cmkj.mall.dto;

import com.cmkj.mall.model.oms.OmsOrderReturnApply;
import com.cmkj.mall.model.oms.OmsCompanyAddress;
import lombok.Getter;
import lombok.Setter;

/**
 * 申请信息封装
 * Created by cmkj on 2018/10/18.
 */
public class OmsOrderReturnApplyResult extends OmsOrderReturnApply {
    @Getter
    @Setter
    private OmsCompanyAddress companyAddress;
}
