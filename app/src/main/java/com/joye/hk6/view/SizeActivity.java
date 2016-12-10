package com.joye.hk6.view;

import android.support.v7.widget.LinearLayoutManager;

import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.Hk6ReportAppCompatActivity;
import com.joye.hk6.internal.di.component.DaggerSizeComponent;
import com.joye.hk6.internal.di.component.SizeComponent;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.presenter.SizeActivityPresenter;
import com.joye.hk6.vu.SizeActivityVu;

import javax.inject.Inject;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/27.
 * 304622254@qq.com
 * Remeark:
 */

public class SizeActivity extends Hk6ReportAppCompatActivity<SizeActivityVu> implements HasComponent<SizeComponent>{
    private SizeComponent sizeComponent;
    public static final String TITLE = "大小走势预警";
    public static final int PICRESID = R.drawable.size;
    @Inject
    StatusBarHelp statusBarHelp;
    @Inject
    SizeActivityPresenter mSizeActivityPresenter;
    @Override
    protected Class<SizeActivityVu> getVuClass() {
        return SizeActivityVu.class;
    }

    @Override
    protected void onBindVu() {
        super.onBindVu();
        initializeInjector();
        statusBarHelp.setStatusBarTintEnable(true, R.drawable.banner_bar_bg);
        vu.setErrorRetryListener(mSizeActivityPresenter.getErrorRetryListener());
        vu.commonRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSizeActivityPresenter.setView(vu);
        mSizeActivityPresenter.initalize(this);
    }

    public void initializeInjector(){
        sizeComponent=DaggerSizeComponent.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .hk6Module(new Hk6Module("2016-12-31"))
                .statusbarActivityModule(new StatusbarActivityModule(this)).build();
        sizeComponent.inject(this);
    }

    @Override
    public SizeComponent getComponent() {
        return sizeComponent;
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
