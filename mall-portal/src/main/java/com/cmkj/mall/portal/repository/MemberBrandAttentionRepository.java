package com.cmkj.mall.portal.repository;

import com.cmkj.mall.portal.domain.MemberBrandAttention;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 会员关注Repository
 * Created by cmkj on 2018/8/2.
 */
public interface MemberBrandAttentionRepository extends MongoRepository<MemberBrandAttention,String> {
    MemberBrandAttention findByMemberIdAndBrandId(Long memberId, Long brandId);
    int deleteByMemberIdAndBrandId(Long memberId,Long brandId);
    List<MemberBrandAttention> findByMemberId(Long memberId);
}
