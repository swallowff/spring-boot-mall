package com.cmkj.mall.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created by cmkj on 2019/4/8.
 */
@Configuration
@MapperScan({"com.cmkj.mall.mapper","com.cmkj.mall.search.dao"})
public class MyBatisConfig {
}
