package com.joye.hk6domain.interactor;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.hk6domain.constants.CompositeMantissa;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.entity.Hk6UiData;
import com.joye.hk6domain.repository.Hk6Repository;
import com.joye.hk6domain.vo.CompositeMantissaVo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func3;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:
 */

public class GetCompositeMantissaUseCase extends GetHk6Data {
    public GetCompositeMantissaUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, Hk6Repository hk6Repository, String date) {
        super(threadExecutor, postExecutionThread, hk6Repository, date);
    }

    @Override
    protected Observable buildUseCaseObservable() {
        Observable observable=Observable.zip(super.buildUseCaseObservable("2014-12-31"),super.buildUseCaseObservable("2015-12-31"), super.buildUseCaseObservable(), new Func3<List<Hk6UiData>,List<Hk6UiData>,List<Hk6UiData>,List<Hk6UiData>>() {


            @Override
            public List<Hk6UiData> call(List<Hk6UiData> o, List<Hk6UiData> o2, List<Hk6UiData> o3) {
                List<Hk6UiData> datas=new ArrayList<Hk6UiData>();
                datas.addAll(o3);
                datas.addAll(o2);
                datas.addAll(o);
                return datas;
            }
        });
        return observable.map(new Func1<List<Hk6UiData>, List<CompositeMantissaVo>>() {

            @Override
            public List<CompositeMantissaVo> call(List<Hk6UiData> hk6UiDatas) {
                List<CompositeMantissaVo> list = new ArrayList<CompositeMantissaVo>(hk6UiDatas.size());
                Collections.reverse(hk6UiDatas);
                int composite0=0,composite1=0, composite2=0,
                        composite3=0, composite4=0, composite5=0,composite6=0, composite7=0, composite8=0, composite9=0;
                for (Hk6UiData itemVo:hk6UiDatas){
                    CompositeMantissaVo vo = new CompositeMantissaVo(itemVo);
                    if(Hk6EnumHelp.getCompositeMantissa(vo.getOpenCode()).equals(CompositeMantissa.CM0)){
                        composite0=0;
                        composite1++;
                        composite2++;
                        composite3++;
                        composite4++;
                        composite5++;
                        composite6++;
                        composite7++;
                        composite8++;
                        composite9++;
                        vo.composite0=composite0;
                        vo.composite1=composite1;
                        vo.composite2=composite2;
                        vo.composite3=composite3;
                        vo.composite4=composite4;
                        vo.composite5=composite5;
                        vo.composite6=composite6;
                        vo.composite7=composite7;
                        vo.composite8=composite8;
                        vo.composite9=composite9;


                    }else if(Hk6EnumHelp.getCompositeMantissa(vo.getOpenCode()).equals(CompositeMantissa.CM1)){
                        composite0++;
                        composite1=0;
                        composite2++;
                        composite3++;
                        composite4++;
                        composite5++;
                        composite6++;
                        composite7++;
                        composite8++;
                        composite9++;
                        vo.composite0=composite0;
                        vo.composite1=composite1;
                        vo.composite2=composite2;
                        vo.composite3=composite3;
                        vo.composite4=composite4;
                        vo.composite5=composite5;
                        vo.composite6=composite6;
                        vo.composite7=composite7;
                        vo.composite8=composite8;
                        vo.composite9=composite9;
                    }else if(Hk6EnumHelp.getCompositeMantissa(vo.getOpenCode()).equals(CompositeMantissa.CM2)){
                        composite0++;
                        composite1++;
                        composite2=0;
                        composite3++;
                        composite4++;
                        composite5++;
                        composite6++;
                        composite7++;
                        composite8++;
                        composite9++;
                        vo.composite0=composite0;
                        vo.composite1=composite1;
                        vo.composite2=composite2;
                        vo.composite3=composite3;
                        vo.composite4=composite4;
                        vo.composite5=composite5;
                        vo.composite6=composite6;
                        vo.composite7=composite7;
                        vo.composite8=composite8;
                        vo.composite9=composite9;
                    }else if(Hk6EnumHelp.getCompositeMantissa(vo.getOpenCode()).equals(CompositeMantissa.CM3)){
                        composite0++;
                        composite1++;
                        composite2++;
                        composite3=0;
                        composite4++;
                        composite5++;
                        composite6++;
                        composite7++;
                        composite8++;
                        composite9++;
                        vo.composite0=composite0;
                        vo.composite1=composite1;
                        vo.composite2=composite2;
                        vo.composite3=composite3;
                        vo.composite4=composite4;
                        vo.composite5=composite5;
                        vo.composite6=composite6;
                        vo.composite7=composite7;
                        vo.composite8=composite8;
                        vo.composite9=composite9;
                    }else if(Hk6EnumHelp.getCompositeMantissa(vo.getOpenCode()).equals(CompositeMantissa.CM4)){
                        composite0++;
                        composite1++;
                        composite2++;
                        composite3++;
                        composite4=0;
                        composite5++;
                        composite6++;
                        composite7++;
                        composite8++;
                        composite9++;
                        vo.composite0=composite0;
                        vo.composite1=composite1;
                        vo.composite2=composite2;
                        vo.composite3=composite3;
                        vo.composite4=composite4;
                        vo.composite5=composite5;
                        vo.composite6=composite6;
                        vo.composite7=composite7;
                        vo.composite8=composite8;
                        vo.composite9=composite9;
                    }else   if(Hk6EnumHelp.getCompositeMantissa(vo.getOpenCode()).equals(CompositeMantissa.CM5)){
                        composite0++;
                        composite1++;
                        composite2++;
                        composite5=0;
                        composite4++;
                        composite3++;
                        composite6++;
                        composite7++;
                        composite8++;
                        composite9++;
                        vo.composite0=composite0;
                        vo.composite1=composite1;
                        vo.composite2=composite2;
                        vo.composite3=composite3;
                        vo.composite4=composite4;
                        vo.composite5=composite5;
                        vo.composite6=composite6;
                        vo.composite7=composite7;
                        vo.composite8=composite8;
                        vo.composite9=composite9;
                    }
                    else   if(Hk6EnumHelp.getCompositeMantissa(vo.getOpenCode()).equals(CompositeMantissa.CM6)){
                        composite0++;
                        composite1++;
                        composite2++;
                        composite6=0;
                        composite4++;
                        composite3++;
                        composite5++;
                        composite7++;
                        composite8++;
                        composite9++;
                        vo.composite0=composite0;
                        vo.composite1=composite1;
                        vo.composite2=composite2;
                        vo.composite3=composite3;
                        vo.composite4=composite4;
                        vo.composite5=composite5;
                        vo.composite6=composite6;
                        vo.composite7=composite7;
                        vo.composite8=composite8;
                        vo.composite9=composite9;
                    }else   if(Hk6EnumHelp.getCompositeMantissa(vo.getOpenCode()).equals(CompositeMantissa.CM7)){
                        composite0++;
                        composite1++;
                        composite2++;
                        composite7=0;
                        composite4++;
                        composite3++;
                        composite6++;
                        composite5++;
                        composite8++;
                        composite9++;
                        vo.composite0=composite0;
                        vo.composite1=composite1;
                        vo.composite2=composite2;
                        vo.composite3=composite3;
                        vo.composite4=composite4;
                        vo.composite5=composite5;
                        vo.composite6=composite6;
                        vo.composite7=composite7;
                        vo.composite8=composite8;
                        vo.composite9=composite9;
                    }else   if(Hk6EnumHelp.getCompositeMantissa(vo.getOpenCode()).equals(CompositeMantissa.CM8)){
                        composite0++;
                        composite1++;
                        composite2++;
                        composite8=0;
                        composite4++;
                        composite3++;
                        composite6++;
                        composite7++;
                        composite5++;
                        composite9++;
                        vo.composite0=composite0;
                        vo.composite1=composite1;
                        vo.composite2=composite2;
                        vo.composite3=composite3;
                        vo.composite4=composite4;
                        vo.composite5=composite5;
                        vo.composite6=composite6;
                        vo.composite7=composite7;
                        vo.composite8=composite8;
                        vo.composite9=composite9;
                    }else   if(Hk6EnumHelp.getCompositeMantissa(vo.getOpenCode()).equals(CompositeMantissa.CM9)){
                        composite0++;
                        composite1++;
                        composite2++;
                        composite9=0;
                        composite4++;
                        composite3++;
                        composite6++;
                        composite7++;
                        composite8++;
                        composite5++;
                        vo.composite0=composite0;
                        vo.composite1=composite1;
                        vo.composite2=composite2;
                        vo.composite3=composite3;
                        vo.composite4=composite4;
                        vo.composite5=composite5;
                        vo.composite6=composite6;
                        vo.composite7=composite7;
                        vo.composite8=composite8;
                        vo.composite9=composite9;
                    }



                    list.add(vo);
                }
                Collections.reverse(list);
                return list;
            }
        });
    }
}
