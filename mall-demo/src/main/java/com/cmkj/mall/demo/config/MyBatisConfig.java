package com.cmkj.mall.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created by cmkj on 2019/4/8.
 */
@Configuration
@MapperScan("com.cmkj.mall.mapper")
public class MyBatisConfig {
}
