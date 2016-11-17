package com.joye.hk6.report;

import com.joye.hk6domain.vo.ColorVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func3;
import rx.schedulers.Schedulers;

/**
 * Created by W,x (JoyeWang)
 * on 2016/11/5.
 * 304622254@qq.com
 * Remeark:波色报表统计
 */

public class ColorReport {
    /**
     * 总数据
     */
    private final List<ColorVo> colorVos;

    public static final int MIN_VALUE=9;

    public interface  IColorReport{
        void onReportMapData(Map<Integer,Integer> blueMap,Map<Integer,Integer>redMap,Map<Integer,Integer>greeMap);
    }


    public ColorReport(List<ColorVo> chineseZodiacVos) {
        this.colorVos = chineseZodiacVos;
    }


    private Map<Integer, Integer> mBubbleSort(List<Statistics> blueStatistics){
        Statistics[] vos=new Statistics[blueStatistics.size()];
        vos= blueStatistics.toArray(vos);
        Statistics temp = vos[0];
        for (int i = vos.length - 1; i > 0; --i)
        {
            for (int j = 0; j < i; ++j)
            {
                if (vos[j + 1].thresholdKey < vos[j].thresholdKey)
                {
                    temp = vos[j];
                    vos[j] = vos[j + 1];
                    vos[j + 1] = temp;
                }
            }
        }
        Map<Integer,Integer> realMap=new TreeMap();
        for (int i=0;i<vos.length;i++){
            int realValue=vos[i].getThresholdValue();
            for(int j=i+1;j<vos.length;j++){
                realValue=realValue-vos[j].getThresholdValue();
                realMap.put(vos[i].getThresholdKey(),realValue);
                break;
            }
            if((i+1)==vos.length){
                realMap.put(vos[i].getThresholdKey(),realValue);
            }

        }

        return realMap;

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



    public void BubbleSort(final IColorReport colorReport){
        Observable<Map<Integer, Integer>> bluemapObserverable = Observable.just(colorVos).flatMap(new Func1<List<ColorVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<ColorVo> colorVos) {
                List<Statistics> blueDatas =new ArrayList<>();
                final Map<Integer,Integer>  blueMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).Blue<MIN_VALUE){
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).Blue) != null) {
                        blueNum = blueMap.get(colorVos.get(i).Blue);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).Blue, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("blue", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> redmapObserverable = Observable.just(colorVos).flatMap(new Func1<List<ColorVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<ColorVo> colorVos) {
                List<Statistics> redDatas =new ArrayList<>();
                final Map<Integer,Integer>  redMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).Red<MIN_VALUE){
                        continue;
                    }
                    int redNum = 0;
                    if (redMap.get(colorVos.get(i).Red) != null) {
                        redNum = redMap.get(colorVos.get(i).Red);
                    }
                    redNum++;
                    redMap.put(colorVos.get(i).Red, redNum);
                }
                for (Integer integer : redMap.keySet()) {
                    Statistics item = new Statistics("red", integer, redMap.get(integer));
                    redDatas.add(item);
                }
                Map<Integer, Integer> retRedMap = mBubbleSort(redDatas);
                return Observable.just(retRedMap);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable<Map<Integer, Integer>> greenMapObserverable = Observable.just(colorVos).flatMap(new Func1<List<ColorVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<ColorVo> colorVos) {
                final Map<Integer,Integer>  greenMap=new TreeMap<>();
                List<Statistics> greenDatas =new ArrayList<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).Green<MIN_VALUE){
                        continue;
                    }
                    int greenNum = 0;
                    if (greenMap.get(colorVos.get(i).Green) != null) {
                        greenNum = greenMap.get(colorVos.get(i).Green);
                    }
                    greenNum++;
                    greenMap.put(colorVos.get(i).Green, greenNum);
                }
                for (Integer integer : greenMap.keySet()) {
                    Statistics item = new Statistics("green", integer, greenMap.get(integer));
                    greenDatas.add(item);
                }
                Map<Integer, Integer> retRedMap = mBubbleSort(greenDatas);
                return Observable.just(retRedMap);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable.zip(bluemapObserverable, redmapObserverable, greenMapObserverable, new Func3<Map<Integer,Integer>, Map<Integer,Integer>, Map<Integer,Integer>, Void>() {
            @Override
            public Void call(Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3) {
                if(colorReport!=null) {
                    colorReport.onReportMapData(map, map2, map3);
                }
                return null;
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe();



    }
//    public void BubbleSort(final IColorReport colorReport){
////        //获取最大的阈值
////        int maxValue=mBubbleSortBlueMaxValue();
//
//
//
//
//
//
//        Observable.from(colorVos).filter(filterBlueFunc).subscribeOn(Schedulers.from(JobExecutor_Factory.create().get())).subscribe(new Observer<ColorVo>() {
//
//            @Override
//            public void onCompleted() {
//                for (Integer integer : blueMap.keySet()) {
//                    Statistics item=new Statistics("blue",integer,blueMap.get(integer));
//                    blueDatas.add(item);
//                }
//                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
//                if(colorReport!=null) {
//                    colorReport.onReportMapData(retBlueMap, retRedMap, retGreenMap);
//                }else{
//                    throw new NullPointerException("colorReportCallback is null");
//                }
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onNext(ColorVo colorVo) {
//                int blueNum=0;
//                if(blueMap.get(colorVo.Blue)!=null){
//                    blueNum=blueMap.get(colorVo.Blue);
//                }
//                blueNum++;
//                blueMap.put(colorVo.Blue,blueNum);
//
//            }
//        });
//        Observable.from(colorVos).filter(filterRedFunc).subscribeOn(Schedulers.from(JobExecutor_Factory.create().get())).subscribe(new Observer<ColorVo>() {
//
//            @Override
//            public void onCompleted() {
//                for (Integer integer : redMap.keySet()) {
//                    Statistics item=new Statistics("red",integer,redMap.get(integer));
//                    redDatas.add(item);
//                }
//                Map<Integer, Integer> retRedMap = mBubbleSort(redDatas);
//                if(colorReport!=null) {
//                    colorReport.onReportMapData(retBlueMap, retRedMap, retGreenMap);
//                }else{
//                    throw new NullPointerException("colorReportCallback is null");
//                }
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onNext(ColorVo colorVo) {
//
//                int redNum=0;
//                if(redMap.get(colorVo.Red)!=null){
//                    redNum=redMap.get(colorVo.Red);
//                }
//                redNum++;
//                redMap.put(colorVo.Red,redNum);
//            }
//        });
//        Observable.from(colorVos).filter(filterGreenFunc).subscribeOn(Schedulers.from(JobExecutor_Factory.create().get())).subscribe(new Observer<ColorVo>() {
//
//            @Override
//            public void onCompleted() {
//                for (Integer integer : greenMap.keySet()) {
//                    Statistics item=new Statistics("green",integer,greenMap.get(integer));
//                    greenDatas.add(item);
//                }
//                Map<Integer, Integer> retGreenMap = mBubbleSort(greenDatas);
//                if(colorReport!=null) {
//                    colorReport.onReportMapData(retBlueMap, retRedMap, retGreenMap);
//                }else{
//                    throw new NullPointerException("colorReportCallback is null");
//                }
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onNext(ColorVo colorVo) {
//                int greenNum=0;
//                if(greenMap.get(colorVo.Green)!=null){
//                    greenNum=greenMap.get(colorVo.Green);
//                }
//                greenNum++;
//                greenMap.put(colorVo.Green,greenNum);
//            }
//        });
//    }
    //1.冒泡得到最大阈值
    //2.获取最大阈值的开奖次数
    //////////3.递归（阈值-1）的开奖次数
    //25 24 23 22 21
    //统计最大阈值出现的次数 阈值-1出现的次数
}
