package com.joye.hk6.util.demarcations;

import com.joye.hk6domain.vo.CompositeVo;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/12/10.
 */

public class CompositeDemarcations {
    /**
     * 获取连出界限统计
     * @param CompositeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> composite1(List<CompositeVo> CompositeVos){
        return  Observable.just(CompositeVos).flatMap(new Func1<List<CompositeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeVo> CompositeVos) {
                return new DemarcationUtils<CompositeVo>(){
                    @Override
                    public int childNum(CompositeVo CompositeVo) {
                        return CompositeVo.composite1;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取蓝波连出界限统计
     * @param CompositeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> composite2(List<CompositeVo> CompositeVos){
        return  Observable.just(CompositeVos).flatMap(new Func1<List<CompositeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeVo> CompositeVos) {
                return new DemarcationUtils<CompositeVo>(){
                    @Override
                    public int childNum(CompositeVo CompositeVo) {
                        return CompositeVo.composite2;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param CompositeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> composite3(List<CompositeVo> CompositeVos){
        return  Observable.just(CompositeVos).flatMap(new Func1<List<CompositeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeVo> CompositeVos) {
                return new DemarcationUtils<CompositeVo>(){
                    @Override
                    public int childNum(CompositeVo CompositeVo) {
                        return CompositeVo.composite3;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param CompositeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> composite4(List<CompositeVo> CompositeVos){
        return  Observable.just(CompositeVos).flatMap(new Func1<List<CompositeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeVo> CompositeVos) {
                return new DemarcationUtils<CompositeVo>(){
                    @Override
                    public int childNum(CompositeVo CompositeVo) {
                        return CompositeVo.composite4;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param CompositeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> composite5(List<CompositeVo> CompositeVos){
        return  Observable.just(CompositeVos).flatMap(new Func1<List<CompositeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeVo> CompositeVos) {
                return new DemarcationUtils<CompositeVo>(){
                    @Override
                    public int childNum(CompositeVo CompositeVo) {
                        return CompositeVo.composite5;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param CompositeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> composite6(List<CompositeVo> CompositeVos){
        return  Observable.just(CompositeVos).flatMap(new Func1<List<CompositeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeVo> CompositeVos) {
                return new DemarcationUtils<CompositeVo>(){
                    @Override
                    public int childNum(CompositeVo CompositeVo) {
                        return CompositeVo.composite6;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param CompositeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> composite7(List<CompositeVo> CompositeVos){
        return  Observable.just(CompositeVos).flatMap(new Func1<List<CompositeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeVo> CompositeVos) {
                return new DemarcationUtils<CompositeVo>(){
                    @Override
                    public int childNum(CompositeVo CompositeVo) {
                        return CompositeVo.composite7;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param CompositeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> composite8(List<CompositeVo> CompositeVos){
        return  Observable.just(CompositeVos).flatMap(new Func1<List<CompositeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeVo> CompositeVos) {
                return new DemarcationUtils<CompositeVo>(){
                    @Override
                    public int childNum(CompositeVo CompositeVo) {
                        return CompositeVo.composite8;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param CompositeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> composite9(List<CompositeVo> CompositeVos){
        return  Observable.just(CompositeVos).flatMap(new Func1<List<CompositeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeVo> CompositeVos) {
                return new DemarcationUtils<CompositeVo>(){
                    @Override
                    public int childNum(CompositeVo CompositeVo) {
                        return CompositeVo.composite9;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param CompositeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> composite10(List<CompositeVo> CompositeVos){
        return  Observable.just(CompositeVos).flatMap(new Func1<List<CompositeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeVo> CompositeVos) {
                return new DemarcationUtils<CompositeVo>(){
                    @Override
                    public int childNum(CompositeVo CompositeVo) {
                        return CompositeVo.composite10;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param CompositeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> composite11(List<CompositeVo> CompositeVos){
        return  Observable.just(CompositeVos).flatMap(new Func1<List<CompositeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeVo> CompositeVos) {
                return new DemarcationUtils<CompositeVo>(){
                    @Override
                    public int childNum(CompositeVo CompositeVo) {
                        return CompositeVo.composite11;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param CompositeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> composite12(List<CompositeVo> CompositeVos){
        return  Observable.just(CompositeVos).flatMap(new Func1<List<CompositeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeVo> CompositeVos) {
                return new DemarcationUtils<CompositeVo>(){
                    @Override
                    public int childNum(CompositeVo CompositeVo) {
                        return CompositeVo.composite12;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param CompositeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> composite13(List<CompositeVo> CompositeVos){
        return  Observable.just(CompositeVos).flatMap(new Func1<List<CompositeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeVo> CompositeVos) {
                return new DemarcationUtils<CompositeVo>(){
                    @Override
                    public int childNum(CompositeVo CompositeVo) {
                        return CompositeVo.composite13;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
}
