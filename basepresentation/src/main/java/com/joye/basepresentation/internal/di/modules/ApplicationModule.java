package com.joye.basepresentation.internal.di.modules;

import android.app.Application;
import android.content.Context;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basepresentation.UiThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/21.
 * 304622254@qq.com
 * Remeark:
 */
@Module
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }
    @Provides @Singleton
    Context provideApplicationContext(){
        return application;
    }
    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UiThread uiThread){
        return uiThread;
    }



}
