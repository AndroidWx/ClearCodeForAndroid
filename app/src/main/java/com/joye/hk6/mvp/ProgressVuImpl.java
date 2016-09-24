package com.joye.hk6.mvp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joye.hk6.R;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/23.
 * 304622254@qq.com
 * Remeark:
 */

public  abstract class ProgressVuImpl<T> extends BaseVuImp implements ProgressVu<T> {
    @Override
    public void showLoading() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void onNext(T t) {

    }


    @Override
    protected void initView() {

    }


}
