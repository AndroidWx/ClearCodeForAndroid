package com.joye.hk6domain.interactor;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.basedomain.interactor.UseCase;
import com.joye.hk6domain.entity.Hk6UiData;
import com.joye.hk6domain.repository.Hk6Repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func4;
import rx.functions.Func9;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/23.
 * 304622254@qq.com
 * Remeark:
 */

public class GetHk6Data extends UseCase {
    protected final Hk6Repository hk6Repository;
    protected final String date;
    @Inject
    public GetHk6Data(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, Hk6Repository hk6Repository, String date) {
        super(threadExecutor, postExecutionThread);
        this.hk6Repository = hk6Repository;
        this.date = date;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return hk6Repository.getHk6Data(date);
    }

    public Observable buildUseCaseObservable(String date){
        return hk6Repository.getHk6Data(date);
    }
    
    protected Observable<List<Hk6UiData>> getHistory(){
        Observable observable2=Observable.zip(
                buildUseCaseObservable("1990-12-31"),
                buildUseCaseObservable("1991-12-31"),
                buildUseCaseObservable("1992-12-31"),
                buildUseCaseObservable("1993-12-31"),
                buildUseCaseObservable("1994-12-31"),
                buildUseCaseObservable("1995-12-31"),
                buildUseCaseObservable("1996-12-31"),
                buildUseCaseObservable("1997-12-31"),
                buildUseCaseObservable("1998-12-31"),
                new Func9<List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>>() {
                    @Override
                    public List<Hk6UiData> call(List<Hk6UiData> o, List<Hk6UiData> o2, List<Hk6UiData> o3,List<Hk6UiData> o4,List<Hk6UiData> o5, List<Hk6UiData> o6,List<Hk6UiData> o7,List<Hk6UiData> o8,List<Hk6UiData>o9) {
                        List<Hk6UiData> datas=new ArrayList<Hk6UiData>();
                        datas.addAll(o9);
                        datas.addAll(o8);
                        datas.addAll(o7);
                        datas.addAll(o6);
                        datas.addAll(o5);
                        datas.addAll(o4);
                        datas.addAll(o3);
                        datas.addAll(o2);
                        datas.addAll(o);
                        return datas;
                    }
                });
        Observable observable1=Observable.zip(
                buildUseCaseObservable("1999-12-31"),
                buildUseCaseObservable("2000-12-31"),
                buildUseCaseObservable("2001-12-31"),
                buildUseCaseObservable("2002-12-31"),
                buildUseCaseObservable("2003-12-31"),
                buildUseCaseObservable("2004-12-31"),
                buildUseCaseObservable("2005-12-31"),
                buildUseCaseObservable("2006-12-31"),
                buildUseCaseObservable("2007-12-31"),
                new Func9<List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>>() {
                    @Override
                    public List<Hk6UiData> call(List<Hk6UiData> o, List<Hk6UiData> o2, List<Hk6UiData> o3,List<Hk6UiData> o4,List<Hk6UiData> o5, List<Hk6UiData> o6,List<Hk6UiData> o7,List<Hk6UiData> o8,List<Hk6UiData>o9) {
                        List<Hk6UiData> datas=new ArrayList<Hk6UiData>();
                        datas.addAll(o9);
                        datas.addAll(o8);
                        datas.addAll(o7);
                        datas.addAll(o6);
                        datas.addAll(o5);
                        datas.addAll(o4);
                        datas.addAll(o3);
                        datas.addAll(o2);
                        datas.addAll(o);
                        return datas;
                    }
                });
        Observable observable0=Observable.zip(
                buildUseCaseObservable("2008-12-31"),
                buildUseCaseObservable("2009-12-31"),
                buildUseCaseObservable("2010-12-31"),
                buildUseCaseObservable("2011-12-31"),
                buildUseCaseObservable("2012-12-31"),
                buildUseCaseObservable("2013-12-31"),
                buildUseCaseObservable("2014-12-31"),
                buildUseCaseObservable("2015-12-31"),
                buildUseCaseObservable("2016-12-31"),
                new Func9<List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>>() {
                    @Override
                    public List<Hk6UiData> call(List<Hk6UiData> o, List<Hk6UiData> o2, List<Hk6UiData> o3,List<Hk6UiData> o4,List<Hk6UiData> o5, List<Hk6UiData> o6,List<Hk6UiData> o7,List<Hk6UiData> o8,List<Hk6UiData>o9) {
                        List<Hk6UiData> datas=new ArrayList<Hk6UiData>();
                        datas.addAll(o9);
                        datas.addAll(o8);
                        datas.addAll(o7);
                        datas.addAll(o6);
                        datas.addAll(o5);
                        datas.addAll(o4);
                        datas.addAll(o3);
                        datas.addAll(o2);
                        datas.addAll(o);
                        return datas;
                    }
                });
        Observable<List<Hk6UiData>> observable=Observable.zip(observable2,observable1,observable0,buildUseCaseObservable(date),new Func4<List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>>(){


            @Override
            public List<Hk6UiData> call(List<Hk6UiData> o, List<Hk6UiData> o2, List<Hk6UiData> o3,List<Hk6UiData> o4) {
                List<Hk6UiData> datas=new ArrayList<Hk6UiData>();
                datas.addAll(o4);
                datas.addAll(o3);
                datas.addAll(o2);
                datas.addAll(o);
                return datas;
            }
        });
         return observable;
    }
}
