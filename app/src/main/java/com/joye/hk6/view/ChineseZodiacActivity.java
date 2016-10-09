package com.joye.hk6.view;

import android.support.v7.widget.LinearLayoutManager;

import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.BasePresenterAppCompatActivity;
import com.joye.hk6.internal.di.component.ChineseZodiacComponent;
import com.joye.hk6.internal.di.component.DaggerChineseZodiacComponent;
import com.joye.hk6.internal.di.component.DaggerColorTwosComponent;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.presenter.ChineseZodiacActivityPresenter;
import com.joye.hk6.presenter.ColorTwosActivityPresenter;
import com.joye.hk6.vu.ChineseZodiacActivityVu;

import javax.inject.Inject;

public class ChineseZodiacActivity extends BasePresenterAppCompatActivity<ChineseZodiacActivityVu> implements HasComponent<ChineseZodiacComponent> {
    ChineseZodiacComponent mChineseZodiacComponent;
    @Inject
    ChineseZodiacActivityPresenter mRegionPresenter;
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
         mChineseZodiacComponent = DaggerChineseZodiacComponent.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .hk6Module(new Hk6Module("2016-12-31"))
                .statusbarActivityModule(new StatusbarActivityModule(this)).build();
        mChineseZodiacComponent.inject(this);
    }
    @Override
    public ChineseZodiacComponent getComponent() {
        return mChineseZodiacComponent;
    }


    @Override
    protected Class<ChineseZodiacActivityVu> getVuClass() {
        return ChineseZodiacActivityVu.class;
    }

}
