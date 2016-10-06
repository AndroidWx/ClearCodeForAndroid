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
import com.joye.hk6domain.vo.CompositeMantissaVo;
import com.joye.layouts.BorderTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:合数大小
 */
public class CompositeMantissaAdapter extends UpdateItemRecyclerViewAdapter<CompositeMantissaVo> {

    public CompositeMantissaAdapter(Context context) {
        super(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SizeItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_composite_mantissa, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SizeItemViewHolder) holder).setViewValue(getDatas().get(position));
    }

    @Override
    public void updateItems(List<CompositeMantissaVo> source, boolean animated) {
        datas.clear();
        datas.addAll(source);
        notifyDataSetChanged();
    }

    public static class SizeItemViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.report_left_expect)
        BorderTextView reportLeftExpect;
        @BindView(R.id.report_left_opencode)
        BorderTextView reportLeftOpencode;
        @BindView(R.id.report_left_composite_0)
        BorderTextView reportLeftComposite0;
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

        public SizeItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setViewValue(CompositeMantissaVo vo) {
            reportLeftExpect.setText(vo.getExpect());
            reportLeftOpencode.setText(Html.fromHtml("<font color='red'>" + vo.getOpenCode() + "</font>"));
            Drawable bigDrawable;
            if (vo.composite0 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite0.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite0.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.composite0Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftComposite0.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftComposite0.setText(vo.composite0 + "");
            }

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


        }
    }

}
