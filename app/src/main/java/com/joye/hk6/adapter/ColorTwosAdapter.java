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
import com.joye.hk6domain.vo.ColorTwosVo;
import com.joye.layouts.BorderTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:
 */
public class ColorTwosAdapter extends UpdateItemRecyclerViewAdapter<ColorTwosVo> {




    public ColorTwosAdapter(Context context) {
        super(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ColorTwosVoItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_colortwos, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ColorTwosVoItemViewHolder) holder).setViewValue(getDatas().get(position));
    }

    @Override
    public void updateItems(List<ColorTwosVo> source, boolean animated) {
        datas.clear();
        datas.addAll(source);
        notifyDataSetChanged();
    }

    public static class ColorTwosVoItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.report_left_expect)
        BorderTextView reportLeftExpect;
        @BindView(R.id.report_left_opencode)
        BorderTextView reportLeftOpencode;
        @BindView(R.id.report_left_redEven)
        BorderTextView reportLeftRedEven;
        @BindView(R.id.report_left_redOdd)
        BorderTextView reportLeftRedOdd;
        @BindView(R.id.report_left_blueEven)
        BorderTextView reportLeftBlueEven;
        @BindView(R.id.report_left_blueOdd)
        BorderTextView reportLeftBlueOdd;
        @BindView(R.id.report_left_greenEven)
        BorderTextView reportLeftGreenEven;
        @BindView(R.id.report_left_greenOdd)
        BorderTextView reportLeftGreenOdd;
        public ColorTwosVoItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setViewValue(ColorTwosVo vo) {
            reportLeftExpect.setText(vo.getExpect());
            reportLeftOpencode.setText(Html.fromHtml("<font color='red'>" + vo.getOpenCode() + "</font>"));
            Drawable bigDrawable;
            if (vo.redEven == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftRedEven.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftRedEven.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.redEvenVigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftRedEven.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftRedEven.setText(vo.redEven + "");
            }

            if (vo.redOdd == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftRedOdd.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftRedOdd.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.redOddVigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftRedOdd.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftRedOdd.setText(vo.redOdd + "");
            }


            if (vo.blueEven == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftBlueEven.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftBlueEven.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.blueEvenVigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftBlueEven.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftBlueEven.setText(vo.blueEven + "");
            }


            if (vo.blueOdd == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftBlueOdd.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftBlueOdd.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.blueOddVigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftBlueOdd.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftBlueOdd.setText(vo.blueOdd + "");
            }

            if (vo.greenEven == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftGreenEven.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftGreenEven.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.greenEvenVigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftGreenEven.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftGreenEven.setText(vo.greenEven + "");
            }

            if (vo.greenOdd == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftGreenOdd.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftGreenOdd.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.greenOddVigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftGreenOdd.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftGreenOdd.setText(vo.greenOdd + "");
            }



        }
    }

}
