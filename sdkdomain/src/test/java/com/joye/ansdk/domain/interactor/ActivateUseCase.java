package com.joye.ansdk.domain.interactor;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.basedomain.interactor.UseCase;

import rx.Observable;

/**
 * Created by joye on 2017/1/17.
 * sdk 激活
 *
 */

public class ActivateUseCase extends UseCase {
    protected ActivateUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return null;
    }
}
