package com.joye.hk6.internal.di.component;

import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.view.ColorTwosActivity;

import dagger.Component;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/27.
 * 304622254@qq.com
 * Remeark:
 */
@PerActivity
@Component(dependencies = Hk6ApplicationComponent.class, modules = {Hk6Module.class, StatusbarActivityModule.class})
public interface ColorTwosComponent extends StatusbarActivityComponent{

    void inject(ColorTwosActivity sizeActivity);

}
