package com.cmkj.mall.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmkj.mall.common.annotation.ApiVersion;
import com.cmkj.mall.common.api.CommonResult;
import com.cmkj.mall.member.controller.base.BaseController;
import com.cmkj.mall.member.dao.UmsMemberLoginDao;
import com.cmkj.mall.member.service.UmsMemberLoginService;
import com.cmkj.mall.member.util.CryptographyUtil;
import com.cmkj.mall.member.util.PageData;
import com.cmkj.mall.member.util.WeChatApiUtil;
import com.cmkj.mall.member.util.sendMessage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONObject;

/**
 * @author swallowff
 * @create 2019/10/11
 */
@ApiVersion(1)
@Api(tags = "UmsMemberLoginController", description = "用户登录")
@RestController
@RequestMapping(value = "{version}/api/mall/member/login")
@SuppressWarnings("rawtypes")
public class UmsMemberLoginController extends BaseController {

	@Autowired
	private UmsMemberLoginDao memberLoginDao;

	@Autowired
	private UmsMemberLoginService memberLoginService;

	@ApiOperation("获取微信access_token")
	@PostMapping(value = "getToken")
	public CommonResult getToken() {
		String accessToken = WeChatApiUtil.getAccessToken();
		return CommonResult.success(accessToken);
	}

	@ApiOperation("获取微信openid、session_key、unionid")
	@PostMapping(value = "getOppid")
	public CommonResult getUnionid(
			@ApiParam(value = "手机code识别码") @RequestParam(value = "code", required = true) String code) {
		
		JSONObject oppid = WeChatApiUtil.getOppid(code);
		return CommonResult.success(oppid);
	}

	@ApiOperation("解密微信用户信息（手机号等）")
	@PostMapping(value = "weixinPhone")
	public CommonResult getUnionid(
			@ApiParam(value = "微信sessionKey") @RequestParam(value = "sessionKey", required = true) String sessionKey,
			@ApiParam(value = "微信解密钥匙encryptedData") @RequestParam(value = "encryptedData", required = true) String encryptedData,
			@ApiParam(value = "微信解密钥匙iv") @RequestParam(value = "iv", required = true) String iv) {
		
		JSONObject userInfo = WeChatApiUtil.getUserInfo(encryptedData, sessionKey, iv);
		return CommonResult.success(userInfo);
	}

	@ApiOperation("获取用户信息(根据用户id)")
	@PostMapping(value = "uderidGetUserInfo")
	public CommonResult uderidGetUserInfo(
			@ApiParam(value = "用户id") @RequestParam(value = "userId", required = true) String userId) {
		
		PageData userInfo = memberLoginDao.getUserInfo(new PageData("userId", userId));
		return CommonResult.success(userInfo);
	}

	@ApiOperation("获取用户信息(根据微信app openid)")
	@PostMapping(value = "appGetUserInfo")
	public CommonResult appGetUserInfo(
			@ApiParam(value = "微信app openid") @RequestParam(value = "appOpenid", required = true) String appOpenid) {
		
		PageData userInfo = memberLoginDao.getUserInfo(new PageData("appOpenid", appOpenid));
		return CommonResult.success(userInfo);
	}

	@ApiOperation("获取用户信息(根据微信小程序 openid)")
	@PostMapping(value = "appletGetUserInfo")
	public CommonResult appletGetUserInfo(
			@ApiParam(value = "微信小程序 openid") @RequestParam(value = "appletOpenid", required = true) String appletOpenid) {
		
		PageData userInfo = memberLoginDao.getUserInfo(new PageData("appletOpenid", appletOpenid));
		return CommonResult.success(userInfo);
	}

	@ApiOperation("获取用户信息(根据微信公众号 openid)")
	@PostMapping(value = "bjnewsGetUserInfo")
	public CommonResult bjnewsGetUserInfo(
			@ApiParam(value = "微信公众号 openid") @RequestParam(value = "bjnewsOpenid", required = true) String bjnewsOpenid) {
		
		PageData userInfo = memberLoginDao.getUserInfo(new PageData("bjnewsOpenid", bjnewsOpenid));
		return CommonResult.success(userInfo);
	}

	@ApiOperation("手机获取验证码")
	@PostMapping(value = "phoneGetCode")
	public CommonResult phoneGetCode(
			@ApiParam(value = "手机号码") @RequestParam(value = "phone", required = true) String phone) {
		
		if (!isPhone(phone)) return CommonResult.validateFailed();
		String code = memberLoginService.getIsCode(phone);
		int flag = sendMessage.send(phone, code, "5", "", 1);
		if (flag < 0) return CommonResult.failed("验证码发送失败");
		return CommonResult.success(true);
	}

	@ApiOperation("手机验证验证码")
	@PostMapping(value = "phoneVerifyCode")
	public CommonResult phoneVerifyCode(
			@ApiParam(value = "手机号码") @RequestParam(value = "phone", required = true) String phone,
			@ApiParam(value = "手机验证码") @RequestParam(value = "code", required = true) String code) {
		
		if (!isPhone(phone))
			return CommonResult.validateFailed();
		if(!memberLoginService.getPhoneCode(phone,code)) return CommonResult.failed("验证码错误");
		memberLoginService.redisDel("phoneCode:" + phone);//清除redis缓存中的手机验证码
		return CommonResult.success(true);
	}
	
	@ApiOperation("手机密码获取用户信息")
	@PostMapping(value = "passwordGetUserInfo")
	public CommonResult passwordGetUserInfo(
			@ApiParam(value = "手机号码") @RequestParam(value = "phone", required = true) String phone,
			@ApiParam(value = "登录密码") @RequestParam(value = "password", required = true) String password) {
		
		if (!isPhone(phone)) return CommonResult.failed("错误手机号");
		if (!isPassword(password,phone)) return CommonResult.failed("密码格式错误");
		PageData userInfo = memberLoginDao.getUserInfo(new PageData("phone", phone));
		if(userInfo == null) return CommonResult.failed("用户不存在");
		if(!userInfo.getString("password").equals(CryptographyUtil.md5(password, CryptographyUtil.SALT))) return CommonResult.failed("密码输入错误");
		return CommonResult.success(userInfo);
	}

	@ApiOperation("手机验证码获取用户信息")
	@PostMapping(value = "codeGetUserInfo")
	public CommonResult codeGetUserInfo(
			@ApiParam(value = "手机号码") @RequestParam(value = "phone", required = true) String phone,
			@ApiParam(value = "手机验证码") @RequestParam(value = "code", required = true) String code) {
		
		if (!isPhone(phone)) return CommonResult.failed("错误手机号");
		if(!memberLoginService.getPhoneCode(phone,code)) return CommonResult.failed("验证码错误");
		PageData userInfo = memberLoginDao.getUserInfo(new PageData("phone", phone));
		if (userInfo == null) return CommonResult.failed("用户不存在");
		memberLoginService.redisDel("phoneCode:" + phone);//清除redis缓存中的手机验证码
		return CommonResult.success(userInfo);
	}

	@ApiOperation("手机验证码注册")
	@PostMapping(value = "phoneCodeRegister")
	public CommonResult phoneCodeRegister(
			@ApiParam(value = "手机号码") @RequestParam(value = "phone", required = true) String phone,
			@ApiParam(value = "手机验证码") @RequestParam(value = "code", required = true) String code,
			@ApiParam(value = "推荐人id") @RequestParam(value = "referralId", required = false) long referralId,
			@ApiParam(value = "APP微信openid") @RequestParam(value = "appOpenid", required = false) String appOpenid,
			@ApiParam(value = "小程序微信openid") @RequestParam(value = "appletOpenid", required = false) String appletOpenid,
			@ApiParam(value = "公众号微信openid") @RequestParam(value = "bjnewsOpenid", required = false) String bjnewsOpenid) {
		
		if (!isPhone(phone)) return CommonResult.failed("错误手机号");
		if(memberLoginDao.isHavePhone(phone) > 0) return CommonResult.failed("账户已存在");
		if(!memberLoginService.getPhoneCode(phone,code)) return CommonResult.failed("验证码错误");
		memberLoginService.userRegister(getPageData());
		return CommonResult.success("注册成功");
	}

	@ApiOperation("手机密码注册")
	@PostMapping(value = "phonePasswordRegister")
	public CommonResult phonePasswordRegister(
			@ApiParam(value = "手机号码") @RequestParam(value = "phone", required = true) String phone,
			@ApiParam(value = "登录密码") @RequestParam(value = "password", required = true) String password,
			@ApiParam(value = "推荐人id") @RequestParam(value = "referralId", required = false) long referralId) {
		
		if (!isPhone(phone)) return CommonResult.failed("错误手机号");
		if(memberLoginDao.isHavePhone(phone) > 0) return CommonResult.failed("账户已存在");
		memberLoginService.userRegister(getPageData());
		return CommonResult.success("注册成功");
	}

	@ApiOperation("修改登录密码")
	@PostMapping(value = "updeteLonginPassword")
	public CommonResult updeteLonginPassword(
			@ApiParam(value = "手机号码") @RequestParam(value = "phone", required = true) String phone,
			@ApiParam(value = "登录密码") @RequestParam(value = "password", required = true) String password) {
		
		if (!isPhone(phone)) return CommonResult.failed("错误手机号");
		if(memberLoginDao.isHavePhone(phone) < 1) return CommonResult.failed("账户不存在");
		if (!isPassword(password,phone)) return CommonResult.failed("密码格式错误");
		memberLoginDao.updeteLonginPassword(phone,CryptographyUtil.md5(password, CryptographyUtil.SALT));
		return CommonResult.success(true);
	}
	
	@ApiOperation("修改支付密码")
	@PostMapping(value = "updetePayPassword")
	public CommonResult updetePayPassword(
			@ApiParam(value = "手机号码") @RequestParam(value = "phone", required = true) String phone,
			@ApiParam(value = "支付密码(6位数字)") @RequestParam(value = "password", required = true) String password) {
		
		if (!isPhone(phone)) return CommonResult.failed("错误手机号");
		if(memberLoginDao.isHavePhone(phone) < 1) return CommonResult.failed("账户不存在");
		if (!isNumPassword(password)) return CommonResult.failed("密码格式错误");
		memberLoginDao.updetePayPassword(phone,CryptographyUtil.md5(password, CryptographyUtil.SALT));
		return CommonResult.success(true);
	}
	
	
}
