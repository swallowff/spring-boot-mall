package com.cmkj.mall.member.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cmkj.mall.member.dto.UmsMemberModel;
import com.cmkj.mall.member.util.PageData;
@Mapper
public interface UmsMemberLoginDao {

	PageData getUserInfo(PageData pd);

	@Select("SELECT COUNT(id) FROM ums_member WHERE user_id = #{userId}")
	int isUserId(long userId);

	@Select("SELECT COUNT(id) FROM ums_member WHERE phone = #{phone}")
	int isHavePhone(String phone);

	PageData getReferralInfo(long referralId);
	
	void insertMember(UmsMemberModel member);

	@Insert("INSERT ums_member_statistics_info(member_id)VALUES(#{memberId})")
	void insertMemberStatisce(long memberId);

	@Insert("INSERT user_finance(member_id)VALUES(#{memberId})")
	void insertUserFinance(long memberId);

	@Update("UPDATE ums_member SET `password` = ${password} WHERE phone = #{phone}")
	void updeteLonginPassword(@Param("phone") String phone, @Param("password") String password);

	@Update("UPDATE ums_member SET password_pay = ${password} WHERE phone = #{phone}")
	void updetePayPassword(@Param("phone") String phone, @Param("password") String password);
}
