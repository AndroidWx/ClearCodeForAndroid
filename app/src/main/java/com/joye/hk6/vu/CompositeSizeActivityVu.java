package com.joye.hk6.vu;

import android.content.Context;

import com.joye.hk6.R;
import com.joye.hk6.adapter.CompositeSizeAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;

/**
 * Created by xiang on 16/9/29.
 */

public class CompositeSizeActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu {
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("合数大小走势预警");
        backdrop.setImageResource(R.drawable.compositesize);
        lableViewStub.setLayoutResource( R.layout.item_compositesize);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new CompositeSizeAdapter(context);
    }
}
