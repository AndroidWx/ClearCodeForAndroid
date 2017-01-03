package com.joye.hk6.view;

import android.support.v7.widget.LinearLayoutManager;

import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.Hk6ReportAppCompatActivity;
import com.joye.hk6.internal.di.component.DaggerOddEvenComponent;
import com.joye.hk6.internal.di.component.OddEvenComponent;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.presenter.OddEvenActivityPresenter;
import com.joye.hk6.util.DateUtil;
import com.joye.hk6.vu.OddEvenActivityVu;

import javax.inject.Inject;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/27.
 * 304622254@qq.com
 * Remeark:
 */

public class OddEvenActivity extends Hk6ReportAppCompatActivity<OddEvenActivityVu> implements HasComponent<OddEvenComponent>{
    private OddEvenComponent mOddEvenComponent;
    public static final String TITLE = "单双预警";
    public static final int PICRESID = R.drawable.oddeven;
    @Inject
    StatusBarHelp statusBarHelp;
    @Inject
    OddEvenActivityPresenter mOddEvenActivityPresenter;
    @Override
    protected Class<OddEvenActivityVu> getVuClass() {
        return OddEvenActivityVu.class;
    }

    @Override
    protected void onBindVu() {
        super.onBindVu();
        initializeInjector();
        statusBarHelp.setStatusBarTintEnable(true, R.drawable.banner_bar_bg);
        vu.setErrorRetryListener(mOddEvenActivityPresenter.getErrorRetryListener());
        vu.commonRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mOddEvenActivityPresenter.setView(vu);
        mOddEvenActivityPresenter.initalize(this);
    }

    public void initializeInjector(){
        mOddEvenComponent = DaggerOddEvenComponent.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .hk6Module(new Hk6Module(DateUtil.getDate()))
                .statusbarActivityModule(new StatusbarActivityModule(this)).build();
        mOddEvenComponent.inject(this);
    }

    @Override
    public OddEvenComponent getComponent() {
        return mOddEvenComponent;
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
