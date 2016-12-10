package com.joye.hk6.view;

import android.support.v7.widget.LinearLayoutManager;

import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.Hk6ReportAppCompatActivity;
import com.joye.hk6.internal.di.component.DaggerModular6Component;
import com.joye.hk6.internal.di.component.Modular6Component;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.presenter.Modular6ActivityPresenter;
import com.joye.hk6.vu.Modular6ActivityVu;

import javax.inject.Inject;

/**
 * Created by xiang on 16/9/29.
 */

public class Modular6Activity extends Hk6ReportAppCompatActivity<Modular6ActivityVu> implements HasComponent<Modular6Component> {
    Modular6Component mModularComponent;
    @Inject
    Modular6ActivityPresenter mRegionPresenter;
    @Inject
    StatusBarHelp statusBarHelp;
    public static final String TITLE = "模6走势预警";
    public static final int PICRESID = R.drawable.modular6;
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
        mModularComponent = DaggerModular6Component.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .hk6Module(new Hk6Module("2016-12-31"))
                .statusbarActivityModule(new StatusbarActivityModule(this)).build();
        mModularComponent.inject(this);
    }
    @Override
    public Modular6Component getComponent() {
        return mModularComponent;
    }

    @Override
    protected Class<Modular6ActivityVu> getVuClass() {
        return Modular6ActivityVu.class;
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
