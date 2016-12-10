package com.joye.hk6.util.demarcations;

import com.joye.hk6domain.vo.Modular3Vo;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/12/10.
 */

public class Modular3Demarcations {
    /**
     * 获取红波连出界限统计
     * @param Modular3Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M0(List<Modular3Vo> Modular3Vos){
        return  Observable.just(Modular3Vos).flatMap(new Func1<List<Modular3Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular3Vo> Modular3Vos) {
                return new DemarcationUtils<Modular3Vo>(){
                    @Override
                    public int childNum(Modular3Vo Modular3Vo) {
                        return Modular3Vo.M0;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular3Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取蓝波连出界限统计
     * @param Modular3Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M1(List<Modular3Vo> Modular3Vos){
        return  Observable.just(Modular3Vos).flatMap(new Func1<List<Modular3Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular3Vo> Modular3Vos) {
                return new DemarcationUtils<Modular3Vo>(){
                    @Override
                    public int childNum(Modular3Vo Modular3Vo) {
                        return Modular3Vo.M1;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular3Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param Modular3Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M2(List<Modular3Vo> Modular3Vos){
        return  Observable.just(Modular3Vos).flatMap(new Func1<List<Modular3Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular3Vo> Modular3Vos) {
                return new DemarcationUtils<Modular3Vo>(){
                    @Override
                    public int childNum(Modular3Vo Modular3Vo) {
                        return Modular3Vo.M2;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular3Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

}
