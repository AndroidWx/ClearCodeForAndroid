package com.joye.hk6.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joye.hk6.R;
import com.joye.hk6domain.entity.ReportI;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xiang on 16/5/16.
 */
public class ReportLeftAdapter<T extends ReportI> extends ReportBaseAdapter<T> {
    List<T> datas;


    public ReportLeftAdapter(Context context, int resource, List<T> list) {
        super(context, resource);
        this.datas = list;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {

            convertView = View.inflate(getContext(), R.layout.item_report_left, null);
            viewHolder = new ViewHolder(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        try {
            viewHolder.expect.
                    setText(getItem(position).getExpect());
            viewHolder.opencode.
                    setText(getItem(position).getOpenCode()+"");
        } catch (Exception e) {
            viewHolder.expect.
                    setText("error");
            viewHolder.opencode.
                    setText("error");
        }
        return convertView;
    }


    class ViewHolder {
        @BindView(R.id.report_left_expect)
        TextView expect;
        @BindView(R.id.report_left_opencode)
        TextView opencode;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
