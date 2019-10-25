package com.cmkj.mall.goods.service.base;


import com.cmkj.mall.common.api.CommonPage;

import java.util.List;

/**
 * @Author:zhangli
 * @Version 1.0
 * 基本的crud
 */
public interface BaseService<T> {
    /**
     * 添加
     * @param entity
     */
    void save(T entity);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 修改
     * @param entity
     */
    void update(T entity);

    /**
     * 根据id查询一个
     * @param id
     * @return
     */
    T selectOne(Long id);

    /**
     * 分页查询所有
     * @return
     */
    CommonPage<T> selectAll(Integer pageSize, Integer pageNum);
}
