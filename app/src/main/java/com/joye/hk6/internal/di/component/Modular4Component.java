package com.joye.hk6.internal.di.component;

import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.view.Modular4Activity;

import dagger.Component;

/**
 * Created by W,x (JoyeWang)
 * on 2016/10/8.
 * 304622254@qq.com
 * Remeark:
 */
@PerActivity
@Component(dependencies = Hk6ApplicationComponent.class, modules = {Hk6Module.class, StatusbarActivityModule.class})
public interface Modular4Component extends StatusbarActivityComponent{

    void inject(Modular4Activity sizeActivity);

}