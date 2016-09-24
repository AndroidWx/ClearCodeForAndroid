package com.joye.hk6.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joye.hk6.R;
import com.joye.hk6domain.vo.ReportRightI;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xiang on 16/5/16.
 */
public class ReportRightAdapter<T extends ReportRightI> extends ReportBaseAdapter<T> {
    List<T> datas;

    public ReportRightAdapter(Context context, int resource, List<T> list) {
        super(context, resource, list);
        this.datas = list;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    private class MyViewClick implements View.OnClickListener {
        private int position;

        public void setPosition(int position) {
            this.position = position;
        }

        public MyViewClick(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(getContext(), R.layout.item_report_right, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
//        viewHolder.tvItem1.setText(getItem(position).getItem1());
//        viewHolder.tvItem1.setVisibility(getItem(position).getItem1Visibility());
//        viewHolder.tvItem2.setText(getItem(position).getItem2());
//        viewHolder.tvItem2.setVisibility(getItem(position).getItem2Visibility());
//        viewHolder.tvItem3.setText(getItem(position).getItem3());
//        viewHolder.tvItem3.setVisibility(getItem(position).getItem3Visibility());
//        viewHolder.tvItem4.setText(getItem(position).getItem4());
//        viewHolder.tvItem4.setVisibility(getItem(position).getItem4Visibility());
//        viewHolder.tvItem5.setText(getItem(position).getItem5());
//        viewHolder.tvItem5.setVisibility(getItem(position).getItem5Visibility());
//        viewHolder.tvItem6.setText(getItem(position).getItem6());
//        viewHolder.tvItem6.setVisibility(getItem(position).getItem6Visibility());
//        viewHolder.tvItem7.setText(getItem(position).getItem7());
//        viewHolder.tvItem7.setVisibility(getItem(position).getItem7Visibility());
//        viewHolder.tvItem8.setText(getItem(position).getItem8());
//        viewHolder.tvItem8.setVisibility(getItem(position).getItem8Visibility());
//        viewHolder.tvItem9.setText(getItem(position).getItem9());
//        viewHolder.tvItem9.setVisibility(getItem(position).getItem9Visibility());
//        viewHolder.tvItem10.setText(getItem(position).getItem10());
//        viewHolder.tvItem10.setVisibility(getItem(position).getItem10Visibility());
//        viewHolder.tvItem11.setText(getItem(position).getItem11());
//        viewHolder.tvItem11.setVisibility(getItem(position).getItem11Visibility());
//        viewHolder.tvItem12.setText(getItem(position).getItem12());
//        viewHolder.tvItem12.setVisibility(getItem(position).getItem12Visibility());
//        viewHolder.tvItem13.setText(getItem(position).getItem13());
//        viewHolder.tvItem13.setVisibility(getItem(position).getItem13Visibility());
//        viewHolder.tvItem14.setText(getItem(position).getItem14());
//        viewHolder.tvItem14.setVisibility(getItem(position).getItem14Visibility());
//        viewHolder.tvItem15.setText(getItem(position).getItem15());
//        viewHolder.tvItem15.setVisibility(getItem(position).getItem15Visibility());
//        viewHolder.tvItem16.setText(getItem(position).getItem16());
//        viewHolder.tvItem16.setVisibility(getItem(position).getItem16Visibility());
//        viewHolder.tvItem17.setText(getItem(position).getItem17());
//        viewHolder.tvItem17.setVisibility(getItem(position).getItem17Visibility());
//        viewHolder.tvItem18.setText(getItem(position).getItem18());
//        viewHolder.tvItem18.setVisibility(getItem(position).getItem18Visibility());
//        viewHolder.tvItem19.setText(getItem(position).getItem19());
//        viewHolder.tvItem19.setVisibility(getItem(position).getItem19Visibility());
//        viewHolder.tvItem20.setText(getItem(position).getItem20());
//        viewHolder.tvItem20.setVisibility(getItem(position).getItem20Visibility());
//        viewHolder.tvItem21.setText(getItem(position).getItem21());
//        viewHolder.tvItem21.setVisibility(getItem(position).getItem21Visibility());
//        viewHolder.tvItem22.setText(getItem(position).getItem22());
//        viewHolder.tvItem22.setVisibility(getItem(position).getItem22Visibility());
//        viewHolder.tvItem23.setText(getItem(position).getItem23());
//        viewHolder.tvItem23.setVisibility(getItem(position).getItem23Visibility());
//        viewHolder.tvItem24.setText(getItem(position).getItem24());
//        viewHolder.tvItem24.setVisibility(getItem(position).getItem24Visibility());
//        viewHolder.tvItem25.setText(getItem(position).getItem25());
//        viewHolder.tvItem25.setVisibility(getItem(position).getItem25Visibility());
//        viewHolder.tvItem26.setText(getItem(position).getItem26());
//        viewHolder.tvItem26.setVisibility(getItem(position).getItem26Visibility());
//        viewHolder.tvItem27.setText(getItem(position).getItem27());
//        viewHolder.tvItem27.setVisibility(getItem(position).getItem27Visibility());
//        viewHolder.tvItem28.setText(getItem(position).getItem28());
//        viewHolder.tvItem28.setVisibility(getItem(position).getItem28Visibility());
//        viewHolder.tvItem29.setText(getItem(position).getItem29());
//        viewHolder.tvItem29.setVisibility(getItem(position).getItem29Visibility());
//        viewHolder.tvItem30.setText(getItem(position).getItem30());
//        viewHolder.tvItem30.setVisibility(getItem(position).getItem30Visibility());
//        viewHolder.tvItem31.setText(getItem(position).getItem31());
//        viewHolder.tvItem31.setVisibility(getItem(position).getItem31Visibility());
//        viewHolder.tvItem32.setText(getItem(position).getItem32());
//        viewHolder.tvItem32.setVisibility(getItem(position).getItem32Visibility());
//        viewHolder.tvItem33.setText(getItem(position).getItem33());
//        viewHolder.tvItem33.setVisibility(getItem(position).getItem33Visibility());
//        viewHolder.tvItem34.setText(getItem(position).getItem34());
//        viewHolder.tvItem34.setVisibility(getItem(position).getItem34Visibility());
//        viewHolder.tvItem35.setText(getItem(position).getItem35());
//        viewHolder.tvItem35.setVisibility(getItem(position).getItem35Visibility());
//        viewHolder.tvItem36.setText(getItem(position).getItem36());
//        viewHolder.tvItem36.setVisibility(getItem(position).getItem36Visibility());
//        viewHolder.tvItem37.setText(getItem(position).getItem37());
//        viewHolder.tvItem37.setVisibility(getItem(position).getItem37Visibility());
//        viewHolder.tvItem38.setText(getItem(position).getItem38());
//        viewHolder.tvItem38.setVisibility(getItem(position).getItem38Visibility());
//        viewHolder.tvItem39.setText(getItem(position).getItem39());
//        viewHolder.tvItem39.setVisibility(getItem(position).getItem39Visibility());
//        viewHolder.tvItem40.setText(getItem(position).getItem40());
//        viewHolder.tvItem40.setVisibility(getItem(position).getItem40Visibility());
//        viewHolder.tvItem41.setText(getItem(position).getItem41());
//        viewHolder.tvItem41.setVisibility(getItem(position).getItem41Visibility());
//        viewHolder.tvItem42.setText(getItem(position).getItem42());
//        viewHolder.tvItem42.setVisibility(getItem(position).getItem42Visibility());
//        viewHolder.tvItem43.setText(getItem(position).getItem43());
//        viewHolder.tvItem43.setVisibility(getItem(position).getItem43Visibility());
//        viewHolder.tvItem44.setText(getItem(position).getItem44());
//        viewHolder.tvItem44.setVisibility(getItem(position).getItem44Visibility());
//        viewHolder.tvItem45.setText(getItem(position).getItem45());
//        viewHolder.tvItem45.setVisibility(getItem(position).getItem45Visibility());
//        viewHolder.tvItem46.setText(getItem(position).getItem46());
//        viewHolder.tvItem46.setVisibility(getItem(position).getItem46Visibility());
//        viewHolder.tvItem47.setText(getItem(position).getItem47());
//        viewHolder.tvItem47.setVisibility(getItem(position).getItem47Visibility());
//        viewHolder.tvItem48.setText(getItem(position).getItem48());
//        viewHolder.tvItem48.setVisibility(getItem(position).getItem48Visibility());
//        viewHolder.tvItem49.setText(getItem(position).getItem49());
//        viewHolder.tvItem49.setVisibility(getItem(position).getItem49Visibility());


        return convertView;
    }

     

    class ViewHolder {
        @BindView(R.id.tv_item1)
        TextView tvItem1;
        @BindView(R.id.tv_item2)
        TextView tvItem2;
        @BindView(R.id.tv_item3)
        TextView tvItem3;
        @BindView(R.id.tv_item4)
        TextView tvItem4;
        @BindView(R.id.tv_item5)
        TextView tvItem5;
        @BindView(R.id.tv_item6)
        TextView tvItem6;
        @BindView(R.id.tv_item7)
        TextView tvItem7;
        @BindView(R.id.tv_item8)
        TextView tvItem8;
        @BindView(R.id.tv_item9)
        TextView tvItem9;
        @BindView(R.id.tv_item10)
        TextView tvItem10;
        @BindView(R.id.tv_item11)
        TextView tvItem11;
        @BindView(R.id.tv_item12)
        TextView tvItem12;
        @BindView(R.id.tv_item13)
        TextView tvItem13;
        @BindView(R.id.tv_item14)
        TextView tvItem14;
        @BindView(R.id.tv_item15)
        TextView tvItem15;
        @BindView(R.id.tv_item16)
        TextView tvItem16;
        @BindView(R.id.tv_item17)
        TextView tvItem17;
        @BindView(R.id.tv_item18)
        TextView tvItem18;
        @BindView(R.id.tv_item19)
        TextView tvItem19;
        @BindView(R.id.tv_item20)
        TextView tvItem20;
        @BindView(R.id.tv_item21)
        TextView tvItem21;
        @BindView(R.id.tv_item22)
        TextView tvItem22;
        @BindView(R.id.tv_item23)
        TextView tvItem23;
        @BindView(R.id.tv_item24)
        TextView tvItem24;
        @BindView(R.id.tv_item25)
        TextView tvItem25;
        @BindView(R.id.tv_item26)
        TextView tvItem26;
        @BindView(R.id.tv_item27)
        TextView tvItem27;
        @BindView(R.id.tv_item28)
        TextView tvItem28;
        @BindView(R.id.tv_item29)
        TextView tvItem29;
        @BindView(R.id.tv_item30)
        TextView tvItem30;
        @BindView(R.id.tv_item31)
        TextView tvItem31;
        @BindView(R.id.tv_item32)
        TextView tvItem32;
        @BindView(R.id.tv_item33)
        TextView tvItem33;
        @BindView(R.id.tv_item34)
        TextView tvItem34;
        @BindView(R.id.tv_item35)
        TextView tvItem35;
        @BindView(R.id.tv_item36)
        TextView tvItem36;
        @BindView(R.id.tv_item37)
        TextView tvItem37;
        @BindView(R.id.tv_item38)
        TextView tvItem38;
        @BindView(R.id.tv_item39)
        TextView tvItem39;
        @BindView(R.id.tv_item40)
        TextView tvItem40;
        @BindView(R.id.tv_item41)
        TextView tvItem41;
        @BindView(R.id.tv_item42)
        TextView tvItem42;
        @BindView(R.id.tv_item43)
        TextView tvItem43;
        @BindView(R.id.tv_item44)
        TextView tvItem44;
        @BindView(R.id.tv_item45)
        TextView tvItem45;
        @BindView(R.id.tv_item46)
        TextView tvItem46;
        @BindView(R.id.tv_item47)
        TextView tvItem47;
        @BindView(R.id.tv_item48)
        TextView tvItem48;
        @BindView(R.id.tv_item49)
        TextView tvItem49;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }
}
