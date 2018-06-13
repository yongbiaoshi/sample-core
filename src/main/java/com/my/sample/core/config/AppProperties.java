package com.my.sample.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 应用基本配置
 * @author shiyongbiao
 */
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    // 基础包名
    private String basePackage;

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }
}
