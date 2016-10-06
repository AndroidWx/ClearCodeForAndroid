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
import com.joye.hk6domain.constants.Mantissa;
import com.joye.hk6domain.vo.MantissaVo;
import com.joye.layouts.BorderTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:尾数
 */
public class MantissaAdapter extends UpdateItemRecyclerViewAdapter<MantissaVo> {





    public MantissaAdapter(Context context) {
        super(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RegionItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_mantissa, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RegionItemViewHolder) holder).setViewValue(getDatas().get(position));
    }

    @Override
    public void updateItems(List<MantissaVo> source, boolean animated) {
        datas.clear();
        datas.addAll(source);
        notifyDataSetChanged();
    }

    public static class RegionItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.report_left_expect)
        BorderTextView reportLeftExpect;
        @BindView(R.id.report_left_opencode)
        BorderTextView reportLeftOpencode;
        @BindView(R.id.report_left_mantissa0)
        BorderTextView reportLeftMantissa0;
        @BindView(R.id.report_left_mantissa1)
        BorderTextView reportLeftMantissa1;
        @BindView(R.id.report_left_mantissa2)
        BorderTextView reportLeftMantissa2;
        @BindView(R.id.report_left_mantissa3)
        BorderTextView reportLeftMantissa3;
        @BindView(R.id.report_left_mantissa4)
        BorderTextView reportLeftMantissa4;
        @BindView(R.id.report_left_mantissa5)
        BorderTextView reportLeftMantissa5;
        @BindView(R.id.report_left_mantissa6)
        BorderTextView reportLeftMantissa6;
        @BindView(R.id.report_left_mantissa7)
        BorderTextView reportLeftMantissa7;
        @BindView(R.id.report_left_mantissa8)
        BorderTextView reportLeftMantissa8;
        @BindView(R.id.report_left_mantissa9)
        BorderTextView reportLeftMantissa9;
        public RegionItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setViewValue(MantissaVo vo) {
            reportLeftExpect.setText(vo.getExpect());
            reportLeftOpencode.setText(Html.fromHtml("<font color='red'>" + vo.getOpenCode() + "</font>"));
            Drawable bigDrawable;
            if (vo. Mantissa0 == 0) {
                bigDrawable = reportLeftMantissa0.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftMantissa0.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftMantissa0.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftMantissa0.getResources().getDrawable(VigilantHelp.getDrawable(vo.Mantissa0Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftMantissa0.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftMantissa0.setText(vo.Mantissa0 + "");
            }

            if (vo. Mantissa1 == 0) {
                bigDrawable = reportLeftMantissa1.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftMantissa1.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftMantissa1.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftMantissa1.getResources().getDrawable(VigilantHelp.getDrawable(vo.MantissaVigilant(Mantissa.Mantissa1), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftMantissa1.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftMantissa1.setText(vo.Mantissa1 + "");
            }

            if (vo. Mantissa2 == 0) {
                bigDrawable = reportLeftMantissa2.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftMantissa2.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftMantissa2.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftMantissa2.getResources().getDrawable(VigilantHelp.getDrawable(vo.MantissaVigilant(Mantissa.Mantissa2), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftMantissa2.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftMantissa2.setText(vo.Mantissa2 + "");
            }

            if (vo. Mantissa3 == 0) {
                bigDrawable = reportLeftMantissa3.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftMantissa3.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftMantissa3.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftMantissa3.getResources().getDrawable(VigilantHelp.getDrawable(vo.MantissaVigilant(Mantissa.Mantissa3), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftMantissa3.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftMantissa3.setText(vo.Mantissa3 + "");
            }

            if (vo. Mantissa4 == 0) {
                bigDrawable = reportLeftMantissa4.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftMantissa4.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftMantissa4.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftMantissa4.getResources().getDrawable(VigilantHelp.getDrawable(vo.MantissaVigilant(Mantissa.Mantissa4), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftMantissa4.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftMantissa4.setText(vo.Mantissa4 + "");
            }

            if (vo. Mantissa5 == 0) {
                bigDrawable = reportLeftMantissa5.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftMantissa5.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftMantissa5.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftMantissa5.getResources().getDrawable(VigilantHelp.getDrawable(vo.MantissaVigilant(Mantissa.Mantissa5), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftMantissa5.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftMantissa5.setText(vo.Mantissa5 + "");
            }

            if (vo. Mantissa6 == 0) {
                bigDrawable = reportLeftMantissa6.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftMantissa6.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftMantissa6.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftMantissa6.getResources().getDrawable(VigilantHelp.getDrawable(vo.MantissaVigilant(Mantissa.Mantissa6), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftMantissa6.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftMantissa6.setText(vo.Mantissa6 + "");
            }

            if (vo. Mantissa7 == 0) {
                bigDrawable = reportLeftMantissa7.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftMantissa7.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftMantissa7.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftMantissa7.getResources().getDrawable(VigilantHelp.getDrawable(vo.MantissaVigilant(Mantissa.Mantissa7), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftMantissa7.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftMantissa7.setText(vo.Mantissa7 + "");
            }
            if (vo. Mantissa8 == 0) {
                bigDrawable = reportLeftMantissa8.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftMantissa8.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftMantissa8.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftMantissa8.getResources().getDrawable(VigilantHelp.getDrawable(vo.MantissaVigilant(Mantissa.Mantissa8), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftMantissa8.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftMantissa8.setText(vo.Mantissa8 + "");
            }
            if (vo. Mantissa9 == 0) {
                bigDrawable = reportLeftMantissa9.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftMantissa9.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftMantissa9.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftMantissa8.getResources().getDrawable(VigilantHelp.getDrawable(vo.MantissaVigilant(Mantissa.Mantissa9), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftMantissa9.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftMantissa9.setText(vo.Mantissa9 + "");
            }

        }
    }

}
