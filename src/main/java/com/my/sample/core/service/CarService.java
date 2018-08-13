package com.my.sample.core.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "car-service", url = "https://ground-carservice.mydadao.com")
public interface CarService {

    @GetMapping(value = "/")
    String index();
}
