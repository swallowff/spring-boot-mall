package com.cmkj.mall.mapper.pms;

import com.cmkj.mall.model.pms.PmsProductTag;
import com.cmkj.mall.model.pms.PmsProductTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductTagMapper {
    long countByExample(PmsProductTagExample example);

    int deleteByExample(PmsProductTagExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsProductTag record);

    int insertSelective(PmsProductTag record);

    List<PmsProductTag> selectByExample(PmsProductTagExample example);

    PmsProductTag selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsProductTag record, @Param("example") PmsProductTagExample example);

    int updateByExample(@Param("record") PmsProductTag record, @Param("example") PmsProductTagExample example);

    int updateByPrimaryKeySelective(PmsProductTag record);

    int updateByPrimaryKey(PmsProductTag record);
}