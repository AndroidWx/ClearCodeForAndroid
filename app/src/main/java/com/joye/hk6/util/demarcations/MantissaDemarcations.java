package com.joye.hk6.util.demarcations;

import com.joye.hk6domain.vo.MantissaVo;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/12/10.
 */

public class MantissaDemarcations {
    /**
     * 获取连出界限统计
     * @param MantissaVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Mantissa0(List<MantissaVo> MantissaVos){
        return  Observable.just(MantissaVos).flatMap(new Func1<List<MantissaVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaVo> MantissaVos) {
                return new DemarcationUtils<MantissaVo>(){
                    @Override
                    public int childNum(MantissaVo MantissaVo) {
                        return MantissaVo.Mantissa0;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(MantissaVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取蓝波连出界限统计
     * @param MantissaVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Mantissa1(List<MantissaVo> MantissaVos){
        return  Observable.just(MantissaVos).flatMap(new Func1<List<MantissaVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaVo> MantissaVos) {
                return new DemarcationUtils<MantissaVo>(){
                    @Override
                    public int childNum(MantissaVo MantissaVo) {
                        return MantissaVo.Mantissa1;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(MantissaVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param MantissaVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Mantissa2(List<MantissaVo> MantissaVos){
        return  Observable.just(MantissaVos).flatMap(new Func1<List<MantissaVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaVo> MantissaVos) {
                return new DemarcationUtils<MantissaVo>(){
                    @Override
                    public int childNum(MantissaVo MantissaVo) {
                        return MantissaVo.Mantissa2;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(MantissaVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param MantissaVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Mantissa3(List<MantissaVo> MantissaVos){
        return  Observable.just(MantissaVos).flatMap(new Func1<List<MantissaVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaVo> MantissaVos) {
                return new DemarcationUtils<MantissaVo>(){
                    @Override
                    public int childNum(MantissaVo MantissaVo) {
                        return MantissaVo.Mantissa3;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(MantissaVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param MantissaVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Mantissa4(List<MantissaVo> MantissaVos){
        return  Observable.just(MantissaVos).flatMap(new Func1<List<MantissaVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaVo> MantissaVos) {
                return new DemarcationUtils<MantissaVo>(){
                    @Override
                    public int childNum(MantissaVo MantissaVo) {
                        return MantissaVo.Mantissa4;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(MantissaVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param MantissaVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Mantissa5(List<MantissaVo> MantissaVos){
        return  Observable.just(MantissaVos).flatMap(new Func1<List<MantissaVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaVo> MantissaVos) {
                return new DemarcationUtils<MantissaVo>(){
                    @Override
                    public int childNum(MantissaVo MantissaVo) {
                        return MantissaVo.Mantissa5;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(MantissaVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param MantissaVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Mantissa6(List<MantissaVo> MantissaVos){
        return  Observable.just(MantissaVos).flatMap(new Func1<List<MantissaVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaVo> MantissaVos) {
                return new DemarcationUtils<MantissaVo>(){
                    @Override
                    public int childNum(MantissaVo MantissaVo) {
                        return MantissaVo.Mantissa6;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(MantissaVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param MantissaVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Mantissa7(List<MantissaVo> MantissaVos){
        return  Observable.just(MantissaVos).flatMap(new Func1<List<MantissaVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaVo> MantissaVos) {
                return new DemarcationUtils<MantissaVo>(){
                    @Override
                    public int childNum(MantissaVo MantissaVo) {
                        return MantissaVo.Mantissa7;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(MantissaVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param MantissaVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Mantissa8(List<MantissaVo> MantissaVos){
        return  Observable.just(MantissaVos).flatMap(new Func1<List<MantissaVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaVo> MantissaVos) {
                return new DemarcationUtils<MantissaVo>(){
                    @Override
                    public int childNum(MantissaVo MantissaVo) {
                        return MantissaVo.Mantissa8;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(MantissaVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param MantissaVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Mantissa9(List<MantissaVo> MantissaVos){
        return  Observable.just(MantissaVos).flatMap(new Func1<List<MantissaVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaVo> MantissaVos) {
                return new DemarcationUtils<MantissaVo>(){
                    @Override
                    public int childNum(MantissaVo MantissaVo) {
                        return MantissaVo.Mantissa9;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(MantissaVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }


}
