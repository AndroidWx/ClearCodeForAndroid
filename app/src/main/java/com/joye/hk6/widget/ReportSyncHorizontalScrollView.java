package com.joye.hk6.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;

/**
 * Created by xiang on 16/5/16.
 */
public class ReportSyncHorizontalScrollView extends HorizontalScrollView {
    public ReportSyncHorizontalScrollView(Context context) {
        super(context);
    }

    public ReportSyncHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ReportSyncHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    /**
     * 产生联动的view对象
     */
    private View mSyncView,mSyncView1;

    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        //让需要联动的view也设置相同的滚动
        if(mSyncView != null) {
            mSyncView.scrollTo(l, t);
        }
        if(mSyncView1!=null){
            mSyncView1.scrollTo(l, t);
        }
    }

    public View getmSyncView() {
        return mSyncView;
    }

    public void setmSyncView(View mSyncView) {
        this.mSyncView = mSyncView;
    }

    public void setmSyncView1(View mSyncView1) {
        this.mSyncView1 = mSyncView1;
    }
}
