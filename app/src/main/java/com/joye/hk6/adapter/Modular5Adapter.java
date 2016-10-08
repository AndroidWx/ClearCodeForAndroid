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
import com.joye.hk6domain.vo.Modular5Vo;
import com.joye.layouts.BorderTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:合数大小
 */
public class Modular5Adapter extends UpdateItemRecyclerViewAdapter<Modular5Vo> {

    public Modular5Adapter(Context context) {
        super(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HeadTwosItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_modular5, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((HeadTwosItemViewHolder) holder).setViewValue(getDatas().get(position));
    }

    @Override
    public void updateItems(List<Modular5Vo> source, boolean animated) {
        datas.clear();
        datas.addAll(source);
        notifyDataSetChanged();
    }

    public static class HeadTwosItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.report_left_expect)
        BorderTextView reportLeftExpect;
        @BindView(R.id.report_left_opencode)
        BorderTextView reportLeftOpencode;
        @BindView(R.id.report_left_modular_5_0)
        BorderTextView reportLeftModular50;
        @BindView(R.id.report_left_modular_5_1)
        BorderTextView reportLeftModular51;
        @BindView(R.id.report_left_modular_5_2)
        BorderTextView reportLeftModular52;
        @BindView(R.id.report_left_modular_5_3)
        BorderTextView reportLeftModular53;
        @BindView(R.id.report_left_modular_5_4)
        BorderTextView reportLeftModular54;


        public HeadTwosItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setViewValue(Modular5Vo vo) {
            reportLeftExpect.setText(vo.getExpect());
            reportLeftOpencode.setText(Html.fromHtml("<font color='red'>" + vo.getOpenCode() + "</font>"));
            Drawable bigDrawable;
            if (vo.M0 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular50.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular50.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.M0Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular50.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular50.setText(vo.M0 + "");
            }

            if (vo.M1 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular51.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular51.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.M1Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular51.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular51.setText(vo.M1 + "");
            }
            if (vo.M2 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular52.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular52.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.M2Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular52.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular52.setText(vo.M2 + "");
            }
            if (vo.M3 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular53.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular53.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.M3Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular53.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular53.setText(vo.M3 + "");
            }

            if (vo.M4 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular54.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular54.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.M4Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftModular54.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftModular54.setText(vo.M4 + "");
            }
        }
    }

}
