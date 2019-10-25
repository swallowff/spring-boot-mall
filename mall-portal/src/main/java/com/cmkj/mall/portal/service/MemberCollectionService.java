package com.cmkj.mall.portal.service;

import com.cmkj.mall.portal.domain.MemberProductCollection;

import java.util.List;

/**
 * 会员收藏Service
 * Created by cmkj on 2018/8/2.
 */
public interface MemberCollectionService {
    int addProduct(MemberProductCollection productCollection);

    int deleteProduct(Long memberId, Long productId);

    List<MemberProductCollection> listProduct(Long memberId);
}
