package com.cmkj.mall.web.aop;

import com.cmkj.mall.common.util.SpringContextHolder;
import com.cmkj.mall.web.config.properties.WebProperties;
import org.apache.http.client.utils.URLEncodedUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shenyu
 * @create 2019/10/9
 */
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {

    private static final WebProperties webProperties = SpringContextHolder.getBean(WebProperties.class);

    private static final Pattern VERSION_PREFIX_PATTERN = Pattern.compile("v(\\d+)/");
    private static final Pattern SWAGGER_VERSION_PREFIX_PATTERN = Pattern.compile("%7Bversion%7D/");

    private int apiVersion;

    public ApiVersionCondition(int apiVersion){
        this.apiVersion = apiVersion;
    }

    @Override
    public ApiVersionCondition combine(ApiVersionCondition apiVersionCondition) {
        return new ApiVersionCondition(apiVersionCondition.getApiVersion());
    }

    @Override
    public int compareTo(ApiVersionCondition apiVersionCondition, HttpServletRequest httpServletRequest) {
        return apiVersionCondition.getApiVersion() - this.apiVersion;
    }

    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest httpServletRequest) {
        Matcher m = VERSION_PREFIX_PATTERN.matcher(httpServletRequest.getRequestURI());
        if (m.find()){
            Integer version = Integer.valueOf(m.group(1));
            if (version >= this.apiVersion){
                return this;
            }
        }
        //解决swagger接口文档因占位符无法匹配的问题
        if (webProperties.getSwaggerOpen() && webProperties.getEnableApiVersion() != null && webProperties.getEnableApiVersion() > 0){
            Matcher m2 = SWAGGER_VERSION_PREFIX_PATTERN.matcher(httpServletRequest.getRequestURI());
            if (m2.find()){
                Integer version = webProperties.getEnableApiVersion();
                if (version >= this.apiVersion){
                    return this;
                }
            }
        }
        return null;
    }
    public int getApiVersion() {
        return apiVersion;
    }

}
