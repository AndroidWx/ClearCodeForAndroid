package com.joye.hk6.internal.di.component;

import android.app.Activity;

import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.basepresentation.internal.di.components.ActivityComponent;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;


import dagger.Component;
import dagger.Module;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/22.
 * 304622254@qq.com
 * Remeark:
 */
@PerActivity
@Component(dependencies = Hk6ApplicationComponent.class,modules =StatusbarActivityModule.class )
public interface StatusbarActivityComponent{//} extends ActivityComponent {
    StatusBarHelp statusBarHelp();
}
