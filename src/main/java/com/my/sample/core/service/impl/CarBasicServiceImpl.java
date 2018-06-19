package com.my.sample.core.service.impl;

import com.my.sample.core.config.webclient.CarBasicProperties;
import com.my.sample.core.entity.dto.CarBasicInfoDto;
import com.my.sample.core.entity.dto.CarBasicResultDto;
import com.my.sample.core.service.CarBasicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Slf4j
@Service
public class CarBasicServiceImpl implements CarBasicService {

    @Resource
    private CarBasicProperties properties;

    @Resource
    private WebClient carBasicWebClient;

    @Override
    public CarBasicInfoDto queryById(int id) {
        // 创建TypeReference用于Json转换
        ParameterizedTypeReference<CarBasicResultDto<CarBasicInfoDto>> typeReference = new ParameterizedTypeReference<CarBasicResultDto<CarBasicInfoDto>>() {
        };
        WebClient.ResponseSpec responseSpec = carBasicWebClient.get().uri(properties.getQueryUrl(), id).retrieve();
        // 处理异常情况
        Mono<CarBasicResultDto<CarBasicInfoDto>> mono = responseSpec.onStatus(HttpStatus::isError, this::errorStatusCodeHandler).bodyToMono(typeReference).doOnError(this::errorHandler);
        // 接收返回值
        CarBasicResultDto<CarBasicInfoDto> result = mono.block();
        checkResult(result); // 检查返回是否成功
        return result.getData();
    }

    private <T> Mono<T> errorStatusCodeHandler(ClientResponse response) {
        String errorMsg = "请求返回：" + response.statusCode() + " - " + response.statusCode().getReasonPhrase();
        return Mono.error(new RuntimeException(errorMsg));
    }

    private void errorHandler(Throwable ex) {
        String errorMsg = "请求CarBasicService出错，message：%s";
        log.error(String.format(errorMsg, ex.getMessage()), ex);
    }

    private <T> void checkResult(CarBasicResultDto<T> result) {
        if (!"success".equals(result.getResult())) {
            String errorMsg = "请求CarBasicService出错，result：%s，errorCode：%s，message：%s";
            throw new RuntimeException(String.format(errorMsg, result.getResult(), result.getErrorCode(), result.getMessage()));
        }
    }

}
