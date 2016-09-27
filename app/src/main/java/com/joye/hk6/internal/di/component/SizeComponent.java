package com.joye.hk6.internal.di.component;

import android.app.Activity;

import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.frg.SizeFragment;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;

import dagger.Component;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/27.
 * 304622254@qq.com
 * Remeark:
 */
@PerActivity
@Component(dependencies = Hk6ApplicationComponent.class, modules = {Hk6Module.class, StatusbarActivityModule.class})
public interface SizeComponent  extends StatusbarActivityComponent{

    void inject(Activity sizeActivity);
    void inject(SizeFragment sizeFragment);

}
