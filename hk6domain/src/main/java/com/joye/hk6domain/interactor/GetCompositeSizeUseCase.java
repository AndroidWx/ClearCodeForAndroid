package com.joye.hk6domain.interactor;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.hk6domain.constants.CompositeSize;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.entity.Hk6UiData;
import com.joye.hk6domain.repository.Hk6Repository;
import com.joye.hk6domain.vo.CompositeSizeVo;

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

public class GetCompositeSizeUseCase extends GetHk6Data {
    public GetCompositeSizeUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, Hk6Repository hk6Repository, String date) {
        super(threadExecutor, postExecutionThread, hk6Repository, date);
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return getHistory().map(new Func1<List<Hk6UiData>, List<CompositeSizeVo>>() {
            @Override
            public List<CompositeSizeVo> call(List<Hk6UiData> hk6UiDatas) {
                List<CompositeSizeVo> list = new ArrayList<CompositeSizeVo>(hk6UiDatas.size());
                Collections.reverse(hk6UiDatas);
                int Big = 0,Small=0;
                CompositeSizeVo vo;
                for (Hk6UiData itemVo:hk6UiDatas){
                      vo = new CompositeSizeVo(itemVo);
                    if(Hk6EnumHelp.getCompositeSize(vo.getOpenCode()).equals(CompositeSize.Big)){
                        Big=0;
                        Small++;
                        vo.Big=Big;
                        vo.Small=Small;

                    }else if(Hk6EnumHelp.getCompositeSize(vo.getOpenCode()).equals(CompositeSize.Small)){
                        Big++;
                        Small=0;
                        vo.Big=Big;
                        vo.Small=Small;
                    }
                    list.add(vo);
                }
                Collections.reverse(list);
                return list;
            }
        });
    }
}
