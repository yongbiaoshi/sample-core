package com.my.sample.core.config;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.SmartValidator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Configuration
@MapperScan(basePackages = {"com.my.sample.core.dao.mapper"})  // mybatis自动描包
@EnableSwagger2Doc // 开启Swagger2，自动生成文档，Url：/swagger-ui.html
public class AppConfig {

}
