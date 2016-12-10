package com.joye.hk6.view;

import android.support.v7.widget.LinearLayoutManager;

import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.Hk6ReportAppCompatActivity;
import com.joye.hk6.internal.di.component.CompositeMantissaComponent;
import com.joye.hk6.internal.di.component.DaggerCompositeMantissaComponent;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.presenter.CompositeMantissaActivityPresenter;
import com.joye.hk6.vu.CompositeMantissaActivityVu;

import javax.inject.Inject;

/**
 * Created by xiang on 16/9/29.
 */

public class CompositeMantissaActivity extends Hk6ReportAppCompatActivity<CompositeMantissaActivityVu> implements HasComponent<CompositeMantissaComponent> {
    CompositeMantissaComponent mMantissaComponent;
    @Inject
    CompositeMantissaActivityPresenter mMantissaActivityPresenter;
    @Inject
    StatusBarHelp statusBarHelp;
    public static final String TITLE = "合尾走势预警";
    public static final int PICRESID = R.drawable.compositemantissa;
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
        mMantissaComponent = DaggerCompositeMantissaComponent.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .hk6Module(new Hk6Module("2016-12-31"))
                .statusbarActivityModule(new StatusbarActivityModule(this)).build();
        mMantissaComponent.inject(this);
    }
    @Override
    public CompositeMantissaComponent getComponent() {
        return mMantissaComponent;
    }

    @Override
    protected Class<CompositeMantissaActivityVu> getVuClass() {
        return CompositeMantissaActivityVu.class;
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
