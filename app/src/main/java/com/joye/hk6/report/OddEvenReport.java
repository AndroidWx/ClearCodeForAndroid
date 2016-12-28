package com.joye.hk6.report;

import com.joye.hk6.view.IPieChartCallback;
import com.joye.hk6domain.vo.OddEvenVo;
import com.joye.hk6domain.vo.OddEvenVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

import static com.joye.hk6.util.demarcations.OddEvenDemarcations.Even;
import static com.joye.hk6.util.demarcations.OddEvenDemarcations.Odd;


/**
 * Created by W,x (JoyeWang)
 * on 2016/11/5.
 * 304622254@qq.com
 * Remeark:波色报表统计
 */

public class OddEvenReport extends BaseReport{
    /**
     * 总数据
     */
    private final List<OddEvenVo> colorVos;

    public static final int MIN_VALUE=5;



    public OddEvenReport(List<OddEvenVo> chineseZodiacVos) {
        this.colorVos = chineseZodiacVos;
    }



    @Override
    public void BubbleSort(final IPieChartCallback callback){
        Observable<Map<Integer, Integer>> Odd = Observable.just(colorVos).flatMap(new Func1<List<OddEvenVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<OddEvenVo> colorVos) {
                List<Statistics> blueDatas =new ArrayList<>();
                final Map<Integer,Integer>  blueMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).Odd<MIN_VALUE){
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).Odd) != null) {
                        blueNum = blueMap.get(colorVos.get(i).Odd);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).Odd, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("Odd", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> Even = Observable.just(colorVos).flatMap(new Func1<List<OddEvenVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<OddEvenVo> colorVos) {
                List<Statistics> blueDatas =new ArrayList<>();
                final Map<Integer,Integer>  blueMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).Even<MIN_VALUE){
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).Even) != null) {
                        blueNum = blueMap.get(colorVos.get(i).Even);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).Even, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("Even", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable.zip(Odd, Even , new Func2<Map<Integer,Integer>, Map<Integer,Integer>, Void>() {
            @Override
            public Void call(Map<Integer, Integer> map, Map<Integer, Integer> map2 ) {
                if(callback!=null) {
                    ArrayList<PieChartImpl> datas=new ArrayList<PieChartImpl>();
                    datas.add(genPieChartImpl(map,"单"));
                    datas.add(genPieChartImpl(map2,"双"));
                    callback.callback(datas);
                }
                return null;
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe();
    }

    @Override
    public void Demarcations(final IPieChartCallback callback) {
        Observable.zip(Odd(colorVos), Even(colorVos) , new Func2<Map<Integer,Integer>, Map<Integer,Integer>, Void>() {
            @Override
            public Void call(Map<Integer, Integer> map, Map<Integer, Integer> map2 ) {
                if(callback!=null) {
                    ArrayList<PieChartImpl> datas=new ArrayList<PieChartImpl>();
                    datas.add(demarcationPieChartImpl(map,"单"));
                    datas.add(demarcationPieChartImpl(map2,"双"));
                    callback.demarcationCallBack(datas);
                }
                return null;
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe();
    }
}
