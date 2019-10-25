package com.cmkj.mall.member.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

public class CryptographyUtil {
	public static final String SALT = "chongziMall";
	/**
	 * base64加密
	 * @param str
	 * @return
	 */
	public static String encBase64(String str){
		return Base64.encodeToString(str.getBytes());
	}
	
	/**
	 * base64解密
	 * @param str
	 * @return
	 */
	public static String decBase64(String str){
		return Base64.decodeToString(str);
	}
	
	/**
	 * Md5加密
	 * @param str
	 * @param salt
	 * @return
	 */
	public static String md5(String str,String salt){
		return new Md5Hash(str,salt).toHex();
	}
	
	public static void main(String[] args) {
		String password="123456";
		
		System.out.println("Md5加密："+CryptographyUtil.md5(password, SALT));
	}
}
