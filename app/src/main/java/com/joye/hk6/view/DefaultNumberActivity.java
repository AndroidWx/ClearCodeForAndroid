package com.joye.hk6.view;

import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.BasePresenterAppCompatActivity;
import com.joye.hk6.internal.di.component.DaggerDefaultNumberComponent;
import com.joye.hk6.internal.di.component.DefaultNumberComponent;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.presenter.DefaultNumberActivityPresenter;
import com.joye.hk6.vu.DefaultNumberActivityVu;

import javax.inject.Inject;

public class DefaultNumberActivity extends BasePresenterAppCompatActivity<DefaultNumberActivityVu> implements HasComponent<DefaultNumberComponent> {
    DefaultNumberComponent mDefaultNumberComponent;
    @Inject
    DefaultNumberActivityPresenter mDefaultNumberActivityPresenter;
    @Inject
    StatusBarHelp statusBarHelp;

    @Override
    protected void onBindVu() {
        super.onBindVu();
        initializeInjector();
        statusBarHelp.setStatusBarTintEnable(true, R.drawable.banner_bar_bg);
        vu.setErrorRetryListener(mDefaultNumberActivityPresenter.getErrorRetryListener());
        mDefaultNumberActivityPresenter.setView(vu);
        mDefaultNumberActivityPresenter.initalize(this);
    }
    public void initializeInjector() {
         mDefaultNumberComponent = DaggerDefaultNumberComponent.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .hk6Module(new Hk6Module("2016-12-31"))
                .statusbarActivityModule(new StatusbarActivityModule(this)).build();
        mDefaultNumberComponent.inject(this);
    }
    @Override
    public DefaultNumberComponent getComponent() {
        return mDefaultNumberComponent;
    }


    @Override
    protected Class<DefaultNumberActivityVu> getVuClass() {
        return DefaultNumberActivityVu.class;
    }

}
