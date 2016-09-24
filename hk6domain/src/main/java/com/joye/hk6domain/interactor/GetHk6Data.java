package com.joye.hk6domain.interactor;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.basedomain.interactor.UseCase;
import com.joye.hk6domain.repository.Hk6Repository;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/23.
 * 304622254@qq.com
 * Remeark:
 */

public class GetHk6Data extends UseCase {
    protected final Hk6Repository hk6Repository;
    protected final String date;
    @Inject
    public GetHk6Data(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, Hk6Repository hk6Repository, String date) {
        super(threadExecutor, postExecutionThread);
        this.hk6Repository = hk6Repository;
        this.date = date;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return hk6Repository.getHk6Data(date);
    }
}
