package com.cmkj.mall.member.controller.base;


import java.text.DecimalFormat;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cmkj.mall.member.util.PageData;
import com.cmkj.mall.member.util.UUIDUtil;



public class BaseController{
	
	/**
	 * 得到PageData
	 */
	public PageData getPageData(){
		return new PageData(this.getRequest());
	}
	
	/**
	 * 得到ModelAndView
	 */
	public ModelAndView getModelAndView(){
		return new ModelAndView();
	}
	
	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		return request;
	}

	/**
	 * 得到32位的uuid
	 * @return
	 */
	public String get32UUID(){
		return UUIDUtil.uuid();
	}
	
	
	/**
	 * 范围随机数
	 */
	public int getRandom(int min, int max){
	    Random random = new Random();
	    return random.nextInt(max) % (max - min + 1) + min;
	}
	
	/**
	 * 随机数
	 */
	public String getRandomNumber(int length) {
		double random = Math.random();
		for (int i = 0; i < length; i++) {
			random = random * 10;
		}
		return String.valueOf((int) random);
	}
	
	/**
	 * String 转double
	 */
	public double Double(String str) {
		Double db = Double.parseDouble(str);
		DecimalFormat df = new DecimalFormat("0.00");
		String dbs = df.format(db);
		Double _db = Double.parseDouble(dbs);
		return _db;
	}
	
	/**
	 * 验证手机号是否合法
	 */
	public boolean isPhone(String phone){
		Pattern p = Pattern.compile("^[1][3,4,5,6,7,8,9][0-9]{9}$");
		Matcher m = p.matcher(phone);
		return m.matches();
	}
	
	/**
	 * 效验密码
	 * @param password
	 */
	public boolean isPassword(String password,String phone){
        //判断密码是否包含数字：包含返回1，不包含返回0
        int i = password.matches(".*\\d+.*") ? 1 : 0;
        //判断密码是否包含字母：包含返回1，不包含返回0
        int j = password.matches(".*[a-zA-Z]+.*") ? 1 : 0;
        //判断密码是否包含特殊符号(~!@#$%^&*()_+|<>,.?/:;'[]{}\)：包含返回1，不包含返回0
//        int k = password.matches(".*[_+|<>,.?/:;'\\[\\]{}\"]+.*") ? 1 : 0;
        //判断密码长度是否在6-16位
        int l = password.length();
        //判断密码中是否包含用户名
        boolean contains = password.contains(phone);
        if (i + j < 1 || l < 6 || l > 16 || contains) {
            return false;
        }
		return true;
	}
	
	/**
	 * 效验6位数字密码
	 * @param password
	 */
	public boolean isNumPassword(String password){
        //判断密码是否包含数字：包含返回1，不包含返回0
        int i = password.matches(".*\\d+.*") ? 1 : 0;
        //判断密码是否包含字母：包含返回1，不包含返回0
        int j = password.matches(".*[a-zA-Z]+.*") ? 1 : 0;
        //判断密码是否包含特殊符号(~!@#$%^&*()_+|<>,.?/:;'[]{}\)：包含返回1，不包含返回0
        int k = password.matches(".*[_+|<>,.?/:;'\\[\\]{}\"]+.*") ? 1 : 0;
        //判断密码长度是否在6-16位
        int l = password.length();
        if (i == 0 && j == 1 && k == 1 && l != 6) {
            return false;
        }
		return true;
	}
}
