package com.joye.hk6.view;

import android.support.v7.widget.LinearLayoutManager;

import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.BasePresenterAppCompatActivity;
import com.joye.hk6.internal.di.component.DaggerModular4Component;
import com.joye.hk6.internal.di.component.Modular4Component;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.presenter.Modular4ActivityPresenter;
import com.joye.hk6.vu.Modular4ActivityVu;

import javax.inject.Inject;

/**
 * Created by xiang on 16/9/29.
 */

public class Modular4Activity extends BasePresenterAppCompatActivity<Modular4ActivityVu> implements HasComponent<Modular4Component> {
    Modular4Component mModularComponent;
    @Inject
    Modular4ActivityPresenter mRegionPresenter;
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
        mModularComponent = DaggerModular4Component.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .hk6Module(new Hk6Module("2016-12-31"))
                .statusbarActivityModule(new StatusbarActivityModule(this)).build();
        mModularComponent.inject(this);
    }
    @Override
    public Modular4Component getComponent() {
        return mModularComponent;
    }

    @Override
    protected Class<Modular4ActivityVu> getVuClass() {
        return Modular4ActivityVu.class;
    }
}
