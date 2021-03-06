package com.joye.hk6;

import android.app.Application;

import com.joye.hk6.common.JoyeEnvironment;
import com.joye.hk6.internal.di.component.DaggerHk6ApplicationComponent;
import com.joye.hk6.internal.di.component.Hk6ApplicationComponent;
import com.joye.hk6.internal.di.modules.Hk6ApplicationModule;

import net.nashlegend.anypref.AnyPref;

/**
 * Created by xiang on 16/9/21.
 */
public class Hk6AndroidApplication extends Application {
    private Hk6ApplicationComponent applicationModule;

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(){
            @Override
            public void run() {
                JoyeEnvironment.Instance.onCreate(Hk6AndroidApplication.this);
                AnyPref.init(Hk6AndroidApplication.this);
            }
        }.start();
        initializeInjector();
    }

    private void initializeInjector(){
        this.applicationModule= DaggerHk6ApplicationComponent.builder()
                .hk6ApplicationModule(new Hk6ApplicationModule(this))
                .build();
    }

    public Hk6ApplicationComponent getApplicationComponent() {
        return applicationModule;
    }
}
