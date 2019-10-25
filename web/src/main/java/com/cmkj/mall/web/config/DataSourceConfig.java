package com.cmkj.mall.web.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ObjectUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * MyBatis配置类
 * Created by cmkj on 2019/4/8.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.cmkj.mall.*.mapper","com.cmkj.mall.*.dao","com.cmkj.mall.dao","com.cmkj.mall.mapper"})
public class DataSourceConfig {
    private Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);
    private static final ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();

    @Value("${mybatis.mapper-locations}")
    private String[] mapperLocation;

    @Value("${mybatis.type-aliases-package}")
    private String typeAliasesPackage;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.druid.initial-size}")
    private int initialSize;

    @Value("${spring.datasource.druid.min-idle}")
    private int minIdle;

    @Value("${spring.datasource.druid.max-active}")
    private int maxActive;

    @Value("${spring.datasource.druid.max-wait}")
    private long maxWait;

    @Value("${spring.datasource.druid.driver-class-name}")
    private String driverClassName;

//    @Value("${spring.datasource.druid.min-evictable-idle-time-millis}")
//    private long minEvictableIdleTimeMillis;

//    @Value("${spring.datasource.druid.time-between-eviction-runs-millis}")
//    private long timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.druid.validation-query}")
    private String validationQuery;

    @Value("${spring.datasource.druid.test-while-idle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.druid.test-on-borrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.druid.test-on-return}")
    private boolean testOnReturn;

    @Value("${spring.datasource.druid.filter.stat.log-slow-sql}")
    private boolean logSlowSql;

    @Value("${spring.datasource.druid.filter.stat.slow-sql-millis}")
    private long slowSqlMillis;

    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        try {
            druidDataSource.setUsername(username);
            druidDataSource.setPassword(password);
            druidDataSource.setUrl(dbUrl);
            druidDataSource.setFilters("stat,wall");
            druidDataSource.setInitialSize(initialSize);
            druidDataSource.setMinIdle(minIdle);
            druidDataSource.setMaxActive(maxActive);
            druidDataSource.setMaxWait(maxWait);
//            druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//            druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
            druidDataSource.setUseGlobalDataSourceStat(true);
            druidDataSource.setDriverClassName(driverClassName);
            druidDataSource.setValidationQuery(validationQuery);
            druidDataSource.setTestWhileIdle(testWhileIdle);
            druidDataSource.setTestOnBorrow(testOnBorrow);
            druidDataSource.setTestOnReturn(testOnReturn);
            // 设置需要的过滤
            List<Filter> statFilters =new ArrayList<>();
            StatFilter statFilter = new StatFilter();
            statFilter.setLogSlowSql(logSlowSql);
            statFilter.setSlowSqlMillis(slowSqlMillis);
            statFilters.add(statFilter);
            // 设置慢SQL
            druidDataSource.setProxyFilters(statFilters);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactoryBean mysqlSessionFactory(DataSource dataSource) throws Exception {
        PackagesSqlSessionFactoryBean sqlSessionFactoryBean = new PackagesSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        if (!ObjectUtils.isEmpty(resolveMapperLocations())) {
            sqlSessionFactoryBean.setMapperLocations(resolveMapperLocations());
        }
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        return sqlSessionFactoryBean;
    }

    public Resource[] resolveMapperLocations() {
        return (Resource[])Stream.of((String[])Optional.ofNullable(this.mapperLocation).orElse(new String[0])).flatMap((location) -> {
            return Stream.of(this.getResources(location));
        }).toArray((len) -> {
            return new Resource[len];
        });
    }

    private Resource[] getResources(String location) {
        try {
            return resourceResolver.getResources(location);
        } catch (IOException var3) {
            return new Resource[0];
        }
    }

}
