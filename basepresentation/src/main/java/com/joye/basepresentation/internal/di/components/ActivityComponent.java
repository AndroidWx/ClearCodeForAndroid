package com.joye.basepresentation.internal.di.components;

import android.app.Activity;

import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.basepresentation.internal.di.modules.ActivityModule;
import com.joye.basepresentation.internal.di.modules.ApplicationModule;

import dagger.Component;

/**
 * Created by xiang on 16/9/21.
 */
@PerActivity
@Component(dependencies = ApplicationModule.class,modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
