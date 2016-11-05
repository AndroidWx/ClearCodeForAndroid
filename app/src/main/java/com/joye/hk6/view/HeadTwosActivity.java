package com.joye.hk6.view;

import android.support.v7.widget.LinearLayoutManager;

import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.BasePresenterAppCompatActivity;
import com.joye.hk6.internal.di.component.DaggerHeadTwosComponent;
import com.joye.hk6.internal.di.component.HeadTwosComponent;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.presenter.HeadTwosActivityPresenter;
import com.joye.hk6.vu.HeadTwosActivityVu;

import javax.inject.Inject;

/**
 * Created by xiang on 16/9/29.
 */

public class HeadTwosActivity extends BasePresenterAppCompatActivity<HeadTwosActivityVu> implements HasComponent<HeadTwosComponent> {
    HeadTwosComponent mHeadTwosComponent;
    @Inject
    HeadTwosActivityPresenter mRegionPresenter;
    @Inject
    StatusBarHelp statusBarHelp;

    @Override
    protected void onBindVu() {
        super.onBindVu();
        initializeInjector();
        statusBarHelp.setStatusBarTintEnable(true, R.drawable.banner_bar_bg);
        vu.setErrorRetryListener(mRegionPresenter.getErrorRetryListener());
        vu.commonRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRegionPresenter.setView(vu);
        mRegionPresenter.initalize(this);
    }
    public void initializeInjector() {
        mHeadTwosComponent = DaggerHeadTwosComponent.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .hk6Module(new Hk6Module("2016-12-31"))
                .statusbarActivityModule(new StatusbarActivityModule(this)).build();
        mHeadTwosComponent.inject(this);
    }
    @Override
    public HeadTwosComponent getComponent() {
        return mHeadTwosComponent;
    }

    @Override
    protected Class<HeadTwosActivityVu> getVuClass() {
        return HeadTwosActivityVu.class;
    }
}
