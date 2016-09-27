package com.joye.hk6.vu.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joye.hk6.R;
import com.joye.hk6.mvp.BaseVuImp;
import com.joye.hk6.mvp.Vu;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/27.
 * 304622254@qq.com
 * Remeark:
 */

public class EmptyVu extends BaseVuImp {
    @Override
    protected void initView() {

    }

    @Override
    public int getResouceId() {
        return R.layout.f_emptycontent;
    }
}
