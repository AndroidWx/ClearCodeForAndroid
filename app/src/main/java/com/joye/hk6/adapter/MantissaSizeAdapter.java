package com.joye.hk6.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joye.hk6.R;
import com.joye.hk6.util.VigilantHelp;
import com.joye.hk6domain.vo.MantissaSizeVo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:尾数大小
 */
public class MantissaSizeAdapter extends UpdateItemRecyclerViewAdapter<MantissaSizeVo> {


    public MantissaSizeAdapter(Context context) {
        super(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SizeItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_mantissasize, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SizeItemViewHolder) holder).setViewValue(getDatas().get(position));
    }

    @Override
    public void updateItems(List<MantissaSizeVo> source, boolean animated) {
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

        public void setViewValue(MantissaSizeVo vo) {
            reportLeftExpect.setText(vo.getExpect());
            reportLeftOpencode.setText(Html.fromHtml("<font color='red'>"+vo.getOpenCode()+"</font>"));
            Drawable bigDrawable;
            if (vo.Big == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftBig.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftBig.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.bigVigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftBig.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftBig.setText(vo.Big + "");
            }

            if (vo.Small == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftSmall.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftSmall.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.smallVigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftSmall.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftSmall.setText(vo.Small + "");
            }

        }
    }

}
