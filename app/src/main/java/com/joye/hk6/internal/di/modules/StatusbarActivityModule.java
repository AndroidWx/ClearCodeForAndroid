package com.joye.hk6.internal.di.modules;

import android.app.Activity;

import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.basepresentation.internal.di.modules.ActivityModule;
import com.joye.hk6.StatusBarHelp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/22.
 * 304622254@qq.com
 * Remeark:
 */
@Module
public class StatusbarActivityModule extends ActivityModule{
    public StatusbarActivityModule(Activity activity) {
        super(activity);
    }

    @Provides @PerActivity
    StatusBarHelp providerStatusBarHelp(){
        return new StatusBarHelp(activity);
    }

}
