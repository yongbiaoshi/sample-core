package com.my.sample.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * 用于WebClient记录日志
 *
 * @author shiyongbiao
 */
public class WebClientLogUtils {
    private static Logger log = LoggerFactory.getLogger(WebClientLogUtils.class);
    private static final String ERROR_MSG = "WebClient请求出错，请求参数：%s，错误信息：%s";
    private static final String MSG = "WebClient请求成功，请求参数：%s，返回结果：%s";

    private static <T> Mono<T> errorStatusCodeHandler(ClientResponse response) {
        String errorMsg = "WebClient请求返回状态=" + response.statusCode() + "-" + response.statusCode().getReasonPhrase();
        return Mono.error(new RuntimeException(errorMsg));
    }

    /**
     * webClient响应统一处理
     *
     * @param requestParams 请求参数，用于记录日志
     * @param responseSpec  响应
     * @param typeReference 类型引用
     * @param <T>           转换类型
     * @return 响应数据
     */
    public static <T> Mono<T> responseHandle(String requestParams, WebClient.ResponseSpec responseSpec, ParameterizedTypeReference<T> typeReference) {
        return responseSpec
                // 处理返回错误状态码
                .onStatus(HttpStatus::isError, WebClientLogUtils::errorStatusCodeHandler).bodyToMono(typeReference)
                // 当调用出错时，记录日志
                .doOnError(ex -> log.error(String.format(ERROR_MSG, requestParams, ex.getMessage()), ex))
                .doOnSuccess(t -> log.debug(String.format(MSG, requestParams, Objects.toString(t, "null"))));
    }

    /**
     * webClient响应统一处理
     *
     * @param requestParams 请求参数，用于记录日志
     * @param responseSpec  响应
     * @param type          类型
     * @param <T>           转换类型
     * @return 响应数据
     */
    public static <T> Mono<T> responseHandle(String requestParams, WebClient.ResponseSpec responseSpec, Class<T> type) {
        return responseSpec
                // 处理返回错误状态码
                .onStatus(HttpStatus::isError, WebClientLogUtils::errorStatusCodeHandler)
                .bodyToMono(type)
                // 当调用出错时，记录日志
                .doOnError(ex -> log.error(String.format(ERROR_MSG, requestParams, ex.getMessage()), ex))
                .doOnSuccess(t -> log.debug(String.format(MSG, requestParams, Objects.toString(t, "null"))));
    }
}
