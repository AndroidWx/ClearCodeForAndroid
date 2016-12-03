package com.joye.hk6.report;

import com.joye.hk6.view.IPieChartCallback;
import com.joye.hk6domain.vo.CompositeMantissaVo;

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
 * Remeark:合尾数报表统计
 */

public class CompositeMantissaReport extends BaseReport {
    /**
     * 总数据
     */
    private final List<CompositeMantissaVo> colorVos;

    public static final int MIN_VALUE = 21;

    public CompositeMantissaReport(List<CompositeMantissaVo> chineseZodiacVos) {
        this.colorVos = chineseZodiacVos;
    }

    @Override
    public void BubbleSort(final IPieChartCallback callback) {
        Observable<Map<Integer, Integer>> composite0 = Observable.just(colorVos).flatMap(new Func1<List<CompositeMantissaVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeMantissaVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).composite0 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).composite0) != null) {
                        blueNum = blueMap.get(colorVos.get(i).composite0);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).composite0, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("composite0", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> composite1 = Observable.just(colorVos).flatMap(new Func1<List<CompositeMantissaVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeMantissaVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).composite1 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).composite1) != null) {
                        blueNum = blueMap.get(colorVos.get(i).composite1);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).composite1, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("composite1", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable<Map<Integer, Integer>> composite2 = Observable.just(colorVos).flatMap(new Func1<List<CompositeMantissaVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeMantissaVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).composite2 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).composite2) != null) {
                        blueNum = blueMap.get(colorVos.get(i).composite2);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).composite2, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("composite2", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> composite3 = Observable.just(colorVos).flatMap(new Func1<List<CompositeMantissaVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeMantissaVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).composite3 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).composite3) != null) {
                        blueNum = blueMap.get(colorVos.get(i).composite3);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).composite3, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("composite3", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> composite4 = Observable.just(colorVos).flatMap(new Func1<List<CompositeMantissaVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeMantissaVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).composite4 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).composite4) != null) {
                        blueNum = blueMap.get(colorVos.get(i).composite4);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).composite4, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("composite4", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> composite5 = Observable.just(colorVos).flatMap(new Func1<List<CompositeMantissaVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeMantissaVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).composite5 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).composite5) != null) {
                        blueNum = blueMap.get(colorVos.get(i).composite5);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).composite5, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("composite5", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> composite6 = Observable.just(colorVos).flatMap(new Func1<List<CompositeMantissaVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeMantissaVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).composite6 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).composite6) != null) {
                        blueNum = blueMap.get(colorVos.get(i).composite6);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).composite6, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("composite6", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable<Map<Integer, Integer>> composite7 = Observable.just(colorVos).flatMap(new Func1<List<CompositeMantissaVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeMantissaVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).composite7 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).composite7) != null) {
                        blueNum = blueMap.get(colorVos.get(i).composite7);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).composite7, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("composite7", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> composite8 = Observable.just(colorVos).flatMap(new Func1<List<CompositeMantissaVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeMantissaVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).composite8 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).composite8) != null) {
                        blueNum = blueMap.get(colorVos.get(i).composite8);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).composite8, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("composite8", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> composite9 = Observable.just(colorVos).flatMap(new Func1<List<CompositeMantissaVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeMantissaVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).composite9 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).composite9) != null) {
                        blueNum = blueMap.get(colorVos.get(i).composite9);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).composite9, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("composite9", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable<ArrayList<PieChartImpl>> o0_9 = Observable.zip(composite0, composite1, composite2, composite3, composite4, composite5, composite6, composite7, composite8, new Func9<Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, ArrayList<PieChartImpl>>() {

            @Override
            public ArrayList<PieChartImpl> call(Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, Map<Integer, Integer> map4, Map<Integer, Integer> map5, Map<Integer, Integer> map6, Map<Integer, Integer> map7, Map<Integer, Integer> map8, Map<Integer, Integer> map9) {
                ArrayList<PieChartImpl> datas = new ArrayList<PieChartImpl>();
                datas.add(genPieChartImpl(map, "0合"));
                datas.add(genPieChartImpl(map2, "1合"));
                datas.add(genPieChartImpl(map3, "2合"));
                datas.add(genPieChartImpl(map4, "3合"));
                datas.add(genPieChartImpl(map5, "4合"));
                datas.add(genPieChartImpl(map6, "5合"));
                datas.add(genPieChartImpl(map7, "6合"));
                datas.add(genPieChartImpl(map8, "7合"));
                datas.add(genPieChartImpl(map9, "8合"));
                return datas;
            }
        }).subscribeOn(Schedulers.newThread());
        Observable.zip(o0_9, composite9, new Func2<ArrayList<PieChartImpl>, Map<Integer, Integer>, Void>() {
            @Override
            public Void call(ArrayList<PieChartImpl> pieCharts, Map<Integer, Integer> map) {
                if (callback != null) {
                    pieCharts.add(genPieChartImpl(map, "9合"));
                    callback.callback(pieCharts);
                }
                return null;
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe();
    }
}
