package com.joye.hk6.internal.di.component;

import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.view.ScrollingActivity;

import dagger.Component;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/23.
 * 304622254@qq.com
 * Remeark:
 */
@PerActivity
@Component(dependencies = Hk6ApplicationComponent.class,modules = {StatusbarActivityModule.class, Hk6Module.class})
public interface Hk6Component extends StatusbarActivityComponent{
    void inject(ScrollingActivity activity);
}
