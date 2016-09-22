package com.joye.hk6.internal.di.modules;

import android.app.Application;

import com.joye.basepresentation.internal.di.modules.ApplicationModule;
import com.joye.hk6data.cache.impl.Hk6Cache;
import com.joye.hk6data.cache.impl.Hk6FileCacheImpl;
import com.joye.hk6data.repository.Hk6DataRepository;
import com.joye.hk6domain.repository.Hk6Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiang on 16/9/21.
 */
@Module
public class Hk6ApplicationModule extends ApplicationModule {
    public Hk6ApplicationModule(Application application) {
        super(application);
    }

    @Provides @Singleton
    public Hk6Cache provideHk6Cache(Hk6FileCacheImpl hk6FileCache){
        return hk6FileCache;
    }
    @Provides @Singleton
    public Hk6Repository provideHk6DataRepository(Hk6DataRepository hk6DataRepository){
        return hk6DataRepository;
    }
}
