package com.joye.hk6.view;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.apkfuns.logutils.LogUtils;
import com.google.common.reflect.TypeToken;
import com.jaeger.library.StatusBarUtil;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.BasePresenterAppCompatActivity;
import com.joye.hk6.ac.EmptyActivity;
import com.joye.hk6.adapter.MainFragmentPagerAdapter;
import com.joye.hk6.frg.ConstantsFragment;
import com.joye.hk6.frg.SizeFragment;
import com.joye.hk6.internal.di.component.DaggerMainComponent;
import com.joye.hk6.internal.di.component.MainComponent;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.presenter.MainPresenter;
import com.joye.hk6.util.Helper;
import com.joye.hk6.vu.MainActivityVu;
import com.joye.hk6data.cache.impl.Hk6FileCacheImpl;
import com.joye.hk6data.entity.Hk6Entity;
import com.joye.hk6data.utils.GsonFactory;

import java.util.List;

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

    @Override
    protected void onBindVu() {
        super.onBindVu();
        initializer();
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
                .statusbarActivityModule(new StatusbarActivityModule(this))
                .hk6ApplicationComponent(getApplicationComponent()).build();
        mainModule.inject(this);
    }

    @Override
    protected Class<MainActivityVu> getVuClass() {
        return MainActivityVu.class;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        LogUtils.v(item);
        switch (item.getItemId()) {
            case android.R.id.home:
                vu.drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.nav_home:

                return true;
            case R.id.about_me:
                return true;
            case R.id.nav_share:
                return true;


        }
        return super.onOptionsItemSelected(item);
    }


}
