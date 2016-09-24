package com.joye.hk6.frg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.joye.hk6.internal.di.component.Hk6Component;
import com.joye.hk6.mvp.BaseBannerOnePageFragment;
import com.joye.hk6.mvp.BasePresenterFragment;
import com.joye.hk6.presenter.ChineseZodiacProbilityPresenter;
import com.joye.hk6.vu.ChineseZodiacProbilityFragmentVu;
import com.joye.hk6.vu.SwipeRefreshRecyclerViewVu;

import javax.inject.Inject;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/22.
 * 304622254@qq.com
 * Remeark:
 */

public class ChineseZodiacProbilityFragment extends BaseBannerOnePageFragment<ChineseZodiacProbilityFragmentVu> {
    @Inject
    ChineseZodiacProbilityPresenter chineseZodiacProbilityPresenter;

    @Override
    protected Class<ChineseZodiacProbilityFragmentVu> getVuClass() {
        return ChineseZodiacProbilityFragmentVu.class;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent(Hk6Component.class).inject(this);
    }

    @Override
    protected void onVuCreate() {
        super.onVuCreate();
        vu.setErrorRetryListener(chineseZodiacProbilityPresenter.getErrorRetryListener());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vu.commonRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        chineseZodiacProbilityPresenter.setView(vu);
        chineseZodiacProbilityPresenter.initalize();

    }
}
