package com.joye.hk6.internal.di.modules;

import android.app.Activity;
import android.content.Context;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.ac.BaseAppCompatActivity;
import com.joye.hk6.util.WriteDataToFileCacheDelegate;
import com.joye.hk6data.cache.impl.Hk6Cache;
import com.joye.hk6domain.repository.Hk6Repository;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by W,x (JoyeWang)
 * on 2016/11/5.
 * 304622254@qq.com
 * Remeark:
 */
@Module
public class WriteDataToFileCacheModule {
    public WriteDataToFileCacheModule(){
    }

    @Provides
    @PerActivity
    WriteDataToFileCacheDelegate privodeWriteDataToFileCacheDelegate(Hk6Cache hk6Cache,ThreadExecutor threadExecutor,
                                                                     Context context ){
        return  new WriteDataToFileCacheDelegate(hk6Cache,context,threadExecutor);
    }
}
