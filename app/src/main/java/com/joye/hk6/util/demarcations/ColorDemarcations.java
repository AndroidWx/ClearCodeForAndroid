package com.joye.hk6.util.demarcations;

import com.joye.hk6domain.vo.ColorVo;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/12/10.
 */

public class ColorDemarcations {
    /**
     * 获取红波连出界限统计
     * @param colorVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> RedColor(List<ColorVo> colorVos){
        return  Observable.just(colorVos).flatMap(new Func1<List<ColorVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<ColorVo> colorVos) {
                return new DemarcationUtils<ColorVo>(){
                    @Override
                    public int childNum(ColorVo colorVo) {
                        return colorVo.Red;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(colorVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取蓝波连出界限统计
     * @param colorVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> BlueColor(List<ColorVo> colorVos){
        return  Observable.just(colorVos).flatMap(new Func1<List<ColorVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<ColorVo> colorVos) {
                return new DemarcationUtils<ColorVo>(){
                    @Override
                    public int childNum(ColorVo colorVo) {
                        return colorVo.Blue;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(colorVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param colorVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> GreenColor(List<ColorVo> colorVos){
        return  Observable.just(colorVos).flatMap(new Func1<List<ColorVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<ColorVo> colorVos) {
                return new DemarcationUtils<ColorVo>(){
                    @Override
                    public int childNum(ColorVo colorVo) {
                        return colorVo.Green;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(colorVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

}
