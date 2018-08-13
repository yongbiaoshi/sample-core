package com.my.sample.core.config.filter;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 记录Request日志
 * 日志内容在{@link WebFilter 注解中配置}
 *
 * @author shiyongbiao
 */
@WebFilter(urlPatterns = "/*", initParams = {
        @WebInitParam(name = "includeQueryString", value = "true"),
        @WebInitParam(name = "includeClientInfo", value = "true"),
        @WebInitParam(name = "includeHeaders", value = "true"),
        @WebInitParam(name = "includePayload", value = "true"),
        @WebInitParam(name = "maxPayloadLength", value = "1024")})
public class RequestLoggingFilter extends CommonsRequestLoggingFilter {

    @Override
    protected void initFilterBean() throws ServletException {
        super.initFilterBean();
        FilterConfig filterConfig = getFilterConfig();
        if (filterConfig != null) {
            this.setIncludeQueryString(Boolean.valueOf(filterConfig.getInitParameter("includeQueryString")));
            this.setIncludeClientInfo(Boolean.valueOf(filterConfig.getInitParameter("includeClientInfo")));
            this.setIncludeHeaders(Boolean.valueOf(filterConfig.getInitParameter("includeHeaders")));
            this.setIncludePayload(Boolean.valueOf(filterConfig.getInitParameter("includePayload")));
            String maxPayloadLength = filterConfig.getInitParameter("maxPayloadLength");
            if (maxPayloadLength != null) {
                this.setMaxPayloadLength(Integer.valueOf(filterConfig.getInitParameter("maxPayloadLength")));
            }
        }
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        MDC.clear();
        request.setAttribute("request_start_time", System.currentTimeMillis());
        MDC.put("uri", request.getRequestURI());
        MDC.put("localAddr", request.getLocalAddr());
        MDC.put("reqSeq", RandomStringUtils.randomAlphabetic(10));
        String requestId = request.getHeader("x-request-id");
        if (!StringUtils.isEmpty(requestId)) {
            MDC.put("requestId", requestId);
        }
        request.setAttribute("timestamp", System.currentTimeMillis());
        super.beforeRequest(request, message);
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        Long start = Long.valueOf(Objects.toString(request.getAttribute("request_start_time"), "0"));
        MDC.put("duration", (System.currentTimeMillis() - start) + "ms");
        super.afterRequest(request, message);
    }
}
