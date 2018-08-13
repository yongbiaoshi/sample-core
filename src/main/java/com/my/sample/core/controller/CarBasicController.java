package com.my.sample.core.controller;

import com.my.sample.core.entity.dto.CarBasicInfoDto;
import com.my.sample.core.entity.vo.CarBasicInfoVo;
import com.my.sample.core.service.CarBasicService;
import com.my.sample.core.service.CarManageService;
import com.my.sample.core.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * 查询车辆信息
 *
 * @author shiyongbiao
 */
@Slf4j
@RestController
@RequestMapping("cars")
public class CarBasicController {

    @Resource
    CarManageService carManageService;
    @Resource
    private CarBasicService carBasicService;

    @Resource
    private CarService carService;

    /**
     * 根据Id查询车辆
     *
     * @param id 车辆ID
     * @return
     */
    @GetMapping("/{id}")
    public CarBasicInfoVo queryById(@PathVariable Integer id) throws IOException {
        CarBasicInfoVo vo = new CarBasicInfoVo();
        BeanUtils.copyProperties(carBasicService.queryById(id), vo);
        return vo;
    }

    /**
     * 根据Id查询车辆
     *
     * @param id 车辆ID
     * @return
     */
    @GetMapping("/f/{id}")
    public CarBasicInfoVo carBasicInfoVo(@PathVariable Integer id) throws IOException {
        CarBasicInfoVo vo = new CarBasicInfoVo();
        BeanUtils.copyProperties(carManageService.queryById(id).getData(), vo);
        return vo;
    }

    /**
     * 查询车辆基础信息
     *
     * @return
     */
    @GetMapping("")
    public List<CarBasicInfoDto> page(Pageable pageable) {
        log.info("分页参数：{}", pageable);
        return carBasicService.page(pageable);
    }


    @GetMapping("test")
    public String test(){
        return carService.index();
    }
}
