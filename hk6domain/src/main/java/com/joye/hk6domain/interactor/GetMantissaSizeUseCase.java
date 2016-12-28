package com.joye.hk6domain.interactor;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.constants.MantissaSize;
import com.joye.hk6domain.entity.Hk6UiData;
import com.joye.hk6domain.repository.Hk6Repository;
import com.joye.hk6domain.vo.MantissaSizeVo;

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

public class GetMantissaSizeUseCase extends GetHk6Data {
    public GetMantissaSizeUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, Hk6Repository hk6Repository, String date) {
        super(threadExecutor, postExecutionThread, hk6Repository, date);
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return getHistory().map(new Func1<List<Hk6UiData>, List<MantissaSizeVo>>() {

            @Override
            public List<MantissaSizeVo> call(List<Hk6UiData> hk6UiDatas) {
                List<MantissaSizeVo> list = new ArrayList<MantissaSizeVo>(hk6UiDatas.size());
                Collections.reverse(hk6UiDatas);
                int MantissaSmall = 0,MantissaBig=0;
                MantissaSizeVo vo;
                for (Hk6UiData itemVo:hk6UiDatas){
                      vo = new MantissaSizeVo(itemVo);
                    if(Hk6EnumHelp.getMantissaSize(vo.getOpenCode()).equals(MantissaSize.MantissaBig)){
                        MantissaBig=0;
                        MantissaSmall++;
                        vo.Big=MantissaBig;
                        vo.Small=MantissaSmall;
                    }else if(Hk6EnumHelp.getMantissaSize(vo.getOpenCode()).equals(MantissaSize.MantissaSmall)){
                        MantissaSmall=0;
                        MantissaBig++;
                        vo.Big=MantissaBig;
                        vo.Small=MantissaSmall;
                    }
                    list.add(vo);
                }
                Collections.reverse(list);
                return list;
            }
        });
    }
}
