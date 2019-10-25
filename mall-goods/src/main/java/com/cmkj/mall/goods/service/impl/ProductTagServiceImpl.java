package com.cmkj.mall.goods.service.impl;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.goods.service.ProductTagService;
import com.cmkj.mall.mapper.pms.PmsProductTagMapper;
import com.cmkj.mall.model.pms.PmsProductTag;
import com.cmkj.mall.model.pms.PmsProductTagExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:zhangli
 * @Version 1.0
 * 商品标签表ServiceImpl
 */

@Service
public class ProductTagServiceImpl implements ProductTagService {

    @Autowired
    private PmsProductTagMapper pmsProductTagMapper;

    /**
     * 商品标签添加
     * @param tagName
     * @return
     */
    @Override
    public void addTag(String tagName) {
        PmsProductTag productTag  = new PmsProductTag();
        productTag.setTagName(tagName);
        pmsProductTagMapper.insert(productTag);
    }

    /**
     * 商品标签删除
     * @param id
     * @return
     */
    @Override
    public void deleteTag(Long id) {
        pmsProductTagMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改商品标签
     * @param pmsProductTag
     * @return
     */
    @Override
    public void updataTag(PmsProductTag pmsProductTag) {
        pmsProductTagMapper.updateByPrimaryKey(pmsProductTag);
    }

    /**
     * 查询所有的商品标签
     * @return
     */
    @Override
    public CommonPage<PmsProductTag> selectAllTag() {
        PmsProductTagExample  example = new PmsProductTagExample();
        return CommonPage.restPage(pmsProductTagMapper.selectByExample(example));
    }
}
