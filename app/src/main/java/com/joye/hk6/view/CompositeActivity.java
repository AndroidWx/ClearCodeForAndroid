package com.joye.hk6.view;

import android.support.v7.widget.LinearLayoutManager;

import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.BasePresenterAppCompatActivity;
import com.joye.hk6.internal.di.component.CompositeComponent;
import com.joye.hk6.internal.di.component.DaggerCompositeComponent;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.presenter.CompositeActivityPresenter;
import com.joye.hk6.vu.CompositeActivityVu;

import javax.inject.Inject;

/**
 * Created by xiang on 16/9/29.
 */

public class CompositeActivity extends BasePresenterAppCompatActivity<CompositeActivityVu> implements HasComponent<CompositeComponent> {
    CompositeComponent mCompositeComponent;
    @Inject
    CompositeActivityPresenter mRegionPresenter;
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
        mCompositeComponent = DaggerCompositeComponent.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .hk6Module(new Hk6Module("2016-12-31"))
                .statusbarActivityModule(new StatusbarActivityModule(this)).build();
        mCompositeComponent.inject(this);
    }
    @Override
    public CompositeComponent getComponent() {
        return mCompositeComponent;
    }

    @Override
    protected void onVuInit() {
    }

    @Override
    protected Class<CompositeActivityVu> getVuClass() {
        return CompositeActivityVu.class;
    }
}
