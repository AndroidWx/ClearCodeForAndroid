package com.joye.hk6.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joye.hk6.R;
import com.joye.hk6domain.vo.ChineseZodiacVo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/24.
 * 304622254@qq.com
 * Remeark:
 */

public class ChineseZodiacProbilityAdapter extends UpdateItemRecyclerViewAdapter<ChineseZodiacVo> {

    public ChineseZodiacProbilityAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChineseZodiacProbilityItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_report_left, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ChineseZodiacProbilityItemViewHolder) holder).setViewValue(getDatas().get(position));
    }

    @Override
    public void updateItems(List<ChineseZodiacVo> source, boolean animated) {
        datas.clear();
        datas.addAll(source);
        notifyDataSetChanged();
    }

    public static class ChineseZodiacProbilityItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.report_left_expect)
        TextView reportLeftExpect;
        @BindView(R.id.report_left_opencode)
        TextView reportLeftOpencode;
        public ChineseZodiacProbilityItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        public void setViewValue(ChineseZodiacVo vo){
            reportLeftExpect.setText(vo.getExpect());
          reportLeftOpencode.setText(vo.getOpenCode()+"");
        }
    }


}
