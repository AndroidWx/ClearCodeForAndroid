package com.joye.hk6.vu.base;

import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;

import com.joye.hk6.R;

import butterknife.BindView;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/29.
 * 304622254@qq.com
 * Remeark:
 */
public abstract class CoordinatorLayoutToolBarImageViewReportVu<T> extends ReportBaseVu<T> {

//    @BindView(R.id.backdrop)
//    public ImageView backdrop;
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
//    @BindView(R.id.collapsing_toolbar)
//    public CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.appbar)
    public AppBarLayout appbar;
//    @BindView(R.id.main_content)
//    public CoordinatorLayout mainContent;
//    @BindView(R.id.lableViewStub)
//    public ViewStub lableViewStub;

    @Override
    protected void initView() {
        super.initView();
        setToolbarTimeAndViewStubInflate();
    }

    public abstract void setToolbarTimeAndViewStubInflate();

    @Override
    public int getResouceId() {
        return R.layout.activity_report;
    }


}
