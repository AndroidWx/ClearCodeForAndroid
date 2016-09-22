package com.joye.basepresentation.internal.di.modules;

import android.app.Application;
import android.content.Context;

import com.joye.basedata.executor.JobExecutor;
import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.basepresentation.UiThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/21.
 * 304622254@qq.com
 * Remeark:
 *  Modules类里面的方法专门提供依赖，
 * 所以我们定义一个类，
 * 用@Module注解，
 * 这样Dagger在构造类的实例的时候，
 * 就知道从哪里去找到需要的依赖。
 * modules的一个重要特征是它们设计为分区并组合在一起
 * （比如说，在我们的app中可以有多个组成在一起的modules）
 */
@Module
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }
    @Provides @Singleton
    public Context provideApplicationContext(){
        return application;
    }
    @Provides @Singleton
    public  PostExecutionThread providePostExecutionThread(UiThread uiThread){
        return uiThread;
    }
    @Provides @Singleton
    public  ThreadExecutor provideThreadExecutor(JobExecutor executor){
        return executor;
    }



}
