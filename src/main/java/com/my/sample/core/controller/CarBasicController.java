package com.my.sample.core.controller;

import com.my.sample.core.entity.vo.CarBasicInfoVo;
import com.my.sample.core.service.CarBasicService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 查询车辆信息
 *
 * @author shiyongbiao
 */
@RestController
@RequestMapping("cars")
public class CarBasicController {

    @Resource
    private CarBasicService carBasicService;

    /**
     * 根据Id查询车辆
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public CarBasicInfoVo carBasicInfoVo(@PathVariable Integer id) {
        CarBasicInfoVo vo = new CarBasicInfoVo();
        BeanUtils.copyProperties(carBasicService.queryById(id), vo);
        return vo;
    }

}
