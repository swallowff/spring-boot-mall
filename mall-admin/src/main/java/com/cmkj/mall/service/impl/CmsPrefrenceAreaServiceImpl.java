package com.cmkj.mall.service.impl;

import com.cmkj.mall.mapper.cms.CmsPrefrenceAreaMapper;
import com.cmkj.mall.model.cms.CmsPrefrenceArea;
import com.cmkj.mall.model.cms.CmsPrefrenceAreaExample;
import com.cmkj.mall.service.CmsPrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品优选Service实现类
 * Created by cmkj on 2018/6/1.
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
