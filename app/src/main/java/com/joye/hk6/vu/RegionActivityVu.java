package com.joye.hk6.vu;

import com.joye.hk6.R;
import com.joye.hk6.vu.base.CoordinatorLayoutToolBarImageViewRecyclerVu;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/29.
 * 304622254@qq.com
 * Remeark:
 */
public class RegionActivityVu extends CoordinatorLayoutToolBarImageViewRecyclerVu {


    @Override
    public void setToolbarTimeAndViewStubInflate() {
        toolbar.setTitle("段位走势预警");
        lableViewStub.setLayoutResource(R.layout.item_region);
        lableViewStub.inflate();
    }
}
