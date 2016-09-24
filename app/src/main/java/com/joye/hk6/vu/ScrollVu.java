package com.joye.hk6.vu;

import android.support.percent.PercentRelativeLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.joye.hk6.R;
import com.joye.hk6.adapter.ReportLeftAdapter;
import com.joye.hk6.adapter.ReportRightAdapter;
import com.joye.hk6.mvp.ProgressVuImpl;
import com.joye.hk6.util.IProgressListener;
import com.joye.hk6.widget.ReportMeasureHeightListView;
import com.joye.hk6.widget.ReportMeasureWidthListView;
import com.joye.hk6.widget.ReportScrollView;
import com.joye.hk6.widget.ReportSyncHorizontalScrollView;
import com.joye.hk6domain.entity.Hk6UiData;
import com.joye.hk6domain.vo.ChineseZodiacVo;
import com.joye.layouts.BorderLinearLayout;
import com.vlonjatg.progressactivity.ProgressActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/22.
 * 304622254@qq.com
 * Remeark:生肖概率的视图
 */
public class ScrollVu extends ProgressVuImpl<List<ChineseZodiacVo>> {
    private IProgressListener progressListener;
    private ReportLeftAdapter reportLeftAdapter;
    public ReportRightAdapter reportRightAdapter;
    @Override
    public void showLoading() {
        progressListener.showLoading();
    }

    @Override
    public void showEmpty() {
        LogUtils.d("showEmpty");
    }

    @Override
    public void showError(Throwable e) {
        LogUtils.d(e);
    }

    @Override
    public void showContent() {
        progressListener.showContent();

    }

    @Override
    public void onNext(List<ChineseZodiacVo> hk6UiDatas) {
        reportLeftAdapter.addAll(hk6UiDatas);
        reportRightAdapter.addAll(hk6UiDatas);
        reportLeftAdapter.notifyDataSetChanged();
        reportRightAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initView() {
        super.initView();
        progressListener = new IProgressListener(progressActivity);
        rightTitleHorscrollView.setmSyncView(rightContentHorscrollView);
        ReportSyncHorizontalScrollViewVisibility.setmSyncView(rightContentHorscrollView);
        rightContentHorscrollView.setmSyncView(rightTitleHorscrollView);
        rightContentHorscrollView.setmSyncView1(ReportSyncHorizontalScrollViewVisibility);
        reportLeftAdapter = new ReportLeftAdapter(view.getContext(), 0, new ArrayList<Hk6UiData>());
        contentListViewLeft.setAdapter(reportLeftAdapter);
        reportRightAdapter = new ReportRightAdapter(view.getContext(), 0, new ArrayList<Hk6UiData>());
        contentListViewRight.setAdapter(reportRightAdapter);
        reportScrollView.setOnScrollListener(new ReportScrollView.OnScrollListener() {

            @Override
            public void onScroll(int l, int t, int oldl, int oldt) {
//                if (topLinearLayout != null) {
//                    if (t >= topLinearLayout.getHeight()) {
//                        titleLayoutVisibile.setVisibility(View.VISIBLE);
//                    } else {
//                        titleLayoutVisibile.setVisibility(View.GONE);
//                    }
//                    if(t<=10){
//                        mSwipeRefreshLayout.setEnabled(true);
//                    }else{
//                        mSwipeRefreshLayout.setEnabled(false);
//                    }
//                }
            }
        });
        commonSwipeRefresh.setColorSchemeColors(R.color.colorPrimary, R.color.colorPrimaryDark);
    }

    @Override
    public int getResouceId() {
        return R.layout.ac_chinese_zodiac_probility_layout;
    }
    @BindView(R.id.report_left_expect)
    TextView reportLeftExpect;
    @BindView(R.id.report_left_opencode)
    TextView reportLeftOpencode;
    @BindView(R.id.tv_item1)
    TextView tvItem1;
    @BindView(R.id.tv_item2)
    TextView tvItem2;
    @BindView(R.id.tv_item3)
    TextView tvItem3;
    @BindView(R.id.tv_item4)
    TextView tvItem4;
    @BindView(R.id.tv_item5)
    TextView tvItem5;
    @BindView(R.id.tv_item6)
    TextView tvItem6;
    @BindView(R.id.tv_item7)
    TextView tvItem7;
    @BindView(R.id.tv_item8)
    TextView tvItem8;
    @BindView(R.id.tv_item9)
    TextView tvItem9;
    @BindView(R.id.tv_item10)
    TextView tvItem10;
    @BindView(R.id.tv_item11)
    TextView tvItem11;
    @BindView(R.id.tv_item12)
    TextView tvItem12;
    @BindView(R.id.tv_item13)
    TextView tvItem13;
    @BindView(R.id.tv_item14)
    TextView tvItem14;
    @BindView(R.id.tv_item15)
    TextView tvItem15;
    @BindView(R.id.tv_item16)
    TextView tvItem16;
    @BindView(R.id.tv_item17)
    TextView tvItem17;
    @BindView(R.id.tv_item18)
    TextView tvItem18;
    @BindView(R.id.tv_item19)
    TextView tvItem19;
    @BindView(R.id.tv_item20)
    TextView tvItem20;
    @BindView(R.id.tv_item21)
    TextView tvItem21;
    @BindView(R.id.tv_item22)
    TextView tvItem22;
    @BindView(R.id.tv_item23)
    TextView tvItem23;
    @BindView(R.id.tv_item24)
    TextView tvItem24;
    @BindView(R.id.tv_item25)
    TextView tvItem25;
    @BindView(R.id.tv_item26)
    TextView tvItem26;
    @BindView(R.id.tv_item27)
    TextView tvItem27;
    @BindView(R.id.tv_item28)
    TextView tvItem28;
    @BindView(R.id.tv_item29)
    TextView tvItem29;
    @BindView(R.id.tv_item30)
    TextView tvItem30;
    @BindView(R.id.tv_item31)
    TextView tvItem31;
    @BindView(R.id.tv_item32)
    TextView tvItem32;
    @BindView(R.id.tv_item33)
    TextView tvItem33;
    @BindView(R.id.tv_item34)
    TextView tvItem34;
    @BindView(R.id.tv_item35)
    TextView tvItem35;
    @BindView(R.id.tv_item36)
    TextView tvItem36;
    @BindView(R.id.tv_item37)
    TextView tvItem37;
    @BindView(R.id.tv_item38)
    TextView tvItem38;
    @BindView(R.id.tv_item39)
    TextView tvItem39;
    @BindView(R.id.tv_item40)
    TextView tvItem40;
    @BindView(R.id.tv_item41)
    TextView tvItem41;
    @BindView(R.id.tv_item42)
    TextView tvItem42;
    @BindView(R.id.tv_item43)
    TextView tvItem43;
    @BindView(R.id.tv_item44)
    TextView tvItem44;
    @BindView(R.id.tv_item45)
    TextView tvItem45;
    @BindView(R.id.tv_item46)
    TextView tvItem46;
    @BindView(R.id.tv_item47)
    TextView tvItem47;
    @BindView(R.id.tv_item48)
    TextView tvItem48;
    @BindView(R.id.tv_item49)
    TextView tvItem49;


    @BindView(R.id.rightTitleHorscrollView)
    ReportSyncHorizontalScrollView rightTitleHorscrollView;
    @BindView(R.id.titleLayout)
    BorderLinearLayout titleLayout;
    @BindView(R.id.contentListViewLeft)
    ReportMeasureWidthListView contentListViewLeft;
    @BindView(R.id.contentListViewRight)
    ReportMeasureHeightListView contentListViewRight;
    @BindView(R.id.rightContentHorscrollView)
    ReportSyncHorizontalScrollView rightContentHorscrollView;
    @BindView(R.id.contentLayout)
    PercentRelativeLayout contentLayout;
    @BindView(R.id.reportScrollView)
    ReportScrollView reportScrollView;
    @BindView(R.id.scroll_top_tv_item1)
    TextView scrollTopTvItem1;
    @BindView(R.id.scroll_top_tv_item2)
    TextView scrollTopTvItem2;
    @BindView(R.id.scroll_top_tv_item3)
    TextView scrollTopTvItem3;
    @BindView(R.id.scroll_top_tv_item4)
    TextView scrollTopTvItem4;
    @BindView(R.id.scroll_top_tv_item5)
    TextView scrollTopTvItem5;
    @BindView(R.id.scroll_top_tv_item6)
    TextView scrollTopTvItem6;
    @BindView(R.id.scroll_top_tv_item7)
    TextView scrollTopTvItem7;
    @BindView(R.id.scroll_top_tv_item8)
    TextView scrollTopTvItem8;
    @BindView(R.id.scroll_top_tv_item9)
    TextView scrollTopTvItem9;
    @BindView(R.id.scroll_top_tv_item10)
    TextView scrollTopTvItem10;
    @BindView(R.id.scroll_top_tv_item11)
    TextView scrollTopTvItem11;
    @BindView(R.id.scroll_top_tv_item12)
    TextView scrollTopTvItem12;
    @BindView(R.id.scroll_top_tv_item13)
    TextView scrollTopTvItem13;
    @BindView(R.id.scroll_top_tv_item14)
    TextView scrollTopTvItem14;
    @BindView(R.id.scroll_top_tv_item15)
    TextView scrollTopTvItem15;
    @BindView(R.id.scroll_top_tv_item16)
    TextView scrollTopTvItem16;
    @BindView(R.id.scroll_top_tv_item17)
    TextView scrollTopTvItem17;
    @BindView(R.id.scroll_top_tv_item18)
    TextView scrollTopTvItem18;
    @BindView(R.id.scroll_top_tv_item19)
    TextView scrollTopTvItem19;
    @BindView(R.id.scroll_top_tv_item20)
    TextView scrollTopTvItem20;
    @BindView(R.id.scroll_top_tv_item21)
    TextView scrollTopTvItem21;
    @BindView(R.id.scroll_top_tv_item22)
    TextView scrollTopTvItem22;
    @BindView(R.id.scroll_top_tv_item23)
    TextView scrollTopTvItem23;
    @BindView(R.id.scroll_top_tv_item24)
    TextView scrollTopTvItem24;
    @BindView(R.id.scroll_top_tv_item25)
    TextView scrollTopTvItem25;
    @BindView(R.id.scroll_top_tv_item26)
    TextView scrollTopTvItem26;
    @BindView(R.id.scroll_top_tv_item27)
    TextView scrollTopTvItem27;
    @BindView(R.id.scroll_top_tv_item28)
    TextView scrollTopTvItem28;
    @BindView(R.id.scroll_top_tv_item29)
    TextView scrollTopTvItem29;
    @BindView(R.id.scroll_top_tv_item30)
    TextView scrollTopTvItem30;
    @BindView(R.id.scroll_top_tv_item31)
    TextView scrollTopTvItem31;
    @BindView(R.id.scroll_top_tv_item32)
    TextView scrollTopTvItem32;
    @BindView(R.id.scroll_top_tv_item33)
    TextView scrollTopTvItem33;
    @BindView(R.id.scroll_top_tv_item34)
    TextView scrollTopTvItem34;
    @BindView(R.id.scroll_top_tv_item35)
    TextView scrollTopTvItem35;
    @BindView(R.id.scroll_top_tv_item36)
    TextView scrollTopTvItem36;
    @BindView(R.id.scroll_top_tv_item37)
    TextView scrollTopTvItem37;
    @BindView(R.id.scroll_top_tv_item38)
    TextView scrollTopTvItem38;
    @BindView(R.id.scroll_top_tv_item39)
    TextView scrollTopTvItem39;
    @BindView(R.id.scroll_top_tv_item40)
    TextView scrollTopTvItem40;
    @BindView(R.id.scroll_top_tv_item41)
    TextView scrollTopTvItem41;
    @BindView(R.id.scroll_top_tv_item42)
    TextView scrollTopTvItem42;
    @BindView(R.id.scroll_top_tv_item43)
    TextView scrollTopTvItem43;
    @BindView(R.id.scroll_top_tv_item44)
    TextView scrollTopTvItem44;
    @BindView(R.id.scroll_top_tv_item45)
    TextView scrollTopTvItem45;
    @BindView(R.id.scroll_top_tv_item46)
    TextView scrollTopTvItem46;
    @BindView(R.id.scroll_top_tv_item47)
    TextView scrollTopTvItem47;
    @BindView(R.id.scroll_top_tv_item48)
    TextView scrollTopTvItem48;
    @BindView(R.id.scroll_top_tv_item49)
    TextView scrollTopTvItem49;
    @BindView(R.id.ReportSyncHorizontalScrollViewVisibility)
    ReportSyncHorizontalScrollView ReportSyncHorizontalScrollViewVisibility;
    @BindView(R.id.titleLayoutVisibile)
    LinearLayout titleLayoutVisibile;
    @BindView(R.id.common_swipe_refresh)
    SwipeRefreshLayout commonSwipeRefresh;
    @BindView(R.id.progressActivity)
    ProgressActivity progressActivity;

}
