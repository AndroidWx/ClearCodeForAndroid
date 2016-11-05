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
import com.joye.hk6domain.vo.ChineseZodiacVo;
import com.joye.layouts.BorderTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/24.
 * 304622254@qq.com
 * Remeark:
 */

public class ChineseZodiacAdapter extends UpdateItemRecyclerViewAdapter<ChineseZodiacVo> {



    public ChineseZodiacAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChineseZodiacProbilityItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_chinese_zodiac, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ChineseZodiacProbilityItemViewHolder) holder).setViewValue(getDatas().get(position));
    }

    @Override
    public void updateItems(List<ChineseZodiacVo> source, boolean animated) {
        datas.clear();
        datas.addAll(source);
        notifyDataSetChanged();
    }

    public static class ChineseZodiacProbilityItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.report_left_expect)
        BorderTextView reportLeftExpect;
        @BindView(R.id.report_left_opencode)
        BorderTextView reportLeftOpencode;
        @BindView(R.id.Mouse)
        BorderTextView Mouse;
        @BindView(R.id.Cow)
        BorderTextView Cow;
        @BindView(R.id.Tiger)
        BorderTextView Tiger;
        @BindView(R.id.Rabbit)
        BorderTextView Rabbit;
        @BindView(R.id.Dragon)
        BorderTextView Dragon;
        @BindView(R.id.Snake)
        BorderTextView Snake;
        @BindView(R.id.Horse)
        BorderTextView Horse;
        @BindView(R.id.Sheep)
        BorderTextView Sheep;
        @BindView(R.id.Monkey)
        BorderTextView Monkey;
        @BindView(R.id.Chook)
        BorderTextView Chook;
        @BindView(R.id.Dog)
        BorderTextView Dog;
        @BindView(R.id.Pig)
        BorderTextView Pig;
        public ChineseZodiacProbilityItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setViewValue(ChineseZodiacVo vo) {
            reportLeftExpect.setText(vo.getExpect());
            reportLeftOpencode.setText(vo.getOpenCode() + "");
            reportLeftExpect.setText(vo.getExpect());
            reportLeftOpencode.setText(Html.fromHtml("<font color='red'>" + vo.getOpenCode() + "</font>"));
            Drawable bigDrawable;
            if (vo.Mouse == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Mouse.setCompoundDrawables(bigDrawable, null, null, null);
                Mouse.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.MouseVigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Mouse.setCompoundDrawables(bigDrawable, null, null, null);
                Mouse.setText(vo.Mouse + "");
            }
            if (vo.Cow == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Cow.setCompoundDrawables(bigDrawable, null, null, null);
                Cow.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.CowVigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Cow.setCompoundDrawables(bigDrawable, null, null, null);
                Cow.setText(vo.Cow + "");
            }
            if (vo.Tiger == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Tiger.setCompoundDrawables(bigDrawable, null, null, null);
                Tiger.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.TigerVigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Tiger.setCompoundDrawables(bigDrawable, null, null, null);
                Tiger.setText(vo.Tiger + "");
            }
            if (vo.Rabbit == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Rabbit.setCompoundDrawables(bigDrawable, null, null, null);
                Rabbit.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.RabbitVigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Rabbit.setCompoundDrawables(bigDrawable, null, null, null);
                Rabbit.setText(vo.Rabbit + "");
            }
            if (vo.Dragon == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Dragon.setCompoundDrawables(bigDrawable, null, null, null);
                Dragon.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.DragonVigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Dragon.setCompoundDrawables(bigDrawable, null, null, null);
                Dragon.setText(vo.Dragon + "");
            }
            if (vo.Snake == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Snake.setCompoundDrawables(bigDrawable, null, null, null);
                Snake.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.SnakeVigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Snake.setCompoundDrawables(bigDrawable, null, null, null);
                Snake.setText(vo.Snake + "");
            }
            if (vo.Horse == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Horse.setCompoundDrawables(bigDrawable, null, null, null);
                Horse.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.HorseVigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Horse.setCompoundDrawables(bigDrawable, null, null, null);
                Horse.setText(vo.Horse + "");
            }
            if (vo.Sheep == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Sheep.setCompoundDrawables(bigDrawable, null, null, null);
                Sheep.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.SheepVigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Sheep.setCompoundDrawables(bigDrawable, null, null, null);
                Sheep.setText(vo.Sheep + "");
            }
            if (vo.Monkey == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Monkey.setCompoundDrawables(bigDrawable, null, null, null);
                Monkey.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.MonkeyVigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Monkey.setCompoundDrawables(bigDrawable, null, null, null);
                Monkey.setText(vo.Monkey + "");
            }
            if (vo.Chook == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Chook.setCompoundDrawables(bigDrawable, null, null, null);
                Chook.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.ChookVigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Chook.setCompoundDrawables(bigDrawable, null, null, null);
                Chook.setText(vo.Chook + "");
            }
            if (vo.Dog == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Dog.setCompoundDrawables(bigDrawable, null, null, null);
                Dog.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.DogVigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Dog.setCompoundDrawables(bigDrawable, null, null, null);
                Dog.setText(vo.Dog + "");
            }
            if (vo.Pig == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Pig.setCompoundDrawables(bigDrawable, null, null, null);
                Pig.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.PigVigilant(), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                Pig.setCompoundDrawables(bigDrawable, null, null, null);
                Pig.setText(vo.Pig + "");
            }


        }
    }


}
