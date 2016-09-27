package com.joye.hk6.view;

import android.os.Bundle;

import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.ac.BaseFragmentActivity;
import com.joye.hk6.ac.EmptyActivity;
import com.joye.hk6.frg.SizeFragment;
import com.joye.hk6.internal.di.component.DaggerMainComponent;
import com.joye.hk6.internal.di.component.DaggerSizeComponent;
import com.joye.hk6.internal.di.component.SizeComponent;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.mvp.BasePresenterActivity;
import com.joye.hk6.vu.base.EmptyVu;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/27.
 * 304622254@qq.com
 * Remeark:
 */

public class SizeActivity extends BaseFragmentActivity implements HasComponent<SizeComponent>{
    private SizeComponent sizeComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector();
        setContentView(R.layout.f_emptycontent);
        addFragment(R.id.emptyContent,new SizeFragment());
    }

    public void initializeInjector(){
        sizeComponent=DaggerSizeComponent.builder().applicationComponent(getApplicationComponent()).hk6Module(new Hk6Module("2016-12-31"))
                .statusbarActivityModule(new StatusbarActivityModule(this)).build();
        sizeComponent.inject(this);
    }

    @Override
    public SizeComponent getComponent() {
        return sizeComponent;
    }
}
