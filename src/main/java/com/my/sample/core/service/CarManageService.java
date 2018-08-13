package com.my.sample.core.service;

import com.my.sample.core.entity.dto.CarBasicInfoDto;
import com.my.sample.core.entity.dto.CarBasicResultDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "carManage", url = "${client.car.basic.base-url}")
public interface CarManageService {

    @RequestMapping(method = RequestMethod.GET, value = "${client.car.basic.query-url}")
    CarBasicResultDto<CarBasicInfoDto> queryById(@PathVariable("id") int id);
}
