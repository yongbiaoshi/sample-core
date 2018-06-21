package com.my.sample.core.service.impl;

import com.my.sample.core.config.client.CarBasicClientProperties;
import com.my.sample.core.entity.dto.CarBasicInfoDto;
import com.my.sample.core.entity.dto.CarBasicResultDto;
import com.my.sample.core.service.CarBasicService;
import com.my.sample.core.util.WebClientLogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.List;

@Slf4j
@Service
public class CarBasicServiceWebClientImpl implements CarBasicService {

    @Resource
    private CarBasicClientProperties properties;

    @Resource
    private WebClient carBasicWebClient;

    @Override
    public CarBasicInfoDto queryById(int id) {
        // 创建TypeReference用于Json转换
        ParameterizedTypeReference<CarBasicResultDto<CarBasicInfoDto>> typeReference = new ParameterizedTypeReference<CarBasicResultDto<CarBasicInfoDto>>() {
        };
        WebClient.ResponseSpec responseSpec = carBasicWebClient.get().uri(properties.getQueryUrl(), id).retrieve();
        // 统一处理返回值
        Mono<CarBasicResultDto<CarBasicInfoDto>> mono = WebClientLogUtils.responseHandle("id=" + id, responseSpec, typeReference);
        // 接收返回值，如果有错误会在这方法上抛出异常
        CarBasicResultDto<CarBasicInfoDto> result = mono.block();
        checkResult(result); // 检查返回是否成功
        return result.getData();
    }

    @Override
    public List<CarBasicInfoDto> page(Pageable pageable) {

        // 创建TypeReference用于Json转换
        ParameterizedTypeReference<CarBasicResultDto<List<CarBasicInfoDto>>> typeReference = new ParameterizedTypeReference<CarBasicResultDto<List<CarBasicInfoDto>>>() {
        };
        WebClient.ResponseSpec responseSpec = carBasicWebClient.get().uri(properties.getQueryPageUrl(), pageable.getPageNumber(), pageable.getPageSize()).retrieve();
        // 统一处理返回值
        Mono<CarBasicResultDto<List<CarBasicInfoDto>>> mono = WebClientLogUtils.responseHandle("分页=" + pageable, responseSpec, typeReference);
        // 接收返回值，如果有错误会在这方法上抛出异常
        CarBasicResultDto<List<CarBasicInfoDto>> result = mono.block(Duration.ofSeconds(10)); //设置超时时间10s
        checkResult(result); // 检查返回是否成功
        return result.getData();
    }

    private <T> void checkResult(CarBasicResultDto<T> result) {
        if (result == null) {
            throw new RuntimeException(String.format("请求CarBasicService出错，无返回值"));
        }
        if (!"success".equals(result.getResult())) {
            String errorMsg = "请求CarBasicService出错，result：%s，errorCode：%s，message：%s";
            throw new RuntimeException(String.format(errorMsg, result.getResult(), result.getErrorCode(), result.getMessage()));
        }
    }

}
