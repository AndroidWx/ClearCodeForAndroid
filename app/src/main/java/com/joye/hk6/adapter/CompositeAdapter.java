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
import com.joye.hk6domain.vo.CompositeVo;
import com.joye.layouts.BorderTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:
 */
public class CompositeAdapter extends UpdateItemRecyclerViewAdapter<CompositeVo> {




    public CompositeAdapter(Context context) {
        super(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CompositeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_composite, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CompositeViewHolder) holder).setViewValue(getDatas().get(position));
    }

    @Override
    public void updateItems(List<CompositeVo> source, boolean animated) {
        datas.clear();
        datas.addAll(source);
        notifyDataSetChanged();
    }

    public static class CompositeViewHolder extends BaseRecyclerViewHolder<CompositeVo> {

        @BindView(R.id.report_left_expect)
        BorderTextView reportLeftExpect;
        @BindView(R.id.report_left_opencode)
        BorderTextView reportLeftOpencode;
        @BindView(R.id.report_left_composite_1)
        BorderTextView reportLeftComposite1;
        @BindView(R.id.report_left_composite_2)
        BorderTextView reportLeftComposite2;
        @BindView(R.id.report_left_composite_3)
        BorderTextView reportLeftComposite3;
        @BindView(R.id.report_left_composite_4)
        BorderTextView reportLeftComposite4;
        @BindView(R.id.report_left_composite_5)
        BorderTextView reportLeftComposite5;
        @BindView(R.id.report_left_composite_6)
        BorderTextView reportLeftComposite6;
        @BindView(R.id.report_left_composite_7)
        BorderTextView reportLeftComposite7;
        @BindView(R.id.report_left_composite_8)
        BorderTextView reportLeftComposite8;
        @BindView(R.id.report_left_composite_9)
        BorderTextView reportLeftComposite9;
        @BindView(R.id.report_left_composite_10)
        BorderTextView reportLeftComposite10;
        @BindView(R.id.report_left_composite_11)
        BorderTextView reportLeftComposite11;
        @BindView(R.id.report_left_composite_12)
        BorderTextView reportLeftComposite12;
        @BindView(R.id.report_left_composite_13)
        BorderTextView reportLeftComposite13;


        public CompositeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setViewValue(CompositeVo vo) {
            reportLeftExpect.setText(vo.getExpect());
            reportLeftOpencode.setText(Html.fromHtml("<font color='red'>" + vo.getOpenCode() + "</font>"));
            Drawable bigDrawable;
            if (vo.composite1 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite1.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite1.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.composite1Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite1.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite1.setText(vo.composite1 + "");
            }

            if (vo.composite2 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite2.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite2.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.composite2Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite2.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite2.setText(vo.composite2 + "");
            }

            if (vo.composite3 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite3.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite3.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.composite3Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite3.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite3.setText(vo.composite3 + "");
            }

            if (vo.composite4 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite4.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite4.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.composite4Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite4.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite4.setText(vo.composite4 + "");
            }
            if (vo.composite5 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite5.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite5.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.composite5Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite5.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite5.setText(vo.composite5 + "");
            }

            if (vo.composite6 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite6.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite6.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.composite6Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite6.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite6.setText(vo.composite6 + "");
            }

            if (vo.composite7 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite7.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite7.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.composite7Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite7.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite7.setText(vo.composite7 + "");
            }

            if (vo.composite8 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite8.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite8.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.composite8Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite8.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite8.setText(vo.composite8 + "");
            }
            if (vo.composite9 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite9.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite9.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.composite9Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite9.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite9.setText(vo.composite9 + "");
            }
            if (vo.composite10 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite10.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite10.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.composite10Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite10.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite10.setText(vo.composite10 + "");
            }
            if (vo.composite11 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite11.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite11.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.composite11Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite11.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite11.setText(vo.composite11 + "");
            }

            if (vo.composite12 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite12.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite12.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.composite12Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite12.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite12.setText(vo.composite12 + "");
            }

            if (vo.composite13 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite13.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite13.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.composite13Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite13.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite13.setText(vo.composite13 + "");
            }

        }
    }

}
