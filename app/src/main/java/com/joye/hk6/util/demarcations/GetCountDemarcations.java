package com.joye.hk6.util.demarcations;

import com.joye.hk6domain.vo.GateCountVo;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/12/10.
 */

public class GetCountDemarcations {
    /**
     * 获取连出界限统计
     * @param GateCountVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> gateCount1(List<GateCountVo> GateCountVos){
        return  Observable.just(GateCountVos).flatMap(new Func1<List<GateCountVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<GateCountVo> GateCountVos) {
                return new DemarcationUtils<GateCountVo>(){
                    @Override
                    public int childNum(GateCountVo GateCountVo) {
                        return GateCountVo.gateCount1;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(GateCountVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param GateCountVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> gateCount2(List<GateCountVo> GateCountVos){
        return  Observable.just(GateCountVos).flatMap(new Func1<List<GateCountVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<GateCountVo> GateCountVos) {
                return new DemarcationUtils<GateCountVo>(){
                    @Override
                    public int childNum(GateCountVo GateCountVo) {
                        return GateCountVo.gateCount2;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(GateCountVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param GateCountVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> gateCount3(List<GateCountVo> GateCountVos){
        return  Observable.just(GateCountVos).flatMap(new Func1<List<GateCountVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<GateCountVo> GateCountVos) {
                return new DemarcationUtils<GateCountVo>(){
                    @Override
                    public int childNum(GateCountVo GateCountVo) {
                        return GateCountVo.gateCount3;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(GateCountVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param GateCountVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> gateCount4(List<GateCountVo> GateCountVos){
        return  Observable.just(GateCountVos).flatMap(new Func1<List<GateCountVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<GateCountVo> GateCountVos) {
                return new DemarcationUtils<GateCountVo>(){
                    @Override
                    public int childNum(GateCountVo GateCountVo) {
                        return GateCountVo.gateCount4;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(GateCountVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param GateCountVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> gateCount5(List<GateCountVo> GateCountVos){
        return  Observable.just(GateCountVos).flatMap(new Func1<List<GateCountVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<GateCountVo> GateCountVos) {
                return new DemarcationUtils<GateCountVo>(){
                    @Override
                    public int childNum(GateCountVo GateCountVo) {
                        return GateCountVo.gateCount5;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(GateCountVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
}
