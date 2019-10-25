package com.cmkj.mall.member.util;


public class ContextRepostiory {
	/**
	 * 业务状态的常量值
	 */
	public static final String SESSION_LOGIN_ACCOUNT = "USER_LOGIN_INFO";
	public static final String SESSION_VERIFICATION_CODE  = "SESSION_VERIFICATION_CODE";
	public static final String SESSION_VERIFICATION_CODE_FINDPASSWORD  = "SESSION_VERIFICATION_CODE_FINDPASSWORD";
	public static final String SESSION_VERIFICATION_IMGCODE  = "SESSION_VERIFICATION_IMGCODE";
	public static final String SESSION_RETRIEVE_IMGCODE  = "SESSION_RETRIEVE_IMGCODE";
	public static final String UPDATECODE  = "UPDATECODE";
	public static final String SUCCESS_CODE = "SUCCESS";
	public static final String ERROR_CODE = "ERROR";
	public static final String ABNORMAL_CODE = "ABNORMAL";
	/**
	 * 微信小程序的APPID
	 * 微信小程序的密钥
	 */
	public static final String APPID = "wx384bc17d31d82535";
	public static final String APPSECRET = "22ded70ede1f180f44c02ec031b2e749";
	
	/**
	 * 微信公众号的APPID
	 * 微信小程序的密钥
	 */
	public static final String WXAPPID = "wx695388d28307d7d2";
	public static final String WXAPPSECRET = "d5372f520452df00cda9d230aa930401";
	
	/**
	 * 微信公众号的APPID -- 测试
	 * 微信小程序的密钥
	 */
//	public static final String WXAPPID = "wxdcbd2a4cea6409a0";
//	public static final String WXAPPSECRET = "c03e8a237f0ff955aa8272d739dcab11";


	/**
	 * 微信支付调用的KEY
	 */
//	public static final String PARTNERKEY = "jojiffwe84854osd98kf8998kd90023l";
	
	/**
	 * 微信支付的商户ID
	 */
//	public static final String MCHID="1514874421";
	
	/**
	 * 微信支付调用的KEY
	 */
	public static final String PARTNERKEY = "jojiffwe84854osd98kf8998kd90023l";
	
	/**
	 * 微信支付的商户ID
	 */
	public static final String MCHID="1517158061";
	
	 //签名方式
    public static final String SIGNTYPE = "MD5";
	
	/**
	 * 业务跳转地址
	 */
	public static final String URL = "https://miniapp.98htcz.com/miniAPP";
//	public static final String URL = "https://apps.98htcz.com/miniAPP";
//	public static final String URL = "http://zl.98htcz.com:82/miniAPP";
	
	/**
	 * 支付回调订单处理业务跳转地址
	 */
	public static final String INDENTURL = "http://www.98htcz.com";
//	public static final String INDENTURL = "http://zl.98htcz.com";
//	public static final String INDENTURL = "http://192.168.0.240:8080";
	
	/**
	 * 用户分享的链接
	 */

	public static final String SHAREURL = "http://www.98htcz.com/CzWx/pageJump/personalCenter";
//	public static final String SHAREURL = "https//miniapp.98htcz.com/miniAPP/pageJump/personalCenter";
//	public static final String SHAREURL = "http://localhost:8080/miniAPP/pageJump/personalCenter";
	/**
	 * 用户默认头像路径
	 */
	public static final String USERHEADIMAGEPATH = "http://czupload.oss-cn-hangzhou.aliyuncs.com/view/2017-12-27/user/album/ec812cffcc75a6bfd7d27746d509707b.jpg";
	/**
	 * 用户自己注册默认公司的推荐ID
	 */
	public static final Integer PUBLICRECOMMENDATIONID = 1702168888;
	/**
	 *用户用微信注册登录默认设置的密码
	 */
	public static final String DEFAULTPASSWORD = "a88888888";
	/**
	 * 开通会员金额
	 */
	public static final double VIPCOST = 99D;
	
	/**
	 * 升级股东商1级金额
	 */
	public static final double SHAREHOLDERONE = 1901D;
	/**
	 * 升级股东商2级金额
	 */
	public static final double SHAREHOLDERTWO = 4901D;
	
	/**
	 * 升级股东商3级金额
	 */
	public static final double SHAREHOLDERTHREE = 9901D;
	/**
	 * 升级股东商4级金额
	 */
	public static final double SHAREHOLDERFOUR = 19901D;
	/**
	 * 升级股东商5级金额
	 */
	public static final double SHAREHOLDERFIRE = 49901D;
	
	
	/**
	 * 老会员获取激活码需要支付金额
	 */
	public static final double GETVIPCODE = 29D;
	
	/**
	 * 购买vip微信支付后回调地址
	 */
	public static final String VIPNOTITYURL = "https//miniapp.98htcz.com/miniAPP/vipPayNotityUrl/wenNotify";
	
	//微信统一下单接口地址
    public static final String pay_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    
    //微信查询订单信息接口地址
    public static final String query_url = "https://api.mch.weixin.qq.com/pay/orderquery";

    // 企业付款
    public static final String TRANSFERS_PAY = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers"; 

    // 企业付款查询
    public static final String TRANSFERS_PAY_QUERY = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo"; 
    
    // 支付证书路径
    public static final String CERT_PATH = "C:\\CERT\\cm\\apiclient_cert.p12"; 
//    public static final String CERT_PATH = "D:\\cert\\gzh\\apiclient_cert.p12"; 
    
	/**
	 * 购买商品微信支付后回调地址
	 */
	public static final String ORDERNOTITYURL = "https//miniapp.98htcz.com/miniAPP/orderPayNotityUrl/wenNotify";
	
	/**
	 *代理用户生成VIP激活码的数量 -- 默认
	 */
	public static final Integer VIPCODENUM = 1700;
	
	/**
	 * 分享注册二维码的logo图片路径
	 */
	public static final String ODEIMG = "C:/VirtualHost/Lmh118523465123/miniAPP/WebContent/images/shoppingMallImages/temp/images/share/logo.jpg";
	
	/**
	 * 分享个人简介的路径
	 */
	public static final String COMPANYPROFILEURL = "https//miniapp.98htcz.com/miniAPP/pageJumpNoFilter/companyProfile";
	
	/**
	 * 首次登录绑定手机号  奖励金额
	 */
	public static final double MONEY = 2.0D;
	
	/**
	 * 升级经销商获得199体验积分
	 */
	public static final double SHOPCOIN = 199D;
	
	/**
	 * 每页显示数量
	 */
	public static final  int PERPAGECOUNT = 20;
	/**
	 * 生成不重复随机字符串包括字母数字
	 *
	 * @param len
	 * @return
	 */
	public static final String FILE_PATH = "https://miniapp.98htcz.com:8080/";
	
	public static String generateRandomStr(int len) {
	    //字符源，可以根据需要删减
	    String generateSource = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String rtnStr = "";
	    for (int i = 0; i < len; i++) {
	        //循环随机获得当次字符，并移走选出的字符
	        String nowStr = String.valueOf(generateSource.charAt((int) Math.floor(Math.random() * generateSource.length())));
	        rtnStr += nowStr;
	        generateSource = generateSource.replaceAll(nowStr, "");
	    }
	    return rtnStr;
	}
	/**
	 * APP Constants
	 */
	// app注册接口_请求协议参数)
	public static final String[] APP_REGISTERED_PARAM_ARRAY = new String[] { "countries", "uname", "passwd","title", "full_name", "company_name", "countries_code", "area_code", "telephone", "mobile" };
	public static final String[] APP_REGISTERED_VALUE_ARRAY = new String[] { "国籍", "邮箱帐号", "密码", "称谓", "名称", "公司名称","国家编号", "区号", "电话", "手机号" };

	// app根据用户名获取会员信息接口_请求协议中的参数
	public static final String[] APP_GETAPPUSER_PARAM_ARRAY = new String[] { "USERNAME" };
	public static final String[] APP_GETAPPUSER_VALUE_ARRAY = new String[] { "用户名" };
	
	//发短信账户信息
	public static final long smsappid = 140009369395L;
	public static final String smsappkey = "89b58d3cacdeda8e3d92c29ecacb1128";
	public static final String smssign = "创敏智能";
	public static final String smsurl = "https://sms.banling.com/intf/sendsms";
	
}
