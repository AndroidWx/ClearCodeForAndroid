package com.joye.hk6.view;

import android.support.v7.widget.LinearLayoutManager;

import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.Hk6ReportAppCompatActivity;
import com.joye.hk6.internal.di.component.DaggerSizeTwosComponent;
import com.joye.hk6.internal.di.component.SizeTwosComponent;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.presenter.SizeTowsPresenter;
import com.joye.hk6.util.DateUtil;
import com.joye.hk6.vu.SizeTwosActivityVu;

import javax.inject.Inject;

/**
 * Created by xiang on 16/9/29.
 */

public class SizeTwosActivity extends Hk6ReportAppCompatActivity<SizeTwosActivityVu> implements HasComponent<SizeTwosComponent> {
    SizeTwosComponent mSizeTwosComponent;
    @Inject
    SizeTowsPresenter mSizeTowsPresenter;
    @Inject
    StatusBarHelp statusBarHelp;
    public static final String TITLE = "半单双走势预警";
    public static final int PICRESID = R.drawable.sizetwos;
    @Override
    protected void onBindVu() {
        super.onBindVu();
        initializeInjector();
        statusBarHelp.setStatusBarTintEnable(true, R.drawable.banner_bar_bg);
        vu.setErrorRetryListener(mSizeTowsPresenter.getErrorRetryListener());
        vu.commonRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSizeTowsPresenter.setView(vu);
        mSizeTowsPresenter.initalize(this);

    }
    public void initializeInjector() {
        mSizeTwosComponent = DaggerSizeTwosComponent.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .hk6Module(new Hk6Module(DateUtil.getDate()))
                .statusbarActivityModule(new StatusbarActivityModule(this)).build();
        mSizeTwosComponent.inject(this);
    }
    @Override
    public SizeTwosComponent getComponent() {
        return mSizeTwosComponent;
    }

    @Override
    public int getReportPic() {
        return PICRESID;
    }

    @Override
    public String getReportActivityTitle() {
        return TITLE;
    }

    @Override
    protected Class<SizeTwosActivityVu> getVuClass() {
        return SizeTwosActivityVu.class;
    }

}
