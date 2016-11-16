package com.joye.hk6.view;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.f2prateek.dart.HensonNavigable;
import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.BasePresenterAppCompatActivity;
import com.joye.hk6.internal.di.component.ColorComponent;
import com.joye.hk6.internal.di.component.DaggerColorComponent;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.presenter.ColorActivityPresenter;
import com.joye.hk6.vu.ColorActivityVu;

import javax.inject.Inject;

/**
 * Created by xiang on 16/9/29.
 */
public class ColorActivity extends BasePresenterAppCompatActivity<ColorActivityVu> implements HasComponent<ColorComponent> {
    public ColorComponent mColorComponent;
    @Inject
    public  ColorActivityPresenter mRegionPresenter;
    @Inject
    public  StatusBarHelp statusBarHelp;

    @Override
    protected void onBindVu() {
        super.onBindVu();
        initializeInjector();
        statusBarHelp.setStatusBarTintEnable(true, R.drawable.banner_bar_bg);
        vu.setErrorRetryListener(mRegionPresenter.getErrorRetryListener());
        vu.commonRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRegionPresenter.setView(vu);
        mRegionPresenter.initalize(this);
    }
    public void initializeInjector() {
        mColorComponent = DaggerColorComponent.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .hk6Module(new Hk6Module("2016-12-31"))
                .statusbarActivityModule(new StatusbarActivityModule(this)).build();
        mColorComponent.inject(this);
    }
    @Override
    public ColorComponent getComponent() {
        return mColorComponent;
    }

    @Override
    protected Class<ColorActivityVu> getVuClass() {
        return ColorActivityVu.class;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_open_rv_menu) {
//            Intent intent =Henson.with(this);
           /* Intent intentSampleFragment = Henson.with(this)
                    .gotoSampleFragment()
                    .foo("bar")
                    .build();*/

        }
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_all_activity, menu);
        return true;
    }

}
