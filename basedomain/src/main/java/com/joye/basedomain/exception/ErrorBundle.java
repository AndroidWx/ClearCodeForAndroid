package com.joye.basedomain.exception;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/8.
 * 304622254@qq.com
 * Remeark:��װһ���쳣
 */

public interface ErrorBundle {
    Exception getException();

    String getErrorMessage();
}
