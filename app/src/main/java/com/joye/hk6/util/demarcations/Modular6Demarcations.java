package com.joye.hk6.util.demarcations;

import com.joye.hk6domain.vo.Modular6Vo;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/12/10.
 */

public class Modular6Demarcations {
    /**
     * 获取红波连出界限统计
     * @param Modular6Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M0(List<Modular6Vo> Modular6Vos){
        return  Observable.just(Modular6Vos).flatMap(new Func1<List<Modular6Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular6Vo> Modular6Vos) {
                return new DemarcationUtils<Modular6Vo>(){
                    @Override
                    public int childNum(Modular6Vo Modular6Vo) {
                        return Modular6Vo.M0;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular6Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取蓝波连出界限统计
     * @param Modular6Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M1(List<Modular6Vo> Modular6Vos){
        return  Observable.just(Modular6Vos).flatMap(new Func1<List<Modular6Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular6Vo> Modular6Vos) {
                return new DemarcationUtils<Modular6Vo>(){
                    @Override
                    public int childNum(Modular6Vo Modular6Vo) {
                        return Modular6Vo.M1;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular6Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param Modular6Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M2(List<Modular6Vo> Modular6Vos){
        return  Observable.just(Modular6Vos).flatMap(new Func1<List<Modular6Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular6Vo> Modular6Vos) {
                return new DemarcationUtils<Modular6Vo>(){
                    @Override
                    public int childNum(Modular6Vo Modular6Vo) {
                        return Modular6Vo.M2;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular6Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param Modular6Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M3(List<Modular6Vo> Modular6Vos){
        return  Observable.just(Modular6Vos).flatMap(new Func1<List<Modular6Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular6Vo> Modular6Vos) {
                return new DemarcationUtils<Modular6Vo>(){
                    @Override
                    public int childNum(Modular6Vo Modular6Vo) {
                        return Modular6Vo.M3;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular6Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param Modular6Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M4(List<Modular6Vo> Modular6Vos){
        return  Observable.just(Modular6Vos).flatMap(new Func1<List<Modular6Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular6Vo> Modular6Vos) {
                return new DemarcationUtils<Modular6Vo>(){
                    @Override
                    public int childNum(Modular6Vo Modular6Vo) {
                        return Modular6Vo.M4;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular6Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param Modular6Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M5(List<Modular6Vo> Modular6Vos){
        return  Observable.just(Modular6Vos).flatMap(new Func1<List<Modular6Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular6Vo> Modular6Vos) {
                return new DemarcationUtils<Modular6Vo>(){
                    @Override
                    public int childNum(Modular6Vo Modular6Vo) {
                        return Modular6Vo.M5;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular6Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

}
