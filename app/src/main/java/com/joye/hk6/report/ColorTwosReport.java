package com.joye.hk6.report;

import com.joye.hk6.view.IPieChartCallback;
import com.joye.hk6domain.vo.ColorTwosVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func6;
import rx.schedulers.Schedulers;

/**
 * Created by W,x (JoyeWang)
 * on 2016/11/5.
 * 304622254@qq.com
 * Remeark:波色报表统计
 */

public class ColorTwosReport extends BaseReport{
    /**
     * 总数据
     */
    private final List<ColorTwosVo> colorVos;

    public static final int MIN_VALUE=18;



    public ColorTwosReport(List<ColorTwosVo> chineseZodiacVos) {
        this.colorVos = chineseZodiacVos;
    }




//    private Func1<ColorVo,Boolean> filterBlueFunc=new Func1<ColorVo, Boolean>() {
//        @Override
//        public Boolean call(ColorVo colorVo) {
//            return colorVo.Blue>MIN_VALUE;
//        }
//    };
//    private Func1<ColorVo,Boolean> filterRedFunc=new Func1<ColorVo, Boolean>() {
//        @Override
//        public Boolean call(ColorVo colorVo) {
//            return colorVo.Red>MIN_VALUE;
//        }
//    };
//    private Func1<ColorVo,Boolean> filterGreenFunc=new Func1<ColorVo, Boolean>() {
//        @Override
//        public Boolean call(ColorVo colorVo) {
//            return colorVo.Green>MIN_VALUE;
//        }
//    };


    @Override
    public void BubbleSort(final IPieChartCallback callback){
        Observable<Map<Integer, Integer>> blueEven = Observable.just(colorVos).flatMap(new Func1<List<ColorTwosVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<ColorTwosVo> colorVos) {
                List<Statistics> blueDatas =new ArrayList<>();
                final Map<Integer,Integer>  blueMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).blueEven<MIN_VALUE){
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).blueEven) != null) {
                        blueNum = blueMap.get(colorVos.get(i).blueEven);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).blueEven, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("blueEven", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> blueOdd = Observable.just(colorVos).flatMap(new Func1<List<ColorTwosVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<ColorTwosVo> colorVos) {
                List<Statistics> redDatas =new ArrayList<>();
                final Map<Integer,Integer>  redMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).blueOdd<MIN_VALUE){
                        continue;
                    }
                    int redNum = 0;
                    if (redMap.get(colorVos.get(i).blueOdd) != null) {
                        redNum = redMap.get(colorVos.get(i).blueOdd);
                    }
                    redNum++;
                    redMap.put(colorVos.get(i).blueOdd, redNum);
                }
                for (Integer integer : redMap.keySet()) {
                    Statistics item = new Statistics("blueOdd", integer, redMap.get(integer));
                    redDatas.add(item);
                }
                Map<Integer, Integer> retRedMap = mBubbleSort(redDatas);
                return Observable.just(retRedMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> redEven = Observable.just(colorVos).flatMap(new Func1<List<ColorTwosVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<ColorTwosVo> colorVos) {
                List<Statistics> redDatas =new ArrayList<>();
                final Map<Integer,Integer>  redMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).redEven<MIN_VALUE){
                        continue;
                    }
                    int redNum = 0;
                    if (redMap.get(colorVos.get(i).redEven) != null) {
                        redNum = redMap.get(colorVos.get(i).redEven);
                    }
                    redNum++;
                    redMap.put(colorVos.get(i).redEven, redNum);
                }
                for (Integer integer : redMap.keySet()) {
                    Statistics item = new Statistics("redEven", integer, redMap.get(integer));
                    redDatas.add(item);
                }
                Map<Integer, Integer> retRedMap = mBubbleSort(redDatas);
                return Observable.just(retRedMap);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable<Map<Integer, Integer>> redOdd = Observable.just(colorVos).flatMap(new Func1<List<ColorTwosVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<ColorTwosVo> colorVos) {
                final Map<Integer,Integer>  greenMap=new TreeMap<>();
                List<Statistics> greenDatas =new ArrayList<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).redOdd<MIN_VALUE){
                        continue;
                    }
                    int greenNum = 0;
                    if (greenMap.get(colorVos.get(i).redOdd) != null) {
                        greenNum = greenMap.get(colorVos.get(i).redOdd);
                    }
                    greenNum++;
                    greenMap.put(colorVos.get(i).redOdd, greenNum);
                }
                for (Integer integer : greenMap.keySet()) {
                    Statistics item = new Statistics("redOdd", integer, greenMap.get(integer));
                    greenDatas.add(item);
                }
                Map<Integer, Integer> retRedMap = mBubbleSort(greenDatas);
                return Observable.just(retRedMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>>  greenEven= Observable.just(colorVos).flatMap(new Func1<List<ColorTwosVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<ColorTwosVo> colorVos) {
                final Map<Integer,Integer>  greenMap=new TreeMap<>();
                List<Statistics> greenDatas =new ArrayList<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).greenEven<MIN_VALUE){
                        continue;
                    }
                    int greenNum = 0;
                    if (greenMap.get(colorVos.get(i).greenEven) != null) {
                        greenNum = greenMap.get(colorVos.get(i).greenEven);
                    }
                    greenNum++;
                    greenMap.put(colorVos.get(i).greenEven, greenNum);
                }
                for (Integer integer : greenMap.keySet()) {
                    Statistics item = new Statistics("greenEven", integer, greenMap.get(integer));
                    greenDatas.add(item);
                }
                Map<Integer, Integer> retRedMap = mBubbleSort(greenDatas);
                return Observable.just(retRedMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>>  greenOdd= Observable.just(colorVos).flatMap(new Func1<List<ColorTwosVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<ColorTwosVo> colorVos) {
                final Map<Integer,Integer>  greenMap=new TreeMap<>();
                List<Statistics> greenDatas =new ArrayList<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).greenOdd<MIN_VALUE){
                        continue;
                    }
                    int greenNum = 0;
                    if (greenMap.get(colorVos.get(i).greenOdd) != null) {
                        greenNum = greenMap.get(colorVos.get(i).greenOdd);
                    }
                    greenNum++;
                    greenMap.put(colorVos.get(i).greenOdd, greenNum);
                }
                for (Integer integer : greenMap.keySet()) {
                    Statistics item = new Statistics("greenOdd", integer, greenMap.get(integer));
                    greenDatas.add(item);
                }
                Map<Integer, Integer> retRedMap = mBubbleSort(greenDatas);
                return Observable.just(retRedMap);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable.zip(redEven, redOdd, greenEven,greenOdd,blueEven,blueOdd, new Func6<Map<Integer,Integer>, Map<Integer,Integer>, Map<Integer,Integer>,Map<Integer,Integer>,Map<Integer,Integer>,Map<Integer,Integer>, Void>() {

            @Override
            public Void call(Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, Map<Integer, Integer> map4, Map<Integer, Integer> map5, Map<Integer, Integer> map6) {
                if(callback!=null) {
                    ArrayList<PieChartImpl> datas=new ArrayList<PieChartImpl>();
                    datas.add(genPieChartImpl(map,"红双"));
                    datas.add(genPieChartImpl(map2,"红单"));
                    datas.add(genPieChartImpl(map3,"绿双"));
                    datas.add(genPieChartImpl(map4,"绿单"));
                    datas.add(genPieChartImpl(map5,"蓝双"));
                    datas.add(genPieChartImpl(map6,"蓝单"));
                    callback.callback(datas);
                }
                return null;
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe();
    }
}
