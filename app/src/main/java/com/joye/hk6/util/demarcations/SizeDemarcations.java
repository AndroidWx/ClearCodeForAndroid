package com.joye.hk6.util.demarcations;

import com.joye.hk6domain.vo.SizeVo;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/12/10.
 */

public class SizeDemarcations {
    /**
     * 获取红波连出界限统计
     * @param SizeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Small(List<SizeVo> SizeVos){
        return  Observable.just(SizeVos).flatMap(new Func1<List<SizeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<SizeVo> SizeVos) {
                return new DemarcationUtils<SizeVo>(){
                    @Override
                    public int childNum(SizeVo SizeVo) {
                        return SizeVo.Small;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(SizeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取蓝波连出界限统计
     * @param SizeVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Big(List<SizeVo> SizeVos){
        return  Observable.just(SizeVos).flatMap(new Func1<List<SizeVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<SizeVo> SizeVos) {
                return new DemarcationUtils<SizeVo>(){
                    @Override
                    public int childNum(SizeVo SizeVo) {
                        return SizeVo.Big;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(SizeVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }



}
