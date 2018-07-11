package com.my.sample.core.service.impl;

import com.my.sample.core.service.LogTestService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.event.Level;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LogTestServiceImpl implements LogTestService {

    @Override
    public void debug(String message) {
        log.debug("Service中的{}级别日志, message: {}", Level.DEBUG, message);
    }

    @Override
    public void info(String message) {
        log.info("Service中的{}级别日志, message: {}", Level.INFO, message);
    }

    @Override
    public void error(String message, Throwable throwable) {
        log.error(String.format("Service中的%s级别日志, message: %s", Level.ERROR, message), throwable);
    }

    @Override
    public void asyncDebug(String message) {
        log.debug("Service中的{}级别日志, message: {}", Level.DEBUG, message);
    }
}
