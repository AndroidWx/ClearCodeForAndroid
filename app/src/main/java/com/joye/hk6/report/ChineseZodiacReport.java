package com.joye.hk6.report;

import com.joye.hk6.view.IPieChartCallback;
import com.joye.hk6domain.vo.ChineseZodiacVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func9;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/11/18.
 */

public class ChineseZodiacReport extends BaseReport {
    public final List<ChineseZodiacVo> chineseZodiacVos;
    public static final int MIN_VALUE = 27;

    public ChineseZodiacReport(List<ChineseZodiacVo> chineseZodiacVos) {
        this.chineseZodiacVos = chineseZodiacVos;
    }

    @Override
    public void BubbleSort(final IPieChartCallback callback) {
        Observable<Map<Integer, Integer>> Mouse = Observable.just(chineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> chineseZodiacVos) {
                List<Statistics> mDatas = new ArrayList<>();
                final Map<Integer, Integer> map = new TreeMap<>();
                for (int i = 0; i < chineseZodiacVos.size(); i++) {
                    if (chineseZodiacVos.get(i).Mouse < MIN_VALUE) {
                        continue;
                    }
                    int mouseNum = 0;
                    if (map.get(chineseZodiacVos.get(i).Mouse) != null) {
                        mouseNum = map.get(chineseZodiacVos.get(i).Mouse);
                    }
                    mouseNum++;
                    map.put(chineseZodiacVos.get(i).Mouse, mouseNum);
                }
                for (Integer integer : map.keySet()) {
                    Statistics item = new Statistics(integer, map.get(integer));
                    mDatas.add(item);
                }
                return Observable.just(mBubbleSort(mDatas));
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> Cow = Observable.just(chineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> chineseZodiacVos) {
                List<Statistics> mDatas = new ArrayList<>();
                final Map<Integer, Integer> map = new TreeMap<>();
                for (int i = 0; i < chineseZodiacVos.size(); i++) {
                    if (chineseZodiacVos.get(i).Cow < MIN_VALUE) {
                        continue;
                    }
                    int CowNum = 0;
                    if (map.get(chineseZodiacVos.get(i).Cow) != null) {
                        CowNum = map.get(chineseZodiacVos.get(i).Cow);
                    }
                    CowNum++;
                    map.put(chineseZodiacVos.get(i).Cow, CowNum);
                }
                for (Integer integer : map.keySet()) {
                    Statistics item = new Statistics(integer, map.get(integer));
                    mDatas.add(item);
                }
                return Observable.just(mBubbleSort(mDatas));
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> Tiger = Observable.just(chineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> chineseZodiacVos) {
                List<Statistics> mDatas = new ArrayList<>();
                final Map<Integer, Integer> map = new TreeMap<>();
                for (int i = 0; i < chineseZodiacVos.size(); i++) {
                    if (chineseZodiacVos.get(i).Tiger < MIN_VALUE) {
                        continue;
                    }
                    int TigerNum = 0;
                    if (map.get(chineseZodiacVos.get(i).Tiger) != null) {
                        TigerNum = map.get(chineseZodiacVos.get(i).Tiger);
                    }
                    TigerNum++;
                    map.put(chineseZodiacVos.get(i).Tiger, TigerNum);
                }
                for (Integer integer : map.keySet()) {
                    Statistics item = new Statistics(integer, map.get(integer));
                    mDatas.add(item);
                }
                return Observable.just(mBubbleSort(mDatas));
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> Rabbit = Observable.just(chineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> chineseZodiacVos) {
                List<Statistics> mDatas = new ArrayList<>();
                final Map<Integer, Integer> map = new TreeMap<>();
                for (int i = 0; i < chineseZodiacVos.size(); i++) {
                    if (chineseZodiacVos.get(i).Rabbit < MIN_VALUE) {
                        continue;
                    }
                    int RabbitNum = 0;
                    if (map.get(chineseZodiacVos.get(i).Rabbit) != null) {
                        RabbitNum = map.get(chineseZodiacVos.get(i).Rabbit);
                    }
                    RabbitNum++;
                    map.put(chineseZodiacVos.get(i).Rabbit, RabbitNum);
                }
                for (Integer integer : map.keySet()) {
                    Statistics item = new Statistics(integer, map.get(integer));
                    mDatas.add(item);
                }
                return Observable.just(mBubbleSort(mDatas));
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> Dragon = Observable.just(chineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> chineseZodiacVos) {
                List<Statistics> mDatas = new ArrayList<>();
                final Map<Integer, Integer> map = new TreeMap<>();
                for (int i = 0; i < chineseZodiacVos.size(); i++) {
                    if (chineseZodiacVos.get(i).Dragon < MIN_VALUE) {
                        continue;
                    }
                    int DragonNum = 0;
                    if (map.get(chineseZodiacVos.get(i).Dragon) != null) {
                        DragonNum = map.get(chineseZodiacVos.get(i).Dragon);
                    }
                    DragonNum++;
                    map.put(chineseZodiacVos.get(i).Dragon, DragonNum);
                }
                for (Integer integer : map.keySet()) {
                    Statistics item = new Statistics(integer, map.get(integer));
                    mDatas.add(item);
                }
                return Observable.just(mBubbleSort(mDatas));
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> Snake = Observable.just(chineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> chineseZodiacVos) {
                List<Statistics> mDatas = new ArrayList<>();
                final Map<Integer, Integer> map = new TreeMap<>();
                for (int i = 0; i < chineseZodiacVos.size(); i++) {
                    if (chineseZodiacVos.get(i).Snake < MIN_VALUE) {
                        continue;
                    }
                    int SnakeNum = 0;
                    if (map.get(chineseZodiacVos.get(i).Snake) != null) {
                        SnakeNum = map.get(chineseZodiacVos.get(i).Snake);
                    }
                    SnakeNum++;
                    map.put(chineseZodiacVos.get(i).Snake, SnakeNum);
                }
                for (Integer integer : map.keySet()) {
                    Statistics item = new Statistics(integer, map.get(integer));
                    mDatas.add(item);
                }
                return Observable.just(mBubbleSort(mDatas));
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> Horse = Observable.just(chineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> chineseZodiacVos) {
                List<Statistics> mDatas = new ArrayList<>();
                final Map<Integer, Integer> map = new TreeMap<>();
                for (int i = 0; i < chineseZodiacVos.size(); i++) {
                    if (chineseZodiacVos.get(i).Horse < MIN_VALUE) {
                        continue;
                    }
                    int HorseNum = 0;
                    if (map.get(chineseZodiacVos.get(i).Horse) != null) {
                        HorseNum = map.get(chineseZodiacVos.get(i).Horse);
                    }
                    HorseNum++;
                    map.put(chineseZodiacVos.get(i).Horse, HorseNum);
                }
                for (Integer integer : map.keySet()) {
                    Statistics item = new Statistics(integer, map.get(integer));
                    mDatas.add(item);
                }
                return Observable.just(mBubbleSort(mDatas));
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> Sheep = Observable.just(chineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> chineseZodiacVos) {
                List<Statistics> mDatas = new ArrayList<>();
                final Map<Integer, Integer> map = new TreeMap<>();
                for (int i = 0; i < chineseZodiacVos.size(); i++) {
                    if (chineseZodiacVos.get(i).Sheep < MIN_VALUE) {
                        continue;
                    }
                    int SheepNum = 0;
                    if (map.get(chineseZodiacVos.get(i).Sheep) != null) {
                        SheepNum = map.get(chineseZodiacVos.get(i).Sheep);
                    }
                    SheepNum++;
                    map.put(chineseZodiacVos.get(i).Sheep, SheepNum);
                }
                for (Integer integer : map.keySet()) {
                    Statistics item = new Statistics(integer, map.get(integer));
                    mDatas.add(item);
                }
                return Observable.just(mBubbleSort(mDatas));
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> Monkey = Observable.just(chineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> chineseZodiacVos) {
                List<Statistics> mDatas = new ArrayList<>();
                final Map<Integer, Integer> map = new TreeMap<>();
                for (int i = 0; i < chineseZodiacVos.size(); i++) {
                    if (chineseZodiacVos.get(i).Monkey < MIN_VALUE) {
                        continue;
                    }
                    int MonkeyNum = 0;
                    if (map.get(chineseZodiacVos.get(i).Monkey) != null) {
                        MonkeyNum = map.get(chineseZodiacVos.get(i).Monkey);
                    }
                    MonkeyNum++;
                    map.put(chineseZodiacVos.get(i).Monkey, MonkeyNum);
                }
                for (Integer integer : map.keySet()) {
                    Statistics item = new Statistics(integer, map.get(integer));
                    mDatas.add(item);
                }
                return Observable.just(mBubbleSort(mDatas));
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> Chook = Observable.just(chineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> chineseZodiacVos) {
                List<Statistics> mDatas = new ArrayList<>();
                final Map<Integer, Integer> map = new TreeMap<>();
                for (int i = 0; i < chineseZodiacVos.size(); i++) {
                    if (chineseZodiacVos.get(i).Chook < MIN_VALUE) {
                        continue;
                    }
                    int ChookNum = 0;
                    if (map.get(chineseZodiacVos.get(i).Chook) != null) {
                        ChookNum = map.get(chineseZodiacVos.get(i).Chook);
                    }
                    ChookNum++;
                    map.put(chineseZodiacVos.get(i).Chook, ChookNum);
                }
                for (Integer integer : map.keySet()) {
                    Statistics item = new Statistics(integer, map.get(integer));
                    mDatas.add(item);
                }
                return Observable.just(mBubbleSort(mDatas));
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> Dog = Observable.just(chineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> chineseZodiacVos) {
                List<Statistics> mDatas = new ArrayList<>();
                final Map<Integer, Integer> map = new TreeMap<>();
                for (int i = 0; i < chineseZodiacVos.size(); i++) {
                    if (chineseZodiacVos.get(i).Dog < MIN_VALUE) {
                        continue;
                    }
                    int DogNum = 0;
                    if (map.get(chineseZodiacVos.get(i).Dog) != null) {
                        DogNum = map.get(chineseZodiacVos.get(i).Dog);
                    }
                    DogNum++;
                    map.put(chineseZodiacVos.get(i).Dog, DogNum);
                }
                for (Integer integer : map.keySet()) {
                    Statistics item = new Statistics(integer, map.get(integer));
                    mDatas.add(item);
                }
                return Observable.just(mBubbleSort(mDatas));
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> Pig = Observable.just(chineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> chineseZodiacVos) {
                List<Statistics> mDatas = new ArrayList<>();
                final Map<Integer, Integer> map = new TreeMap<>();
                for (int i = 0; i < chineseZodiacVos.size(); i++) {
                    if (chineseZodiacVos.get(i).Pig < MIN_VALUE) {
                        continue;
                    }
                    int PigNum = 0;
                    if (map.get(chineseZodiacVos.get(i).Pig) != null) {
                        PigNum = map.get(chineseZodiacVos.get(i).Pig);
                    }
                    PigNum++;
                    map.put(chineseZodiacVos.get(i).Pig, PigNum);
                }
                for (Integer integer : map.keySet()) {
                    Statistics item = new Statistics(integer, map.get(integer));
                    mDatas.add(item);
                }
                return Observable.just(mBubbleSort(mDatas));
            }
        }).subscribeOn(Schedulers.newThread());

        Observable<List<PieChartImpl>> someData = Observable.zip(Mouse, Cow, Tiger, Rabbit, Dragon, Snake, Horse, Sheep, Monkey, new Func9<Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, List<PieChartImpl>>() {
            @Override
            public List<PieChartImpl> call(Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, Map<Integer, Integer> map4, Map<Integer, Integer> map5, Map<Integer, Integer> map6, Map<Integer, Integer> map7, Map<Integer, Integer> map8, Map<Integer, Integer> map9) {
                ArrayList<PieChartImpl> datas = new ArrayList<PieChartImpl>();
                datas.add(genPieChartImpl(map, "鼠"));
                datas.add(genPieChartImpl(map2, "牛"));
                datas.add(genPieChartImpl(map3, "虎"));
                datas.add(genPieChartImpl(map4, "兔"));
                datas.add(genPieChartImpl(map5, "龙"));
                datas.add(genPieChartImpl(map6, "蛇"));
                datas.add(genPieChartImpl(map7, "马"));
                datas.add(genPieChartImpl(map8, "羊"));
                datas.add(genPieChartImpl(map9, "猴"));
                return datas;
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<List<PieChartImpl>> otherData = Observable.zip(Chook, Dog, Pig, new Func3<Map<Integer, Integer>, Map<Integer, Integer>, Map<Integer, Integer>, List<PieChartImpl>>() {
            @Override
            public List<PieChartImpl> call(Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3) {
                ArrayList<PieChartImpl> datas = new ArrayList<PieChartImpl>();
                datas.add(genPieChartImpl(map, "鸡"));
                datas.add(genPieChartImpl(map2, "狗"));
                datas.add(genPieChartImpl(map3, "猪"));
                return datas;
            }
        }).subscribeOn(Schedulers.newThread());
        Observable.zip(someData, otherData, new Func2<List<PieChartImpl>, List<PieChartImpl>, Void>() {
            @Override
            public Void call(List<PieChartImpl> pieCharts, List<PieChartImpl> pieCharts2) {
                ArrayList<PieChartImpl> datas = new ArrayList<PieChartImpl>();
                datas.addAll(pieCharts);
                datas.addAll(pieCharts2);
                if(callback!=null){
                    callback.callback(datas);
                }
                return null;
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe();;
    }
}
