package com.my.sample.core.config.handler;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 统一Json返回格式
 * Controller方法返回的所有ResponseBody的值，包装成统一格式{@link ResponseResult}
 *
 * @author shiyongbiao
 */
public class ResponseBodyWrapHandler implements HandlerMethodReturnValueHandler {

    private final HandlerMethodReturnValueHandler delegate;

    public ResponseBodyWrapHandler(HandlerMethodReturnValueHandler delegate) {
        this.delegate = delegate;
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return delegate.supportsReturnType(returnType);
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {
        ResponseResult rr;
        if (returnValue instanceof ResponseResult) {
            // 允许自己返回ResponseResult类型的结果，这种情况下，不做处理，直接返回
            rr = (ResponseResult) returnValue;
        } else {
            rr = new ResponseResult("success", returnValue);
        }
        delegate.handleReturnValue(rr, returnType, modelAndViewContainer, nativeWebRequest);
    }
}
