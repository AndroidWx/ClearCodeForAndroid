package com.joye.hk6.util.demarcations;

import com.joye.hk6domain.vo.RegionVo;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/12/10.
 */

public class RegionDemarcations {
    /**
     * 获取红波连出界限统计
     * @param RegionVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> One(List<RegionVo> RegionVos){
        return  Observable.just(RegionVos).flatMap(new Func1<List<RegionVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<RegionVo> RegionVos) {
                return new DemarcationUtils<RegionVo>(){
                    @Override
                    public int childNum(RegionVo RegionVo) {
                        return RegionVo.One;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(RegionVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取蓝波连出界限统计
     * @param RegionVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Two(List<RegionVo> RegionVos){
        return  Observable.just(RegionVos).flatMap(new Func1<List<RegionVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<RegionVo> RegionVos) {
                return new DemarcationUtils<RegionVo>(){
                    @Override
                    public int childNum(RegionVo RegionVo) {
                        return RegionVo.Two;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(RegionVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param RegionVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Three(List<RegionVo> RegionVos){
        return  Observable.just(RegionVos).flatMap(new Func1<List<RegionVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<RegionVo> RegionVos) {
                return new DemarcationUtils<RegionVo>(){
                    @Override
                    public int childNum(RegionVo RegionVo) {
                        return RegionVo.Three;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(RegionVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param RegionVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Four(List<RegionVo> RegionVos){
        return  Observable.just(RegionVos).flatMap(new Func1<List<RegionVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<RegionVo> RegionVos) {
                return new DemarcationUtils<RegionVo>(){
                    @Override
                    public int childNum(RegionVo RegionVo) {
                        return RegionVo.Four;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(RegionVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param RegionVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Five(List<RegionVo> RegionVos){
        return  Observable.just(RegionVos).flatMap(new Func1<List<RegionVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<RegionVo> RegionVos) {
                return new DemarcationUtils<RegionVo>(){
                    @Override
                    public int childNum(RegionVo RegionVo) {
                        return RegionVo.Five;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(RegionVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param RegionVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Sex(List<RegionVo> RegionVos){
        return  Observable.just(RegionVos).flatMap(new Func1<List<RegionVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<RegionVo> RegionVos) {
                return new DemarcationUtils<RegionVo>(){
                    @Override
                    public int childNum(RegionVo RegionVo) {
                        return RegionVo.Sex;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(RegionVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param RegionVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Seven(List<RegionVo> RegionVos){
        return  Observable.just(RegionVos).flatMap(new Func1<List<RegionVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<RegionVo> RegionVos) {
                return new DemarcationUtils<RegionVo>(){
                    @Override
                    public int childNum(RegionVo RegionVo) {
                        return RegionVo.Seven;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(RegionVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

}
