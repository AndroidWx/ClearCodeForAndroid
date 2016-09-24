package com.joye.hk6.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by xiang on 16/5/17.
 */
public class ReportScrollView extends ScrollView {
    private OnScrollListener onScrollListener;

    public ReportScrollView(Context context) {
        super(context);
    }

    public ReportScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ReportScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 设置滚动接口
     *
     * @param onScrollListener
     */
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {//滑动改变就会实时调用
        super.onScrollChanged(l, t, oldl, oldt);
        if (onScrollListener != null) {
            onScrollListener.onScroll(l,t,oldl,oldt);
        }
    }


    /**
     * 滚动的回调接口
     */
    public interface OnScrollListener {
        /**
         * 回调方法， 返回MyScrollView滑动的Y方向距离
         *
         * @param scrollY 、
         */
        void onScroll(int l, int t, int oldl, int oldt);
    }
}
