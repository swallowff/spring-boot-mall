package com.cmkj.mall.order.service;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.common.api.ResultCode;
import com.cmkj.mall.common.constant.resultcode.GoodsResultCode;
import com.cmkj.mall.common.constant.states.CommonStatusEnums;
import com.cmkj.mall.common.exception.ServiceException;
import com.cmkj.mall.mapper.oms.OmsCartItemMapper;
import com.cmkj.mall.mapper.pms.PmsProductCategoryAttributeRelationMapper;
import com.cmkj.mall.mapper.pms.PmsProductMapper;
import com.cmkj.mall.mapper.pms.PmsSkuStockMapper;
import com.cmkj.mall.mapper.ums.UmsMemberMapper;
import com.cmkj.mall.model.oms.OmsCartItem;
import com.cmkj.mall.model.oms.OmsCartItemExample;
import com.cmkj.mall.model.pms.PmsProduct;
import com.cmkj.mall.model.pms.PmsSkuStock;
import com.cmkj.mall.model.ums.UmsMember;
import com.cmkj.mall.order.dao.CartItemDao;
import com.cmkj.mall.order.vo.CartItemsListVO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author swallowff
 * @create 2019/10/13
 */
@Service
public class CartApiService {
    @Autowired
    private OmsCartItemMapper cartItemMapper;
    @Autowired
    private CartItemDao cartItemDao;
    @Autowired
    private UmsMemberMapper memberMapper;
    @Autowired
    private PmsSkuStockMapper skuStockMapper;
    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private PmsProductCategoryAttributeRelationMapper pcaRelationMapper;

    public int addOrUpdateItem(Long memberId, Long skuId, int quantity) {
        OmsCartItemExample example = new OmsCartItemExample();
        example.createCriteria()
                .andMemberIdEqualTo(memberId)
                .andProductSkuIdEqualTo(skuId)
                .andDeleteStatusEqualTo(CommonStatusEnums.DeleteStatus.NORMAL.getVal());
        List<OmsCartItem> list = cartItemMapper.selectByExample(example);
        if (!list.isEmpty()){
            //用户已添加过相同的sku,只增加数量
            OmsCartItem existItem = list.get(0);
            existItem.setQuantity(existItem.getQuantity() + quantity);
            return cartItemMapper.updateByPrimaryKeySelective(existItem);
        }else {
            PmsSkuStock sku = skuStockMapper.selectByPrimaryKey(skuId);
            if (sku == null){
                throw new ServiceException(GoodsResultCode.GOODS_EXPIRED);
            }
            PmsProduct spu = productMapper.selectByPrimaryKey(sku.getProductId());
            if (spu == null){
                throw new ServiceException(GoodsResultCode.GOODS_EXPIRED);
            }
            UmsMember member = memberMapper.selectByPrimaryKey(memberId);
            OmsCartItem cartItem = new OmsCartItem();
            cartItem.setMemberId(memberId);
            cartItem.setProductSkuId(skuId);
            cartItem.setDeleteStatus(CommonStatusEnums.DeleteStatus.NORMAL.getVal());
            cartItem.setMemberNickname(member.getNickname());
            cartItem.setQuantity(quantity);
            cartItem.setProductId(spu.getId());
            cartItem.setProductName(spu.getName());
            cartItem.setProductSubTitle(spu.getSubTitle());
            cartItem.setProductCategoryId(spu.getProductCategoryId());
            cartItem.setPrice(sku.getPrice());
            cartItem.setProductPic(sku.getPic());
            cartItem.setProductSkuCode(sku.getSkuCode());
            cartItem.setSp1(sku.getSp1());
            cartItem.setSp2(sku.getSp2());
            cartItem.setSp3(sku.getSp3());
            cartItem.setCreateDate(new Date());
            cartItem.setModifyDate(cartItem.getCreateDate());
            return cartItemMapper.insertSelective(cartItem);
        }
    }

    public CommonPage<OmsCartItem> selectByMemberId(Long memberId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        OmsCartItemExample example = new OmsCartItemExample();
        example.createCriteria().andMemberIdEqualTo(memberId);
        List<OmsCartItem> list = cartItemMapper.selectByExample(example);
        return CommonPage.restPage(list);
    }

    public CommonPage<CartItemsListVO> selectItemsWithSkuInfo(Long memberId, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<CartItemsListVO> list = cartItemDao.selectItemsWithSkuInfo(memberId);
        return CommonPage.restPage(list);
    }

    public int deleteByPrimaryKey(Long id){
        return cartItemMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public int deleteBatch(Long[] ids){
        int del = 0;
        int count = 0;
        for (Long id : ids){
            del = deleteByPrimaryKey(id);
            if (del == 0){
                throw new IllegalArgumentException("id " + id + " does not exist");
            }else {
                count++;
            }
        }
        return count;
    }

    public int deleteByMemberId(Long memberId){
        OmsCartItemExample example = new OmsCartItemExample();
        example.createCriteria().andMemberIdEqualTo(memberId);
        return cartItemMapper.deleteByExample(example);
    }

    public int deleteMemberItem(Long id,Long memberId){
        OmsCartItemExample example = new OmsCartItemExample();
        example.createCriteria().andMemberIdEqualTo(memberId).andIdEqualTo(id);
        return cartItemMapper.deleteByExample(example);
    }

    @Transactional
    public int deleteMemberItems(Long[] ids,Long memberId){
        int flag = 0,count = 0;
        for (Long id : ids){
            flag = deleteMemberItem(id,memberId);
            if (flag == 0){
                throw new ServiceException(ResultCode.FAILED.getCode(),"Wrong Argument ! id = " + id + " memberId = " + memberId);
            }else {
                count++;
            }
        }
        return count;
    }
}
