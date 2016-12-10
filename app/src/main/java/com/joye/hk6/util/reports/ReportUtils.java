package com.joye.hk6.util.reports;

import android.support.annotation.NonNull;

import com.joye.hk6.report.Statistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/12/10.
 */

public abstract  class ReportUtils<T> {
    @NonNull
    public Observable<Map<Integer, Integer>> getMapObservable(List<T> colorVos) {
        return Observable.just(colorVos).flatMap(new Func1<List<T>, Observable<Map<Integer, Integer>>>() {
            @Override
            public Observable<Map<Integer, Integer>> call(List<T> colorVos) {
                List<Statistics> blueDatas = new ArrayList<>();
                final Map<Integer, Integer> blueMap = new TreeMap<>();
                for (int i = 0; i < colorVos.size(); i++) {
                    if (getChild(colorVos.get(i))< getMinValue()) {
                        continue;
                    }
                    int blueNum = 0;
                    if (blueMap.get(getChild(colorVos.get(i))) != null) {
                        blueNum = blueMap.get(getChild(colorVos.get(i)));
                    }
                    blueNum++;
                    blueMap.put(getChild(colorVos.get(i)), blueNum);
                }
                for (Integer integer : blueMap.keySet()) {
                    Statistics item = new Statistics("blue", integer, blueMap.get(integer));
                    blueDatas.add(item);
                }
                Map<Integer, Integer> retBlueMap = mBubbleSort(blueDatas);
                return Observable.just(retBlueMap);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    public abstract int getMinValue();
    public abstract int getChild(T t);

    protected Map<Integer, Integer> mBubbleSort(List<Statistics> blueStatistics){
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

}
