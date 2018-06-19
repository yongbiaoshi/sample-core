package com.my.sample.core.entity.dto;

import lombok.Data;

import java.util.Date;

/**
 * Car基础信息传输对象
 *
 * @author shiyongbiao
 */
@Data
public class CarBasicInfoDto {

    private int id;
    private String brand;
    private String model;
    private String license;
    private Date lastUpdateTime;
    private Date createTime;
}
