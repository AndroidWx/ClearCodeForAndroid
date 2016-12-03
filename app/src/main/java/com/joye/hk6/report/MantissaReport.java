package com.joye.hk6.report;

import com.joye.hk6.view.IPieChartCallback;
import com.joye.hk6domain.vo.MantissaVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.Func9;
import rx.schedulers.Schedulers;

/**
 * Created by W,x (JoyeWang)
 * on 2016/11/5.
 * 304622254@qq.com
 * Remeark:尾数报表统计
 */

public class MantissaReport extends BaseReport {
    /**
     * 总数据
     */
    private final List<MantissaVo> colorVos;

    public static final int MIN_VALUE = 21;

    public MantissaReport(List<MantissaVo> chineseZodiacVos) {
        this.colorVos = chineseZodiacVos;
    }

    @Override
    public void BubbleSort(final IPieChartCallback callback) {
        Observable<Map<Integer, Integer>> Mantissa0 = Observable.just(colorVos).flatMap(new Func1<List<MantissaVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).Mantissa0 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).Mantissa0) != null) {
                        blueNum = blueMap.get(colorVos.get(i).Mantissa0);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).Mantissa0, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("Mantissa0", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> Mantissa1 = Observable.just(colorVos).flatMap(new Func1<List<MantissaVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).Mantissa1 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).Mantissa1) != null) {
                        blueNum = blueMap.get(colorVos.get(i).Mantissa1);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).Mantissa1, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("Mantissa1", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable<Map<Integer, Integer>> Mantissa2 = Observable.just(colorVos).flatMap(new Func1<List<MantissaVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).Mantissa2 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).Mantissa2) != null) {
                        blueNum = blueMap.get(colorVos.get(i).Mantissa2);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).Mantissa2, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("Mantissa2", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> Mantissa3 = Observable.just(colorVos).flatMap(new Func1<List<MantissaVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).Mantissa3 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).Mantissa3) != null) {
                        blueNum = blueMap.get(colorVos.get(i).Mantissa3);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).Mantissa3, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("Mantissa3", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> Mantissa4 = Observable.just(colorVos).flatMap(new Func1<List<MantissaVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).Mantissa4 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).Mantissa4) != null) {
                        blueNum = blueMap.get(colorVos.get(i).Mantissa4);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).Mantissa4, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("Mantissa4", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> Mantissa5 = Observable.just(colorVos).flatMap(new Func1<List<MantissaVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).Mantissa5 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).Mantissa5) != null) {
                        blueNum = blueMap.get(colorVos.get(i).Mantissa5);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).Mantissa5, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("Mantissa5", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> Mantissa6 = Observable.just(colorVos).flatMap(new Func1<List<MantissaVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).Mantissa6 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).Mantissa6) != null) {
                        blueNum = blueMap.get(colorVos.get(i).Mantissa6);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).Mantissa6, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("Mantissa6", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable<Map<Integer, Integer>> Mantissa7 = Observable.just(colorVos).flatMap(new Func1<List<MantissaVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).Mantissa7 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).Mantissa7) != null) {
                        blueNum = blueMap.get(colorVos.get(i).Mantissa7);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).Mantissa7, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("Mantissa7", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> Mantissa8 = Observable.just(colorVos).flatMap(new Func1<List<MantissaVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).Mantissa8 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).Mantissa8) != null) {
                        blueNum = blueMap.get(colorVos.get(i).Mantissa8);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).Mantissa8, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("Mantissa8", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> Mantissa9 = Observable.just(colorVos).flatMap(new Func1<List<MantissaVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).Mantissa9 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).Mantissa9) != null) {
                        blueNum = blueMap.get(colorVos.get(i).Mantissa9);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).Mantissa9, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("Mantissa9", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable<ArrayList<PieChartImpl>> o0_9 = Observable.zip(Mantissa0, Mantissa1, Mantissa2, Mantissa3, Mantissa4, Mantissa5, Mantissa6, Mantissa7, Mantissa8, new Func9<Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, ArrayList<PieChartImpl>>() {

            @Override
            public ArrayList<PieChartImpl> call(Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, Map<Integer, Integer> map4, Map<Integer, Integer> map5, Map<Integer, Integer> map6, Map<Integer, Integer> map7, Map<Integer, Integer> map8, Map<Integer, Integer> map9) {
                ArrayList<PieChartImpl> datas = new ArrayList<PieChartImpl>();
                datas.add(genPieChartImpl(map, "0尾"));
                datas.add(genPieChartImpl(map2, "1尾"));
                datas.add(genPieChartImpl(map3, "2尾"));
                datas.add(genPieChartImpl(map4, "3尾"));
                datas.add(genPieChartImpl(map5, "4尾"));
                datas.add(genPieChartImpl(map6, "5尾"));
                datas.add(genPieChartImpl(map7, "6尾"));
                datas.add(genPieChartImpl(map8, "7尾"));
                datas.add(genPieChartImpl(map9, "8尾"));
                return datas;
            }
        }).subscribeOn(Schedulers.newThread());
        Observable.zip(o0_9, Mantissa9, new Func2<ArrayList<PieChartImpl>, Map<Integer, Integer>, Void>() {
            @Override
            public Void call(ArrayList<PieChartImpl> pieCharts, Map<Integer, Integer> map) {
                if (callback != null) {
                    pieCharts.add(genPieChartImpl(map, "9尾"));
                    callback.callback(pieCharts);
                }
                return null;
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe();
    }
}
