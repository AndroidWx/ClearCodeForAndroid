package com.joye.hk6.view;

import android.support.v7.widget.LinearLayoutManager;

import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.Hk6ReportAppCompatActivity;
import com.joye.hk6.internal.di.component.ChineseZodiacComponent;
import com.joye.hk6.internal.di.component.DaggerChineseZodiacComponent;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.presenter.ChineseZodiacActivityPresenter;
import com.joye.hk6.util.DateUtil;
import com.joye.hk6.vu.ChineseZodiacActivityVu;

import javax.inject.Inject;

public class ChineseZodiacActivity extends Hk6ReportAppCompatActivity<ChineseZodiacActivityVu> implements HasComponent<ChineseZodiacComponent> {
    ChineseZodiacComponent mChineseZodiacComponent;
    @Inject
    ChineseZodiacActivityPresenter mRegionPresenter;
    @Inject
    StatusBarHelp statusBarHelp;

    public static final String TITLE = "生肖历史阈值分析";
    public static final int PICRESID = R.drawable.chinesezodiac;

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
         mChineseZodiacComponent = DaggerChineseZodiacComponent.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .hk6Module(new Hk6Module(DateUtil.getDate()))
                .statusbarActivityModule(new StatusbarActivityModule(this)).build();
        mChineseZodiacComponent.inject(this);
    }
    @Override
    public ChineseZodiacComponent getComponent() {
        return mChineseZodiacComponent;
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
    protected void onResume() {
        super.onResume();
        vu.toolbar.setTitle("生肖走势图预警");
    }


    @Override
    protected Class<ChineseZodiacActivityVu> getVuClass() {
        return ChineseZodiacActivityVu.class;
    }

}
