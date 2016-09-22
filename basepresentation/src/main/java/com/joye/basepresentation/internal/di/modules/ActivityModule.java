package com.joye.basepresentation.internal.di.modules;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/21.
 * 304622254@qq.com
 * Remeark:
 */

import android.app.Activity;

import com.joye.basepresentation.internal.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Modules类里面的方法专门提供依赖，
 * 所以我们定义一个类，
 * 用@Module注解，
 * 这样Dagger在构造类的实例的时候，
 * 就知道从哪里去找到需要的依赖。
 * modules的一个重要特征是它们设计为分区并组合在一起
 * （比如说，在我们的app中可以有多个组成在一起的modules）
 */
@Module
public class ActivityModule {
    protected final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides @PerActivity Activity activity(){
        return activity;
    }
}
