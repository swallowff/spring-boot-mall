package com.cmkj.mall.common.annotation;

import java.lang.annotation.*;

/**
 * 用于在controller类标注接口版本
 * @author swallowff
 * @create 2019/10/11
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiVersion {
    int value();

}