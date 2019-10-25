package com.cmkj.mall.member.util;

import java.util.ArrayList;

import com.cmkj.mall.member.sms.SmsSingleSender;
import com.cmkj.mall.member.sms.SmsSingleSenderResult;


public class sendMessage {
	
	public static int send(String phone, String context,String context2, String context3,int type) {
		 int inputLine = -99;
		    	/**
		    	 *  0    	 成功
		    	 * 201701	错误的手机号码
				* 201702	错误的短信模板ID
				* 201709	发送内容和模板不匹配
				* 201710	有效号码不足
				* 201711	变量内容超过限定字符，变量的内容不能超过18个字符。
				* 201708	模板参数没有全部生效,短信内容不能包含特殊字符#,请检查参数重试
				* 201705	参数错误
				* 201706	短信长度超过限制，短信内容不能超过500个字符。
				* 例：【创敏科技集团】828834为您的验证码，请于5分钟内填写。感谢您光临智能宜家商城！
		    	*/
		 int tmplId = 142863; 
		 String sign = ContextRepostiory.smssign;
		 if(type == 1) { 
			 try {
		            //请根据实际 appid 和 appkey 进行开发，以下只作为演示 sdk 使用
		            long appid = ContextRepostiory.smsappid;
		            String appkey =ContextRepostiory.smsappkey;
		            //初始化单发
		            SmsSingleSender singleSender = new SmsSingleSender(appid, appkey);
		            SmsSingleSenderResult singleSenderResult;
		            ArrayList<String> params = new ArrayList<String>();
		            params.add(context);
		            params.add(context2);
		            singleSenderResult = singleSender.sendWithParam("86", phone, tmplId, params, sign, "", "");
		           inputLine = singleSenderResult.result;
			    } catch (Exception e) {
			    	e.printStackTrace();
			    	}
		 }else if(type==2) { 
		//例:【创敏科技集团】您的宜家商城账号是:13659373336,密码是:123456,请在[微信]添加朋友-输入《创敏科技》-公众号-关注并登陆参与抽奖！登录，谢谢！
		   try {
	            //请根据实际 appid 和 appkey 进行开发，以下只作为演示 sdk 使用
	            long appid =  ContextRepostiory.smsappid;
	            String appkey = ContextRepostiory.smsappkey;
	            tmplId=143013;
	            //初始化单发
	            SmsSingleSender singleSender = new SmsSingleSender(appid, appkey);
	            SmsSingleSenderResult singleSenderResult;
	            ArrayList<String> params = new ArrayList<String>();
	            params.add(context);
	            params.add(context2);
	            params.add(context3);
	            singleSenderResult = singleSender.sendWithParam("86", phone, tmplId, params, sign, "", "");
	           inputLine = singleSenderResult.result;
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		 }else{
			 try {
		            //请根据实际 appid 和 appkey 进行开发，以下只作为演示 sdk 使用
		            long appid =  ContextRepostiory.smsappid;
		            String appkey = ContextRepostiory.smsappkey;
		            //初始化单发
		            SmsSingleSender singleSender = new SmsSingleSender(appid, appkey);
		            SmsSingleSenderResult singleSenderResult;
		            String params = context+context2+context3;
		            singleSenderResult = singleSender.send(0,"86", String.valueOf(phone),params, sign, "", "");
		           inputLine = singleSenderResult.result;
			    } catch (Exception e) {
			    	e.printStackTrace();
			    }
		 }
		
		    return inputLine;
	}
}
