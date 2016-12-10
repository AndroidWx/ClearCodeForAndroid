package com.joye.hk6.util.demarcations;

import com.joye.hk6domain.vo.ChineseZodiacVo;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/12/10.
 */

public class ChineseZodiacDemarcations  {
    /**
     * 获取老鼠连出界限统计
     * @param ChineseZodiacVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Mouse(List<ChineseZodiacVo> ChineseZodiacVos){
        return  Observable.just(ChineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> ChineseZodiacVos) {
                return new DemarcationUtils<ChineseZodiacVo>(){
                    @Override
                    public int childNum(ChineseZodiacVo ChineseZodiacVo) {
                        return ChineseZodiacVo.Mouse;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(ChineseZodiacVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取蓝波连出界限统计
     * @param ChineseZodiacVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Cow(List<ChineseZodiacVo> ChineseZodiacVos){
        return  Observable.just(ChineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> ChineseZodiacVos) {
                return new DemarcationUtils<ChineseZodiacVo>(){
                    @Override
                    public int childNum(ChineseZodiacVo ChineseZodiacVo) {
                        return ChineseZodiacVo.Cow;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(ChineseZodiacVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取老虎连出界限统计
     * @param ChineseZodiacVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Tiger(List<ChineseZodiacVo> ChineseZodiacVos){
        return  Observable.just(ChineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> ChineseZodiacVos) {
                return new DemarcationUtils<ChineseZodiacVo>(){
                    @Override
                    public int childNum(ChineseZodiacVo ChineseZodiacVo) {
                        return ChineseZodiacVo.Tiger;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(ChineseZodiacVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取老虎连出界限统计
     * @param ChineseZodiacVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Rabbit(List<ChineseZodiacVo> ChineseZodiacVos){
        return  Observable.just(ChineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> ChineseZodiacVos) {
                return new DemarcationUtils<ChineseZodiacVo>(){
                    @Override
                    public int childNum(ChineseZodiacVo ChineseZodiacVo) {
                        return ChineseZodiacVo.Rabbit;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(ChineseZodiacVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取龙连出界限统计
     * @param ChineseZodiacVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Dragon(List<ChineseZodiacVo> ChineseZodiacVos){
        return  Observable.just(ChineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> ChineseZodiacVos) {
                return new DemarcationUtils<ChineseZodiacVo>(){
                    @Override
                    public int childNum(ChineseZodiacVo ChineseZodiacVo) {
                        return ChineseZodiacVo.Dragon;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(ChineseZodiacVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param ChineseZodiacVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Snake(List<ChineseZodiacVo> ChineseZodiacVos){
        return  Observable.just(ChineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> ChineseZodiacVos) {
                return new DemarcationUtils<ChineseZodiacVo>(){
                    @Override
                    public int childNum(ChineseZodiacVo ChineseZodiacVo) {
                        return ChineseZodiacVo.Snake;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(ChineseZodiacVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param ChineseZodiacVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Horse(List<ChineseZodiacVo> ChineseZodiacVos){
        return  Observable.just(ChineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> ChineseZodiacVos) {
                return new DemarcationUtils<ChineseZodiacVo>(){
                    @Override
                    public int childNum(ChineseZodiacVo ChineseZodiacVo) {
                        return ChineseZodiacVo.Horse;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(ChineseZodiacVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param ChineseZodiacVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Sheep(List<ChineseZodiacVo> ChineseZodiacVos){
        return  Observable.just(ChineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> ChineseZodiacVos) {
                return new DemarcationUtils<ChineseZodiacVo>(){
                    @Override
                    public int childNum(ChineseZodiacVo ChineseZodiacVo) {
                        return ChineseZodiacVo.Sheep;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(ChineseZodiacVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param ChineseZodiacVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Monkey(List<ChineseZodiacVo> ChineseZodiacVos){
        return  Observable.just(ChineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> ChineseZodiacVos) {
                return new DemarcationUtils<ChineseZodiacVo>(){
                    @Override
                    public int childNum(ChineseZodiacVo ChineseZodiacVo) {
                        return ChineseZodiacVo.Monkey;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(ChineseZodiacVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param ChineseZodiacVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Chook(List<ChineseZodiacVo> ChineseZodiacVos){
        return  Observable.just(ChineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> ChineseZodiacVos) {
                return new DemarcationUtils<ChineseZodiacVo>(){
                    @Override
                    public int childNum(ChineseZodiacVo ChineseZodiacVo) {
                        return ChineseZodiacVo.Chook;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(ChineseZodiacVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }


    /**
     * 获取连出界限统计
     * @param ChineseZodiacVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Dog(List<ChineseZodiacVo> ChineseZodiacVos){
        return  Observable.just(ChineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> ChineseZodiacVos) {
                return new DemarcationUtils<ChineseZodiacVo>(){
                    @Override
                    public int childNum(ChineseZodiacVo ChineseZodiacVo) {
                        return ChineseZodiacVo.Dog;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(ChineseZodiacVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }


    /**
     * 获取连出界限统计
     * @param ChineseZodiacVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> Pig(List<ChineseZodiacVo> ChineseZodiacVos){
        return  Observable.just(ChineseZodiacVos).flatMap(new Func1<List<ChineseZodiacVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<ChineseZodiacVo> ChineseZodiacVos) {
                return new DemarcationUtils<ChineseZodiacVo>(){
                    @Override
                    public int childNum(ChineseZodiacVo ChineseZodiacVo) {
                        return ChineseZodiacVo.Pig;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(ChineseZodiacVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
}
