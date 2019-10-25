package com.cmkj.mall.goods.service.impl;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.goods.service.PmsProductServiceService;
import com.cmkj.mall.mapper.pms.PmsProductServiceMapper;
import com.cmkj.mall.model.pms.PmsProductService;
import com.cmkj.mall.model.pms.PmsProductServiceExample;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:zhangli
 * @Version 1.0
 * 商品服务表ServiceImpl
 */
@Service
public class PmsProductServiceServiceImpl implements PmsProductServiceService {

    @Autowired
    private PmsProductServiceMapper pmsProductServiceMapper;

    @Override
    public void save(PmsProductService entity) {
        pmsProductServiceMapper.insert(entity);
    }

    @Override
    public void delete(Long id) {
        pmsProductServiceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(PmsProductService entity) {
        pmsProductServiceMapper.updateByPrimaryKey(entity);
    }

    @Override
    public PmsProductService selectOne(Long id) {
        return pmsProductServiceMapper.selectByPrimaryKey(id);
    }

    @Override
    public CommonPage<PmsProductService> selectAll(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return CommonPage.restPage(pmsProductServiceMapper.selectByExample(new PmsProductServiceExample()));
    }
}
