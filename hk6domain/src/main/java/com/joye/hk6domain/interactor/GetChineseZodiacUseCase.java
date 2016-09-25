package com.joye.hk6domain.interactor;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.hk6domain.constants.ChineseZodiac;
import com.joye.hk6domain.entity.Hk6UiData;
import com.joye.hk6domain.repository.Hk6Repository;
import com.joye.hk6domain.vo.ChineseZodiacVo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/24.
 * 304622254@qq.com
 * Remeark:
 */

public class GetChineseZodiacUseCase extends GetHk6Data {


    public GetChineseZodiacUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, Hk6Repository hk6Repository, String date) {
        super(threadExecutor, postExecutionThread, hk6Repository, date);
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return super.buildUseCaseObservable().map(new Func1<List<Hk6UiData>, List<ChineseZodiacVo>>() {

            @Override
            public List<ChineseZodiacVo> call(List<Hk6UiData> hk6UiDatas) {
                List<ChineseZodiacVo> list = new ArrayList<ChineseZodiacVo>(hk6UiDatas.size());
                Map<String,Integer> map=null;
                Collections.reverse(hk6UiDatas);
                //便利所有的数据
                for (Hk6UiData itemVo:hk6UiDatas){
                    ChineseZodiacVo vo = new ChineseZodiacVo(itemVo);
                    if(map==null){
                        map=vo.getMap();
                    }
                    for (ChineseZodiac chineseZodiac:ChineseZodiac.values()){
                        int value=map.get(chineseZodiac.name());
                         map.put(chineseZodiac.name(),  !Arrays.asList(chineseZodiac.getNumbers()).contains(vo.getOpenCode())?value+1:0);
                    }
//                    for (NumberProperty property:NumberProperty.values()){
//                        int value=map.get(property.getChineseZodiac().name());
//                        map.put(property.getChineseZodiac().name(), !Arrays.asList(property.getChineseZodiac().getNumbers()).contains(vo.getOpenCode())?value+1:0);
//                    }
                    vo.setMap(map);
                    list.add(vo);
                }
                return list;
            }
        });
    }
}
