package com.joye.hk6.vu;

import android.content.Context;

import com.joye.hk6.adapter.ReportAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.report.IPieChart;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;

/**
 * Created by W,x (JoyeWang)
 * on 2016/11/10.
 * 304622254@qq.com
 * Remeark:
 */
public class ReportActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu<IPieChart>{
    @Override
    public void setToolbarTimeAndViewStubInflate() {

    }
    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new ReportAdapter(context);
    }
}
