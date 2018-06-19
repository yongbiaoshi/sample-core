package com.my.sample.core.service;

import com.my.sample.core.entity.dto.CarBasicInfoDto;

/**
 * 车辆基础信息查询服务
 *
 * @author shiyongbiao
 */
public interface CarBasicService {

    /**
     * 根据车辆Id查询车辆基础信息
     *
     * @param id 车辆Id
     * @return 车辆基础信息
     */
    CarBasicInfoDto queryById(int id);
}
