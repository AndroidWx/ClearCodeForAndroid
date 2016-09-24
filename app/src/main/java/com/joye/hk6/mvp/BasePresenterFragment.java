package com.joye.hk6.mvp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joye.basepresentation.internal.di.HasComponent;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/22.
 * 304622254@qq.com
 * Remeark:
 */

public abstract class BasePresenterFragment<V extends Vu> extends Fragment {
    protected V vu;

    public BasePresenterFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        try {
            vu = getVuClass().newInstance();
            onVuCreate();
             vu.init(inflater, container);
            view = vu.getView();
            onBindVu();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }

        return view;
    }

    @Override
    public final void onDestroyView() {
        onDestroyVu();
        vu = null;
        super.onDestroyView();
    }

    protected void onDestroyVu() {
    }

    ;

    protected void onBindVu() {
    }

    ;  @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>)getActivity()).getComponent());
    }

    protected abstract Class<V> getVuClass();

    protected void onVuCreate() {
    }
}
