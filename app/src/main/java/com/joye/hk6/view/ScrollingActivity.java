package com.joye.hk6.view;

import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.internal.di.component.DaggerHk6Component;
import com.joye.hk6.internal.di.component.Hk6Component;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.mvp.BasePresenterActivity;
import com.joye.hk6.presenter.ChineseZodiacProbilityPresenter;
import com.joye.hk6.vu.ChineseZodiacProbilityFragmentVu;
import com.joye.hk6.vu.ScrollingActivityVu;

import javax.inject.Inject;


public class ScrollingActivity extends BasePresenterActivity<ChineseZodiacProbilityFragmentVu> {
    @Inject
    StatusBarHelp barHelp;
    @Inject
    ChineseZodiacProbilityPresenter chineseZodiacProbilityPresenter;
    Hk6Component hk6Component;
    String date;
    @Override
    protected void onBindVu() {
        super.onBindVu();
        barHelp.setStatusBarTintEnable(true, R.color.colorAccent);
        chineseZodiacProbilityPresenter.setView(vu);
        chineseZodiacProbilityPresenter.initalize();
    }

    @Override
    public Class<ChineseZodiacProbilityFragmentVu> getVuClass() {
        return ChineseZodiacProbilityFragmentVu.class;
    }

    @Override
    protected void initializeInjector() {
        date="2016-09-23";
        hk6Component = DaggerHk6Component.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .statusbarActivityModule(getActivityModule())
                .hk6Module(new Hk6Module(date)).build();
        hk6Component.inject(this);
    }
}
