package com.joye.hk6.vu;

import com.joye.hk6.R;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;

/**
 * Created by xiang on 16/9/29.
 */

public class ColorTwosActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu {
    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("半波走势预警");
        backdrop.setImageResource(R.drawable.size);
        lableViewStub.setLayoutResource( R.layout.item_size);
        lableViewStub.inflate();
    }
}
