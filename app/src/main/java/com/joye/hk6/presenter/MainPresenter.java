package com.joye.hk6.presenter;

import android.content.DialogInterface;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;
import android.view.View;

import com.apkfuns.logutils.LogUtils;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.R;
import com.joye.hk6.adapter.MainFragmentPagerAdapter;
import com.joye.hk6.frg.ConstantsFragment;
import com.joye.hk6.frg.VariationFragment;
import com.joye.hk6.mvp.Presenter;
import com.joye.hk6.view.MainActivity;
import com.joye.hk6.vu.MainActivityVu;
import com.pgyersdk.feedback.PgyFeedback;
import com.pgyersdk.javabean.AppBean;
import com.pgyersdk.update.PgyUpdateManager;
import com.pgyersdk.update.UpdateManagerListener;

import javax.inject.Inject;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/29.
 * 304622254@qq.com
 * Remeark:
 */
@PerActivity
public class MainPresenter implements Presenter<MainActivityVu> {
    private MainActivityVu vu;
    private  MainActivity mainActivity;
    private MainFragmentPagerAdapter mPagerAdapter;
    private UpdateManagerListener updateLitener = new UpdateManagerListener() {
        @Override
        public void onNoUpdateAvailable() {
//            Logger.v("onNoUpdateAvailable");
        }

        @Override
        public void onUpdateAvailable(String result) {
            // 将新版本信息封装到AppBean中
            final AppBean appBean = getAppBeanFromString(result);
            new AlertDialog.Builder(mainActivity)
                    .setTitle("更新")
                    .setMessage(appBean.getReleaseNote())
                    .setNegativeButton(
                            "确定",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(
                                        DialogInterface dialog,
                                        int which) {
                                    startDownloadTask(
                                            mainActivity,
                                            appBean.getDownloadURL());
                                }
                            }).show();
        }
    };


    @Inject
    public MainPresenter() {
    }

    @Override
    public void setView(MainActivityVu mainActivityVu) {
        this.vu = mainActivityVu;
        vu.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PgyFeedback.getInstance().showDialog(mainActivity);

            }
        });
    }

    public void onBindVu(final MainActivity mainActivity) {
        this.mainActivity=mainActivity;
        PgyUpdateManager.register(mainActivity, updateLitener);

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }
    public void setupViewPager() {
        mainActivity.setSupportActionBar(vu.toolbar);
        final ActionBar ab = mainActivity.getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        ab.setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(vu.navView);
        mPagerAdapter = new MainFragmentPagerAdapter(mainActivity.getSupportFragmentManager());
        mPagerAdapter.addFragment(ConstantsFragment.newInstance(), "永久属性");
        mPagerAdapter.addFragment(VariationFragment.newInstance(), "生肖波色");
        vu.viewpager.setAdapter(mPagerAdapter);
    }
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        vu.drawerLayout.closeDrawers();
                        disposeMenuAction(menuItem);
                        return true;
                    }
                });
    }
    private void disposeMenuAction(MenuItem item){
//        switch (item.getItemId()){
//
//        }
        LogUtils.d(item.getItemId());
    }

    @Override
    public void destroy() {
        PgyUpdateManager.unregister();
    }
}
