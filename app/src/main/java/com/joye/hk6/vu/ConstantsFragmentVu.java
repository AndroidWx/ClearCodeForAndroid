package com.joye.hk6.vu;

import android.content.Context;

import com.joye.hk6.adapter.ConstantsAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.vu.base.BannberOnePageProgressSwipeRefreshRecyclerVu;

/**
 * Created by Wx on 2016/9/26.
 * QQ:304622254;
 * remark:
 */
public class ConstantsFragmentVu extends BannberOnePageProgressSwipeRefreshRecyclerVu<ConstantsAdapter.ConstantsItem> {
    public ConstantsFragmentVu() {
        bannerStubInflate=false;
    }

    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new ConstantsAdapter(context);
    }
}
