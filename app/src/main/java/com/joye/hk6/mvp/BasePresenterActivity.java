package com.joye.hk6.mvp;

import android.os.Bundle;
import android.support.annotation.CallSuper;

import com.joye.hk6.Hk6AndroidApplication;
import com.joye.hk6.ac.BaseActivity;
import com.joye.hk6.internal.di.component.Hk6ApplicationComponent;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/22.
 * 304622254@qq.com
 * Remeark:
 */

public abstract class BasePresenterActivity<  V extends Vu> extends BaseActivity{
    protected V vu;

    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            vu = getVuClass().newInstance();
            onVuInit();
            vu.init(getLayoutInflater(), null);
            setContentView(vu.getView());
            onBindVu();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    protected void onVuInit() {
        //do nothing
    }

    public abstract Class<V> getVuClass();

    @Override
    protected final void onDestroy() {
        onDestroyVu();
        vu = null;
        super.onDestroy();
    }

    /**
     * inject
     */
    protected  void initializeInjector(){

    }
    @CallSuper
    protected void onBindVu() {
        initializeInjector();
    };

    protected void onDestroyVu() {
        //do nothing
    };


}
