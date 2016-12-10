package com.joye.hk6.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.joye.hk6.R;
import com.joye.hk6.report.PieChartImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xiang on 16/11/17.
 */
public class ReportAdapter extends UpdateItemRecyclerViewAdapter<PieChartImpl> {

    public ReportAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DefaultViewHolder(LayoutInflater.from(context).inflate(R.layout.item_report_piechat, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((DefaultViewHolder) holder).setViewValue(getDatas().get(position));
    }

    @Override
    public void updateItems(List<PieChartImpl> datas, boolean animated) {
        getDatas().clear();
        getDatas().addAll(datas);
        notifyDataSetChanged();


    }

    static class DefaultViewHolder extends BaseRecyclerViewHolder<PieChartImpl> {
        @BindView(R.id.chart1)
        PieChart mChart;
        public DefaultViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }

        @Override
        void setViewValue(PieChartImpl pieChart) {
            Typeface mTfLight = Typeface.createFromAsset(itemView.getResources().getAssets(), "OpenSans-Light.ttf");
            Typeface mTfRegular = Typeface.createFromAsset(itemView.getResources().getAssets(), "OpenSans-Regular.ttf");
            mChart.setUsePercentValues(true);
            mChart.getDescription().setEnabled(false);
            mChart.setExtraOffsets(5, 10, 5, 5);
            mChart.setDragDecelerationFrictionCoef(0.95f);
            mChart.setCenterTextTypeface(mTfLight);

            mChart.setCenterText(pieChart.getContentText());

            mChart.setDrawHoleEnabled(true);
            mChart.setHoleColor(Color.WHITE);

            mChart.setTransparentCircleColor(Color.WHITE);
            mChart.setTransparentCircleAlpha(110);

            mChart.setHoleRadius(58f);
            mChart.setTransparentCircleRadius(61f);

            mChart.setDrawCenterText(true);

            mChart.setRotationAngle(0);
            // enable rotation of the chart by touch
            mChart.setRotationEnabled(true);
            mChart.setHighlightPerTapEnabled(true);

            // mChart.setUnit(" €");
            // mChart.setDrawUnitsInChart(true);

            // add a selection listener

            setData(pieChart.getPieEntryFlotArrayList(),pieChart.getPieEntryLabelArrayList(), mTfLight);
//        setData(4,100);
            mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
            // mChart.spin(2000, 0, 360);


            Legend l = mChart.getLegend();
            l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
            l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
            l.setOrientation(Legend.LegendOrientation.VERTICAL);
            l.setDrawInside(false);
            l.setXEntrySpace(7f);
            l.setYEntrySpace(0f);
            l.setYOffset(0f);

            // entry label styling
            mChart.setEntryLabelColor(Color.GRAY);
            mChart.setEntryLabelTypeface(mTfRegular);
            mChart.setEntryLabelTextSize(12f);


        }


        private void setData(  ArrayList<Float> range,ArrayList<String> lables, Typeface mTfLight) {


            ArrayList<PieEntry> entries = new ArrayList<PieEntry>();

            // NOTE: The order of the entries when being added to the entries array determines their position around the center of
            // the chart.
            for (int i = 0; i < range.size() ; i++) {
                entries.add(new PieEntry(range.get(i), lables.get(i)));
            }

            PieDataSet dataSet = new PieDataSet(entries, "控制仓位");
            dataSet.setSliceSpace(3f);
            dataSet.setSelectionShift(5f);

            // add a lot of colors

            ArrayList<Integer> colors = new ArrayList<Integer>();

            for (int c : ColorTemplate.VORDIPLOM_COLORS)
                colors.add(c);

            for (int c : ColorTemplate.JOYFUL_COLORS)
                colors.add(c);

            for (int c : ColorTemplate.COLORFUL_COLORS)
                colors.add(c);

            for (int c : ColorTemplate.LIBERTY_COLORS)
                colors.add(c);

            for (int c : ColorTemplate.PASTEL_COLORS)
                colors.add(c);

            colors.add(ColorTemplate.getHoloBlue());

            dataSet.setColors(colors);
            //dataSet.setSelectionShift(0f);

            PieData data = new PieData(dataSet);
            data.setValueFormatter(new PercentFormatter());
            data.setValueTextSize(11f);
            data.setValueTextColor(Color.GRAY);
            data.setValueTypeface(mTfLight);
            mChart.setData(data);

            // undo all highlights
            mChart.highlightValues(null);

            mChart.invalidate();
        }


    }
}
