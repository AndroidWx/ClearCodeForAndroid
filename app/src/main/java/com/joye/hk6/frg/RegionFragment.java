package com.joye.hk6.frg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.joye.hk6.R;
import com.joye.hk6.mvp.BaseBannerOnePageFragment;
import com.joye.hk6.presenter.RegionFragmentPresenter;
import com.joye.hk6.view.RegionActivity;
import com.joye.hk6.vu.RegionFragmentVu;
import com.joye.hk6domain.constants.Formula;
import com.joye.hk6domain.constants.Probalility;
import com.joye.hk6domain.constants.Vigilant;
import com.joye.layouts.BorderRippleViewTextView;


import javax.inject.Inject;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/22.
 * 304622254@qq.com
 * Remeark:
 */

public class RegionFragment extends BaseBannerOnePageFragment<RegionFragmentVu> {
    @Inject
    RegionFragmentPresenter mRegionPresenter;

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
        String sFinalBig=String.format(format,"每段",
                Formula.lottery(Vigilant.Base.getDcValue(), Probalility.Region.Default),
                Formula.lottery(Vigilant.Blue.getDcValue(),Probalility.Region.Default),
                Formula.lottery(Vigilant.Blue_1.getDcValue(),Probalility.Region.Default),
                Formula.lottery(Vigilant.Yellow.getDcValue(),Probalility.Region.Default),
                Formula.lottery(Vigilant.Yellow_1.getDcValue(),Probalility.Region.Default),
                Formula.lottery(Vigilant.Orange.getDcValue(),Probalility.Region.Default),
                Formula.lottery(Vigilant.Orange_1.getDcValue(),Probalility.Region.Default),
                Formula.lottery(Vigilant.Red.getDcValue(),Probalility.Region.Default),
                Formula.lottery(Vigilant.Red_1.getDcValue(),Probalility.Region.Default) );
        String numbers="    一段：1-7；二段：8-14；三段：15-21；四段：22-28；五段29-35；六段36-42；七段43-49；建议"+ Formula.lottery(Vigilant.Orange.getDcValue(),Probalility.Region.Default)+"期关注";
        sFinalBig=sFinalBig+numbers;
        sFinalBig=sFinalBig.replaceAll("ppp","%");
        vu.expandTextView.setText(sFinalBig);
        vu.BannerOnePageImpl.setTitleLable("段位走势");
    }
}
