package com.joye.hk6.vu;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.joye.hk6.R;
import com.joye.hk6.adapter.RegionAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.mvp.BaseVuImp;
import com.joye.hk6.vu.base.ProgressSwipeRefreshRecyclerVu;
import com.joye.layouts.BorderTextView;

import butterknife.BindView;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/29.
 * 304622254@qq.com
 * Remeark:
 */
public class RegionActivityVu extends ProgressSwipeRefreshRecyclerVu {

    @BindView(R.id.backdrop)
    public ImageView backdrop;
    @BindView(R.id.toolbar)
    public  Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    public CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.appbar)
    public  AppBarLayout appbar;
    @BindView(R.id.main_content)
    public  CoordinatorLayout mainContent;

    @Override
    protected void initView(){
        super.initView();
        toolbar.setTitle("段位走势预警");

    }
    @Override
    public int getResouceId() {
        return R.layout.activity_region;
    }
    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new RegionAdapter(context);
    }
}
