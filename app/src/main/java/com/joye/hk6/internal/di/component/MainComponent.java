package com.joye.hk6.internal.di.component;

import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.internal.di.modules.WriteDataToFileCacheModule;
import com.joye.hk6.view.MainActivity;
import com.joye.hk6data.cache.impl.Hk6Cache;

import dagger.Component;

/**
 * Created by Wx on 2016/9/26.
 * QQ:304622254;
 * remark:
 */
@PerActivity
@Component(dependencies = Hk6ApplicationComponent.class,modules ={ StatusbarActivityModule.class, WriteDataToFileCacheModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}

