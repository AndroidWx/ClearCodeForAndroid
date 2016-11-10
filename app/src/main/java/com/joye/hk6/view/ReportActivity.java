package com.joye.hk6.view;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.f2prateek.dart.Dart;
import com.f2prateek.dart.HensonNavigable;
import com.f2prateek.dart.InjectExtra;
import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.BasePresenterAppCompatActivity;
import com.joye.hk6.internal.di.component.DaggerReportComponent;
import com.joye.hk6.internal.di.component.ReportComponent;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.presenter.ReportActivityPresenter;
import com.joye.hk6.report.IPieChart;
import com.joye.hk6.report.PieChartImpl;
import com.joye.hk6.util.ReportHelper;
import com.joye.hk6.vu.ReportActivityVu;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by xiang on 16/11/5.
 * remark:属性报表查看activity
 *
 */
@HensonNavigable
public class ReportActivity extends BasePresenterAppCompatActivity<ReportActivityVu> implements HasComponent<ReportComponent>{


    ReportComponent reportComponent;
    @Inject
    StatusBarHelp statusBarHelp;
    @Inject
    ReportActivityPresenter presenter;
    @InjectExtra
    ArrayList<PieChartImpl> listPirChartDatas;
    @InjectExtra(ReportHelper.EXTRA_KEY_TYPE)
    String mTitleName;
    @InjectExtra(ReportHelper.EXTRA_KEY_DRAWABLE_ID)
    int mDrawableId;

    @Override
    protected Class<ReportActivityVu> getVuClass() {
        return ReportActivityVu.class;
    }
    @Override
    protected void onBindVu() {
        super.onBindVu();
        Dart.inject(this);
        initializeInjector();
        statusBarHelp.setStatusBarTintEnable(true, R.drawable.banner_bar_bg);
        vu.commonRecyclerView.setLayoutManager(new GridLayoutManager(this,13));
        presenter.setView(vu);
        presenter.initalize(this);



    }
    public void initializeInjector(){
        reportComponent= DaggerReportComponent.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .statusbarActivityModule(new StatusbarActivityModule(this)).build();
    }

    @Override
    public ReportComponent getComponent() {
        return reportComponent;
    }
}
