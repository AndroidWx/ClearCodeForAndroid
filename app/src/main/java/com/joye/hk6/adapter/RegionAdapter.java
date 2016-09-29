package com.joye.hk6.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joye.hk6.R;
import com.joye.hk6.util.VigilantHelp;
import com.joye.hk6domain.constants.Region;
import com.joye.hk6domain.vo.RegionVo;
import com.joye.layouts.BorderTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:
 */
public class RegionAdapter extends UpdateItemRecyclerViewAdapter<RegionVo> {




    public RegionAdapter(Context context) {
        super(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RegionItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_region, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RegionItemViewHolder) holder).setViewValue(getDatas().get(position));
    }

    @Override
    public void updateItems(List<RegionVo> source, boolean animated) {
        datas.clear();
        datas.addAll(source);
        notifyDataSetChanged();
    }

    public static class RegionItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.report_left_expect)
        BorderTextView reportLeftExpect;
        @BindView(R.id.report_left_opencode)
        BorderTextView reportLeftOpencode;
        @BindView(R.id.report_left_Region1)
        BorderTextView reportLeftRegion1;
        @BindView(R.id.report_left_Region2)
        BorderTextView reportLeftRegion2;
        @BindView(R.id.report_left_Region3)
        BorderTextView reportLeftRegion3;
        @BindView(R.id.report_left_Region4)
        BorderTextView reportLeftRegion4;
        @BindView(R.id.report_left_Region5)
        BorderTextView reportLeftRegion5;
        @BindView(R.id.report_left_Region6)
        BorderTextView reportLeftRegion6;
        @BindView(R.id.report_left_Region7)
        BorderTextView reportLeftRegion7;

        public RegionItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setViewValue(RegionVo vo) {
            reportLeftExpect.setText(vo.getExpect());
            reportLeftOpencode.setText(vo.getOpenCode() + "");
            Drawable bigDrawable ;
            if(vo.One==0){
                bigDrawable = reportLeftRegion1.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftRegion1.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftRegion1.setText(Html.fromHtml("<font color='red'>特码</font>"));
            }else{
                bigDrawable = reportLeftRegion1.getResources().getDrawable(VigilantHelp.getDrawable(vo.regionVigilant(Region.One),false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftRegion1.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftRegion1.setText(vo.One+"");
            }

            if(vo.Two==0){
                bigDrawable = reportLeftRegion1.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftRegion2.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftRegion2.setText(Html.fromHtml("<font color='red'>特码</font>"));
            }else{
                bigDrawable = reportLeftRegion1.getResources().getDrawable(VigilantHelp.getDrawable(vo.regionVigilant(Region.Two),false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftRegion2.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftRegion2.setText(vo.Two+"");
            }


            if(vo.Three==0){
                bigDrawable = reportLeftRegion1.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftRegion3.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftRegion3.setText(Html.fromHtml("<font color='red'>特码</font>"));
            }else{
                bigDrawable = reportLeftRegion1.getResources().getDrawable(VigilantHelp.getDrawable(vo.regionVigilant(Region.Three),false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftRegion3.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftRegion3.setText(vo.Three+"");
            }


            if(vo.Four==0){
                bigDrawable = reportLeftRegion1.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftRegion4.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftRegion4.setText(Html.fromHtml("<font color='red'>特码</font>"));
            }else{
                bigDrawable = reportLeftRegion1.getResources().getDrawable(VigilantHelp.getDrawable(vo.regionVigilant(Region.Four),false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftRegion4.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftRegion4.setText(vo.Four+"");
            }

            if(vo.Five==0){
                bigDrawable = reportLeftRegion1.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftRegion5.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftRegion5.setText(Html.fromHtml("<font color='red'>特码</font>"));
            }else{
                bigDrawable = reportLeftRegion1.getResources().getDrawable(VigilantHelp.getDrawable(vo.regionVigilant(Region.Five),false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftRegion5.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftRegion5.setText(vo.Five+"");
            }

            if(vo.Sex==0){
                bigDrawable = reportLeftRegion1.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftRegion6.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftRegion6.setText(Html.fromHtml("<font color='red'>特码</font>"));
            }else{
                bigDrawable = reportLeftRegion1.getResources().getDrawable(VigilantHelp.getDrawable(vo.regionVigilant(Region.Six),false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftRegion6.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftRegion6.setText(vo.Sex+"");
            }

            if(vo.Seven==0){
                bigDrawable = reportLeftRegion1.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftRegion7.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftRegion7.setText(Html.fromHtml("<font color='red'>特码</font>"));
            }else{
                bigDrawable = reportLeftRegion1.getResources().getDrawable(VigilantHelp.getDrawable(vo.regionVigilant(Region.Seven),false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                reportLeftRegion7.setCompoundDrawables(bigDrawable, null, null, null);
                reportLeftRegion7.setText(vo.Seven+"");
            }


        }
    }

}
