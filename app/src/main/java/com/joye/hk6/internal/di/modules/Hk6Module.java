package com.joye.hk6.internal.di.modules;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6domain.interactor.GetChineseZodiacUseCase;
import com.joye.hk6domain.interactor.GetHk6Data;
import com.joye.hk6domain.repository.Hk6Repository;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/23.
 * 304622254@qq.com
 * Remeark:
 */
@Module
public class Hk6Module {
    private String date="2016-09-23";

    public Hk6Module(String date) {
        this.date = date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Provides @PerActivity @Named("GetHk6Data")
    UseCase provideGetHk6DataUseCase(ThreadExecutor threadExecutor,
                                     PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetHk6Data(threadExecutor,postExecutionThread,hk6Repository,date);
    }
    @Provides @PerActivity @Named("GetChineseZodiacUseCase")
    UseCase provideGetChineseZodiacUseCase(ThreadExecutor threadExecutor,
                                     PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetChineseZodiacUseCase(threadExecutor,postExecutionThread,hk6Repository,date);
    }



}
