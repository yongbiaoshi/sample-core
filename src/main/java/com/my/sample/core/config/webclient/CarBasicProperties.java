package com.my.sample.core.config.webclient;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "client.car.basic")
public class CarBasicProperties {

    private String baseUrl;
    private Map<String, String> headers;
    private String queryUrl;
    private String queryListUrl;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getQueryUrl() {
        return queryUrl;
    }

    public void setQueryUrl(String queryUrl) {
        this.queryUrl = queryUrl;
    }

    public String getQueryListUrl() {
        return queryListUrl;
    }

    public void setQueryListUrl(String queryListUrl) {
        this.queryListUrl = queryListUrl;
    }
}
