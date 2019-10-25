package com.cmkj.mall.goods.dao;

import com.cmkj.mall.goods.entity.AllClassify;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:zhangli
 * @Version 1.0
 */
@Mapper
@Repository
public interface AllClassifyDao {
    /**
     * 拿到全部分类
     * @return
     */
    List<AllClassify> selectAll();
}
