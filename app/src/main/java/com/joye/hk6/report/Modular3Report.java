package com.joye.hk6.report;

import com.joye.hk6.view.IPieChartCallback;
import com.joye.hk6domain.vo.Modular3Vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func3;
import rx.schedulers.Schedulers;

import static com.joye.hk6.util.demarcations.Modular3Demarcations.M0;
import static com.joye.hk6.util.demarcations.Modular3Demarcations.M1;
import static com.joye.hk6.util.demarcations.Modular3Demarcations.M2;

/**
 * Created by W,x (JoyeWang)
 * on 2016/11/5.
 * 304622254@qq.com
 * Remeark:合数报表统计
 */

public class Modular3Report extends BaseReport{
    /**
     * 总数据
     */
    private final List<Modular3Vo> colorVos;

    public static final int MIN_VALUE=5;

    public Modular3Report(List<Modular3Vo> chineseZodiacVos) {
        this.colorVos = chineseZodiacVos;
    }

    @Override
    public void BubbleSort(final IPieChartCallback callback){
        Observable<Map<Integer, Integer>> M0 = Observable.just(colorVos).flatMap(new Func1<List<Modular3Vo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular3Vo> colorVos) {
                List<Statistics> blueDatas =new ArrayList<>();
                final Map<Integer,Integer>  blueMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).M0<MIN_VALUE){
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).M0) != null) {
                        blueNum = blueMap.get(colorVos.get(i).M0);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).M0, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("M0", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable<Map<Integer, Integer>> M1 = Observable.just(colorVos).flatMap(new Func1<List<Modular3Vo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular3Vo> colorVos) {
                List<Statistics> blueDatas =new ArrayList<>();
                final Map<Integer,Integer>  blueMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).M1<MIN_VALUE){
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).M1) != null) {
                        blueNum = blueMap.get(colorVos.get(i).M1);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).M1, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("M1", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> M2 = Observable.just(colorVos).flatMap(new Func1<List<Modular3Vo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular3Vo> colorVos) {
                List<Statistics> blueDatas =new ArrayList<>();
                final Map<Integer,Integer>  blueMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).M2<MIN_VALUE){
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).M2) != null) {
                        blueNum = blueMap.get(colorVos.get(i).M2);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).M2, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("M2", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());


        Observable.zip(M0,M1,M2, new Func3<Map<Integer,Integer>, Map<Integer,Integer>, Map<Integer,Integer>,Void>() {


            @Override
            public Void call(Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3) {
                if(callback!=null) {
                    ArrayList<PieChartImpl> datas=new ArrayList<PieChartImpl>();
                    datas.add(genPieChartImpl(map,"模3余0"));
                    datas.add(genPieChartImpl(map2,"模3余1"));
                    datas.add(genPieChartImpl(map3,"模3余2"));
                    callback.callback(datas);
                }
                return null;
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe();
    }

    @Override
    public void Demarcations(final IPieChartCallback callback) {
        Observable.zip(M0(colorVos),M1(colorVos),M2(colorVos), new Func3<Map<Integer,Integer>, Map<Integer,Integer>, Map<Integer,Integer>,Void>() {


            @Override
            public Void call(Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3) {
                if(callback!=null) {
                    ArrayList<PieChartImpl> datas=new ArrayList<PieChartImpl>();
                    datas.add(demarcationPieChartImpl(map,"模3余0"));
                    datas.add(demarcationPieChartImpl(map2,"模3余1"));
                    datas.add(demarcationPieChartImpl(map3,"模3余2"));
                    callback.demarcationCallBack(datas);
                }
                return null;
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe();
    }
}
