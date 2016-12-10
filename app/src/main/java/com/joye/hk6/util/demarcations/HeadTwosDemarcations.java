package com.joye.hk6.util.demarcations;

import com.joye.hk6domain.vo.HeadTwosVo;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 16/12/10.
 */

public class HeadTwosDemarcations {
    /**
     * 获取连出界限统计
     * @param HeadTwosVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> HeadEven0(List<HeadTwosVo> HeadTwosVos){
        return  Observable.just(HeadTwosVos).flatMap(new Func1<List<HeadTwosVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadTwosVo> HeadTwosVos) {
                return new DemarcationUtils<HeadTwosVo>(){
                    @Override
                    public int childNum(HeadTwosVo HeadTwosVo) {
                        return HeadTwosVo.HeadEven0;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(HeadTwosVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取蓝波连出界限统计
     * @param HeadTwosVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> HeadEven1(List<HeadTwosVo> HeadTwosVos){
        return  Observable.just(HeadTwosVos).flatMap(new Func1<List<HeadTwosVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadTwosVo> HeadTwosVos) {
                return new DemarcationUtils<HeadTwosVo>(){
                    @Override
                    public int childNum(HeadTwosVo HeadTwosVo) {
                        return HeadTwosVo.HeadEven1;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(HeadTwosVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param HeadTwosVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> HeadEven2(List<HeadTwosVo> HeadTwosVos){
        return  Observable.just(HeadTwosVos).flatMap(new Func1<List<HeadTwosVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadTwosVo> HeadTwosVos) {
                return new DemarcationUtils<HeadTwosVo>(){
                    @Override
                    public int childNum(HeadTwosVo HeadTwosVo) {
                        return HeadTwosVo.HeadEven2;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(HeadTwosVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param HeadTwosVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> HeadEven3(List<HeadTwosVo> HeadTwosVos){
        return  Observable.just(HeadTwosVos).flatMap(new Func1<List<HeadTwosVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadTwosVo> HeadTwosVos) {
                return new DemarcationUtils<HeadTwosVo>(){
                    @Override
                    public int childNum(HeadTwosVo HeadTwosVo) {
                        return HeadTwosVo.HeadEven3;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(HeadTwosVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param HeadTwosVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> HeadEven4(List<HeadTwosVo> HeadTwosVos){
        return  Observable.just(HeadTwosVos).flatMap(new Func1<List<HeadTwosVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadTwosVo> HeadTwosVos) {
                return new DemarcationUtils<HeadTwosVo>(){
                    @Override
                    public int childNum(HeadTwosVo HeadTwosVo) {
                        return HeadTwosVo.HeadEven4;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(HeadTwosVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param HeadTwosVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> HeadOdd0(List<HeadTwosVo> HeadTwosVos){
        return  Observable.just(HeadTwosVos).flatMap(new Func1<List<HeadTwosVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadTwosVo> HeadTwosVos) {
                return new DemarcationUtils<HeadTwosVo>(){
                    @Override
                    public int childNum(HeadTwosVo HeadTwosVo) {
                        return HeadTwosVo.HeadOdd0;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(HeadTwosVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param HeadTwosVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> HeadOdd1(List<HeadTwosVo> HeadTwosVos){
        return  Observable.just(HeadTwosVos).flatMap(new Func1<List<HeadTwosVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadTwosVo> HeadTwosVos) {
                return new DemarcationUtils<HeadTwosVo>(){
                    @Override
                    public int childNum(HeadTwosVo HeadTwosVo) {
                        return HeadTwosVo.HeadOdd1;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(HeadTwosVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param HeadTwosVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> HeadOdd2(List<HeadTwosVo> HeadTwosVos){
        return  Observable.just(HeadTwosVos).flatMap(new Func1<List<HeadTwosVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadTwosVo> HeadTwosVos) {
                return new DemarcationUtils<HeadTwosVo>(){
                    @Override
                    public int childNum(HeadTwosVo HeadTwosVo) {
                        return HeadTwosVo.HeadOdd2;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(HeadTwosVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }
    /**
     * 获取连出界限统计
     * @param HeadTwosVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> HeadOdd3(List<HeadTwosVo> HeadTwosVos){
        return  Observable.just(HeadTwosVos).flatMap(new Func1<List<HeadTwosVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadTwosVo> HeadTwosVos) {
                return new DemarcationUtils<HeadTwosVo>(){
                    @Override
                    public int childNum(HeadTwosVo HeadTwosVo) {
                        return HeadTwosVo.HeadOdd3;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(HeadTwosVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }

    /**
     * 获取连出界限统计
     * @param HeadTwosVos
     * @return
     */
    public static Observable<Map<Integer, Integer>> HeadOdd4(List<HeadTwosVo> HeadTwosVos){
        return  Observable.just(HeadTwosVos).flatMap(new Func1<List<HeadTwosVo>, Observable<Map<Integer, Integer>>>() {

            @Override
            public Observable<Map<Integer, Integer>> call(List<HeadTwosVo> HeadTwosVos) {
                return new DemarcationUtils<HeadTwosVo>(){
                    @Override
                    public int childNum(HeadTwosVo HeadTwosVo) {
                        return HeadTwosVo.HeadOdd4;
                    }

                    @Override
                    public int minNum() {
                        return 2;
                    }
                }.getMapObservable(HeadTwosVos);
            }
        }).subscribeOn(Schedulers.newThread());
    }


}
