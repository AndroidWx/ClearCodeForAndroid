package com.joye.hk6.view;

import com.f2prateek.dart.Dart;
import com.f2prateek.dart.HensonNavigable;
import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.BasePresenterAppCompatActivity;
import com.joye.hk6.internal.di.component.DaggerReportComponent;
import com.joye.hk6.internal.di.component.ReportComponent;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.presenter.ReportActivityPresenter;
import com.joye.hk6.report.PieChartImpl;
import com.joye.hk6.vu.ReportActivityVu;

import java.util.ArrayList;

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

//    @InjectExtra
    ArrayList<PieChartImpl> listPirChartDatas;
//    @InjectExtra(ReportHelper.EXTRA_KEY_TYPE)
    String mTitleName;
//    @InjectExtra(ReportHelper.EXTRA_KEY_DRAWABLE_ID)
    int mDrawableId;

    public static final String EXTRA_KEY_DATAS="EXTRA_KEY_DATAS";

    public static final String EXTRA_KEY_TITLE="EXTRA_KEY_TITLE";

    public static final String EXTRA_KEY_PICRESID="EXTRA_KEY_PICRESID";
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
        presenter.setView(vu);
        presenter.initalize(this);
        if(getIntent().hasExtra(EXTRA_KEY_DATAS)){
            listPirChartDatas=getIntent().getParcelableArrayListExtra(EXTRA_KEY_DATAS);
        }
        if(getIntent().hasExtra(EXTRA_KEY_TITLE)){
            vu.toolbar.setTitle(getIntent().getStringExtra(EXTRA_KEY_TITLE));
        }
        if(getIntent().hasExtra(EXTRA_KEY_PICRESID)){
            vu. backdrop.setImageResource(getIntent().getIntExtra(EXTRA_KEY_PICRESID,R.drawable.color));
        }

        vu.mAdapter.updateItems(listPirChartDatas,true);


    }
    public void initializeInjector(){
        reportComponent= DaggerReportComponent.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .statusbarActivityModule(new StatusbarActivityModule(this)).build();
        reportComponent.inject(this);
    }

    @Override
    public ReportComponent getComponent() {
        return reportComponent;
    }
}
