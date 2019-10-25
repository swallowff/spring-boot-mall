package com.cmkj.mall.goods.service.impl;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.goods.service.PmsCommentService;
import com.cmkj.mall.mapper.pms.PmsCommentMapper;
import com.cmkj.mall.model.pms.PmsComment;
import com.cmkj.mall.model.pms.PmsCommentExample;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author:zhangli
 * @Version 1.0
 * 商品评论表ServiceImpl
 */
@Service
public class PmsCommentServiceImpl implements PmsCommentService {

    @Autowired
    private PmsCommentMapper pmsCommentMapper;

    @Override
    public void save(PmsComment entity) {
        pmsCommentMapper.insert(entity);
    }

    @Override
    public void delete(Long id) {
        pmsCommentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(PmsComment entity) {
        pmsCommentMapper.updateByPrimaryKey(entity);
    }

    @Override
    public PmsComment selectOne(Long id) {
        return pmsCommentMapper.selectByPrimaryKey(id);
    }

    @Override
    public CommonPage<PmsComment> selectAll(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        PmsCommentExample example = new PmsCommentExample();
        return CommonPage.restPage(pmsCommentMapper.selectByExample(example));
    }
}
