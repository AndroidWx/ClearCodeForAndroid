package com.joye.hk6.frg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.joye.hk6.R;
import com.joye.hk6.mvp.BaseBannerOnePageFragment;
import com.joye.hk6.presenter.RegionPresenter;
import com.joye.hk6.view.RegionActivity;
import com.joye.hk6.vu.RegionFragmentVu;
import com.joye.layouts.BorderRippleViewTextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/22.
 * 304622254@qq.com
 * Remeark:
 */

public class RegionFragment extends BaseBannerOnePageFragment<RegionFragmentVu> {
    @Inject
    RegionPresenter mRegionPresenter;

    @Override
    protected Class<RegionFragmentVu> getVuClass() {
        return RegionFragmentVu.class;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RegionActivity.class.cast(getActivity()).getComponent().inject(this);
    }

    @Override
    protected void onVuCreate() {
        super.onVuCreate();
        vu.setErrorRetryListener(mRegionPresenter.getErrorRetryListener());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vu.commonRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRegionPresenter.setView(vu);
        mRegionPresenter.initalize();
        vu.BannerOnePageImpl.setOnRippleCompleteListener(new BorderRippleViewTextView.OnRippleCompleteListener() {
            @Override
            public void onComplete(BorderRippleViewTextView rippleView) {
                getActivity().finish();
            }
        });
        String format=getResources().getString(R.string.vigilant);
        List<Object>list=new ArrayList<>();
        vu.BannerOnePageImpl.setTitleLable("大小走势");
    }
}
