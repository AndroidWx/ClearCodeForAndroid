package com.joye.basepresentation;

import com.joye.basedomain.executor.PostExecutionThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/21.
 * 304622254@qq.com
 * Remeark: 待注入的一个单列UI线程
 */
@Singleton
public class UiThread implements PostExecutionThread {
    @Inject
    public UiThread(){

    }
    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
