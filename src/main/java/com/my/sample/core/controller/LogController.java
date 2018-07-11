package com.my.sample.core.controller;

import com.my.sample.core.service.LogTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("log")
@Slf4j
public class LogController {

    @Resource
    LogTestService logTestService;

    @GetMapping("debug")
    public String logDebug() {
        log.debug("这是一个Debug级别的日志{\"\"}");
        logTestService.debug("测试日志");
        logTestService.asyncDebug("异步日志测试");
        return "success";
    }
}
