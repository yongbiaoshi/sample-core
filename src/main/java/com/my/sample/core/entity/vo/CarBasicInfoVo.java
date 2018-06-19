package com.my.sample.core.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * Car基础信息Vo
 *
 * @author shiyongbiao
 */
@Data
public class CarBasicInfoVo {

    private int id;
    private String brand;
    private String model;
    private String license;
    private Date lastUpdateTime;
    private Date createTime;
}
