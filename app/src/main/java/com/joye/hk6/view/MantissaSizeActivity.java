package com.joye.hk6.view;

import android.support.v7.widget.LinearLayoutManager;

import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.BasePresenterAppCompatActivity;
import com.joye.hk6.internal.di.component.DaggerMantissaSizeComponent;
import com.joye.hk6.internal.di.component.MantissaSizeComponent;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.presenter.MantissaSizeActivityPresenter;
import com.joye.hk6.vu.MantissaSizeActivityVu;

import javax.inject.Inject;

/**
 * Created by xiang on 16/9/29.
 */

public class MantissaSizeActivity extends BasePresenterAppCompatActivity<MantissaSizeActivityVu> implements HasComponent<MantissaSizeComponent> {
    MantissaSizeComponent mMantissaComponent;
    @Inject
    MantissaSizeActivityPresenter mMantissaActivityPresenter;
    @Inject
    StatusBarHelp statusBarHelp;

    @Override
    protected void onBindVu() {
        super.onBindVu();
        initializeInjector();
        statusBarHelp.setStatusBarTintEnable(true, R.drawable.banner_bar_bg);
        vu.setErrorRetryListener(mMantissaActivityPresenter.getErrorRetryListener());
        vu.commonRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMantissaActivityPresenter.setView(vu);
        mMantissaActivityPresenter.initalize(this);
    }
    public void initializeInjector() {
        mMantissaComponent = DaggerMantissaSizeComponent.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .hk6Module(new Hk6Module("2016-12-31"))
                .statusbarActivityModule(new StatusbarActivityModule(this)).build();
        mMantissaComponent.inject(this);
    }
    @Override
    public MantissaSizeComponent getComponent() {
        return mMantissaComponent;
    }

    @Override
    protected Class<MantissaSizeActivityVu> getVuClass() {
        return MantissaSizeActivityVu.class;
    }
}
