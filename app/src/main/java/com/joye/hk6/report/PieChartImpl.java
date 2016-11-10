package com.joye.hk6.report;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by W,x (JoyeWang)
 * on 2016/11/10.
 * 304622254@qq.com
 * Remeark:
 */

public class PieChartImpl implements IPieChart, Parcelable {

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public PieChartImpl() {
    }

    protected PieChartImpl(Parcel in) {
    }

    public static final Parcelable.Creator<PieChartImpl> CREATOR = new Parcelable.Creator<PieChartImpl>() {
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
