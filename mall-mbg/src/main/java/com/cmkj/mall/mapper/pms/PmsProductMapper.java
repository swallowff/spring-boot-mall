package com.cmkj.mall.mapper.pms;

import com.cmkj.mall.model.pms.PmsProduct;
import com.cmkj.mall.model.pms.PmsProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductMapper {
    long countByExample(PmsProductExample example);

    int deleteByExample(PmsProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsProduct record);

    int insertSelective(PmsProduct record);

    //用来添加商品跟标签中间表数据
    void insertGoodsTagCentre(PmsProduct record);
    //用来删除商品跟标签中间表数据
    void deleteGoodsTagCentre(Long id);

    //用来添加商品跟服务中间表数据
    void insertGoodsServiceCentre(PmsProduct record);
    //用来删除商品跟服务中间表数据
    void deleteGoodsServiceCentre(Long id);

    List<PmsProduct> selectByExampleWithBLOBs(PmsProductExample example);

    List<PmsProduct> selectByExample(PmsProductExample example);

    PmsProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    int updateByExample(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    int updateByPrimaryKeySelective(PmsProduct record);

    int updateByPrimaryKeyWithBLOBs(PmsProduct record);

    int updateByPrimaryKey(PmsProduct record);
}