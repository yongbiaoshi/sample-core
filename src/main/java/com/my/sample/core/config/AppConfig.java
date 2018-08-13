package com.my.sample.core.config;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@MapperScan(basePackages = {"com.my.sample.core.dao.mapper"})  // mybatis自动描包
@EnableSwagger2Doc // 开启Swagger2，自动生成文档，Url：/swagger-ui.html
@EnableConfigurationProperties(AppProperties.class)
@EnableAsync
@EnableFeignClients(basePackages = {"com.my.sample.core.service"})
public class AppConfig {

}
