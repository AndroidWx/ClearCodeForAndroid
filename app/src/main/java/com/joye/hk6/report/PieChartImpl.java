package com.joye.hk6.report;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by W,x (JoyeWang)
 * on 2016/11/10.
 * 304622254@qq.com
 * Remeark:
 */

public class PieChartImpl implements IPieChart, Parcelable {

    private String contentText;
    private ArrayList<Float> pieEntryFlotArrayList;
    private ArrayList<String> pieEntryLabelArrayList;


    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public ArrayList<Float> getPieEntryFlotArrayList() {
        return pieEntryFlotArrayList;
    }

    public void setPieEntryFlotArrayList(ArrayList<Float> pieEntryFlotArrayList) {
        this.pieEntryFlotArrayList = pieEntryFlotArrayList;
    }

    public ArrayList<String> getPieEntryLabelArrayList() {
        return pieEntryLabelArrayList;
    }

    public void setPieEntryLabelArrayList(ArrayList<String> pieEntryLabelArrayList) {
        this.pieEntryLabelArrayList = pieEntryLabelArrayList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.contentText);
        dest.writeList(this.pieEntryFlotArrayList);
        dest.writeStringList(this.pieEntryLabelArrayList);
    }

    public PieChartImpl() {
    }

    protected PieChartImpl(Parcel in) {
        this.contentText = in.readString();
        this.pieEntryFlotArrayList = new ArrayList<Float>();
        in.readList(this.pieEntryFlotArrayList, Float.class.getClassLoader());
        this.pieEntryLabelArrayList = in.createStringArrayList();
    }

    public static final Creator<PieChartImpl> CREATOR = new Creator<PieChartImpl>() {
        @Override
        public PieChartImpl createFromParcel(Parcel source) {
            return new PieChartImpl(source);
        }

        @Override
        public PieChartImpl[] newArray(int size) {
            return new PieChartImpl[size];
        }
    };
}
