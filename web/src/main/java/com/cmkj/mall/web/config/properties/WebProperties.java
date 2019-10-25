package com.cmkj.mall.web.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author swallowff
 * @create 2019/10/14
 */
@Configuration
@PropertySource(value = "classpath:web.properties",encoding = "UTF-8",ignoreResourceNotFound = false)
@ConfigurationProperties(prefix = "web")
public class WebProperties {
    //是否开启swagger,生产环境关闭
    private Boolean swaggerOpen = false;
    private String fileUploadPath;
    private Integer enableApiVersion;

    public String getFileUploadPath() {
        return fileUploadPath;
    }

    public void setFileUploadPath(String fileUploadPath) {
        this.fileUploadPath = fileUploadPath;
    }

    public Boolean getSwaggerOpen() {
        return swaggerOpen;
    }

    public void setSwaggerOpen(Boolean swaggerOpen) {
        this.swaggerOpen = swaggerOpen;
    }

    public Integer getEnableApiVersion() {
        return enableApiVersion;
    }

    public void setEnableApiVersion(Integer enableApiVersion) {
        this.enableApiVersion = enableApiVersion;
    }
}
