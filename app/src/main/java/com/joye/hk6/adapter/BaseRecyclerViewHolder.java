package com.joye.hk6.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by xiang on 16/9/30.
 */

public abstract class BaseRecyclerViewHolder<T> extends RecyclerView.ViewHolder {
    public BaseRecyclerViewHolder(View itemView) {
        super(itemView);
    }
    abstract void setViewValue(T t);
}
