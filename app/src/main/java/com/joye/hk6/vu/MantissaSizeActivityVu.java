package com.joye.hk6.vu;

import android.content.Context;

import com.joye.hk6.R;
import com.joye.hk6.adapter.MantissaSizeAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;

/**
 * Created by xiang on 16/9/29.
 */

public class MantissaSizeActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu {
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("尾数大小走势预警");
        backdrop.setImageResource(R.drawable.mantissasize);
        lableViewStub.setLayoutResource( R.layout.item_mantissasize);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new MantissaSizeAdapter(context);
    }
}
