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
import com.joye.hk6domain.constants.HeadAge;
import com.joye.hk6domain.vo.HeadAgeVo;
import com.joye.layouts.BorderTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:
 */
public class HeadAgeAdapter extends UpdateItemRecyclerViewAdapter<HeadAgeVo> {



    public HeadAgeAdapter(Context context) {
        super(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HeageAgeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_headage, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((HeageAgeViewHolder) holder).setViewValue(getDatas().get(position));
    }

    @Override
    public void updateItems(List<HeadAgeVo> source, boolean animated) {
        datas.clear();
        datas.addAll(source);
        notifyDataSetChanged();
    }

    public static class HeageAgeViewHolder extends BaseRecyclerViewHolder<HeadAgeVo> {

        @BindView(R.id.report_left_expect)
        BorderTextView reportLeftExpect;
        @BindView(R.id.report_left_opencode)
        BorderTextView reportLeftOpencode;
        @BindView(R.id.report_left_headage0)
        BorderTextView reportLeftHeadage0;
        @BindView(R.id.report_left_headage1)
        BorderTextView reportLeftHeadage1;
        @BindView(R.id.report_left_headage2)
        BorderTextView reportLeftHeadage2;
        @BindView(R.id.report_left_headage3)
        BorderTextView reportLeftHeadage3;
        @BindView(R.id.report_left_headage4)
        BorderTextView reportLeftHeadage4;


        public HeageAgeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        @Override
        public void setViewValue(HeadAgeVo vo) {
            reportLeftExpect.setText(vo.getExpect());
            reportLeftOpencode.setText(Html.fromHtml("<font color='red'>" + vo.getOpenCode() + "</font>"));
            Drawable bigDrawable;
            if (vo.headage0 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadage0.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadage0.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.headage0Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadage0.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadage0.setText(vo.headage0 + "");
            }

            if (vo.headage1 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadage1.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadage1.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.headageVigilant(HeadAge.Headage1), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadage1.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadage1.setText(vo.headage1 + "");
            }


            if (vo.headage2 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadage2.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadage2.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.headageVigilant(HeadAge.Headage2), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadage2.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadage2.setText(vo.headage2 + "");
            }


            if (vo.headage3 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadage3.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadage3.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.headageVigilant(HeadAge.Headage3), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadage3.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadage3.setText(vo.headage3 + "");
            }

            if (vo.headage4 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadage4.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadage4.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.headageVigilant(HeadAge.Headage4), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftHeadage4.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftHeadage4.setText(vo.headage4 + "");
            }

        }
    }

}
