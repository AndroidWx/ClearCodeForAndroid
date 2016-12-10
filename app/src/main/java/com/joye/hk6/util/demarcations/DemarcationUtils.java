package com.joye.hk6.util.demarcations;

import android.support.annotation.NonNull;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import rx.Observable;

/**
 * Created by xiang on 16/12/10.
 * 极限工具类
 */

public abstract class DemarcationUtils<T> {
    @NonNull
    public Observable<Map<Integer, Integer>> getMapObservable(List<T> colorVos) {
        final Map<Integer,Integer>  map=new TreeMap<>();
        //连续出现的次数
        int j=0;
        for (int i = 0; i < colorVos.size(); i++) {
            //初始设置为0
            int w=0;
            //如果等于0
            if(childNum(colorVos.get(i))==0) {
                //出现次数加1
                j++;
            }
            if(childNum(colorVos.get(i))>0){
                //必须出现一次
                if(j<minNum()){
                    continue;
                }
                if (map.get(j) != null) {
                    w = map.get(j);
                }
                w++;
                map.put(j,w);
                j=0;
            }
        }
        return Observable.just(map);
    }

    public abstract int childNum(T t);
    public abstract int minNum();
}
