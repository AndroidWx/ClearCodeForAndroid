package com.joye.hk6.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joye.hk6.R;
import com.joye.hk6.util.VigilantHelp;
import com.joye.hk6domain.vo.Modular3Vo;
import com.joye.layouts.BorderTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:合数大小
 */
public class Modular3Adapter extends UpdateItemRecyclerViewAdapter<Modular3Vo> {


 

    public Modular3Adapter(Context context) {
        super(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HeadTwosItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_modular3, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((HeadTwosItemViewHolder) holder).setViewValue(getDatas().get(position));
    }

    @Override
    public void updateItems(List<Modular3Vo> source, boolean animated) {
        datas.clear();
        datas.addAll(source);
        notifyDataSetChanged();
    }

    public static class HeadTwosItemViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.report_left_expect)
        BorderTextView reportLeftExpect;
        @BindView(R.id.report_left_opencode)
        BorderTextView reportLeftOpencode;
        @BindView(R.id.report_left_modular_3_0)
        BorderTextView reportLeftModular30;
        @BindView(R.id.report_left_modular_3_1)
        BorderTextView reportLeftModular31;
        @BindView(R.id.report_left_modular_3_2)
        BorderTextView reportLeftModular32;

        public HeadTwosItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setViewValue(Modular3Vo vo) {
            reportLeftExpect.setText(vo.getExpect());
            reportLeftOpencode.setText(Html.fromHtml("<font color='red'>" + vo.getOpenCode() + "</font>"));
            Drawable bigDrawable;
            if (vo.M0 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular30.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular30.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.M0Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular30.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular30.setText(vo.M0 + "");
            }

            if (vo.M1 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular31.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular31.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.M1Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular31.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular31.setText(vo.M1 + "");
            }
            if (vo.M2 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular32.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular32.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.M2Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular32.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular32.setText(vo.M2 + "");
            }
             
        }
    }

}
