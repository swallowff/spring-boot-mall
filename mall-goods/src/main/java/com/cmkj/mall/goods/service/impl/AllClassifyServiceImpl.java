package com.cmkj.mall.goods.service.impl;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.goods.dao.AllClassifyDao;
import com.cmkj.mall.goods.entity.AllClassify;
import com.cmkj.mall.goods.service.AllClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:zhangli
 * @Version 1.0
 */
@Service
public class AllClassifyServiceImpl implements AllClassifyService {

    @Autowired
    private AllClassifyDao allClassifyDao;

    /**
     * 全部分类
      * @return
     */
    @Override
    public CommonPage<AllClassify> getAllClassifyList() {
        return CommonPage.restPage(allClassifyDao.selectAll());
    }
}
