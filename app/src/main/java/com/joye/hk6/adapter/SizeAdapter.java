package com.joye.hk6.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joye.hk6.R;
import com.joye.hk6domain.vo.SizeVo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:
 */
public class SizeAdapter extends UpdateItemRecyclerViewAdapter<SizeVo> {


    public SizeAdapter(Context context) {
        super(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SizeItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_size, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SizeItemViewHolder) holder).setViewValue(getDatas().get(position));
    }

    @Override
    public void updateItems(List<SizeVo> source, boolean animated) {
        datas.clear();
        datas.addAll(source);
        notifyDataSetChanged();
    }

    public static class SizeItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.report_left_expect)
        TextView reportLeftExpect;
        @BindView(R.id.report_left_opencode)
        TextView reportLeftOpencode;
        @BindView(R.id.report_left_Big)
        TextView reportLeftBig;
        @BindView(R.id.report_left_Small)
        TextView reportLeftSmall;
        public SizeItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setViewValue(SizeVo vo) {
            reportLeftExpect.setText(vo.getExpect());
            reportLeftOpencode.setText(vo.getOpenCode() + "");
            reportLeftBig.setText(vo.Big==0?"大":vo.Big+"");
            reportLeftSmall.setText(vo.Small==0?"小":vo.Small+"");
        }
    }

}
