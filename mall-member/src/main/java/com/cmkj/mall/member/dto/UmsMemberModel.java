package com.cmkj.mall.member.dto;

import io.swagger.annotations.ApiModelProperty;
public class UmsMemberModel {
	
	@ApiModelProperty("会员id")
	private long id;
	
	@ApiModelProperty("用户权限id")
	private int levelId;
	
	@ApiModelProperty("用户id")
	private long userId;
	
	@ApiModelProperty("登录密码")
	private String password;
	
	@ApiModelProperty("用户昵称")
	private String nickname;
	
	@ApiModelProperty("手机号码")
	private String phone;
	
	@ApiModelProperty("注册时间")
	private String createTime;
	
	@ApiModelProperty("帐号启用状态:0->禁用；1->启用")
	private int status;
	
	@ApiModelProperty("头像")
	private String icon;
	
	@ApiModelProperty("推荐人")
	private long referrer;
	
	@ApiModelProperty("间接推荐人")
	private long referrerSecond;
	
	@ApiModelProperty("间间接推荐人")
	private long referrerThird;
	
	@ApiModelProperty("推荐层阶")
	private String referrerLayer;
	
	@ApiModelProperty("app微信openid")
	private String appOpenid;
	
	@ApiModelProperty("小程序微信openid")
	private String appletOpenid;
	
	@ApiModelProperty("公众号微信openid")
	private String bjnewsOpenid;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getLevelId() {
		return levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public long getReferrer() {
		return referrer;
	}

	public void setReferrer(long referrer) {
		this.referrer = referrer;
	}

	public long getReferrerSecond() {
		return referrerSecond;
	}

	public void setReferrerSecond(long referrerSecond) {
		this.referrerSecond = referrerSecond;
	}

	public long getReferrerThird() {
		return referrerThird;
	}

	public void setReferrerThird(long referrerThird) {
		this.referrerThird = referrerThird;
	}

	public String getReferrerLayer() {
		return referrerLayer;
	}

	public void setReferrerLayer(String referrerLayer) {
		this.referrerLayer = referrerLayer;
	}

	public String getAppOpenid() {
		return appOpenid;
	}

	public void setAppOpenid(String appOpenid) {
		this.appOpenid = appOpenid;
	}

	public String getAppletOpenid() {
		return appletOpenid;
	}

	public void setAppletOpenid(String appletOpenid) {
		this.appletOpenid = appletOpenid;
	}

	public String getBjnewsOpenid() {
		return bjnewsOpenid;
	}

	public void setBjnewsOpenid(String bjnewsOpenid) {
		this.bjnewsOpenid = bjnewsOpenid;
	}

}
