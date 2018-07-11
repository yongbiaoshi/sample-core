package com.my.sample.core.service;

import org.springframework.scheduling.annotation.Async;

public interface LogTestService {

    void debug(String message);

    void info(String message);

    void error(String message, Throwable throwable);

    @Async
    void asyncDebug(String message);
}
