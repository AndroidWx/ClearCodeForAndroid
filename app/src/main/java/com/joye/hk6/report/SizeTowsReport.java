package com.joye.hk6.report;

import com.joye.hk6.view.IPieChartCallback;
import com.joye.hk6domain.vo.SizeTwosVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func4;
import rx.schedulers.Schedulers;

import static com.joye.hk6.util.demarcations.SizeTowsDemarcations.BigEven;
import static com.joye.hk6.util.demarcations.SizeTowsDemarcations.BigOdd;
import static com.joye.hk6.util.demarcations.SizeTowsDemarcations.SmallEven;
import static com.joye.hk6.util.demarcations.SizeTowsDemarcations.SmallOdd;

/**
 * Created by W,x (JoyeWang)
 * on 2016/11/5.
 * 304622254@qq.com
 * Remeark:半单双报表统计
 */

public class SizeTowsReport extends BaseReport{
    /**
     * 总数据
     */
    private final List<SizeTwosVo> colorVos;

    public static final int MIN_VALUE=12;



    public SizeTowsReport(List<SizeTwosVo> chineseZodiacVos) {
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
        Observable<Map<Integer, Integer>> SmallEvenObserverable = Observable.just(colorVos).flatMap(new Func1<List<SizeTwosVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<SizeTwosVo> colorVos) {
                List<Statistics> blueDatas =new ArrayList<>();
                final Map<Integer,Integer>  blueMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).SmallEven<MIN_VALUE){
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).SmallEven) != null) {
                        blueNum = blueMap.get(colorVos.get(i).SmallEven);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).SmallEven, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("SmallEven", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> SmallOddObserverable = Observable.just(colorVos).flatMap(new Func1<List<SizeTwosVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<SizeTwosVo> colorVos) {
                List<Statistics> redDatas =new ArrayList<>();
                final Map<Integer,Integer>  redMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).SmallOdd<MIN_VALUE){
                        continue;
                    }
                    int redNum = 0;
                    if (redMap.get(colorVos.get(i).SmallOdd) != null) {
                        redNum = redMap.get(colorVos.get(i).SmallOdd);
                    }
                    redNum++;
                    redMap.put(colorVos.get(i).SmallOdd, redNum);
                }
                for (Integer integer : redMap.keySet()) {
                    Statistics item = new Statistics("SmallOdd", integer, redMap.get(integer));
                    redDatas.add(item);
                }
                Map<Integer, Integer> retRedMap = mBubbleSort(redDatas);
                return Observable.just(retRedMap);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable<Map<Integer, Integer>> BigEven = Observable.just(colorVos).flatMap(new Func1<List<SizeTwosVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<SizeTwosVo> colorVos) {
                final Map<Integer,Integer>  greenMap=new TreeMap<>();
                List<Statistics> greenDatas =new ArrayList<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).BigEven<MIN_VALUE){
                        continue;
                    }
                    int greenNum = 0;
                    if (greenMap.get(colorVos.get(i).BigEven) != null) {
                        greenNum = greenMap.get(colorVos.get(i).BigEven);
                    }
                    greenNum++;
                    greenMap.put(colorVos.get(i).BigEven, greenNum);
                }
                for (Integer integer : greenMap.keySet()) {
                    Statistics item = new Statistics("BigEven", integer, greenMap.get(integer));
                    greenDatas.add(item);
                }
                Map<Integer, Integer> retRedMap = mBubbleSort(greenDatas);
                return Observable.just(retRedMap);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable<Map<Integer, Integer>> BigOdd = Observable.just(colorVos).flatMap(new Func1<List<SizeTwosVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<SizeTwosVo> colorVos) {
                final Map<Integer,Integer>  greenMap=new TreeMap<>();
                List<Statistics> greenDatas =new ArrayList<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).BigOdd<MIN_VALUE){
                        continue;
                    }
                    int greenNum = 0;
                    if (greenMap.get(colorVos.get(i).BigOdd) != null) {
                        greenNum = greenMap.get(colorVos.get(i).BigOdd);
                    }
                    greenNum++;
                    greenMap.put(colorVos.get(i).BigOdd, greenNum);
                }
                for (Integer integer : greenMap.keySet()) {
                    Statistics item = new Statistics("BigOdd", integer, greenMap.get(integer));
                    greenDatas.add(item);
                }
                Map<Integer, Integer> retRedMap = mBubbleSort(greenDatas);
                return Observable.just(retRedMap);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable.zip(SmallEvenObserverable, SmallOddObserverable, BigEven,BigOdd, new Func4<Map<Integer,Integer>, Map<Integer,Integer>, Map<Integer,Integer>,Map<Integer,Integer>, Void>() {
            @Override
            public Void call(Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3,Map<Integer, Integer> map4) {
                if(callback!=null) {
                    ArrayList<PieChartImpl> datas=new ArrayList<PieChartImpl>();
                    datas.add(genPieChartImpl(map,"小双"));
                    datas.add(genPieChartImpl(map2,"小单"));
                    datas.add(genPieChartImpl(map3,"大双"));
                    datas.add(genPieChartImpl(map4,"大单"));
                    callback.callback(datas);
                }
                return null;
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe();



    }

    @Override
    public void Demarcations(final IPieChartCallback callback) {
        Observable.zip(SmallEven(colorVos), SmallOdd(colorVos), BigEven(colorVos),BigOdd(colorVos), new Func4<Map<Integer,Integer>, Map<Integer,Integer>, Map<Integer,Integer>,Map<Integer,Integer>, Void>() {
            @Override
            public Void call(Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3,Map<Integer, Integer> map4) {
                if(callback!=null) {
                    ArrayList<PieChartImpl> datas=new ArrayList<PieChartImpl>();
                    datas.add(demarcationPieChartImpl(map,"小双"));
                    datas.add(demarcationPieChartImpl(map2,"小单"));
                    datas.add(demarcationPieChartImpl(map3,"大双"));
                    datas.add(demarcationPieChartImpl(map4,"大单"));
                    callback.demarcationCallBack(datas);
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
