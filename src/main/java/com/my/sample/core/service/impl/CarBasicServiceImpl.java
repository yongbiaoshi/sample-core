package com.my.sample.core.service.impl;

import com.my.sample.core.config.webclient.CarBasicProperties;
import com.my.sample.core.entity.dto.CarBasicInfoDto;
import com.my.sample.core.service.CarBasicService;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.Resource;

public class CarBasicServiceImpl implements CarBasicService {

    @Resource
    CarBasicProperties properties;

    @Resource
    WebClient carBasicWebClient;

    @Override
    public CarBasicInfoDto queryById(int id) {
//        carBasicWebClient.get().uri()
        return null;
    }
}
