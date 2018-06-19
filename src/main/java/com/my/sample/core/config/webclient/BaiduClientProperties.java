package com.my.sample.core.config.webclient;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "client.baidu.query")
public class BaiduClientProperties {

    private String baseUrl;
    private Map<String, String> headers;
    private Map<String, String> uriVariables;
    private String keywordQueryUrl;

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

    public Map<String, String> getUriVariables() {
        return uriVariables;
    }

    public void setUriVariables(Map<String, String> uriVariables) {
        this.uriVariables = uriVariables;
    }

    public String getKeywordQueryUrl() {
        return keywordQueryUrl;
    }

    public void setKeywordQueryUrl(String keywordQueryUrl) {
        this.keywordQueryUrl = keywordQueryUrl;
    }
}
