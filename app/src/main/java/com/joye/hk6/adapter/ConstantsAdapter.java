package com.joye.hk6.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.joye.hk6.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/27.
 * 304622254@qq.com
 * Remeark:
 */

public class ConstantsAdapter extends AnimalUpdateItemRecyclerViewAdapter<ConstantsAdapter.ConstantsItem> {

    @BindView(R.id.name)
    TextView name;


    public ConstantsAdapter(Context ctx) {
        super(ctx);
    }

    private View.OnClickListener onClickListener=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            LogUtils.v(v.getTag());
            Integer integer= (Integer) v.getTag();
            if(mRecyclerViewItemListener!=null){
                mRecyclerViewItemListener.onRecyclerViewItemClick(getDatas().get(integer));

            }
        }
    };
    @Override
    public  ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder= new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_constants, parent, false));
        holder.cardView.setOnClickListener(onClickListener);
        holder.name.setOnClickListener(onClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        runEnterAnimation(holder.itemView, position);
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.setEntity(getDatas().get(position));
        holder1.cardView.setTag(position);
        ((ViewHolder) holder).name.setTag(position);
    }


    public   class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.itemView)
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setEntity(final ConstantsItem constantsItem) {
            name.setText(constantsItem.getName());
        }
    }

    public static class ConstantsItem{
        public int  name;
        public Class<?> className;

        public ConstantsItem(int name, Class<?> className) {
                this.name = name;
                this.className = className;
        }

        public int getName() {
            return name;
        }

        public Class<?> getClassName() {
            return className;
        }
    }

}
