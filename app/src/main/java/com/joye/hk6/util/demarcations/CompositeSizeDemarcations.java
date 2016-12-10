package com.joye.hk6.util.demarcations;

import com.joye.hk6domain.vo.CompositeSizeVo;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/12/10.
 */

public class CompositeSizeDemarcations {
    /**
     * 获取红波连出界限统计
     * @param CompositeSizeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Small(List<CompositeSizeVo> CompositeSizeVos){
        return  Observable.just(CompositeSizeVos).flatMap(new Func1<List<CompositeSizeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeSizeVo> CompositeSizeVos) {
                return new DemarcationUtils<CompositeSizeVo>(){
                    @Override
                    public int childNum(CompositeSizeVo CompositeSizeVo) {
                        return CompositeSizeVo.Small;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeSizeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取蓝波连出界限统计
     * @param CompositeSizeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Big(List<CompositeSizeVo> CompositeSizeVos){
        return  Observable.just(CompositeSizeVos).flatMap(new Func1<List<CompositeSizeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<CompositeSizeVo> CompositeSizeVos) {
                return new DemarcationUtils<CompositeSizeVo>(){
                    @Override
                    public int childNum(CompositeSizeVo CompositeSizeVo) {
                        return CompositeSizeVo.Big;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(CompositeSizeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }



}
