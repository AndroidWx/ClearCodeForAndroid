package com.joye.hk6.view;

import android.support.v7.widget.LinearLayoutManager;

import com.google.common.reflect.TypeToken;
import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.BasePresenterAppCompatActivity;
import com.joye.hk6.internal.di.component.DaggerSizeTwosComponent;
import com.joye.hk6.internal.di.component.SizeTwosComponent;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.presenter.SizeTowsPresenter;
import com.joye.hk6.util.Helper;
import com.joye.hk6.vu.SizeTwosActivityVu;
import com.joye.hk6data.cache.impl.Hk6FileCacheImpl;
import com.joye.hk6data.entity.Hk6Entity;
import com.joye.hk6data.utils.GsonFactory;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by xiang on 16/9/29.
 */

public class SizeTwosActivity extends BasePresenterAppCompatActivity<SizeTwosActivityVu> implements HasComponent<SizeTwosComponent> {
    SizeTwosComponent mSizeTwosComponent;
    @Inject
    SizeTowsPresenter mSizeTowsPresenter;
    @Inject
    StatusBarHelp statusBarHelp;
    @Inject
    Hk6FileCacheImpl mHk6FileCacheImpl;
    public void a() {
        for (int i = 1990; i < 2016; i++) {
            mHk6FileCacheImpl.put(
                    (List<Hk6Entity>) GsonFactory.SingleTon.create().fromJson(Helper.readAssertResource(this, i + ".json"), new TypeToken<List<Hk6Entity>>() {
                    }.getType()), 1990 + "");
        }
    }
    @Override
    protected void onBindVu() {
        super.onBindVu();
        initializeInjector();
        statusBarHelp.setStatusBarTintEnable(true, R.drawable.banner_bar_bg);
        vu.setErrorRetryListener(mSizeTowsPresenter.getErrorRetryListener());
        vu.commonRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSizeTowsPresenter.setView(vu);
        mSizeTowsPresenter.initalize(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                a();
            }
        }).start();
    }
    public void initializeInjector() {
        mSizeTwosComponent = DaggerSizeTwosComponent.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .hk6Module(new Hk6Module("2016-12-31"))
                .statusbarActivityModule(new StatusbarActivityModule(this)).build();
        mSizeTwosComponent.inject(this);
    }
    @Override
    public SizeTwosComponent getComponent() {
        return mSizeTwosComponent;
    }

    @Override
    protected Class<SizeTwosActivityVu> getVuClass() {
        return SizeTwosActivityVu.class;
    }
}
