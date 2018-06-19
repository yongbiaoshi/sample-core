package com.my.sample.core.config.webclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@Configuration
@EnableConfigurationProperties({BaiduClientProperties.class, CarBasicProperties.class})
public class WebClientConfig {


    @Bean(name = "baiduWebClient")
    public WebClient baiduWebClient(BaiduClientProperties properties) {
        return WebClient.builder()
                .baseUrl(properties.getBaseUrl()) // 基础Url
                .defaultHeaders(httpHeaders -> {
                    // 设置默认请求头
                    Map<String, String> headers = properties.getHeaders();
                    for (Map.Entry<String, String> head : headers.entrySet()) {
                        httpHeaders.add(head.getKey(), head.getValue());
                    }
                })
                .defaultUriVariables(properties.getUriVariables()) // 添加默认请求参数
                .filter(commonExchangeFilterFunction())
                .build();
    }

    @Bean(name = "carBasicWebClient")
    public WebClient carBasicWebClient(CarBasicProperties properties) {
        return WebClient.builder()
                .baseUrl(properties.getBaseUrl()) // 基础Url
                .defaultHeaders(httpHeaders -> {
                    // 设置默认请求头
                    Map<String, String> headers = properties.getHeaders();
                    for (Map.Entry<String, String> head : headers.entrySet()) {
                        httpHeaders.add(head.getKey(), head.getValue());
                    }
                })
                .filter(commonExchangeFilterFunction())
                .build();
    }

    @Bean
    public ExchangeFilterFunction commonExchangeFilterFunction() {
        return new CommonExchangeFilterFunction();
    }

    private void log(Logger logger, ClientRequest request) {
        logger.info("发起请求，Url:{}，Headers:{}，Method:{}", request.url(), request.headers(), request.method());
    }

    public class CommonExchangeFilterFunction implements ExchangeFilterFunction {
        Logger logger = LoggerFactory.getLogger(CommonExchangeFilterFunction.class);
        @Override
        public Mono<ClientResponse> filter(ClientRequest request, ExchangeFunction next) {
            // 记录请求日志
            log(logger, request);
            return next.exchange(request);
        }
    }
}
