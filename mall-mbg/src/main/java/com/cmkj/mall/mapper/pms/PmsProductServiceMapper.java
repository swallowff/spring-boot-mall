package com.cmkj.mall.mapper.pms;

import com.cmkj.mall.model.pms.PmsProductService;
import com.cmkj.mall.model.pms.PmsProductServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductServiceMapper {
    long countByExample(PmsProductServiceExample example);

    int deleteByExample(PmsProductServiceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsProductService record);

    int insertSelective(PmsProductService record);

    List<PmsProductService> selectByExample(PmsProductServiceExample example);

    PmsProductService selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsProductService record, @Param("example") PmsProductServiceExample example);

    int updateByExample(@Param("record") PmsProductService record, @Param("example") PmsProductServiceExample example);

    int updateByPrimaryKeySelective(PmsProductService record);

    int updateByPrimaryKey(PmsProductService record);
}