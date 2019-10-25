package com.cmkj.mall.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmkj.mall.member.dao.UmsMemberPersonalDao;
import com.cmkj.mall.member.util.RedisUtil;

@Service
public class UmsMemberPersonalService {
	@Autowired
	private UmsMemberPersonalDao memberPersonalDao;
	
	@Autowired
	private RedisUtil redis;
	

}
