package com.joye.hk6.report;

import com.joye.hk6.view.IPieChartCallback;
import com.joye.hk6domain.vo.GateCountVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func5;
import rx.schedulers.Schedulers;

import static com.joye.hk6.util.demarcations.GetCountDemarcations.gateCount1;
import static com.joye.hk6.util.demarcations.GetCountDemarcations.gateCount2;
import static com.joye.hk6.util.demarcations.GetCountDemarcations.gateCount3;
import static com.joye.hk6.util.demarcations.GetCountDemarcations.gateCount4;
import static com.joye.hk6.util.demarcations.GetCountDemarcations.gateCount5;

/**
 * Created by W,x (JoyeWang)
 * on 2016/11/5.
 * 304622254@qq.com
 * Remeark:合数报表统计
 */

public class GateCountReport extends BaseReport{
    /**
     * 总数据
     */
    private final List<GateCountVo> colorVos;

    public static final int MIN_VALUE=9;

    public GateCountReport(List<GateCountVo> chineseZodiacVos) {
        this.colorVos = chineseZodiacVos;
    }

    @Override
    public void BubbleSort(final IPieChartCallback callback){
        Observable<Map<Integer, Integer>> gateCount1 = Observable.just(colorVos).flatMap(new Func1<List<GateCountVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<GateCountVo> colorVos) {
                List<Statistics> blueDatas =new ArrayList<>();
                final Map<Integer,Integer>  blueMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).gateCount1<MIN_VALUE){
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).gateCount1) != null) {
                        blueNum = blueMap.get(colorVos.get(i).gateCount1);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).gateCount1, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("gateCount1", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable<Map<Integer, Integer>> gateCount2 = Observable.just(colorVos).flatMap(new Func1<List<GateCountVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<GateCountVo> colorVos) {
                List<Statistics> blueDatas =new ArrayList<>();
                final Map<Integer,Integer>  blueMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).gateCount2<MIN_VALUE){
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).gateCount2) != null) {
                        blueNum = blueMap.get(colorVos.get(i).gateCount2);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).gateCount2, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("gateCount2", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> gateCount3 = Observable.just(colorVos).flatMap(new Func1<List<GateCountVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<GateCountVo> colorVos) {
                List<Statistics> blueDatas =new ArrayList<>();
                final Map<Integer,Integer>  blueMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).gateCount3<MIN_VALUE){
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).gateCount3) != null) {
                        blueNum = blueMap.get(colorVos.get(i).gateCount3);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).gateCount3, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("gateCount3", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> gateCount4 = Observable.just(colorVos).flatMap(new Func1<List<GateCountVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<GateCountVo> colorVos) {
                List<Statistics> blueDatas =new ArrayList<>();
                final Map<Integer,Integer>  blueMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).gateCount4<MIN_VALUE){
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).gateCount4) != null) {
                        blueNum = blueMap.get(colorVos.get(i).gateCount4);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).gateCount4, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("gateCount4", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> gateCount5 = Observable.just(colorVos).flatMap(new Func1<List<GateCountVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<GateCountVo> colorVos) {
                List<Statistics> blueDatas =new ArrayList<>();
                final Map<Integer,Integer>  blueMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).gateCount5<MIN_VALUE){
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).gateCount5) != null) {
                        blueNum = blueMap.get(colorVos.get(i).gateCount5);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).gateCount5, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("gateCount5", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable.zip(gateCount1,gateCount2,gateCount3,gateCount4,gateCount5, new Func5<Map<Integer,Integer>, Map<Integer,Integer>, Map<Integer,Integer>, Map<Integer,Integer>, Map<Integer,Integer>,Void>() {

            @Override
            public Void call(Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, Map<Integer, Integer> map4, Map<Integer, Integer> map5) {
                if(callback!=null) {
                    ArrayList<PieChartImpl> datas=new ArrayList<PieChartImpl>();
                    datas.add(genPieChartImpl(map,"1门"));
                    datas.add(genPieChartImpl(map2,"2门"));
                    datas.add(genPieChartImpl(map3,"3门"));
                    datas.add(genPieChartImpl(map4,"4门"));
                    datas.add(genPieChartImpl(map5,"5门"));
                    callback.callback(datas);
                }
                return null;
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe();
    }

    @Override
    public void Demarcations(final IPieChartCallback callback) {
        Observable.zip(gateCount1(colorVos),
                gateCount2(colorVos),
                gateCount3(colorVos),
                gateCount4(colorVos),
                gateCount5(colorVos), new Func5<Map<Integer,Integer>, Map<Integer,Integer>, Map<Integer,Integer>, Map<Integer,Integer>, Map<Integer,Integer>,Void>() {

            @Override
            public Void call(Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, Map<Integer, Integer> map4, Map<Integer, Integer> map5) {
                if(callback!=null) {
                    ArrayList<PieChartImpl> datas=new ArrayList<PieChartImpl>();
                    datas.add(demarcationPieChartImpl(map,"1门"));
                    datas.add(demarcationPieChartImpl(map2,"2门"));
                    datas.add(demarcationPieChartImpl(map3,"3门"));
                    datas.add(demarcationPieChartImpl(map4,"4门"));
                    datas.add(demarcationPieChartImpl(map5,"5门"));
                    callback.demarcationCallBack(datas);
                }
                return null;
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe();
    }
}
