package com.cmkj.mall.member.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmkj.mall.member.dao.UmsMemberLoginDao;
import com.cmkj.mall.member.dto.UmsMemberModel;
import com.cmkj.mall.member.util.CommonUtil;
import com.cmkj.mall.member.util.CryptographyUtil;
import com.cmkj.mall.member.util.DateUtil;
import com.cmkj.mall.member.util.PageData;
import com.cmkj.mall.member.util.RedisUtil;

@Service
public class UmsMemberLoginService {
	@Autowired
	private UmsMemberLoginDao memberLoginDao;
	
	@Autowired
	private RedisUtil redis;
	
	//查询用户信息
	public PageData getUserInfo(PageData pd){
		return memberLoginDao.getUserInfo(pd);
	}

	//获取验证码
	public String getIsCode(String phone) {
		String phoneCode = (String)redis.get("phoneCode:" + phone);
		if(phoneCode == null){
			String code = CommonUtil.getRandomNumber(6);
			redis.set("phoneCode:" + phone, code, 60 * 5);
			return code;
		}else{
			return phoneCode;
		}
	}

	//通过手机号获取redis中的验证码
	public boolean getPhoneCode(String phone,String code) {
		String phoneCode = (String)redis.get("phoneCode:" + phone);
		if(phoneCode != null  && code.equals(phoneCode)){
			return true;
		}else{
			return false;
		}
	}

	//通过键删除redis
	public void redisDel(String key){
		redis.del(key);
	}
	
	@Transactional
	public void userRegister(PageData pd) {
		UmsMemberModel member = new UmsMemberModel();
		if(pd.containsKey("referralId")){//录入推荐信息
			PageData referralInfo = memberLoginDao.getReferralInfo(pd.getLong("referralId"));
			if(referralInfo != null){
				member.setReferrer(pd.getLong("referralId"));
				if(referralInfo.containsKey("referrer")) member.setReferrerSecond(referralInfo.getInt("referrer"));
				if(referralInfo.containsKey("referrerSecond")) member.setReferrerThird(referralInfo.getInt("referrerSecond"));
				if(referralInfo.containsKey("referrerLayer")){
					member.setReferrerLayer(pd.getLong("referralId") + "," + referralInfo.getString("referrerLayer"));
				}
			}
		}
		
		long userId = 0;//生成用户id
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyMMdd");
		for (int i = 0; i < 9998; i++) {
			int x = (int) (Math.random() * (9999-1000+1))+1000;
			String u = format.format(date) + x;
			userId = Long.parseLong(u);
			if (memberLoginDao.isUserId(userId) == 0) {
				break;
			}
		}
		
		if(pd.containsKey("password")) member.setPassword(CryptographyUtil.md5(pd.getString("password"), CryptographyUtil.SALT));
		if(pd.containsKey("appOpenid")) member.setAppOpenid(pd.getString("appOpenid"));
		if(pd.containsKey("appletOpenid")) member.setAppletOpenid(pd.getString("appletOpenid"));
		if(pd.containsKey("bjnewsOpenid")) member.setBjnewsOpenid(pd.getString("bjnewsOpenid"));
		
		member.setLevelId(5);
		member.setUserId(userId);
		member.setNickname(userId + "");
		member.setPhone(pd.getString("phone"));
		member.setStatus(1);
		member.setCreateTime(DateUtil.getTime());
		member.setIcon("http://czupload.oss-cn-hangzhou.aliyuncs.com/view/2017-12-27/user/album/ec812cffcc75a6bfd7d27746d509707b.jpg");
		//新增会员信息表
		memberLoginDao.insertMember(member);
		long memberId = member.getId();
		System.out.println(memberId);
		//新增会员统计信息表
		memberLoginDao.insertMemberStatisce(memberId);
		//新增用户财务表
		memberLoginDao.insertUserFinance(memberId);
		//清除redis缓存中的手机验证码
		if(pd.containsKey("code")) redisDel("phoneCode:" + pd.getString("phone"));
	}
	
}
