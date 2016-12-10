package com.joye.hk6.util.demarcations;

import com.joye.hk6domain.vo.CompositeMantissaVo;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/12/10.
 */

public class CompositeMantissaDemarcations {
    /**
     * 获取连出界限统计
     * @param CompositeMantissaVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> composite0(List<CompositeMantissaVo> CompositeMantissaVos){
        return  Observable.just(CompositeMantissaVos).flatMap(new Func1<List<CompositeMantissaVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeMantissaVo> CompositeMantissaVos) {
                return new DemarcationUtils<CompositeMantissaVo>(){
                    @Override
                    public int childNum(CompositeMantissaVo CompositeMantissaVo) {
                        return CompositeMantissaVo.composite0;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeMantissaVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param CompositeMantissaVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> composite1(List<CompositeMantissaVo> CompositeMantissaVos){
        return  Observable.just(CompositeMantissaVos).flatMap(new Func1<List<CompositeMantissaVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeMantissaVo> CompositeMantissaVos) {
                return new DemarcationUtils<CompositeMantissaVo>(){
                    @Override
                    public int childNum(CompositeMantissaVo CompositeMantissaVo) {
                        return CompositeMantissaVo.composite1;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeMantissaVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param CompositeMantissaVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> composite2(List<CompositeMantissaVo> CompositeMantissaVos){
        return  Observable.just(CompositeMantissaVos).flatMap(new Func1<List<CompositeMantissaVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeMantissaVo> CompositeMantissaVos) {
                return new DemarcationUtils<CompositeMantissaVo>(){
                    @Override
                    public int childNum(CompositeMantissaVo CompositeMantissaVo) {
                        return CompositeMantissaVo.composite2;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeMantissaVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param CompositeMantissaVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> composite3(List<CompositeMantissaVo> CompositeMantissaVos){
        return  Observable.just(CompositeMantissaVos).flatMap(new Func1<List<CompositeMantissaVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeMantissaVo> CompositeMantissaVos) {
                return new DemarcationUtils<CompositeMantissaVo>(){
                    @Override
                    public int childNum(CompositeMantissaVo CompositeMantissaVo) {
                        return CompositeMantissaVo.composite3;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeMantissaVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param CompositeMantissaVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> composite4(List<CompositeMantissaVo> CompositeMantissaVos){
        return  Observable.just(CompositeMantissaVos).flatMap(new Func1<List<CompositeMantissaVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeMantissaVo> CompositeMantissaVos) {
                return new DemarcationUtils<CompositeMantissaVo>(){
                    @Override
                    public int childNum(CompositeMantissaVo CompositeMantissaVo) {
                        return CompositeMantissaVo.composite4;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeMantissaVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param CompositeMantissaVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> composite5(List<CompositeMantissaVo> CompositeMantissaVos){
        return  Observable.just(CompositeMantissaVos).flatMap(new Func1<List<CompositeMantissaVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeMantissaVo> CompositeMantissaVos) {
                return new DemarcationUtils<CompositeMantissaVo>(){
                    @Override
                    public int childNum(CompositeMantissaVo CompositeMantissaVo) {
                        return CompositeMantissaVo.composite5;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeMantissaVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    public static Observable<Map<Integer, Integer>> composite6(List<CompositeMantissaVo> CompositeMantissaVos){
        return  Observable.just(CompositeMantissaVos).flatMap(new Func1<List<CompositeMantissaVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeMantissaVo> CompositeMantissaVos) {
                return new DemarcationUtils<CompositeMantissaVo>(){
                    @Override
                    public int childNum(CompositeMantissaVo CompositeMantissaVo) {
                        return CompositeMantissaVo.composite6;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeMantissaVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    public static Observable<Map<Integer, Integer>> composite7(List<CompositeMantissaVo> CompositeMantissaVos){
        return  Observable.just(CompositeMantissaVos).flatMap(new Func1<List<CompositeMantissaVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeMantissaVo> CompositeMantissaVos) {
                return new DemarcationUtils<CompositeMantissaVo>(){
                    @Override
                    public int childNum(CompositeMantissaVo CompositeMantissaVo) {
                        return CompositeMantissaVo.composite7;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeMantissaVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    public static Observable<Map<Integer, Integer>> composite8(List<CompositeMantissaVo> CompositeMantissaVos){
        return  Observable.just(CompositeMantissaVos).flatMap(new Func1<List<CompositeMantissaVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeMantissaVo> CompositeMantissaVos) {
                return new DemarcationUtils<CompositeMantissaVo>(){
                    @Override
                    public int childNum(CompositeMantissaVo CompositeMantissaVo) {
                        return CompositeMantissaVo.composite8;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeMantissaVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    public static Observable<Map<Integer, Integer>> composite9(List<CompositeMantissaVo> CompositeMantissaVos){
        return  Observable.just(CompositeMantissaVos).flatMap(new Func1<List<CompositeMantissaVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeMantissaVo> CompositeMantissaVos) {
                return new DemarcationUtils<CompositeMantissaVo>(){
                    @Override
                    public int childNum(CompositeMantissaVo CompositeMantissaVo) {
                        return CompositeMantissaVo.composite9;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeMantissaVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
}
