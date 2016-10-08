package com.joye.hk6domain.interactor;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.hk6domain.constants.CompositeMantissa;
import com.joye.hk6domain.constants.HeadTwos;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.entity.Hk6UiData;
import com.joye.hk6domain.repository.Hk6Repository;
import com.joye.hk6domain.vo.CompositeMantissaVo;
import com.joye.hk6domain.vo.HeadTwosVo;

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

public class GetHeadTwosUseCase extends GetHk6Data {
    public GetHeadTwosUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, Hk6Repository hk6Repository, String date) {
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
        return observable.map(new Func1<List<Hk6UiData>, List<HeadTwosVo>>() {

            @Override
            public List<HeadTwosVo> call(List<Hk6UiData> hk6UiDatas) {
                List<HeadTwosVo> list = new ArrayList<HeadTwosVo>(hk6UiDatas.size());
                Collections.reverse(hk6UiDatas);
                int HeadEven0=0,HeadEven1=0, HeadEven2=0,
                        HeadEven3=0, HeadEven4=0, HeadOdd0=0,HeadOdd1=0, HeadOdd2=0, HeadOdd3=0, HeadOdd4=0;
                for (Hk6UiData itemVo:hk6UiDatas){
                    HeadTwosVo vo = new HeadTwosVo(itemVo);
                    if(Hk6EnumHelp.getHeadTwos(vo.getOpenCode()).equals(HeadTwos.HeadEven0)){
                        HeadEven0=0;
                        HeadEven1++;
                        HeadEven2++;
                        HeadEven3++;
                        HeadEven4++;
                        HeadOdd0++;
                        HeadOdd1++;
                        HeadOdd2++;
                        HeadOdd3++;
                        HeadOdd4++;
                        vo.HeadEven0=HeadEven0;
                        vo.HeadEven1=HeadEven1;
                        vo.HeadEven2=HeadEven2;
                        vo.HeadEven3=HeadEven3;
                        vo.HeadEven4=HeadEven4;
                        vo.HeadOdd0=HeadOdd0;
                        vo.HeadOdd1=HeadOdd1;
                        vo.HeadOdd2=HeadOdd2;
                        vo.HeadOdd3=HeadOdd3;
                        vo.HeadOdd4=HeadOdd4;
                    }else if(Hk6EnumHelp.getHeadTwos(vo.getOpenCode()).equals(HeadTwos.HeadEven1)){
                        HeadEven0++;
                        HeadEven1=0;
                        HeadEven2++;
                        HeadEven3++;
                        HeadEven4++;
                        HeadOdd0++;
                        HeadOdd1++;
                        HeadOdd2++;
                        HeadOdd3++;
                        HeadOdd4++;
                        vo.HeadEven0=HeadEven0;
                        vo.HeadEven1=HeadEven1;
                        vo.HeadEven2=HeadEven2;
                        vo.HeadEven3=HeadEven3;
                        vo.HeadEven4=HeadEven4;
                        vo.HeadOdd0=HeadOdd0;
                        vo.HeadOdd1=HeadOdd1;
                        vo.HeadOdd2=HeadOdd2;
                        vo.HeadOdd3=HeadOdd3;
                        vo.HeadOdd4=HeadOdd4;
                    }else if(Hk6EnumHelp.getHeadTwos(vo.getOpenCode()).equals(HeadTwos.HeadEven2)){
                        HeadEven0++;
                        HeadEven1++;
                        HeadEven2=0;
                        HeadEven3++;
                        HeadEven4++;
                        HeadOdd0++;
                        HeadOdd1++;
                        HeadOdd2++;
                        HeadOdd3++;
                        HeadOdd4++;
                        vo.HeadEven0=HeadEven0;
                        vo.HeadEven1=HeadEven1;
                        vo.HeadEven2=HeadEven2;
                        vo.HeadEven3=HeadEven3;
                        vo.HeadEven4=HeadEven4;
                        vo.HeadOdd0=HeadOdd0;
                        vo.HeadOdd1=HeadOdd1;
                        vo.HeadOdd2=HeadOdd2;
                        vo.HeadOdd3=HeadOdd3;
                        vo.HeadOdd4=HeadOdd4;
                    }else if(Hk6EnumHelp.getHeadTwos(vo.getOpenCode()).equals(HeadTwos.HeadEven3)){
                        HeadEven0++;
                        HeadEven1++;
                        HeadEven2++;
                        HeadEven3=0;
                        HeadEven4++;
                        HeadOdd0++;
                        HeadOdd1++;
                        HeadOdd2++;
                        HeadOdd3++;
                        HeadOdd4++;
                        vo.HeadEven0=HeadEven0;
                        vo.HeadEven1=HeadEven1;
                        vo.HeadEven2=HeadEven2;
                        vo.HeadEven3=HeadEven3;
                        vo.HeadEven4=HeadEven4;
                        vo.HeadOdd0=HeadOdd0;
                        vo.HeadOdd1=HeadOdd1;
                        vo.HeadOdd2=HeadOdd2;
                        vo.HeadOdd3=HeadOdd3;
                        vo.HeadOdd4=HeadOdd4;
                    }else if(Hk6EnumHelp.getHeadTwos(vo.getOpenCode()).equals(HeadTwos.HeadEven4)){
                        HeadEven0++;
                        HeadEven1++;
                        HeadEven2++;
                        HeadEven3++;
                        HeadEven4=0;
                        HeadOdd0++;
                        HeadOdd1++;
                        HeadOdd2++;
                        HeadOdd3++;
                        HeadOdd4++;
                        vo.HeadEven0=HeadEven0;
                        vo.HeadEven1=HeadEven1;
                        vo.HeadEven2=HeadEven2;
                        vo.HeadEven3=HeadEven3;
                        vo.HeadEven4=HeadEven4;
                        vo.HeadOdd0=HeadOdd0;
                        vo.HeadOdd1=HeadOdd1;
                        vo.HeadOdd2=HeadOdd2;
                        vo.HeadOdd3=HeadOdd3;
                        vo.HeadOdd4=HeadOdd4;
                    }else if(Hk6EnumHelp.getHeadTwos(vo.getOpenCode()).equals(HeadTwos.HeadOdd0)){
                        HeadEven0++;
                        HeadEven1++;
                        HeadEven2++;
                        HeadEven3++;
                        HeadEven4++;
                        HeadOdd0=0;
                        HeadOdd1++;
                        HeadOdd2++;
                        HeadOdd3++;
                        HeadOdd4++;
                        vo.HeadEven0=HeadEven0;
                        vo.HeadEven1=HeadEven1;
                        vo.HeadEven2=HeadEven2;
                        vo.HeadEven3=HeadEven3;
                        vo.HeadEven4=HeadEven4;
                        vo.HeadOdd0=HeadOdd0;
                        vo.HeadOdd1=HeadOdd1;
                        vo.HeadOdd2=HeadOdd2;
                        vo.HeadOdd3=HeadOdd3;
                        vo.HeadOdd4=HeadOdd4;
                    }else if(Hk6EnumHelp.getHeadTwos(vo.getOpenCode()).equals(HeadTwos.HeadOdd1)){
                        HeadEven0++;
                        HeadEven1++;
                        HeadEven2++;
                        HeadEven3++;
                        HeadEven4++;
                        HeadOdd0++;
                        HeadOdd1=0;
                        HeadOdd2++;
                        HeadOdd3++;
                        HeadOdd4++;
                        vo.HeadEven0=HeadEven0;
                        vo.HeadEven1=HeadEven1;
                        vo.HeadEven2=HeadEven2;
                        vo.HeadEven3=HeadEven3;
                        vo.HeadEven4=HeadEven4;
                        vo.HeadOdd0=HeadOdd0;
                        vo.HeadOdd1=HeadOdd1;
                        vo.HeadOdd2=HeadOdd2;
                        vo.HeadOdd3=HeadOdd3;
                        vo.HeadOdd4=HeadOdd4;
                    }else if(Hk6EnumHelp.getHeadTwos(vo.getOpenCode()).equals(HeadTwos.HeadOdd2)){
                        HeadEven0++;
                        HeadEven1++;
                        HeadEven2++;
                        HeadEven3++;
                        HeadEven4++;
                        HeadOdd0++;
                        HeadOdd1++;
                        HeadOdd2=0;
                        HeadOdd3++;
                        HeadOdd4++;
                        vo.HeadEven0=HeadEven0;
                        vo.HeadEven1=HeadEven1;
                        vo.HeadEven2=HeadEven2;
                        vo.HeadEven3=HeadEven3;
                        vo.HeadEven4=HeadEven4;
                        vo.HeadOdd0=HeadOdd0;
                        vo.HeadOdd1=HeadOdd1;
                        vo.HeadOdd2=HeadOdd2;
                        vo.HeadOdd3=HeadOdd3;
                        vo.HeadOdd4=HeadOdd4;
                    }else if(Hk6EnumHelp.getHeadTwos(vo.getOpenCode()).equals(HeadTwos.HeadOdd3)){
                        HeadEven0++;
                        HeadEven1++;
                        HeadEven2++;
                        HeadEven3++;
                        HeadEven4++;
                        HeadOdd0++;
                        HeadOdd1++;
                        HeadOdd2++;
                        HeadOdd3=0;
                        HeadOdd4++;
                        vo.HeadEven0=HeadEven0;
                        vo.HeadEven1=HeadEven1;
                        vo.HeadEven2=HeadEven2;
                        vo.HeadEven3=HeadEven3;
                        vo.HeadEven4=HeadEven4;
                        vo.HeadOdd0=HeadOdd0;
                        vo.HeadOdd1=HeadOdd1;
                        vo.HeadOdd2=HeadOdd2;
                        vo.HeadOdd3=HeadOdd3;
                        vo.HeadOdd4=HeadOdd4;
                    }else if(Hk6EnumHelp.getHeadTwos(vo.getOpenCode()).equals(HeadTwos.HeadOdd4)){
                        HeadEven0++;
                        HeadEven1++;
                        HeadEven2++;
                        HeadEven3++;
                        HeadEven4++;
                        HeadOdd0++;
                        HeadOdd1++;
                        HeadOdd2++;
                        HeadOdd3++;
                        HeadOdd4=0;
                        vo.HeadEven0=HeadEven0;
                        vo.HeadEven1=HeadEven1;
                        vo.HeadEven2=HeadEven2;
                        vo.HeadEven3=HeadEven3;
                        vo.HeadEven4=HeadEven4;
                        vo.HeadOdd0=HeadOdd0;
                        vo.HeadOdd1=HeadOdd1;
                        vo.HeadOdd2=HeadOdd2;
                        vo.HeadOdd3=HeadOdd3;
                        vo.HeadOdd4=HeadOdd4;
                    }
                    list.add(vo);
                }
                Collections.reverse(list);
                return list;
            }
        });
    }
}
