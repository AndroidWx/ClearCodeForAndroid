package com.joye.hk6;

import android.app.Application;

import com.joye.hk6.dl.component.ApplicationComponent;

/**
 * Created by xiang on 16/9/21.
 */
public class AndroidApplication extends Application {
    private ApplicationComponent applicationModule;
    @Override
    public void onCreate() {
        super.onCreate();

    }

    private void initializeInjector(){
//        this.applicationModule= Dagger.builder().applicationModule()
    }
}
