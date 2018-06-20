package com.my.sample.core.service;

import com.my.sample.core.entity.dto.CarBasicInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

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

    /**
     * 分页查询车辆信息
     *
     * @param pageable 分页信息
     * @return 车辆基础信息集合
     */
    List<CarBasicInfoDto> page(Pageable pageable);
}
