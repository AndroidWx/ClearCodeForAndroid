package com.joye.hk6.view;

import android.support.v7.widget.LinearLayoutManager;

import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.BasePresenterAppCompatActivity;
import com.joye.hk6.internal.di.component.DaggerRegionComponent;
import com.joye.hk6.internal.di.component.RegionComponent;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.presenter.RegionActivityPresenter;
import com.joye.hk6.vu.RegionActivityVu;

import javax.inject.Inject;

public class RegionActivity extends BasePresenterAppCompatActivity<RegionActivityVu> implements HasComponent<RegionComponent> {
    RegionComponent mRegionComponent;
    @Inject
    RegionActivityPresenter mRegionPresenter;

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


    @Override
    public Class<RegionActivityVu> getVuClass() {
        return RegionActivityVu.class;
    }

    @Inject
    StatusBarHelp statusBarHelp;

    public void initializeInjector() {
        mRegionComponent = DaggerRegionComponent.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .hk6Module(new Hk6Module("2016-12-31"))
                .statusbarActivityModule(new StatusbarActivityModule(this)).build();
        mRegionComponent.inject(this);
    }

    @Override
    public RegionComponent getComponent() {
        return mRegionComponent;
    }

}
