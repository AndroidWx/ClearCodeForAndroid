package com.joye.hk6.view;

import com.joye.hk6.report.PieChartImpl;

import java.util.ArrayList;

/**
 * Created by xiang on 16/11/17.
 */

public interface IPieChartCallback {
    void callback(ArrayList<PieChartImpl> datas);
}
