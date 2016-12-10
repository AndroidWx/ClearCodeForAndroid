package com.joye.hk6.util.demarcations;

import com.joye.hk6domain.vo.HeadAgeVo;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/12/10.
 */

public class HeadAgeDemarcations {
    /**
     * 获取连出界限统计
     * @param HeadAgeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> headage0(List<HeadAgeVo> HeadAgeVos){
        return  Observable.just(HeadAgeVos).flatMap(new Func1<List<HeadAgeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadAgeVo> HeadAgeVos) {
                return new DemarcationUtils<HeadAgeVo>(){
                    @Override
                    public int childNum(HeadAgeVo HeadAgeVo) {
                        return HeadAgeVo.headage0;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(HeadAgeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param HeadAgeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> headage2(List<HeadAgeVo> HeadAgeVos){
        return  Observable.just(HeadAgeVos).flatMap(new Func1<List<HeadAgeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadAgeVo> HeadAgeVos) {
                return new DemarcationUtils<HeadAgeVo>(){
                    @Override
                    public int childNum(HeadAgeVo HeadAgeVo) {
                        return HeadAgeVo.headage2;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(HeadAgeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param HeadAgeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> headage3(List<HeadAgeVo> HeadAgeVos){
        return  Observable.just(HeadAgeVos).flatMap(new Func1<List<HeadAgeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadAgeVo> HeadAgeVos) {
                return new DemarcationUtils<HeadAgeVo>(){
                    @Override
                    public int childNum(HeadAgeVo HeadAgeVo) {
                        return HeadAgeVo.headage3;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(HeadAgeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param HeadAgeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> headage4(List<HeadAgeVo> HeadAgeVos){
        return  Observable.just(HeadAgeVos).flatMap(new Func1<List<HeadAgeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadAgeVo> HeadAgeVos) {
                return new DemarcationUtils<HeadAgeVo>(){
                    @Override
                    public int childNum(HeadAgeVo HeadAgeVo) {
                        return HeadAgeVo.headage4;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(HeadAgeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param HeadAgeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> headage1(List<HeadAgeVo> HeadAgeVos){
        return  Observable.just(HeadAgeVos).flatMap(new Func1<List<HeadAgeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadAgeVo> HeadAgeVos) {
                return new DemarcationUtils<HeadAgeVo>(){
                    @Override
                    public int childNum(HeadAgeVo HeadAgeVo) {
                        return HeadAgeVo.headage1;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(HeadAgeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
}
