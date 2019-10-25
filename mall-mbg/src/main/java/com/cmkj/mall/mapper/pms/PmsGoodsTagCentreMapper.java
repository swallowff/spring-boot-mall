package com.cmkj.mall.mapper.pms;

import com.cmkj.mall.model.pms.PmsGoodsTagCentre;
import com.cmkj.mall.model.pms.PmsGoodsTagCentreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsGoodsTagCentreMapper {
    long countByExample(PmsGoodsTagCentreExample example);

    int deleteByExample(PmsGoodsTagCentreExample example);

    int insert(PmsGoodsTagCentre record);

    int insertSelective(PmsGoodsTagCentre record);

    List<PmsGoodsTagCentre> selectByExample(PmsGoodsTagCentreExample example);

    int updateByExampleSelective(@Param("record") PmsGoodsTagCentre record, @Param("example") PmsGoodsTagCentreExample example);

    int updateByExample(@Param("record") PmsGoodsTagCentre record, @Param("example") PmsGoodsTagCentreExample example);
}