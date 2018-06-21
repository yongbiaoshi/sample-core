package com.my.sample.core.config.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableConfigurationProperties({CarBasicClientProperties.class})
public class RestTemplateConfig {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public RestTemplate carBasicRestTemplate(RestTemplateBuilder builder, CarBasicClientProperties properties) {
        String username = "admin";
        String password = "123456";
        String token = "TOKEN";
        String headerValue = "987654321";
        builder.basicAuthorization(username, password).rootUri(properties.getBaseUrl()).additionalInterceptors((ClientHttpRequestInterceptor) (request, body, execution) -> {
            request.getHeaders().add(token, headerValue);
            return execution.execute(request, body);
        }, (request, body, execution) -> {
            // createMessage(request, null, null);
            System.out.println("request type : " + request);
            logger.info("request type : {}", request);
            return execution.execute(request, body);
        });
        RestTemplate template = builder.build();
        return template;
    }

    protected String createMessage(HttpServletRequest request, String prefix, String suffix) {
        StringBuilder msg = new StringBuilder();
        msg.append(prefix);
        msg.append("uri=").append(request.getRequestURI());

        String queryString = request.getQueryString();
        if (queryString != null) {
            msg.append('?').append(queryString);
        }

        msg.append(";headers=").append(new ServletServerHttpRequest(request).getHeaders());

        //        String payload = getMessagePayload(request);
        //        if (payload != null) {
        //            msg.append(";payload=").append(payload);
        //        }

        msg.append(suffix);
        return msg.toString();
    }
}
