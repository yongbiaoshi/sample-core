package com.my.sample.core.config.exception;

public class AppException extends RuntimeException {

    public static final String DEFAULT_ERROR_CODE = "SYSTEM_ERROR";
    public static final String DEFAULT_ERROR_MSG = "系统错误";
    private static final long serialVersionUID = -2285739833204427158L;
    private String errorCode;

    public AppException(String errorCode, String message) {
        super(message, null);
        this.errorCode = errorCode;
    }

    public AppException(String errorCode, String message, Throwable t) {
        super(message, t);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
