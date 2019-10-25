package com.cmkj.mall.goods.controller;

import com.cmkj.mall.common.annotation.ApiVersion;
import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.common.api.CommonResult;
import com.cmkj.mall.goods.entity.AllClassify;
import com.cmkj.mall.goods.service.AllClassifyService;
import com.cmkj.mall.mapper.pms.PmsProductMapper;
import com.cmkj.mall.model.pms.PmsProduct;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author:zhangli
 * @Version 1.0
 */
@Api(tags = {"商品全部分类"},value = "商品全部分类接口")
@ApiVersion(1)
@RestController
@RequestMapping(value = "{version}/api/mall/goods/allclass")
public class AllClassifyController {

    @Autowired
    private AllClassifyService allClassifyService;

    @Autowired
    private PmsProductMapper pmsProductMapper;

    /**
     * 拿到所有商品分类
     * @return
     */
    @ApiOperation(httpMethod = "GET",value = "商品全部分类",notes = "商品全部分类")
    @RequestMapping(value = "all",method = RequestMethod.GET)
    public CommonResult<CommonPage<AllClassify>> getAllClassify(){
        return CommonResult.success(allClassifyService.getAllClassifyList());
    }

    /**
     * 根据商品id删除商品
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE",value = "删除商品",notes = "删除商品")
    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    public CommonResult  deleteGoods(Long id){
        //先去判断删除的商品是否在数据库中存在
        PmsProduct pmsProduct = pmsProductMapper.selectByPrimaryKey(id);
        try {
            if (pmsProduct.getId()==id) {
                //存在就删除,该id商品
                pmsProductMapper.deleteByPrimaryKey(id);
                //删除商品后把商品跟标签中间表一并删除
                pmsProductMapper.deleteGoodsTagCentre(id);
                //删除商品后把商品跟服务中间表一并删除
                pmsProductMapper.deleteGoodsServiceCentre(id);
                return  CommonResult.success("商品id为：" + id + "删除成功！");
            }
        }catch (NullPointerException e){
            e.printStackTrace();
            return CommonResult.success("没有id为："+id+"的商品");
        }
        return null;
    }
}
