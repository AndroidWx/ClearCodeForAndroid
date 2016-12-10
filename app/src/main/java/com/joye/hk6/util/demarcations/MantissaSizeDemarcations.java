package com.joye.hk6.util.demarcations;

import com.joye.hk6domain.vo.MantissaSizeVo;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/12/10.
 */

public class MantissaSizeDemarcations {
    /**
     * 获取红波连出界限统计
     * @param MantissaSizeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Small(List<MantissaSizeVo> MantissaSizeVos){
        return  Observable.just(MantissaSizeVos).flatMap(new Func1<List<MantissaSizeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaSizeVo> MantissaSizeVos) {
                return new DemarcationUtils<MantissaSizeVo>(){
                    @Override
                    public int childNum(MantissaSizeVo MantissaSizeVo) {
                        return MantissaSizeVo.Small;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(MantissaSizeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取蓝波连出界限统计
     * @param MantissaSizeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Big(List<MantissaSizeVo> MantissaSizeVos){
        return  Observable.just(MantissaSizeVos).flatMap(new Func1<List<MantissaSizeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<MantissaSizeVo> MantissaSizeVos) {
                return new DemarcationUtils<MantissaSizeVo>(){
                    @Override
                    public int childNum(MantissaSizeVo MantissaSizeVo) {
                        return MantissaSizeVo.Big;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(MantissaSizeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }



}
