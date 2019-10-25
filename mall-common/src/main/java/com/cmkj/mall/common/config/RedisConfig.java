package com.cmkj.mall.common.config;

import com.cmkj.mall.common.config.properties.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author swallowff
 * @create 2019/10/14
 */
@Configuration
public class RedisConfig {
    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(factory);

        //设置序列化工具
        setSerializer(redisTemplate);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean
    public JedisPool jedisPool(JedisPoolConfig jedisPoolConfig){
        return new JedisPool(jedisPoolConfig,redisProperties.getHost(),redisProperties.getPort(),redisProperties.getTimeout(),redisProperties.getPassword(),redisProperties.getDatabase(),false);
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(redisProperties.getPoolMaxIdle());
        config.setMaxTotal(redisProperties.getPoolMaxTotal());
        config.setMaxWaitMillis(redisProperties.getMaxWaitMillis());
        config.setTestOnBorrow(redisProperties.isTestOnBorrow());
        config.setTestOnReturn(redisProperties.isTestOnReturn());
        return config;
    }

    private void setSerializer(RedisTemplate<String, Object> template) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        template.setValueSerializer(stringSerializer);
        template.setKeySerializer(stringSerializer);
        template.setHashKeySerializer(stringSerializer);
        template.setHashValueSerializer(stringSerializer);
    }



}
