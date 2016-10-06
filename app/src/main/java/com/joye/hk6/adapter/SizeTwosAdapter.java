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
import com.joye.hk6domain.vo.SizeTwosVo;
import com.joye.layouts.BorderTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:
 */
public class SizeTwosAdapter extends UpdateItemRecyclerViewAdapter<SizeTwosVo> {

    public SizeTwosAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SizeItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_sizetwos, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SizeItemViewHolder) holder).setViewValue(getDatas().get(position));
    }

    @Override
    public void updateItems(List<SizeTwosVo> source, boolean animated) {
        datas.clear();
        datas.addAll(source);
        notifyDataSetChanged();
    }

    public static class SizeItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.report_left_expect)
        BorderTextView reportLeftExpect;
        @BindView(R.id.report_left_opencode)
        BorderTextView reportLeftOpencode;
        @BindView(R.id.SmallOdd)
        BorderTextView SmallOdd;
        @BindView(R.id.SmallEven)
        BorderTextView SmallEven;
        @BindView(R.id.BigOdd)
        BorderTextView BigOdd;
        @BindView(R.id.BigEven)
        BorderTextView BigEven;

        public SizeItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setViewValue(SizeTwosVo vo) {
            try {
                reportLeftExpect.setText(vo.getExpect());
                reportLeftOpencode.setText(Html.fromHtml("<font color='red'>" + vo.getOpenCode() + "</font>"));
                Drawable bigDrawable;
                if (vo.SmallEven == 0) {
                    bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                    bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                    SmallEven.setCompoundDrawables(bigDrawable, null, null, null);
                    SmallEven.setText(Html.fromHtml("<font color='red'>特码</font>"));
                } else {
                    bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.smallEvenVigilant(), false));
                    bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                    SmallEven.setCompoundDrawables(bigDrawable, null, null, null);
                    SmallEven.setText(vo.SmallEven + "");
                }

                if (vo.SmallOdd == 0) {
                    bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                    bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                    SmallOdd.setCompoundDrawables(bigDrawable, null, null, null);
                    SmallOdd.setText(Html.fromHtml("<font color='red'>特码</font>"));
                } else {
                    bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.smallOddVigilant(), false));
                    bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                    SmallOdd.setCompoundDrawables(bigDrawable, null, null, null);
                    SmallOdd.setText(vo.SmallOdd + "");
                }
                if (vo.BigEven == 0) {
                    bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                    bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                    BigEven.setCompoundDrawables(bigDrawable, null, null, null);
                    BigEven.setText(Html.fromHtml("<font color='red'>特码</font>"));
                } else {
                    bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.bigEvenVigilant(), false));
                    bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                    BigEven.setCompoundDrawables(bigDrawable, null, null, null);
                    BigEven.setText(vo.BigEven + "");
                }

                if (vo.BigOdd == 0) {
                    bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                    bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                    BigOdd.setCompoundDrawables(bigDrawable, null, null, null);
                    BigOdd.setText(Html.fromHtml("<font color='red'>特码</font>"));
                } else {
                    bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.bigOddVigilant(), false));
                    bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                    BigOdd.setCompoundDrawables(bigDrawable, null, null, null);
                    BigOdd.setText(vo.BigOdd + "");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
