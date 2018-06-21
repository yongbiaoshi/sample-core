package com.my.sample.core.service.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.sample.core.config.client.CarBasicClientProperties;
import com.my.sample.core.entity.dto.CarBasicInfoDto;
import com.my.sample.core.entity.dto.CarBasicResultDto;
import com.my.sample.core.service.CarBasicService;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Primary
@Service
public class CarBasicServiceRestTemplateImpl implements CarBasicService {

    @Resource
    private CarBasicClientProperties properties;

    @Resource
    private RestTemplate carBasicRestTemplate;

    @Resource
    private ObjectMapper objectMapper;

    @SuppressWarnings("unchecked")
    @Override
    public CarBasicInfoDto queryById(int id) throws IOException {
        JavaType type = objectMapper.getTypeFactory().constructParametricType(CarBasicResultDto.class, CarBasicInfoDto.class);
        String result = carBasicRestTemplate
                .getForObject(properties.getBaseUrl() + properties.getQueryUrl(), String.class, id);
        CarBasicResultDto<CarBasicInfoDto> info = objectMapper.readValue(result, type);
        return info.getData();
    }

    @Override
    public List<CarBasicInfoDto> page(Pageable pageable) {
        return null;
    }
}
