package com.joye.hk6.util.demarcations;

import com.joye.hk6domain.vo.OddEvenVo;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/12/10.
 */

public class OddEvenDemarcations {
    /**
     * 获取红波连出界限统计
     * @param OddEvenVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Odd(List<OddEvenVo> OddEvenVos){
        return  Observable.just(OddEvenVos).flatMap(new Func1<List<OddEvenVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<OddEvenVo> OddEvenVos) {
                return new DemarcationUtils<OddEvenVo>(){
                    @Override
                    public int childNum(OddEvenVo OddEvenVo) {
                        return OddEvenVo.Odd;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(OddEvenVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取蓝波连出界限统计
     * @param OddEvenVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Even(List<OddEvenVo> OddEvenVos){
        return  Observable.just(OddEvenVos).flatMap(new Func1<List<OddEvenVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<OddEvenVo> OddEvenVos) {
                return new DemarcationUtils<OddEvenVo>(){
                    @Override
                    public int childNum(OddEvenVo OddEvenVo) {
                        return OddEvenVo.Even;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(OddEvenVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }



}
