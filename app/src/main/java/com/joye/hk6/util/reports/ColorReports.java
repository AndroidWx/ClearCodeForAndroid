package com.joye.hk6.util.reports;

import com.joye.hk6domain.vo.ColorVo;

import java.util.List;
import java.util.Map;

import rx.Observable;

/**
 * Created by xiang on 16/12/10.
 */

public class ColorReports {
    public static Observable<Map<Integer, Integer>> getBluemapObserverable(List<ColorVo> colorVos) {
        return new ReportUtils<ColorVo>() {
            @Override
            public int getMinValue() {
                return 9;
            }

            @Override
            public int getChild(ColorVo vo) {
                return vo.Blue;
            }
        }.getMapObservable(colorVos);
    }

    public static Observable<Map<Integer, Integer>> getRedmapObserverable(List<ColorVo> colorVos) {
        return new ReportUtils<ColorVo>() {
            @Override
            public int getMinValue() {
                return 9;
            }

            @Override
            public int getChild(ColorVo vo) {
                return vo.Red;
            }
        }.getMapObservable(colorVos);
    }

    public static Observable<Map<Integer, Integer>> getGreenObserverable(List<ColorVo> colorVos) {
        return new ReportUtils<ColorVo>() {
            @Override
            public int getMinValue() {
                return 9;
            }

            @Override
            public int getChild(ColorVo vo) {
                return vo.Green;
            }
        }.getMapObservable(colorVos);
    }
}
