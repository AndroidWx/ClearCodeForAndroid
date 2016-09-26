package com.joye.hk6.ac;

import android.os.Bundle;

import com.joye.hk6.mvp.Vu;

/**
 * Created by Wx on 2016/9/26.
 * QQ:304622254;
 * remark:
 */

public abstract class BasePresenterAppCompatActivity<V extends Vu> extends BaseAppCompatActivity {
    protected V vu;
    protected abstract Class<V> getVuClass();

    @Override
    protected final void onDestroy() {
        onDestroyVu();
        vu = null;
        super.onDestroy();
    }
    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            vu = getVuClass().newInstance();
            vu.init(getLayoutInflater(), null);
            setContentView(vu.getView());
            onBindVu();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected void onBindVu() {
    };

    protected void onDestroyVu() {
    };
}
