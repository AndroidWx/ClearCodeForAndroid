package com.joye.hk6.view;

import android.support.v7.widget.LinearLayoutManager;

import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.Hk6ReportAppCompatActivity;
import com.joye.hk6.internal.di.component.DaggerHeadAgeComponent;
import com.joye.hk6.internal.di.component.HeadAgeComponent;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.presenter.HeadAgeActivityPresenter;
import com.joye.hk6.util.DateUtil;
import com.joye.hk6.vu.HeadAgeActivityVu;

import javax.inject.Inject;

/**
 * Created by xiang on 16/9/29.
 */

public class HeadAgeActivity extends Hk6ReportAppCompatActivity<HeadAgeActivityVu> implements HasComponent<HeadAgeComponent> {
    HeadAgeComponent mColorTwosComponent;
    @Inject
    HeadAgeActivityPresenter mRegionPresenter;
    @Inject
    StatusBarHelp statusBarHelp;
    public static final String TITLE = "头数走势预警";
    public static final int PICRESID = R.drawable.headage;
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
        mColorTwosComponent = DaggerHeadAgeComponent.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .hk6Module(new Hk6Module(DateUtil.getDate()))
                .statusbarActivityModule(new StatusbarActivityModule(this)).build();
        mColorTwosComponent.inject(this);
    }
    @Override
    public HeadAgeComponent getComponent() {
        return mColorTwosComponent;
    }

    @Override
    protected Class<HeadAgeActivityVu> getVuClass() {
        return HeadAgeActivityVu.class;
    }

    @Override
    public int getReportPic() {
        return PICRESID;
    }

    @Override
    public String getReportActivityTitle() {
        return TITLE;
    }
}
