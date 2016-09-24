package com.joye.hk6.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/23.
 * 304622254@qq.com
 * Remeark:
 */

public class ReportBaseAdapter<T> extends ArrayAdapter<T> {
    public ReportBaseAdapter(Context context, int resource) {
        super(context, resource);
    }

    public ReportBaseAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public ReportBaseAdapter(Context context, int resource, T[] objects) {
        super(context, resource, objects);
    }

    public ReportBaseAdapter(Context context, int resource, int textViewResourceId, T[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public ReportBaseAdapter(Context context, int resource, List<T> objects) {
        super(context, resource, objects);
    }

    public ReportBaseAdapter(Context context, int resource, int textViewResourceId, List<T> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
