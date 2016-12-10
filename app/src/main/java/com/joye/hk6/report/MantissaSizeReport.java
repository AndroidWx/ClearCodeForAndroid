package com.joye.hk6.report;

import com.joye.hk6.view.IPieChartCallback;
import com.joye.hk6domain.vo.MantissaSizeVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

import static com.joye.hk6.util.demarcations.MantissaSizeDemarcations.Big;
import static com.joye.hk6.util.demarcations.MantissaSizeDemarcations.Small;

/**
 * Created by W,x (JoyeWang)
 * on 2016/11/5.
 * 304622254@qq.com
 * Remeark:尾数大小报表统计
 */

public class MantissaSizeReport extends BaseReport{
    /**
     * 总数据
     */
    private final List<MantissaSizeVo> colorVos;

    public static final int MIN_VALUE=4;



    public MantissaSizeReport(List<MantissaSizeVo> chineseZodiacVos) {
        this.colorVos = chineseZodiacVos;
    }



    @Override
    public void BubbleSort(final IPieChartCallback callback){
        Observable<Map<Integer, Integer>> Small = Observable.just(colorVos).flatMap(new Func1<List<MantissaSizeVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaSizeVo> colorVos) {
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
        Observable<Map<Integer, Integer>> Big = Observable.just(colorVos).flatMap(new Func1<List<MantissaSizeVo>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaSizeVo> colorVos) {
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
}
