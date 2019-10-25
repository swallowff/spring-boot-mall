package com.cmkj.mall.mapper.pms;

import com.cmkj.mall.model.pms.PmsGoodsServiceCentre;
import com.cmkj.mall.model.pms.PmsGoodsServiceCentreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsGoodsServiceCentreMapper {
    long countByExample(PmsGoodsServiceCentreExample example);

    int deleteByExample(PmsGoodsServiceCentreExample example);

    int insert(PmsGoodsServiceCentre record);

    int insertSelective(PmsGoodsServiceCentre record);

    List<PmsGoodsServiceCentre> selectByExample(PmsGoodsServiceCentreExample example);

    int updateByExampleSelective(@Param("record") PmsGoodsServiceCentre record, @Param("example") PmsGoodsServiceCentreExample example);

    int updateByExample(@Param("record") PmsGoodsServiceCentre record, @Param("example") PmsGoodsServiceCentreExample example);
}