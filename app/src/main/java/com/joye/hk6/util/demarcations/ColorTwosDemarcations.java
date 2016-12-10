package com.joye.hk6.util.demarcations;

import com.joye.hk6domain.vo.ColorTwosVo;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/12/10.
 */

public class ColorTwosDemarcations {
    /**
     * 获取连出界限统计
     * @param ColorTwosVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> redEven(List<ColorTwosVo> ColorTwosVos){
        return  Observable.just(ColorTwosVos).flatMap(new Func1<List<ColorTwosVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<ColorTwosVo> ColorTwosVos) {
                return new DemarcationUtils<ColorTwosVo>(){
                    @Override
                    public int childNum(ColorTwosVo ColorTwosVo) {
                        return ColorTwosVo.redEven;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(ColorTwosVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param ColorTwosVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> redOdd(List<ColorTwosVo> ColorTwosVos){
        return  Observable.just(ColorTwosVos).flatMap(new Func1<List<ColorTwosVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<ColorTwosVo> ColorTwosVos) {
                return new DemarcationUtils<ColorTwosVo>(){
                    @Override
                    public int childNum(ColorTwosVo ColorTwosVo) {
                        return ColorTwosVo.redOdd;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(ColorTwosVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param ColorTwosVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> greenEven(List<ColorTwosVo> ColorTwosVos){
        return  Observable.just(ColorTwosVos).flatMap(new Func1<List<ColorTwosVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<ColorTwosVo> ColorTwosVos) {
                return new DemarcationUtils<ColorTwosVo>(){
                    @Override
                    public int childNum(ColorTwosVo ColorTwosVo) {
                        return ColorTwosVo.greenEven;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(ColorTwosVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param ColorTwosVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> greenOdd(List<ColorTwosVo> ColorTwosVos){
        return  Observable.just(ColorTwosVos).flatMap(new Func1<List<ColorTwosVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<ColorTwosVo> ColorTwosVos) {
                return new DemarcationUtils<ColorTwosVo>(){
                    @Override
                    public int childNum(ColorTwosVo ColorTwosVo) {
                        return ColorTwosVo.greenOdd;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(ColorTwosVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param ColorTwosVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> blueOdd(List<ColorTwosVo> ColorTwosVos){
        return  Observable.just(ColorTwosVos).flatMap(new Func1<List<ColorTwosVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<ColorTwosVo> ColorTwosVos) {
                return new DemarcationUtils<ColorTwosVo>(){
                    @Override
                    public int childNum(ColorTwosVo ColorTwosVo) {
                        return ColorTwosVo.blueOdd;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(ColorTwosVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param ColorTwosVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> blueEven(List<ColorTwosVo> ColorTwosVos){
        return  Observable.just(ColorTwosVos).flatMap(new Func1<List<ColorTwosVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<ColorTwosVo> ColorTwosVos) {
                return new DemarcationUtils<ColorTwosVo>(){
                    @Override
                    public int childNum(ColorTwosVo ColorTwosVo) {
                        return ColorTwosVo.blueEven;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(ColorTwosVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
}
