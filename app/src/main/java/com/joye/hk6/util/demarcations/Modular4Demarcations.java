package com.joye.hk6.util.demarcations;

import com.joye.hk6domain.vo.Modular4Vo;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/12/10.
 */

public class Modular4Demarcations {
    /**
     * 获取红波连出界限统计
     * @param Modular4Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M0(List<Modular4Vo> Modular4Vos){
        return  Observable.just(Modular4Vos).flatMap(new Func1<List<Modular4Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular4Vo> Modular4Vos) {
                return new DemarcationUtils<Modular4Vo>(){
                    @Override
                    public int childNum(Modular4Vo Modular4Vo) {
                        return Modular4Vo.M0;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular4Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取蓝波连出界限统计
     * @param Modular4Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M1(List<Modular4Vo> Modular4Vos){
        return  Observable.just(Modular4Vos).flatMap(new Func1<List<Modular4Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular4Vo> Modular4Vos) {
                return new DemarcationUtils<Modular4Vo>(){
                    @Override
                    public int childNum(Modular4Vo Modular4Vo) {
                        return Modular4Vo.M1;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular4Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param Modular4Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M2(List<Modular4Vo> Modular4Vos){
        return  Observable.just(Modular4Vos).flatMap(new Func1<List<Modular4Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular4Vo> Modular4Vos) {
                return new DemarcationUtils<Modular4Vo>(){
                    @Override
                    public int childNum(Modular4Vo Modular4Vo) {
                        return Modular4Vo.M2;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular4Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param Modular4Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M3(List<Modular4Vo> Modular4Vos){
        return  Observable.just(Modular4Vos).flatMap(new Func1<List<Modular4Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular4Vo> Modular4Vos) {
                return new DemarcationUtils<Modular4Vo>(){
                    @Override
                    public int childNum(Modular4Vo Modular4Vo) {
                        return Modular4Vo.M3;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular4Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

}
