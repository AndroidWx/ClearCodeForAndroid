package com.joye.hk6.report;

import com.joye.hk6.view.IPieChartCallback;
import com.joye.hk6domain.vo.HeadTwosVo;

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

import static com.joye.hk6.util.demarcations.HeadTwosDemarcations.HeadEven0;
import static com.joye.hk6.util.demarcations.HeadTwosDemarcations.HeadEven1;
import static com.joye.hk6.util.demarcations.HeadTwosDemarcations.HeadEven2;
import static com.joye.hk6.util.demarcations.HeadTwosDemarcations.HeadEven3;
import static com.joye.hk6.util.demarcations.HeadTwosDemarcations.HeadEven4;
import static com.joye.hk6.util.demarcations.HeadTwosDemarcations.HeadOdd0;
import static com.joye.hk6.util.demarcations.HeadTwosDemarcations.HeadOdd1;
import static com.joye.hk6.util.demarcations.HeadTwosDemarcations.HeadOdd2;
import static com.joye.hk6.util.demarcations.HeadTwosDemarcations.HeadOdd3;
import static com.joye.hk6.util.demarcations.HeadTwosDemarcations.HeadOdd4;

/**
 * Created by W,x (JoyeWang)
 * on 2016/11/5.
 * 304622254@qq.com
 * Remeark:合尾数报表统计
 */

public class HeadTwosReport extends BaseReport {
    /**
     * 总数据
     */
    private final List<HeadTwosVo> colorVos;

    public static final int MIN_VALUE = 21;

    public HeadTwosReport(List<HeadTwosVo> chineseZodiacVos) {
        this.colorVos = chineseZodiacVos;
    }

    @Override
    public void BubbleSort(final IPieChartCallback callback) {
        Observable<Map<Integer, Integer>> HeadEven0 = Observable.just(colorVos).flatMap(new Func1<List<HeadTwosVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadTwosVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).HeadEven0 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).HeadEven0) != null) {
                        blueNum = blueMap.get(colorVos.get(i).HeadEven0);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).HeadEven0, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("HeadEven0", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> HeadEven1 = Observable.just(colorVos).flatMap(new Func1<List<HeadTwosVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadTwosVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).HeadEven1 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).HeadEven1) != null) {
                        blueNum = blueMap.get(colorVos.get(i).HeadEven1);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).HeadEven1, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("HeadEven1", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable<Map<Integer, Integer>> HeadEven2 = Observable.just(colorVos).flatMap(new Func1<List<HeadTwosVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadTwosVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).HeadEven2 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).HeadEven2) != null) {
                        blueNum = blueMap.get(colorVos.get(i).HeadEven2);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).HeadEven2, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("HeadEven2", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> HeadEven3 = Observable.just(colorVos).flatMap(new Func1<List<HeadTwosVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadTwosVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).HeadEven3 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).HeadEven3) != null) {
                        blueNum = blueMap.get(colorVos.get(i).HeadEven3);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).HeadEven3, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("HeadEven3", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> HeadEven4 = Observable.just(colorVos).flatMap(new Func1<List<HeadTwosVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadTwosVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).HeadEven4 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).HeadEven4) != null) {
                        blueNum = blueMap.get(colorVos.get(i).HeadEven4);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).HeadEven4, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("HeadEven4", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> HeadOdd0 = Observable.just(colorVos).flatMap(new Func1<List<HeadTwosVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadTwosVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).HeadOdd0 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).HeadOdd0) != null) {
                        blueNum = blueMap.get(colorVos.get(i).HeadOdd0);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).HeadOdd0, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("HeadOdd0", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> HeadOdd1 = Observable.just(colorVos).flatMap(new Func1<List<HeadTwosVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadTwosVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).HeadOdd1 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).HeadOdd1) != null) {
                        blueNum = blueMap.get(colorVos.get(i).HeadOdd1);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).HeadOdd1, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("HeadOdd1", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable<Map<Integer, Integer>> HeadOdd2 = Observable.just(colorVos).flatMap(new Func1<List<HeadTwosVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadTwosVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).HeadOdd2 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).HeadOdd2) != null) {
                        blueNum = blueMap.get(colorVos.get(i).HeadOdd2);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).HeadOdd2, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("HeadOdd2", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> HeadOdd3 = Observable.just(colorVos).flatMap(new Func1<List<HeadTwosVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadTwosVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).HeadOdd3 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).HeadOdd3) != null) {
                        blueNum = blueMap.get(colorVos.get(i).HeadOdd3);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).HeadOdd3, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("HeadOdd3", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> HeadOdd4 = Observable.just(colorVos).flatMap(new Func1<List<HeadTwosVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadTwosVo> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (colorVos.get(i).HeadOdd4 < MIN_VALUE) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).HeadOdd4) != null) {
                        blueNum = blueMap.get(colorVos.get(i).HeadOdd4);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).HeadOdd4, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("HeadOdd4", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable<ArrayList<PieChartImpl>> o0_9 = Observable.zip(HeadEven0, HeadEven1, HeadEven2, HeadEven3, HeadEven4, HeadOdd0, HeadOdd1, HeadOdd2, HeadOdd3, new Func9<Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, ArrayList<PieChartImpl>>() {

            @Override
            public ArrayList<PieChartImpl> call(Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, Map<Integer, Integer> map4, Map<Integer, Integer> map5, Map<Integer, Integer> map6, Map<Integer, Integer> map7, Map<Integer, Integer> map8, Map<Integer, Integer> map9) {
                ArrayList<PieChartImpl> datas = new ArrayList<PieChartImpl>();
                datas.add(genPieChartImpl(map, "0头双"));
                datas.add(genPieChartImpl(map2, "1头双"));
                datas.add(genPieChartImpl(map3, "2头双"));
                datas.add(genPieChartImpl(map4, "3头双"));
                datas.add(genPieChartImpl(map5, "4头双"));
                datas.add(genPieChartImpl(map6, "0头单"));
                datas.add(genPieChartImpl(map7, "1头单"));
                datas.add(genPieChartImpl(map8, "2头单"));
                datas.add(genPieChartImpl(map9, "3头单"));
                return datas;
            }
        }).subscribeOn(Schedulers.newThread());
        Observable.zip(o0_9, HeadOdd4, new Func2<ArrayList<PieChartImpl>, Map<Integer, Integer>, Void>() {
            @Override
            public Void call(ArrayList<PieChartImpl> pieCharts, Map<Integer, Integer> map) {
                if (callback != null) {
                    pieCharts.add(genPieChartImpl(map, "4头单"));
                    callback.callback(pieCharts);
                }
                return null;
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe();
    }

    @Override
    public void Demarcations(final IPieChartCallback callback) {
        Observable<ArrayList<PieChartImpl>> o0_9 = Observable.zip(HeadEven0(colorVos), HeadEven1(colorVos),
                HeadEven2(colorVos), HeadEven3(colorVos), HeadEven4(colorVos), HeadOdd0(colorVos),
                HeadOdd1(colorVos), HeadOdd2(colorVos), HeadOdd3(colorVos), new Func9<Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, ArrayList<PieChartImpl>>() {

            @Override
            public ArrayList<PieChartImpl> call(Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, Map<Integer, Integer> map4, Map<Integer, Integer> map5, Map<Integer, Integer> map6, Map<Integer, Integer> map7, Map<Integer, Integer> map8, Map<Integer, Integer> map9) {
                ArrayList<PieChartImpl> datas = new ArrayList<PieChartImpl>();
                datas.add(demarcationPieChartImpl(map, "0头双"));
                datas.add(demarcationPieChartImpl(map2, "1头双"));
                datas.add(demarcationPieChartImpl(map3, "2头双"));
                datas.add(demarcationPieChartImpl(map4, "3头双"));
                datas.add(demarcationPieChartImpl(map5, "4头双"));
                datas.add(demarcationPieChartImpl(map6, "0头单"));
                datas.add(demarcationPieChartImpl(map7, "1头单"));
                datas.add(demarcationPieChartImpl(map8, "2头单"));
                datas.add(demarcationPieChartImpl(map9, "3头单"));
                return datas;
            }
        }).subscribeOn(Schedulers.newThread());
        Observable.zip(o0_9, HeadOdd4(colorVos), new Func2<ArrayList<PieChartImpl>, Map<Integer, Integer>, Void>() {
            @Override
            public Void call(ArrayList<PieChartImpl> pieCharts, Map<Integer, Integer> map) {
                if (callback != null) {
                    pieCharts.add(demarcationPieChartImpl(map, "4头单"));
                    callback.callback(pieCharts);
                }
                return null;
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe();
    }
}
