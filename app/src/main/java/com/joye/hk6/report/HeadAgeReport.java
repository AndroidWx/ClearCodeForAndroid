package com.joye.hk6.report;

import com.joye.hk6.view.IPieChartCallback;
import com.joye.hk6domain.vo.HeadAgeVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func5;
import rx.schedulers.Schedulers;

import static com.joye.hk6.util.demarcations.HeadAgeDemarcations.headage0;
import static com.joye.hk6.util.demarcations.HeadAgeDemarcations.headage1;
import static com.joye.hk6.util.demarcations.HeadAgeDemarcations.headage2;
import static com.joye.hk6.util.demarcations.HeadAgeDemarcations.headage3;
import static com.joye.hk6.util.demarcations.HeadAgeDemarcations.headage4;

/**
 * Created by W,x (JoyeWang)
 * on 2016/11/5.
 * 304622254@qq.com
 * Remeark:头色报表统计
 */

public class HeadAgeReport extends BaseReport{
    /**
     * 总数据
     */
    private final List<HeadAgeVo> colorVos;

    public static final int MIN_VALUE=9;



    public HeadAgeReport(List<HeadAgeVo> chineseZodiacVos) {
        this.colorVos = chineseZodiacVos;
    }





    @Override
    public void BubbleSort(final IPieChartCallback callback){
        Observable<Map<Integer, Integer>> headage0 = Observable.just(colorVos).flatMap(new Func1<List<HeadAgeVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadAgeVo> colorVos) {
                List<Statistics> blueDatas =new ArrayList<>();
                final Map<Integer,Integer>  blueMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).headage0<MIN_VALUE){
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).headage0) != null) {
                        blueNum = blueMap.get(colorVos.get(i).headage0);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).headage0, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("headage0", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable<Map<Integer, Integer>> headage1 = Observable.just(colorVos).flatMap(new Func1<List<HeadAgeVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadAgeVo> colorVos) {
                List<Statistics> blueDatas =new ArrayList<>();
                final Map<Integer,Integer>  blueMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).headage1<MIN_VALUE){
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).headage1) != null) {
                        blueNum = blueMap.get(colorVos.get(i).headage1);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).headage1, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("headage1", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> headage2 = Observable.just(colorVos).flatMap(new Func1<List<HeadAgeVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadAgeVo> colorVos) {
                List<Statistics> blueDatas =new ArrayList<>();
                final Map<Integer,Integer>  blueMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).headage2<MIN_VALUE){
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).headage2) != null) {
                        blueNum = blueMap.get(colorVos.get(i).headage2);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).headage2, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("headage2", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> headage3 = Observable.just(colorVos).flatMap(new Func1<List<HeadAgeVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadAgeVo> colorVos) {
                List<Statistics> blueDatas =new ArrayList<>();
                final Map<Integer,Integer>  blueMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).headage3<MIN_VALUE){
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).headage3) != null) {
                        blueNum = blueMap.get(colorVos.get(i).headage3);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).headage3, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("headage3", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> headage4 = Observable.just(colorVos).flatMap(new Func1<List<HeadAgeVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadAgeVo> colorVos) {
                List<Statistics> blueDatas =new ArrayList<>();
                final Map<Integer,Integer>  blueMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).headage4<MIN_VALUE){
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).headage4) != null) {
                        blueNum = blueMap.get(colorVos.get(i).headage4);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).headage4, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("headage4", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable.zip(headage0,headage1,headage2,headage3,headage4, new Func5<Map<Integer,Integer>, Map<Integer,Integer>, Map<Integer,Integer>, Map<Integer,Integer>, Map<Integer,Integer>,Void>() {

            @Override
            public Void call(Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, Map<Integer, Integer> map4, Map<Integer, Integer> map5) {
                if(callback!=null) {
                    ArrayList<PieChartImpl> datas=new ArrayList<PieChartImpl>();
                    datas.add(genPieChartImpl(map,"0头"));
                    datas.add(genPieChartImpl(map2,"1头"));
                    datas.add(genPieChartImpl(map3,"2头"));
                    datas.add(genPieChartImpl(map4,"3头"));
                    datas.add(genPieChartImpl(map5,"4头"));
                    callback.callback(datas);
                }
                return null;
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe();



    }

    @Override
    public void Demarcations(final IPieChartCallback callback) {
        Observable.zip(headage0(colorVos),headage1(colorVos),headage2(colorVos),headage3(colorVos),headage4(colorVos), new Func5<Map<Integer,Integer>, Map<Integer,Integer>, Map<Integer,Integer>, Map<Integer,Integer>, Map<Integer,Integer>,Void>() {

            @Override
            public Void call(Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, Map<Integer, Integer> map4, Map<Integer, Integer> map5) {
                if(callback!=null) {
                    ArrayList<PieChartImpl> datas=new ArrayList<PieChartImpl>();
                    datas.add(demarcationPieChartImpl(map,"0头"));
                    datas.add(demarcationPieChartImpl(map2,"1头"));
                    datas.add(demarcationPieChartImpl(map3,"2头"));
                    datas.add(demarcationPieChartImpl(map4,"3头"));
                    datas.add(demarcationPieChartImpl(map5,"4头"));
                    callback.demarcationCallBack(datas);
                }
                return null;
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe();


    }
}
