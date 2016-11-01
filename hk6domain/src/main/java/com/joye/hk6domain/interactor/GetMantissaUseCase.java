package com.joye.hk6domain.interactor;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.constants.Mantissa;
import com.joye.hk6domain.entity.Hk6UiData;
import com.joye.hk6domain.repository.Hk6Repository;
import com.joye.hk6domain.vo.MantissaVo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func9;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:
 */

public class GetMantissaUseCase extends GetHk6Data {
    public GetMantissaUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, Hk6Repository hk6Repository, String date) {
        super(threadExecutor, postExecutionThread, hk6Repository, date);
    }

    @Override
    protected Observable buildUseCaseObservable() {
        Observable observable=Observable.zip(
                super.buildUseCaseObservable("2008-12-31"),
                super.buildUseCaseObservable("2009-12-31"),
                super.buildUseCaseObservable("2010-12-31"),
                super.buildUseCaseObservable("2011-12-31"),
                super.buildUseCaseObservable("2012-12-31"),
                super.buildUseCaseObservable("2013-12-31"),
                super.buildUseCaseObservable("2014-12-31"),
                super.buildUseCaseObservable("2015-12-31"),
                super.buildUseCaseObservable(),
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
                });        return observable.map(new Func1<List<Hk6UiData>, List<MantissaVo>>() {

            @Override
            public List<MantissaVo> call(List<Hk6UiData> hk6UiDatas) {
                List<MantissaVo> list = new ArrayList<MantissaVo>(hk6UiDatas.size());
                Collections.reverse(hk6UiDatas);
                int Mantissa0 = 0,Mantissa1=0,Mantissa2=0,Mantissa3=0,Mantissa4=0,Mantissa5=0,
                        Mantissa6=0,Mantissa7=0,Mantissa8=0,Mantissa9=0;
                for (Hk6UiData itemVo:hk6UiDatas){
                    MantissaVo vo = new MantissaVo(itemVo);
                    if(Hk6EnumHelp.getMantissa(vo.getOpenCode()).equals(Mantissa.Mantissa0)){
                        Mantissa0=0;
                        Mantissa1++;
                        Mantissa2++;
                        Mantissa3++;
                        Mantissa4++;
                        Mantissa5++;
                        Mantissa6++;
                        Mantissa7++;
                        Mantissa8++;
                        Mantissa9++;
                        vo.Mantissa0=Mantissa0;
                        vo.Mantissa1=Mantissa1;
                        vo.Mantissa2=Mantissa2;
                        vo.Mantissa3=Mantissa3;
                        vo.Mantissa4=Mantissa4;
                        vo.Mantissa5=Mantissa5;
                        vo.Mantissa6=Mantissa6;
                        vo.Mantissa7=Mantissa7;
                        vo.Mantissa8=Mantissa8;
                        vo.Mantissa9=Mantissa9;
                    }else if(Hk6EnumHelp.getMantissa(vo.getOpenCode()).equals(Mantissa.Mantissa1)){
                        Mantissa0++;
                        Mantissa1=0;
                        Mantissa2++;
                        Mantissa3++;
                        Mantissa4++;
                        Mantissa5++;
                        Mantissa6++;
                        Mantissa7++;
                        Mantissa8++;
                        Mantissa9++;
                        vo.Mantissa0=Mantissa0;
                        vo.Mantissa1=Mantissa1;
                        vo.Mantissa2=Mantissa2;
                        vo.Mantissa3=Mantissa3;
                        vo.Mantissa4=Mantissa4;
                        vo.Mantissa5=Mantissa5;
                        vo.Mantissa6=Mantissa6;
                        vo.Mantissa7=Mantissa7;
                        vo.Mantissa8=Mantissa8;
                        vo.Mantissa9=Mantissa9;
                    }else if(Hk6EnumHelp.getMantissa(vo.getOpenCode()).equals(Mantissa.Mantissa2)){
                        Mantissa0++;
                        Mantissa1++;
                        Mantissa2=0;
                        Mantissa3++;
                        Mantissa4++;
                        Mantissa5++;
                        Mantissa6++;
                        Mantissa7++;
                        Mantissa8++;
                        Mantissa9++;
                        vo.Mantissa0=Mantissa0;
                        vo.Mantissa1=Mantissa1;
                        vo.Mantissa2=Mantissa2;
                        vo.Mantissa3=Mantissa3;
                        vo.Mantissa4=Mantissa4;
                        vo.Mantissa5=Mantissa5;
                        vo.Mantissa6=Mantissa6;
                        vo.Mantissa7=Mantissa7;
                        vo.Mantissa8=Mantissa8;
                        vo.Mantissa9=Mantissa9;
                    }else if(Hk6EnumHelp.getMantissa(vo.getOpenCode()).equals(Mantissa.Mantissa3)){
                        Mantissa0++;
                        Mantissa1++;
                        Mantissa2++;
                        Mantissa3=0;
                        Mantissa4++;
                        Mantissa5++;
                        Mantissa6++;
                        Mantissa7++;
                        Mantissa8++;
                        Mantissa9++;
                        vo.Mantissa0=Mantissa0;
                        vo.Mantissa1=Mantissa1;
                        vo.Mantissa2=Mantissa2;
                        vo.Mantissa3=Mantissa3;
                        vo.Mantissa4=Mantissa4;
                        vo.Mantissa5=Mantissa5;
                        vo.Mantissa6=Mantissa6;
                        vo.Mantissa7=Mantissa7;
                        vo.Mantissa8=Mantissa8;
                        vo.Mantissa9=Mantissa9;
                    }else if(Hk6EnumHelp.getMantissa(vo.getOpenCode()).equals(Mantissa.Mantissa4)){
                        Mantissa0++;
                        Mantissa1++;
                        Mantissa2++;
                        Mantissa3++;
                        Mantissa4=0;
                        Mantissa5++;
                        Mantissa6++;
                        Mantissa7++;
                        Mantissa8++;
                        Mantissa9++;
                        vo.Mantissa0=Mantissa0;
                        vo.Mantissa1=Mantissa1;
                        vo.Mantissa2=Mantissa2;
                        vo.Mantissa3=Mantissa3;
                        vo.Mantissa4=Mantissa4;
                        vo.Mantissa5=Mantissa5;
                        vo.Mantissa6=Mantissa6;
                        vo.Mantissa7=Mantissa7;
                        vo.Mantissa8=Mantissa8;
                        vo.Mantissa9=Mantissa9;
                    }else if(Hk6EnumHelp.getMantissa(vo.getOpenCode()).equals(Mantissa.Mantissa5)){
                        Mantissa0++;
                        Mantissa1++;
                        Mantissa2++;
                        Mantissa3++;
                        Mantissa4++;
                        Mantissa5=0;
                        Mantissa6++;
                        Mantissa7++;
                        Mantissa8++;
                        Mantissa9++;
                        vo.Mantissa0=Mantissa0;
                        vo.Mantissa1=Mantissa1;
                        vo.Mantissa2=Mantissa2;
                        vo.Mantissa3=Mantissa3;
                        vo.Mantissa4=Mantissa4;
                        vo.Mantissa5=Mantissa5;
                        vo.Mantissa6=Mantissa6;
                        vo.Mantissa7=Mantissa7;
                        vo.Mantissa8=Mantissa8;
                        vo.Mantissa9=Mantissa9;
                    }else if(Hk6EnumHelp.getMantissa(vo.getOpenCode()).equals(Mantissa.Mantissa6)){
                        Mantissa0++;
                        Mantissa1++;
                        Mantissa2++;
                        Mantissa3++;
                        Mantissa4++;
                        Mantissa5++;
                        Mantissa6=0;
                        Mantissa7++;
                        Mantissa8++;
                        Mantissa9++;
                        vo.Mantissa0=Mantissa0;
                        vo.Mantissa1=Mantissa1;
                        vo.Mantissa2=Mantissa2;
                        vo.Mantissa3=Mantissa3;
                        vo.Mantissa4=Mantissa4;
                        vo.Mantissa5=Mantissa5;
                        vo.Mantissa6=Mantissa6;
                        vo.Mantissa7=Mantissa7;
                        vo.Mantissa8=Mantissa8;
                        vo.Mantissa9=Mantissa9;
                    }else if(Hk6EnumHelp.getMantissa(vo.getOpenCode()).equals(Mantissa.Mantissa7)){
                        Mantissa0++;
                        Mantissa1++;
                        Mantissa2++;
                        Mantissa3++;
                        Mantissa4++;
                        Mantissa5++;
                        Mantissa6++;
                        Mantissa7=0;
                        Mantissa8++;
                        Mantissa9++;
                        vo.Mantissa0=Mantissa0;
                        vo.Mantissa1=Mantissa1;
                        vo.Mantissa2=Mantissa2;
                        vo.Mantissa3=Mantissa3;
                        vo.Mantissa4=Mantissa4;
                        vo.Mantissa5=Mantissa5;
                        vo.Mantissa6=Mantissa6;
                        vo.Mantissa7=Mantissa7;
                        vo.Mantissa8=Mantissa8;
                        vo.Mantissa9=Mantissa9;
                    }else if(Hk6EnumHelp.getMantissa(vo.getOpenCode()).equals(Mantissa.Mantissa8)){
                        Mantissa0++;
                        Mantissa1++;
                        Mantissa2++;
                        Mantissa3++;
                        Mantissa4++;
                        Mantissa5++;
                        Mantissa6++;
                        Mantissa7++;
                        Mantissa8=0;
                        Mantissa9++;
                        vo.Mantissa0=Mantissa0;
                        vo.Mantissa1=Mantissa1;
                        vo.Mantissa2=Mantissa2;
                        vo.Mantissa3=Mantissa3;
                        vo.Mantissa4=Mantissa4;
                        vo.Mantissa5=Mantissa5;
                        vo.Mantissa6=Mantissa6;
                        vo.Mantissa7=Mantissa7;
                        vo.Mantissa8=Mantissa8;
                        vo.Mantissa9=Mantissa9;
                    }else if(Hk6EnumHelp.getMantissa(vo.getOpenCode()).equals(Mantissa.Mantissa9)){
                        Mantissa0++;
                        Mantissa1++;
                        Mantissa2++;
                        Mantissa3++;
                        Mantissa4++;
                        Mantissa5++;
                        Mantissa6++;
                        Mantissa7++;
                        Mantissa8++;
                        Mantissa9=0;
                        vo.Mantissa0=Mantissa0;
                        vo.Mantissa1=Mantissa1;
                        vo.Mantissa2=Mantissa2;
                        vo.Mantissa3=Mantissa3;
                        vo.Mantissa4=Mantissa4;
                        vo.Mantissa5=Mantissa5;
                        vo.Mantissa6=Mantissa6;
                        vo.Mantissa7=Mantissa7;
                        vo.Mantissa8=Mantissa8;
                        vo.Mantissa9=Mantissa9;
                    }
                    list.add(vo);
                }
                Collections.reverse(list);
                return list;
            }
        });
    }
}
