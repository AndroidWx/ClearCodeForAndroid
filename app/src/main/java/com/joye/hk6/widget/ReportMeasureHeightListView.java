package com.joye.hk6.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by xiang on 16/5/16.
 */
public class ReportMeasureHeightListView extends ListView {
    public ReportMeasureHeightListView(Context context) {
        super(context);
    }

    public ReportMeasureHeightListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ReportMeasureHeightListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    /**
     * 重写该方法，ScrollView中嵌套ListView
     * 达到使ListView自适应高度
     */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

}
