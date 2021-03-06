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
import com.joye.hk6domain.vo.SizeVo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:
 */
public class SizeAdapter extends UpdateItemRecyclerViewAdapter<SizeVo> {


    public SizeAdapter(Context context) {
        super(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SizeItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_size, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SizeItemViewHolder) holder).setViewValue(getDatas().get(position));
    }

    @Override
    public void updateItems(List<SizeVo> source, boolean animated) {
        datas.clear();
        datas.addAll(source);
        notifyDataSetChanged();
    }

    public static class SizeItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.report_left_expect)
        TextView reportLeftExpect;
        @BindView(R.id.report_left_opencode)
        TextView reportLeftOpencode;
        @BindView(R.id.report_left_Big)
        TextView reportLeftBig;
        @BindView(R.id.report_left_Small)
        TextView reportLeftSmall;
        public SizeItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setViewValue(SizeVo vo) {
            reportLeftExpect.setText(vo.getExpect());
            reportLeftOpencode.setText(Html.fromHtml("<font color='red'>"+vo.getOpenCode()+"</font>"));
            reportLeftBig.setText(vo.Big==0?"大":vo.Big+"");
            if(vo.Big==0){
                reportLeftBig.setBackgroundColor(android.R.color.holo_red_dark);
            }else if(vo.Small==0){
                reportLeftSmall.setBackgroundColor(android.R.color.holo_red_dark);
            }
            reportLeftSmall.setText(vo.Small==0?"小":vo.Small+"");
            Drawable bigDrawable = reportLeftBig.getResources().getDrawable(VigilantHelp.getDrawable(vo.bigVigilant()));
            bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
            reportLeftBig.setCompoundDrawables(bigDrawable, null, null, null)  ;;

            Drawable smallDrawable = reportLeftBig.getResources().getDrawable(VigilantHelp.getDrawable(vo.smallVigilant()));
            smallDrawable.setBounds(0, 0, smallDrawable.getMinimumWidth(), smallDrawable.getMinimumHeight());
            reportLeftSmall.setCompoundDrawables(smallDrawable, null, null, null);

        }
    }

}
