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
import com.joye.hk6domain.vo.GateCountVo;
import com.joye.layouts.BorderTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:
 */
public class GateCountAdapter extends UpdateItemRecyclerViewAdapter<GateCountVo> {




    public GateCountAdapter(Context context) {
        super(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GateCountViewHolder(LayoutInflater.from(context).inflate(R.layout.item_gatecount, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((GateCountViewHolder) holder).setViewValue(getDatas().get(position));
    }

    @Override
    public void updateItems(List<GateCountVo> source, boolean animated) {
        datas.clear();
        datas.addAll(source);
        notifyDataSetChanged();
    }

    public static class GateCountViewHolder extends BaseRecyclerViewHolder<GateCountVo> {

        @BindView(R.id.report_left_expect)
        BorderTextView reportLeftExpect;
        @BindView(R.id.report_left_opencode)
        BorderTextView reportLeftOpencode;
        @BindView(R.id.report_left_gateCount1)
        BorderTextView reportLeftGateCount1;
        @BindView(R.id.report_left_gateCount2)
        BorderTextView reportLeftGateCount2;
        @BindView(R.id.report_left_gateCount3)
        BorderTextView reportLeftGateCount3;
        @BindView(R.id.report_left_gateCount4)
        BorderTextView reportLeftGateCount4;
        @BindView(R.id.report_left_gateCount5)
        BorderTextView reportLeftGateCount5;


        public GateCountViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setViewValue(GateCountVo vo) {
            reportLeftExpect.setText(vo.getExpect());
            reportLeftOpencode.setText(Html.fromHtml("<font color='red'>" + vo.getOpenCode() + "</font>"));
            Drawable bigDrawable;
            if (vo.gateCount1 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftGateCount1.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftGateCount1.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.gateCount1Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftGateCount1.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftGateCount1.setText(vo.gateCount1 + "");
            }

            if (vo.gateCount2 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftGateCount2.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftGateCount2.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.gateCount2Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftGateCount2.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftGateCount2.setText(vo.gateCount2 + "");
            }

            if (vo.gateCount3 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftGateCount3.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftGateCount3.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.gateCount3Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftGateCount3.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftGateCount3.setText(vo.gateCount3 + "");
            }


            if (vo.gateCount4 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftGateCount4.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftGateCount4.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.gateCount4Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftGateCount4.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftGateCount4.setText(vo.gateCount4 + "");
            }
            if (vo.gateCount5 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftGateCount5.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftGateCount5.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.gateCount5Vigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftGateCount5.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftGateCount5.setText(vo.gateCount5 + "");
            }
        }
    }

}
