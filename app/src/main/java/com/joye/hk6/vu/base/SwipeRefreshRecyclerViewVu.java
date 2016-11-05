package com.joye.hk6.vu.base;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.joye.hk6.R;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.mvp.BaseVuImp;
import com.joye.hk6.util.IProgressListener;
import com.vlonjatg.progressactivity.ProgressActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/24.
 * 304622254@qq.com
 * Remeark:
 */

public   abstract   class SwipeRefreshRecyclerViewVu extends BaseVuImp    {
    @BindView(R.id.common_recycler_view)
    public RecyclerView commonRecyclerView;
    @BindView(R.id.common_swipe_refresh)
    public SwipeRefreshLayout commonSwipeRefresh;
    @BindView(R.id.progressActivity)
    public  ProgressActivity progressActivity;
    public IProgressListener iProgressListener;

    public UpdateItemRecyclerViewAdapter mAdapter;

    @CallSuper
    @Override
    protected void initView() {
        ButterKnife.bind(this, view);
        iProgressListener=new IProgressListener(progressActivity);
        try {
            commonRecyclerView.setLayoutManager(new LinearLayoutManager(commonRecyclerView.getContext()));
            mAdapter = getRecylerViewAdapter(commonRecyclerView.getContext());
            commonRecyclerView.setAdapter(mAdapter);
            commonSwipeRefresh.setColorSchemeColors(R.color.colorPrimary, R.color.colorPrimaryDark);
            commonSwipeRefresh.setEnabled(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  abstract UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context);

}
