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
@EnableConfigurationProperties({CarBasicProperties.class})
public class WebClientConfig {

    @Bean(name = "carBasicWebClient")
    public WebClient carBasicWebClient(CarBasicProperties properties) {
        return WebClient.builder().baseUrl(properties.getBaseUrl()) // 基础Url
                .defaultHeaders(httpHeaders -> {
                    // 设置默认请求头
                    Map<String, String> headers = properties.getHeaders();
                    for (Map.Entry<String, String> head : headers.entrySet()) {
                        httpHeaders.add(head.getKey(), head.getValue());
                    }
                }).filter(loggingExchangeFilterFunction()).build();
    }

    @Bean
    public ExchangeFilterFunction loggingExchangeFilterFunction() {
        return new LoggingExchangeFilterFunction();
    }

    /**
     * 记录请求参数信息
     *
     * @param logger  日志对象
     * @param request 请求
     */
    private void log(Logger logger, ClientRequest request) {
        logger.debug("WebClient发起请求，Url:{}，Headers:{}，Method:{}", request.url(), request.headers(), request.method());
    }

    public class LoggingExchangeFilterFunction implements ExchangeFilterFunction {
        Logger logger = LoggerFactory.getLogger(LoggingExchangeFilterFunction.class);

        @Override
        public Mono<ClientResponse> filter(ClientRequest request, ExchangeFunction next) {
            // 记录请求日志
            log(logger, request);
            return next.exchange(request);
        }
    }
}
