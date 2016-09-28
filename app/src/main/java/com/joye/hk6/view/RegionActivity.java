package com.joye.hk6.view;

import android.os.Bundle;

import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.BaseFragmentActivity;
import com.joye.hk6.frg.RegionFragment;
import com.joye.hk6.internal.di.component.DaggerRegionComponent;
import com.joye.hk6.internal.di.component.RegionComponent;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;

import javax.inject.Inject;

public class RegionActivity extends BaseFragmentActivity implements HasComponent<RegionComponent> {
    RegionComponent mRegionComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector();
        statusBarHelp.setStatusBarTintEnable(true, R.drawable.banner_bar_bg);
        setContentView(R.layout.f_emptycontent);
        sizeFragment = new RegionFragment();
        addFragment(R.id.emptyContent, sizeFragment);
    }

    private RegionFragment sizeFragment;
    @Inject
    StatusBarHelp statusBarHelp;

    public void initializeInjector() {
        mRegionComponent = DaggerRegionComponent.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .hk6Module(new Hk6Module("2016-12-31"))
                .statusbarActivityModule(new StatusbarActivityModule(this)).build();
        mRegionComponent.inject(this);
    }

    @Override
    public RegionComponent getComponent() {
        return mRegionComponent;
    }

}
