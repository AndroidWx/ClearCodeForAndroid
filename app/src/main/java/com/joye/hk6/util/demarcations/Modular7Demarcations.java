package com.joye.hk6.util.demarcations;

import com.joye.hk6domain.vo.Modular7Vo;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/12/10.
 */

public class Modular7Demarcations {
    /**
     * 获取红波连出界限统计
     * @param Modular7Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M0(List<Modular7Vo> Modular7Vos){
        return  Observable.just(Modular7Vos).flatMap(new Func1<List<Modular7Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular7Vo> Modular7Vos) {
                return new DemarcationUtils<Modular7Vo>(){
                    @Override
                    public int childNum(Modular7Vo Modular7Vo) {
                        return Modular7Vo.M0;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular7Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取蓝波连出界限统计
     * @param Modular7Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M1(List<Modular7Vo> Modular7Vos){
        return  Observable.just(Modular7Vos).flatMap(new Func1<List<Modular7Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular7Vo> Modular7Vos) {
                return new DemarcationUtils<Modular7Vo>(){
                    @Override
                    public int childNum(Modular7Vo Modular7Vo) {
                        return Modular7Vo.M1;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular7Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param Modular7Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M2(List<Modular7Vo> Modular7Vos){
        return  Observable.just(Modular7Vos).flatMap(new Func1<List<Modular7Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular7Vo> Modular7Vos) {
                return new DemarcationUtils<Modular7Vo>(){
                    @Override
                    public int childNum(Modular7Vo Modular7Vo) {
                        return Modular7Vo.M2;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular7Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param Modular7Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M3(List<Modular7Vo> Modular7Vos){
        return  Observable.just(Modular7Vos).flatMap(new Func1<List<Modular7Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular7Vo> Modular7Vos) {
                return new DemarcationUtils<Modular7Vo>(){
                    @Override
                    public int childNum(Modular7Vo Modular7Vo) {
                        return Modular7Vo.M3;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular7Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param Modular7Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M4(List<Modular7Vo> Modular7Vos){
        return  Observable.just(Modular7Vos).flatMap(new Func1<List<Modular7Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular7Vo> Modular7Vos) {
                return new DemarcationUtils<Modular7Vo>(){
                    @Override
                    public int childNum(Modular7Vo Modular7Vo) {
                        return Modular7Vo.M4;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular7Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param Modular7Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M5(List<Modular7Vo> Modular7Vos){
        return  Observable.just(Modular7Vos).flatMap(new Func1<List<Modular7Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular7Vo> Modular7Vos) {
                return new DemarcationUtils<Modular7Vo>(){
                    @Override
                    public int childNum(Modular7Vo Modular7Vo) {
                        return Modular7Vo.M5;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular7Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param Modular7Vos
     * @return
     */
    public static Observable<Map<Integer, Integer>> M6(List<Modular7Vo> Modular7Vos){
        return  Observable.just(Modular7Vos).flatMap(new Func1<List<Modular7Vo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<Modular7Vo> Modular7Vos) {
                return new DemarcationUtils<Modular7Vo>(){
                    @Override
                    public int childNum(Modular7Vo Modular7Vo) {
                        return Modular7Vo.M6;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(Modular7Vos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

}
