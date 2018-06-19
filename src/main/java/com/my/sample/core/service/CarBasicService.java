package com.my.sample.core.service;

import com.my.sample.core.entity.dto.CarBasicInfoDto;

/**
 * 车辆基础信息查询服务
 *
 * @author shiyongbiao
 */
public interface CarBasicService {

    CarBasicInfoDto queryById(int id);
}
