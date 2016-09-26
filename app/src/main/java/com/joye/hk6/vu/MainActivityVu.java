package com.joye.hk6.vu;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import com.joye.hk6.R;
import com.joye.hk6.mvp.BaseVuImp;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wx on 2016/9/26.
 * QQ:304622254;
 * remark:
 */
public class MainActivityVu extends BaseVuImp {
    @BindView(R.id.appbar)
    public AppBarLayout appbar;
    @BindView(R.id.viewpager)
    public ViewPager viewpager;
    @BindView(R.id.fab)
    public FloatingActionButton fab;
    @BindView(R.id.main_content)
    public CoordinatorLayout mainContent;
    @BindView(R.id.nav_view)
    public NavigationView navView;
    @BindView(R.id.drawer_layout)
    public DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.tabs)
    public TabLayout tabs;

    @Override
    protected void initView() {
        ButterKnife.bind(this, view);
    }

    @Override
    public int getResouceId() {
        return R.layout.activity_main;
    }
}
