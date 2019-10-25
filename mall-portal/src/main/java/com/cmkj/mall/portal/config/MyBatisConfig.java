package com.cmkj.mall.portal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 * Created by cmkj on 2019/4/8.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.cmkj.mall.mapper","com.cmkj.mall.portal.dao"})
public class MyBatisConfig {
}
