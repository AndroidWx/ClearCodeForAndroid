package com.joye.basedomain.exception;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/8.
 * 304622254@qq.com
 * Remeark:用于管理默认错误包装异常。
 */

public class DefaultErrorBundle implements ErrorBundle {
    private final Exception exception;

    private static final String DEFAULT_ERROR_MSG = "Unknown error";

    public DefaultErrorBundle(Exception exception) {
        this.exception = exception;
    }

    @Override
    public Exception getException() {
        return exception;
    }

    @Override
    public String getErrorMessage() {
        return (exception==null)?DEFAULT_ERROR_MSG:exception.getMessage();
    }
}
