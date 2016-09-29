package com.joye.hk6.vu;

import android.content.Context;

import com.joye.hk6.R;
import com.joye.hk6.adapter.SizeAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/29.
 * 304622254@qq.com
 * Remeark:
 */
public class SizeActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu{


    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("大小走势预警");
        backdrop.setImageResource(R.drawable.size);
        lableViewStub.setLayoutResource( R.layout.item_size);
        lableViewStub.inflate();
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new SizeAdapter(context);
    }
}
