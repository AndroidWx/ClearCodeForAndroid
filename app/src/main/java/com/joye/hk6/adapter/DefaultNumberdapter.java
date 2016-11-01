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
import com.joye.hk6domain.constants.NumberProperty;
import com.joye.hk6domain.vo.DefaultNumberVo;
import com.joye.layouts.BorderTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:
 */
public class DefaultNumberdapter extends UpdateItemRecyclerViewAdapter<DefaultNumberVo> {




    public DefaultNumberdapter(Context context) {
        super(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DefaultNumberVoItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_default_number, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((DefaultNumberVoItemViewHolder) holder).setViewValue(getDatas().get(position));
    }

    @Override
    public void updateItems(List<DefaultNumberVo> source, boolean animated) {
        datas.clear();
        datas.addAll(source);
        notifyDataSetChanged();
    }

    public static class DefaultNumberVoItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.report_left_expect)
        BorderTextView reportLeftExpect;
        @BindView(R.id.report_left_opencode)
        BorderTextView reportLeftOpencode;
        @BindView(R.id.N1)
        BorderTextView N1;
        @BindView(R.id.N2)
        BorderTextView N2;
        @BindView(R.id.N3)
        BorderTextView N3;
        @BindView(R.id.N4)
        BorderTextView N4;
        @BindView(R.id.N5)
        BorderTextView N5;
        @BindView(R.id.N6)
        BorderTextView N6;
        @BindView(R.id.N7)
        BorderTextView N7;
        @BindView(R.id.N8)
        BorderTextView N8;
        @BindView(R.id.N9)
        BorderTextView N9;
        @BindView(R.id.N10)
        BorderTextView N10;
        @BindView(R.id.N11)
        BorderTextView N11;
        @BindView(R.id.N12)
        BorderTextView N12;
        @BindView(R.id.N13)
        BorderTextView N13;
        @BindView(R.id.N14)
        BorderTextView N14;
        @BindView(R.id.N15)
        BorderTextView N15;
        @BindView(R.id.N16)
        BorderTextView N16;
        @BindView(R.id.N17)
        BorderTextView N17;
        @BindView(R.id.N18)
        BorderTextView N18;
        @BindView(R.id.N19)
        BorderTextView N19;
        @BindView(R.id.N20)
        BorderTextView N20;
        @BindView(R.id.N21)
        BorderTextView N21;
        @BindView(R.id.N22)
        BorderTextView N22;
        @BindView(R.id.N23)
        BorderTextView N23;
        @BindView(R.id.N24)
        BorderTextView N24;
        @BindView(R.id.N25)
        BorderTextView N25;
        @BindView(R.id.N26)
        BorderTextView N26;
        @BindView(R.id.N27)
        BorderTextView N27;
        @BindView(R.id.N28)
        BorderTextView N28;
        @BindView(R.id.N29)
        BorderTextView N29;
        @BindView(R.id.N30)
        BorderTextView N30;
        @BindView(R.id.N31)
        BorderTextView N31;
        @BindView(R.id.N32)
        BorderTextView N32;
        @BindView(R.id.N33)
        BorderTextView N33;
        @BindView(R.id.N34)
        BorderTextView N34;
        @BindView(R.id.N35)
        BorderTextView N35;
        @BindView(R.id.N36)
        BorderTextView N36;
        @BindView(R.id.N37)
        BorderTextView N37;
        @BindView(R.id.N38)
        BorderTextView N38;
        @BindView(R.id.N39)
        BorderTextView N39;
        @BindView(R.id.N40)
        BorderTextView N40;
        @BindView(R.id.N41)
        BorderTextView N41;
        @BindView(R.id.N42)
        BorderTextView N42;
        @BindView(R.id.N43)
        BorderTextView N43;
        @BindView(R.id.N44)
        BorderTextView N44;
        @BindView(R.id.N45)
        BorderTextView N45;
        @BindView(R.id.N46)
        BorderTextView N46;
        @BindView(R.id.N47)
        BorderTextView N47;
        @BindView(R.id.N48)
        BorderTextView N48;
        @BindView(R.id.N49)
        BorderTextView N49;

        public DefaultNumberVoItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setViewValue(DefaultNumberVo vo) {
            reportLeftExpect.setText(vo.getExpect());
            reportLeftOpencode.setText(Html.fromHtml("<font color='red'>" + vo.getOpenCode() + "</font>"));
            Drawable bigDrawable;
            if (vo.N1 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N1.setCompoundDrawables(bigDrawable, null, null, null);
                N1.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N1), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N1.setCompoundDrawables(bigDrawable, null, null, null);
                N1.setText(vo.N1+ "");
            }
            if (vo.N2 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N2.setCompoundDrawables(bigDrawable, null, null, null);
                N2.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N2), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N2.setCompoundDrawables(bigDrawable, null, null, null);
                N2.setText(vo.N2+ "");
            }
            if (vo.N3 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N3.setCompoundDrawables(bigDrawable, null, null, null);
                N3.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N3), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N3.setCompoundDrawables(bigDrawable, null, null, null);
                N3.setText(vo.N3+ "");
            }
            if (vo.N4 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N4.setCompoundDrawables(bigDrawable, null, null, null);
                N4.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N4), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N4.setCompoundDrawables(bigDrawable, null, null, null);
                N4.setText(vo.N4+ "");
            }
            if (vo.N5 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N5.setCompoundDrawables(bigDrawable, null, null, null);
                N5.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N5), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N5.setCompoundDrawables(bigDrawable, null, null, null);
                N5.setText(vo.N5+ "");
            }
            if (vo.N6 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N6.setCompoundDrawables(bigDrawable, null, null, null);
                N6.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N6), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N6.setCompoundDrawables(bigDrawable, null, null, null);
                N6.setText(vo.N6+ "");
            }
            if (vo.N7 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N7.setCompoundDrawables(bigDrawable, null, null, null);
                N7.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N7), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N7.setCompoundDrawables(bigDrawable, null, null, null);
                N7.setText(vo.N7+ "");
            }
            if (vo.N8 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N8.setCompoundDrawables(bigDrawable, null, null, null);
                N8.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N8), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N8.setCompoundDrawables(bigDrawable, null, null, null);
                N8.setText(vo.N8+ "");
            }
            if (vo.N9 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N9.setCompoundDrawables(bigDrawable, null, null, null);
                N9.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N9), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N9.setCompoundDrawables(bigDrawable, null, null, null);
                N9.setText(vo.N9+ "");
            }
            if (vo.N10 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N10.setCompoundDrawables(bigDrawable, null, null, null);
                N10.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N10), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N10.setCompoundDrawables(bigDrawable, null, null, null);
                N10.setText(vo.N10+ "");
            }
            if (vo.N11 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N11.setCompoundDrawables(bigDrawable, null, null, null);
                N11.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N11), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N11.setCompoundDrawables(bigDrawable, null, null, null);
                N11.setText(vo.N11+ "");
            }
            if (vo.N12 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N12.setCompoundDrawables(bigDrawable, null, null, null);
                N12.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N12), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N12.setCompoundDrawables(bigDrawable, null, null, null);
                N12.setText(vo.N12+ "");
            }
            if (vo.N13 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N13.setCompoundDrawables(bigDrawable, null, null, null);
                N13.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N13), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N13.setCompoundDrawables(bigDrawable, null, null, null);
                N13.setText(vo.N13+ "");
            }
            if (vo.N14 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N14.setCompoundDrawables(bigDrawable, null, null, null);
                N14.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N14), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N14.setCompoundDrawables(bigDrawable, null, null, null);
                N14.setText(vo.N14+ "");
            }
            if (vo.N15 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N15.setCompoundDrawables(bigDrawable, null, null, null);
                N15.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N15), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N15.setCompoundDrawables(bigDrawable, null, null, null);
                N15.setText(vo.N15+ "");
            }
            if (vo.N16 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N16.setCompoundDrawables(bigDrawable, null, null, null);
                N16.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N16), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N16.setCompoundDrawables(bigDrawable, null, null, null);
                N16.setText(vo.N16+ "");
            }
            if (vo.N17 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N17.setCompoundDrawables(bigDrawable, null, null, null);
                N17.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N17), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N17.setCompoundDrawables(bigDrawable, null, null, null);
                N17.setText(vo.N17+ "");
            }
            if (vo.N18 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N18.setCompoundDrawables(bigDrawable, null, null, null);
                N18.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N18), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N18.setCompoundDrawables(bigDrawable, null, null, null);
                N18.setText(vo.N18+ "");
            }
            if (vo.N19 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N19.setCompoundDrawables(bigDrawable, null, null, null);
                N19.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N19), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N19.setCompoundDrawables(bigDrawable, null, null, null);
                N19.setText(vo.N19+ "");
            }
            if (vo.N20 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N20.setCompoundDrawables(bigDrawable, null, null, null);
                N20.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N20), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N20.setCompoundDrawables(bigDrawable, null, null, null);
                N20.setText(vo.N20+ "");
            }
            if (vo.N21 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N21.setCompoundDrawables(bigDrawable, null, null, null);
                N21.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N21), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N21.setCompoundDrawables(bigDrawable, null, null, null);
                N21.setText(vo.N21+ "");
            }
            if (vo.N22 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N22.setCompoundDrawables(bigDrawable, null, null, null);
                N22.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N22), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N22.setCompoundDrawables(bigDrawable, null, null, null);
                N22.setText(vo.N22+ "");
            }
            if (vo.N23 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N23.setCompoundDrawables(bigDrawable, null, null, null);
                N23.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N23), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N23.setCompoundDrawables(bigDrawable, null, null, null);
                N23.setText(vo.N23+ "");
            }
            if (vo.N24 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N24.setCompoundDrawables(bigDrawable, null, null, null);
                N24.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N24), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N24.setCompoundDrawables(bigDrawable, null, null, null);
                N24.setText(vo.N24+ "");
            }
            if (vo.N25 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N25.setCompoundDrawables(bigDrawable, null, null, null);
                N25.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N25), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N25.setCompoundDrawables(bigDrawable, null, null, null);
                N25.setText(vo.N25+ "");
            }
            if (vo.N26 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N26.setCompoundDrawables(bigDrawable, null, null, null);
                N26.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N26), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N26.setCompoundDrawables(bigDrawable, null, null, null);
                N26.setText(vo.N26+ "");
            }
            if (vo.N27 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N27.setCompoundDrawables(bigDrawable, null, null, null);
                N27.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N27), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N27.setCompoundDrawables(bigDrawable, null, null, null);
                N27.setText(vo.N27+ "");
            }
            if (vo.N28 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N28.setCompoundDrawables(bigDrawable, null, null, null);
                N28.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N28), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N28.setCompoundDrawables(bigDrawable, null, null, null);
                N28.setText(vo.N28+ "");
            }
            if (vo.N29 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N29.setCompoundDrawables(bigDrawable, null, null, null);
                N29.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N29), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N29.setCompoundDrawables(bigDrawable, null, null, null);
                N29.setText(vo.N29+ "");
            }
            if (vo.N30 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N30.setCompoundDrawables(bigDrawable, null, null, null);
                N30.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N30), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N30.setCompoundDrawables(bigDrawable, null, null, null);
                N30.setText(vo.N30+ "");
            }
            if (vo.N31 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N31.setCompoundDrawables(bigDrawable, null, null, null);
                N31.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N31), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N31.setCompoundDrawables(bigDrawable, null, null, null);
                N31.setText(vo.N31+ "");
            }
            if (vo.N32 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N32.setCompoundDrawables(bigDrawable, null, null, null);
                N32.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N32), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N32.setCompoundDrawables(bigDrawable, null, null, null);
                N32.setText(vo.N32+ "");
            }
            if (vo.N33 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N33.setCompoundDrawables(bigDrawable, null, null, null);
                N33.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N33), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N33.setCompoundDrawables(bigDrawable, null, null, null);
                N33.setText(vo.N33+ "");
            }
            if (vo.N34 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N34.setCompoundDrawables(bigDrawable, null, null, null);
                N34.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N34), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N34.setCompoundDrawables(bigDrawable, null, null, null);
                N34.setText(vo.N34+ "");
            }
            if (vo.N35 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N35.setCompoundDrawables(bigDrawable, null, null, null);
                N35.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N35), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N35.setCompoundDrawables(bigDrawable, null, null, null);
                N35.setText(vo.N35+ "");
            }
            if (vo.N36 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N36.setCompoundDrawables(bigDrawable, null, null, null);
                N36.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N36), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N36.setCompoundDrawables(bigDrawable, null, null, null);
                N36.setText(vo.N36+ "");
            }
            if (vo.N37 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N37.setCompoundDrawables(bigDrawable, null, null, null);
                N37.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N37), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N37.setCompoundDrawables(bigDrawable, null, null, null);
                N37.setText(vo.N37+ "");
            }
            if (vo.N38 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N38.setCompoundDrawables(bigDrawable, null, null, null);
                N38.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N38), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N38.setCompoundDrawables(bigDrawable, null, null, null);
                N38.setText(vo.N38+ "");
            }
            if (vo.N39 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N39.setCompoundDrawables(bigDrawable, null, null, null);
                N39.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N39), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N39.setCompoundDrawables(bigDrawable, null, null, null);
                N39.setText(vo.N39+ "");
            }
            if (vo.N40 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N40.setCompoundDrawables(bigDrawable, null, null, null);
                N40.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N40), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N40.setCompoundDrawables(bigDrawable, null, null, null);
                N40.setText(vo.N40+ "");
            }
            if (vo.N41 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N41.setCompoundDrawables(bigDrawable, null, null, null);
                N41.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N41), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N41.setCompoundDrawables(bigDrawable, null, null, null);
                N41.setText(vo.N41+ "");
            }
            if (vo.N42 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N42.setCompoundDrawables(bigDrawable, null, null, null);
                N42.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N42), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N42.setCompoundDrawables(bigDrawable, null, null, null);
                N42.setText(vo.N42+ "");
            }
            if (vo.N43 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N43.setCompoundDrawables(bigDrawable, null, null, null);
                N43.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N43), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N43.setCompoundDrawables(bigDrawable, null, null, null);
                N43.setText(vo.N43+ "");
            }
            if (vo.N44 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N44.setCompoundDrawables(bigDrawable, null, null, null);
                N44.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N44), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N44.setCompoundDrawables(bigDrawable, null, null, null);
                N44.setText(vo.N44+ "");
            }
            if (vo.N45 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N45.setCompoundDrawables(bigDrawable, null, null, null);
                N45.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N45), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N45.setCompoundDrawables(bigDrawable, null, null, null);
                N45.setText(vo.N45+ "");
            }
            if (vo.N46 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N46.setCompoundDrawables(bigDrawable, null, null, null);
                N46.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N46), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N46.setCompoundDrawables(bigDrawable, null, null, null);
                N46.setText(vo.N46+ "");
            }
            if (vo.N47 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N47.setCompoundDrawables(bigDrawable, null, null, null);
                N47.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N47), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N47.setCompoundDrawables(bigDrawable, null, null, null);
                N47.setText(vo.N47+ "");
            }
            if (vo.N48 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N48.setCompoundDrawables(bigDrawable, null, null, null);
                N48.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N48), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N48.setCompoundDrawables(bigDrawable, null, null, null);
                N48.setText(vo.N48+ "");
            }
            if (vo.N49 == 0) {
                bigDrawable = reportLeftExpect.getResources().getDrawable(R.drawable.ic_favorite_red_a700_18dp);
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N49.setCompoundDrawables(bigDrawable, null, null, null);
                N49.setText(Html.fromHtml("<font color='red'>特码</font>"));
            } else {
                bigDrawable = reportLeftExpect.getResources().getDrawable(VigilantHelp.getDrawable(vo.getVigilant(NumberProperty.N49), false));
                bigDrawable.setBounds(0, 0, bigDrawable.getMinimumWidth(), bigDrawable.getMinimumHeight());
                N49.setCompoundDrawables(bigDrawable, null, null, null);
                N49.setText(vo.N49+ "");
            }
        }
    }

}
