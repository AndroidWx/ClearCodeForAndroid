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
import com.joye.hk6domain.vo.Modular7Vo;
import com.joye.layouts.BorderTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:合数大小
 */
public class Modular7Adapter extends UpdateItemRecyclerViewAdapter<Modular7Vo> {




    public Modular7Adapter(Context context) {
        super(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HeadTwosItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_modular7, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((HeadTwosItemViewHolder) holder).setViewValue(getDatas().get(position));
    }

    @Override
    public void updateItems(List<Modular7Vo> source, boolean animated) {
        datas.clear();
        datas.addAll(source);
        notifyDataSetChanged();
    }

    public static class HeadTwosItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.report_left_expect)
        BorderTextView reportLeftExpect;
        @BindView(R.id.report_left_opencode)
        BorderTextView reportLeftOpencode;
        @BindView(R.id.report_left_modular_7_0)
        BorderTextView reportLeftModular70;
        @BindView(R.id.report_left_modular_7_1)
        BorderTextView reportLeftModular71;
        @BindView(R.id.report_left_modular_7_2)
        BorderTextView reportLeftModular72;
        @BindView(R.id.report_left_modular_7_3)
        BorderTextView reportLeftModular73;
        @BindView(R.id.report_left_modular_7_4)
        BorderTextView reportLeftModular74;
        @BindView(R.id.report_left_modular_7_5)
        BorderTextView reportLeftModular75;
        @BindView(R.id.report_left_modular_7_6)
        BorderTextView reportLeftModular76;
        
        public HeadTwosItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setViewValue(Modular7Vo vo) {
            reportLeftExpect.setText(vo.getExpect());
            reportLeftOpencode.setText(Html.fromHtml("<font color='red'>" + vo.getOpenCode() + "</font>"));
            Drawable bigDrawable;
            if (vo.M0 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular70.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular70.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.M0Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular70.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular70.setText(vo.M0 + "");
            }

            if (vo.M1 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular71.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular71.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.M1Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular71.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular71.setText(vo.M1 + "");
            }
            if (vo.M2 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular72.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular72.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.M2Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular72.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular72.setText(vo.M2 + "");
            }
            if (vo.M3 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular73.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular73.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.M3Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular73.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular73.setText(vo.M3 + "");
            }

            if (vo.M4 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular74.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular74.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.M4Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular74.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular74.setText(vo.M4 + "");
            }

            if (vo.M5 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular75.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular75.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.M5Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular75.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular75.setText(vo.M5 + "");
            }
            if (vo.M6 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular76.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular76.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.M6Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular76.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular76.setText(vo.M6 + "");
            }

        }
    }

}
