package com.joye.hk6.mvp;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/23.
 * 304622254@qq.com
 * Remeark:
 */

public interface ProgressVu<T> extends Vu {
    /**
     * loading
     */
    void showLoading();

    /**
     * 空
     */
    void showEmpty();

    /**
     * 错误显示
     * @param e error
     */
    void showError(Throwable e);

    /**
     * 展示内容
     */
    void showContent();

    /**
     * 展示数据
     * @param t
     */
    void onNext(T t);
}
