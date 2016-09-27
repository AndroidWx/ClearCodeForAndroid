package com.joye.hk6.vu;

import android.content.Context;

import com.joye.hk6.adapter.SizeAdapter;
import com.joye.hk6.adapter.UpdateItemRecyclerViewAdapter;
import com.joye.hk6.vu.base.ProgressSwipeRefreshRecyclerVu;
import com.joye.hk6domain.vo.SizeVo;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:
 */

public class SizeFragmentVu extends ProgressSwipeRefreshRecyclerVu<SizeVo> {
    @Override
    public UpdateItemRecyclerViewAdapter getRecylerViewAdapter(Context context) {
        return new SizeAdapter(context);
    }
}
