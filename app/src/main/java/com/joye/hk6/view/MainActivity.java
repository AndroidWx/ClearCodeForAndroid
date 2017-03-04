package com.joye.hk6.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;

import com.apkfuns.logutils.LogUtils;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.BasePresenterAppCompatActivity;
import com.joye.hk6.internal.di.component.DaggerMainComponent;
import com.joye.hk6.internal.di.component.MainComponent;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.internal.di.modules.WriteDataToFileCacheModule;
import com.joye.hk6.presenter.MainPresenter;
import com.joye.hk6.util.WriteDataToFileCacheDelegate;
import com.joye.hk6.vu.MainActivityVu;

import javax.inject.Inject;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/26.
 * 304622254@qq.com
 * Remeark:
 */

public class MainActivity extends BasePresenterAppCompatActivity<MainActivityVu> {

    @Inject
    StatusBarHelp help;
    private MainComponent mainModule;
    @Inject
    MainPresenter mainPresenter;
    @Inject
    WriteDataToFileCacheDelegate writeDataToFileCacheDelegate;
    @Override
    protected void onBindVu() {
        super.onBindVu();
        initializer();
        writeDataToFileCacheDelegate.wirteData();
        mainPresenter.onBindVu(this);
        mainPresenter.setView(vu);
        mainPresenter.setupViewPager();
        vu.tabs.setupWithViewPager(vu.viewpager);
        help.setStatusBarTintEnable(true,R.color.colorPrimary);
        //  StatusBarUtil.setColorNoTranslucent(this,R.color.colorPrimary);
        //StatusBarUtil.setTransparentForDrawerLayout(this,vu.drawerLayout );


    }

    private void initializer() {
        mainModule= DaggerMainComponent.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .statusbarActivityModule(new StatusbarActivityModule(this))
                .writeDataToFileCacheModule(new WriteDataToFileCacheModule())
                .build();
        mainModule.inject(this);
    }

    @Override
    protected Class<MainActivityVu> getVuClass() {
        return MainActivityVu.class;
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        LogUtils.v(item);
        switch (item.getItemId()) {
            case android.R.id.home:
                vu.drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.nav_home:
                 Intent intent =(new Intent(this,ReportActivity.class));
                startActivity(intent);
                return true;
            case R.id.about_me:
                return true;
            case R.id.nav_share:
                return true;


        }
        return super.onOptionsItemSelected(item);
    }


}
