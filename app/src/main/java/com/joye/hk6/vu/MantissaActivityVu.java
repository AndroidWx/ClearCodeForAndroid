package com.joye.hk6.vu;

import android.content.Context;

import com.joye.hk6.R;
import com.joye.hk6.adapter.MantissaAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;

/**
 * Created by xiang on 16/9/29.
 */

public class MantissaActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu {
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("尾数走势预警");
        backdrop.setImageResource(R.drawable.mantissa);
        lableViewStub.setLayoutResource( R.layout.item_mantissa);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new MantissaAdapter(context);
    }
}
