package com.my.sample.core.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Locale;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastUpdateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
