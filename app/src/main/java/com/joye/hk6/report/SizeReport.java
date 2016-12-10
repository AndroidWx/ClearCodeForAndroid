package com.joye.hk6.report;

import com.joye.hk6.view.IPieChartCallback;
import com.joye.hk6domain.vo.SizeVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

import static com.joye.hk6.util.demarcations.SizeDemarcations.Big;
import static com.joye.hk6.util.demarcations.SizeDemarcations.Small;


/**
 * Created by W,x (JoyeWang)
 * on 2016/11/5.
 * 304622254@qq.com
 * Remeark:波色报表统计
 */

public class SizeReport extends BaseReport{
    /**
     * 总数据
     */
    private final List<SizeVo> colorVos;

    public static final int MIN_VALUE=5;



    public SizeReport(List<SizeVo> chineseZodiacVos) {
        this.colorVos = chineseZodiacVos;
    }



    @Override
    public void BubbleSort(final IPieChartCallback callback){
        Observable<Map<Integer, Integer>> Small = Observable.just(colorVos).flatMap(new Func1<List<SizeVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<SizeVo> colorVos) {
                List<Statistics> blueDatas =new ArrayList<>();
                final Map<Integer,Integer>  blueMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).Small<MIN_VALUE){
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).Small) != null) {
                        blueNum = blueMap.get(colorVos.get(i).Small);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).Small, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("Small", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable<Map<Integer, Integer>> Big = Observable.just(colorVos).flatMap(new Func1<List<SizeVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<SizeVo> colorVos) {
                List<Statistics> blueDatas =new ArrayList<>();
                final Map<Integer,Integer>  blueMap=new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if(colorVos.get(i).Big<MIN_VALUE){
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(colorVos.get(i).Big) != null) {
                        blueNum = blueMap.get(colorVos.get(i).Big);
                    }
                    blueNum++;
                    blueMap.put(colorVos.get(i).Big, blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("Big", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
        Observable.zip(Small, Big , new Func2<Map<Integer,Integer>, Map<Integer,Integer>, Void>() {
            @Override
            public Void call(Map<Integer, Integer> map, Map<Integer, Integer> map2 ) {
                if(callback!=null) {
                    ArrayList<PieChartImpl> datas=new ArrayList<PieChartImpl>();
                    datas.add(genPieChartImpl(map,"小"));
                    datas.add(genPieChartImpl(map2,"大"));
                    callback.callback(datas);
                }
                return null;
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe();
    }

    @Override
    public void Demarcations(final IPieChartCallback callback) {
        Observable.zip(Small(colorVos), Big(colorVos) , new Func2<Map<Integer,Integer>, Map<Integer,Integer>, Void>() {
            @Override
            public Void call(Map<Integer, Integer> map, Map<Integer, Integer> map2 ) {
                if(callback!=null) {
                    ArrayList<PieChartImpl> datas=new ArrayList<PieChartImpl>();
                    datas.add(demarcationPieChartImpl(map,"小"));
                    datas.add(demarcationPieChartImpl(map2,"大"));
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
