package com.joye.hk6.internal.di.modules;

import android.app.Activity;

import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.basepresentation.internal.di.modules.ActivityModule;
import com.joye.hk6.StatusBarHelp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Wx on 2016/9/26.
 * QQ:304622254;
 * remark:
 */
@Module
public class MainModule extends ActivityModule {
    public MainModule(Activity activity) {
        super(activity);
    }

    @Provides
    @PerActivity
    StatusBarHelp providerStatusBarHelp() {
        return new StatusBarHelp(activity);
    }
}

