package com.my.sample.core.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BaiduResultVo implements Serializable {

    private static final long serialVersionUID = 5919803143089383124L;
    /**
     * 如果json字符串与实体类名不同，使用{@link JsonProperty 注解进行转换}
     */
    @JsonProperty("q")
    private String keyword;
    private String status;
    @JsonProperty(value = "s")
    private List<String> results;
}
