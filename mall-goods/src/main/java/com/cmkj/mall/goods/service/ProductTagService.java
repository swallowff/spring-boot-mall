package com.cmkj.mall.goods.service;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.model.pms.PmsProductTag;

import java.util.List;

/**
 * @Author:zhangli
 * @Version 1.0
 * 商品标签表Service
 */
public interface ProductTagService {

    /**
     * 商品标签添加
     * @param tagName
     * @return
     */
    void addTag(String tagName);

    /**
     * 商品标签删除
     * @param id
     * @return
     */
    void deleteTag(Long  id);

    /**
     * 修改商品标签
     * @param pmsProductTag
     * @return
     */
    void updataTag(PmsProductTag pmsProductTag);

    /**
     * 查询所有的商品标签
     * @return
     */
    CommonPage<PmsProductTag> selectAllTag();


}
