package com.joye.hk6.view;

import android.os.Bundle;

import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.BaseFragmentActivity;
import com.joye.hk6.frg.SizeFragment;
import com.joye.hk6.internal.di.component.DaggerHk6Component;
import com.joye.hk6.internal.di.component.Hk6Component;
import com.joye.hk6.internal.di.modules.Hk6Module;

import javax.inject.Inject;

public class ChineseZodiacProbilityActivity extends BaseFragmentActivity implements HasComponent<Hk6Component> {
    @Inject
    StatusBarHelp barHelp;

    Hk6Component hk6Component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector();
        barHelp.setStatusBarTintEnable(true, R.drawable.statusbar_bg);
        setContentView(R.layout.activity_chinese_zodiac_probility);
        addFragment(R.id.fragmentChineseZodiacProbility,new SizeFragment());

    }
    protected void initializeInjector() {
        String date="2016-12-31";
        hk6Component = DaggerHk6Component.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .statusbarActivityModule(getActivityModule())
                .hk6Module(new Hk6Module(date)).build();
        hk6Component.inject(this);

    }

    @Override
    public Hk6Component getComponent() {
        return hk6Component;
    }
}
