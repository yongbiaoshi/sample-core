package com.my.sample.core.config;

import com.my.sample.core.config.exception.BasicErrorAttributes;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ServletComponentScan(basePackages = {"${app.base-package}.config"})
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public ErrorAttributes errorAttributes() {
        return new BasicErrorAttributes();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 默认添加”/“路径，直接返回200，一般用于服务状态监控
        registry.addStatusController("/", HttpStatus.OK);
    }
}
