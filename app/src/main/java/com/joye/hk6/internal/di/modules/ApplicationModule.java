package com.joye.hk6.internal.di.modules;

import android.app.Application;

import com.joye.hk6data.repository.Hk6DataRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiang on 16/9/21.
 */
@Module
public class ApplicationModule extends com.joye.basepresentation.internal.di.modules.ApplicationModule{
    public ApplicationModule(Application application) {
        super(application);
    }
    @Provides
    @Singleton
    Hk6DataRepository  provideHk6DataRepository(Hk6DataRepository hk6DataRepository){
        return hk6DataRepository;
    }
}
