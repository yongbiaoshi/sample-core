package com.my.sample.core;

import com.my.sample.core.util.WebClientLogUtils;
import com.mysql.jdbc.log.Slf4JLogger;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.Loggers;

import java.time.Duration;

public class WebClientTest {
    static Logger log = LoggerFactory.getLogger(WebClientTest.class);

    static {
        Loggers.useSl4jLoggers();
    }

    @Test
    public void timeoutTest() {
        int l = 1;
        WebClient client = WebClient.builder().baseUrl("http://localhost:8081").build();
        WebClient.ResponseSpec responseSpec = client.get().uri("/sleep?l={l}", l).retrieve();
        Mono<String> mono = WebClientLogUtils.responseHandle("l=" + l, responseSpec, String.class);
        mono = mono.onErrorReturn("测试fallback返回");
        String r = null;
        try {
            r = mono.log(Loggers.getLogger(WebClientTest.class)).block(Duration.ofSeconds(5));
        } catch (Exception e) {
            log.error("请求出错", e);
        }
        System.out.println(r);
    }
}
