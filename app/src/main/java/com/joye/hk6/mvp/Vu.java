package com.joye.hk6.mvp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/22.
 * 304622254@qq.com
 * Remeark:
 */

public interface Vu  {

    void init(LayoutInflater layoutInflater, ViewGroup container);

    View getView();
}
