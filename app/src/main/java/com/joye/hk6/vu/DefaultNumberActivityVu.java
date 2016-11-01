package com.joye.hk6.vu;

import android.content.Context;

import com.joye.hk6.R;
import com.joye.hk6.adapter.ColorAdapter;
import com.joye.hk6.adapter.DefaultNumberdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewReportVu;
import com.joye.hk6domain.vo.DefaultNumberVo;

import java.util.List;

/**
 * Created by xiang on 16/9/29.
 */

public class DefaultNumberActivityVu extends CoordinatorLayoutToolBarImageViewReportVu<DefaultNumberVo> {
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("数字走势预警");
//        backdrop.setImageResource(R.drawable.color);
//        lableViewStub.setLayoutResource( R.layout.report_title_right_v);
//        lableViewStub.inflate();
    }


    @Override
    public void onNext(List<DefaultNumberVo> o) {
         reportLeftAdapter.clear();
        reportRightAdapter.clear();
        reportLeftAdapter.addAll(o);
        reportRightAdapter.addAll(o);
       reportLeftAdapter.notifyDataSetChanged();
        reportRightAdapter.notifyDataSetChanged();
    }
}
