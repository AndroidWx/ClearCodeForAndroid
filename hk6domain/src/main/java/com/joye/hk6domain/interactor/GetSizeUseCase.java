package com.joye.hk6domain.interactor;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.constants.Hk6Size;
import com.joye.hk6domain.entity.Hk6UiData;
import com.joye.hk6domain.repository.Hk6Repository;
import com.joye.hk6domain.vo.SizeVo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.Func3;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:
 */

public class GetSizeUseCase extends GetHk6Data {
    public GetSizeUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, Hk6Repository hk6Repository, String date) {
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
        return  observable.map(new Func1<List<Hk6UiData>, List<SizeVo>>() {

            @Override
            public List<SizeVo> call(List<Hk6UiData> hk6UiDatas) {
                List<SizeVo> list = new ArrayList<SizeVo>(hk6UiDatas.size());
                Map<String,Integer> map=null;
                Collections.reverse(hk6UiDatas);
                int Big = 0,Small=0;
                for (Hk6UiData itemVo:hk6UiDatas){
                    SizeVo vo = new SizeVo(itemVo);
                    if(Hk6EnumHelp.getHk6Size(vo.getOpenCode()).equals(Hk6Size.Big)){
                        Small++;
                        Big=0;
                        vo.Big=0;
                        vo.Small=Small;
                    }else{
                        Big++;
                        Small=0;
                        vo.Small=0;
                        vo.Big=Big;
                    }
                    list.add(vo);
                }
                Collections.reverse(list);
                return list;
            }
        });
    }
}
