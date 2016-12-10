package com.joye.hk6.util.demarcations;

import com.joye.hk6domain.vo.SizeTwosVo;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/12/10.
 */

public class SizeTowsDemarcations {
    /**
     * 获取红波连出界限统计
     * @param SizeTwosVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> BigEven(List<SizeTwosVo> SizeTwosVos){
        return  Observable.just(SizeTwosVos).flatMap(new Func1<List<SizeTwosVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<SizeTwosVo> SizeTwosVos) {
                return new DemarcationUtils<SizeTwosVo>(){
                    @Override
                    public int childNum(SizeTwosVo SizeTwosVo) {
                        return SizeTwosVo.BigEven;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(SizeTwosVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取蓝波连出界限统计
     * @param SizeTwosVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> BigOdd(List<SizeTwosVo> SizeTwosVos){
        return  Observable.just(SizeTwosVos).flatMap(new Func1<List<SizeTwosVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<SizeTwosVo> SizeTwosVos) {
                return new DemarcationUtils<SizeTwosVo>(){
                    @Override
                    public int childNum(SizeTwosVo SizeTwosVo) {
                        return SizeTwosVo.BigOdd;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(SizeTwosVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param SizeTwosVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> SmallOdd(List<SizeTwosVo> SizeTwosVos){
        return  Observable.just(SizeTwosVos).flatMap(new Func1<List<SizeTwosVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<SizeTwosVo> SizeTwosVos) {
                return new DemarcationUtils<SizeTwosVo>(){
                    @Override
                    public int childNum(SizeTwosVo SizeTwosVo) {
                        return SizeTwosVo.SmallOdd;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(SizeTwosVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param SizeTwosVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> SmallEven(List<SizeTwosVo> SizeTwosVos){
        return  Observable.just(SizeTwosVos).flatMap(new Func1<List<SizeTwosVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<SizeTwosVo> SizeTwosVos) {
                return new DemarcationUtils<SizeTwosVo>(){
                    @Override
                    public int childNum(SizeTwosVo SizeTwosVo) {
                        return SizeTwosVo.SmallEven;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(SizeTwosVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

}
