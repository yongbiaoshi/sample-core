package com.my.sample.core.config.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 统一ResponseBody返回值
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseResult {
    private String result;
    private String errorCode;
    private String message;
    private Object data;

    public ResponseResult(String result, Object data) {
        this.result = result;
        this.data = data;
    }
}
