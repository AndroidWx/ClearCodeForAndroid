package com.joye.hk6.vu;

import android.content.Context;

import com.joye.hk6.R;
import com.joye.hk6.adapter.CompositeMantissaAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;

/**
 * Created by xiang on 16/9/29.
 */

public class CompositeMantissaActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu {
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("合尾走势预警");
        backdrop.setImageResource(R.drawable.compositemantissa);
        lableViewStub.setLayoutResource( R.layout.item_composite_mantissa);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new CompositeMantissaAdapter(context);
    }
}
