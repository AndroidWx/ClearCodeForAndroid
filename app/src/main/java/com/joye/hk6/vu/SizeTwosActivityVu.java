package com.joye.hk6.vu;

import android.content.Context;

import com.joye.hk6.R;
import com.joye.hk6.adapter.SizeTwosAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;

/**
 * Created by xiang on 16/9/29.
 */

public class SizeTwosActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu {
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("半单双走势预警");
        backdrop.setImageResource(R.drawable.sizetwos);
        lableViewStub.setLayoutResource( R.layout.item_sizetwos);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new SizeTwosAdapter(context);
    }
}
