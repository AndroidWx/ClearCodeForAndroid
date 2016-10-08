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
import com.joye.hk6domain.vo.HeadTwosVo;
import com.joye.layouts.BorderTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:合数大小
 */
public class HeadTwosAdapter extends UpdateItemRecyclerViewAdapter<HeadTwosVo> {



    public HeadTwosAdapter(Context context) {
        super(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HeadTwosItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_headtows, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((HeadTwosItemViewHolder) holder).setViewValue(getDatas().get(position));
    }

    @Override
    public void updateItems(List<HeadTwosVo> source, boolean animated) {
        datas.clear();
        datas.addAll(source);
        notifyDataSetChanged();
    }

    public static class HeadTwosItemViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.report_left_expect)
        BorderTextView reportLeftExpect;
        @BindView(R.id.report_left_opencode)
        BorderTextView reportLeftOpencode;
        @BindView(R.id.report_left_headOdd0)
        BorderTextView reportLeftHeadOdd0;
        @BindView(R.id.report_left_headOdd1)
        BorderTextView reportLeftHeadOdd1;
        @BindView(R.id.report_left_headOdd2)
        BorderTextView reportLeftHeadOdd2;
        @BindView(R.id.report_left_headOdd3)
        BorderTextView reportLeftHeadOdd3;
        @BindView(R.id.report_left_headOdd4)
        BorderTextView reportLeftHeadOdd4;
        @BindView(R.id.report_left_headEven0)
        BorderTextView reportLeftHeadEven0;
        @BindView(R.id.report_left_headEven1)
        BorderTextView reportLeftHeadEven1;
        @BindView(R.id.report_left_headEven2)
        BorderTextView reportLeftHeadEven2;
        @BindView(R.id.report_left_headEven3)
        BorderTextView reportLeftHeadEven3;
        @BindView(R.id.report_left_headEven4)
        BorderTextView reportLeftHeadEven4;

        public HeadTwosItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setViewValue(HeadTwosVo vo) {
            reportLeftExpect.setText(vo.getExpect());
            reportLeftOpencode.setText(Html.fromHtml("<font color='red'>" + vo.getOpenCode() + "</font>"));
            Drawable bigDrawable;
            if (vo.HeadOdd0 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadOdd0.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadOdd0.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.headOdd0Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadOdd0.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadOdd0.setText(vo.HeadOdd0 + "");
            }

            if (vo.HeadOdd1 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadOdd1.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadOdd1.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.headOdd1Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadOdd1.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadOdd1.setText(vo.HeadOdd1 + "");
            }
            if (vo.HeadOdd2 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadOdd2.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadOdd2.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.headOdd2Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadOdd2.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadOdd2.setText(vo.HeadOdd2 + "");
            }
            if (vo.HeadOdd3 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadOdd3.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadOdd3.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.headOdd3Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadOdd3.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadOdd3.setText(vo.HeadOdd3 + "");
            }

            if (vo.HeadOdd4 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadOdd4.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadOdd4.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.headOdd4Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadOdd4.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadOdd4.setText(vo.HeadOdd4 + "");
            }

            if (vo.HeadEven0 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadEven0.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadEven0.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.headEven0Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadEven0.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadEven0.setText(vo.HeadEven0 + "");
            }
            if (vo.HeadEven1 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadEven1.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadEven1.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.headEven1Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadEven1.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadEven1.setText(vo.HeadEven1 + "");
            }
            if (vo.HeadEven2 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadEven2.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadEven2.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.headEven2Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadEven2.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadEven2.setText(vo.HeadEven2 + "");
            }
            if (vo.HeadEven3 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadEven3.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadEven3.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.headEven3Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadEven3.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadEven3.setText(vo.HeadEven3 + "");
            }
            if (vo.HeadEven4 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadEven4.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadEven4.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.headEven4Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadEven4.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadEven4.setText(vo.HeadEven4 + "");
            }
        }
    }

}
