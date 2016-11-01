package com.joye.hk6.vu.base;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.view.ViewStub;
import android.widget.ImageView;

import com.joye.hk6.R;
import com.joye.hk6.adapter.RegionAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;

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
