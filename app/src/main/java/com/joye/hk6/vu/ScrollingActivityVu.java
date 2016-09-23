package com.joye.hk6.vu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joye.hk6.R;
import com.joye.hk6.mvp.Vu;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/23.
 * 304622254@qq.com
 * Remeark:
 */
public class ScrollingActivityVu implements Vu {
    private View view;
    @Override
    public void init(LayoutInflater layoutInflater, ViewGroup container) {
        view=layoutInflater.inflate(R.layout.activity_scrolling,container);

    }

    @Override
    public View getView() {
        return view;
    }
}
