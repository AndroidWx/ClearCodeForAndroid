package com.joye.hk6.frg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.joye.hk6.mvp.BaseBannerOnePageFragment;
import com.joye.hk6.presenter.SizePresenter;
import com.joye.hk6.view.SizeActivity;
import com.joye.hk6.vu.SizeFragmentVu;
import com.joye.layouts.BorderRippleViewTextView;

import javax.inject.Inject;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/22.
 * 304622254@qq.com
 * Remeark:
 */

public class SizeFragment extends BaseBannerOnePageFragment<SizeFragmentVu> {
    @Inject
    SizePresenter SizePresenter;

    @Override
    protected Class<SizeFragmentVu> getVuClass() {
        return SizeFragmentVu.class;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SizeActivity.class.cast(getActivity()).getComponent().inject(this);
    }

    @Override
    protected void onVuCreate() {
        super.onVuCreate();
        vu.setErrorRetryListener(SizePresenter.getErrorRetryListener());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vu.commonRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        SizePresenter.setView(vu);
        SizePresenter.initalize();
        vu.BannerOnePageImpl.setOnRippleCompleteListener(new BorderRippleViewTextView.OnRippleCompleteListener() {
            @Override
            public void onComplete(BorderRippleViewTextView rippleView) {
                getActivity().finish();
            }
        });
        vu.BannerOnePageImpl.setTitleLable("大小走势");
    }
}
