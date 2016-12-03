package com.joye.hk6.view;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.joye.basepresentation.internal.di.HasComponent;
import com.joye.hk6.R;
import com.joye.hk6.StatusBarHelp;
import com.joye.hk6.ac.BasePresenterAppCompatActivity;
import com.joye.hk6.internal.di.component.DaggerModular6Component;
import com.joye.hk6.internal.di.component.Modular6Component;
import com.joye.hk6.internal.di.modules.Hk6Module;
import com.joye.hk6.internal.di.modules.StatusbarActivityModule;
import com.joye.hk6.presenter.Modular6ActivityPresenter;
import com.joye.hk6.report.PieChartImpl;
import com.joye.hk6.vu.Modular6ActivityVu;
import com.joye.hk6data.utils.CollectionUtils;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by xiang on 16/9/29.
 */

public class Modular6Activity extends BasePresenterAppCompatActivity<Modular6ActivityVu> implements HasComponent<Modular6Component> {
    Modular6Component mModularComponent;
    @Inject
    Modular6ActivityPresenter mRegionPresenter;
    @Inject
    StatusBarHelp statusBarHelp;
    public static final String TITLE = "模6走势预警";
    public static final int PICRESID = R.drawable.modular6;
    ArrayList<PieChartImpl> datas=new ArrayList<>();
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
        mModularComponent = DaggerModular6Component.builder()
                .hk6ApplicationComponent(getApplicationComponent())
                .hk6Module(new Hk6Module("2016-12-31"))
                .statusbarActivityModule(new StatusbarActivityModule(this)).build();
        mModularComponent.inject(this);
    }
    @Override
    public Modular6Component getComponent() {
        return mModularComponent;
    }

    @Override
    protected Class<Modular6ActivityVu> getVuClass() {
        return Modular6ActivityVu.class;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_open_rv_menu) {
            if(CollectionUtils.isEmpty(datas)){
                return true;
            }
            Intent intent = new Intent(this, ReportActivity.class);
            intent.putParcelableArrayListExtra(ReportActivity.EXTRA_KEY_DATAS, datas);
            intent.putExtra(ReportActivity.EXTRA_KEY_PICRESID, PICRESID);
            intent.putExtra(ReportActivity.EXTRA_KEY_TITLE, TITLE);
            startActivity(intent);
        }
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_all_activity, menu);
        return true;
    }

    @Override
    protected void onVuInit() {
        super.onVuInit();
        vu.setCallback(new IPieChartCallback() {
            @Override
            public void callback(ArrayList<PieChartImpl> mdatas) {
                datas.addAll(mdatas);
            }
        });
    }
}
