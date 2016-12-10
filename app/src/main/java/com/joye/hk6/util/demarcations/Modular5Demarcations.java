package com.joye.hk6.util.demarcations;

import com.joye.hk6domain.vo.Modular5Vo;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/12/10.
 */

public class Modular5Demarcations {
    /**
     * 获取红波连出界限统计
     * @param Modular5Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M0(List<Modular5Vo> Modular5Vos){
        return  Observable.just(Modular5Vos).flatMap(new Func1<List<Modular5Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular5Vo> Modular5Vos) {
                return new DemarcationUtils<Modular5Vo>(){
                    @Override
                    public int childNum(Modular5Vo Modular5Vo) {
                        return Modular5Vo.M0;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular5Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取蓝波连出界限统计
     * @param Modular5Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M1(List<Modular5Vo> Modular5Vos){
        return  Observable.just(Modular5Vos).flatMap(new Func1<List<Modular5Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular5Vo> Modular5Vos) {
                return new DemarcationUtils<Modular5Vo>(){
                    @Override
                    public int childNum(Modular5Vo Modular5Vo) {
                        return Modular5Vo.M1;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular5Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param Modular5Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M2(List<Modular5Vo> Modular5Vos){
        return  Observable.just(Modular5Vos).flatMap(new Func1<List<Modular5Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular5Vo> Modular5Vos) {
                return new DemarcationUtils<Modular5Vo>(){
                    @Override
                    public int childNum(Modular5Vo Modular5Vo) {
                        return Modular5Vo.M2;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular5Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param Modular5Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M3(List<Modular5Vo> Modular5Vos){
        return  Observable.just(Modular5Vos).flatMap(new Func1<List<Modular5Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular5Vo> Modular5Vos) {
                return new DemarcationUtils<Modular5Vo>(){
                    @Override
                    public int childNum(Modular5Vo Modular5Vo) {
                        return Modular5Vo.M3;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular5Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param Modular5Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M4(List<Modular5Vo> Modular5Vos){
        return  Observable.just(Modular5Vos).flatMap(new Func1<List<Modular5Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular5Vo> Modular5Vos) {
                return new DemarcationUtils<Modular5Vo>(){
                    @Override
                    public int childNum(Modular5Vo Modular5Vo) {
                        return Modular5Vo.M4;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular5Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

}
