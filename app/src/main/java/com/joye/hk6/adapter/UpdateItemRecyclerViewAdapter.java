package com.joye.hk6.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiang on 15/9/21.
 * title: 支持更新item adapter 抽象者
 * Remarks:
 */
public abstract class UpdateItemRecyclerViewAdapter<T> extends RecyclerView.Adapter<ViewHolder> implements  IUpdateItem<T>{
    protected Context context;
    protected List<T> datas;
     private UpdateItemRecyclerViewAdapter(){
    }

    //nothing ;
    protected UpdateItemRecyclerViewAdapter(Context ctx){
        this.context=ctx;
        datas=new ArrayList<T>();
    }

    public List<T> getDatas(){
        return datas;
    }
    @Override
    public final int getItemCount() {
        return datas.size();
    }

}
