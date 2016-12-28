package com.joye.hk6domain.interactor;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.constants.Region;
import com.joye.hk6domain.entity.Hk6UiData;
import com.joye.hk6domain.repository.Hk6Repository;
import com.joye.hk6domain.vo.RegionVo;

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

public class GetRegionUseCase extends GetHk6Data {
    public GetRegionUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, Hk6Repository hk6Repository, String date) {
        super(threadExecutor, postExecutionThread, hk6Repository, date);
    }

    @Override
    protected Observable buildUseCaseObservable() {
         return getHistory().map(new Func1<List<Hk6UiData>, List<RegionVo>>() {

            @Override
            public List<RegionVo> call(List<Hk6UiData> hk6UiDatas) {
                List<RegionVo> list = new ArrayList<RegionVo>(hk6UiDatas.size());
                Collections.reverse(hk6UiDatas);
                int One = 0,Two=0,Three=0,Four=0,Five=0,Sex=0,Seven=0;
                RegionVo vo;
                for (Hk6UiData itemVo:hk6UiDatas){
                      vo = new RegionVo(itemVo);
                    if(Hk6EnumHelp.getRegion(vo.getOpenCode()).equals(Region.One)){
                        One=0;
                        Two++;
                        Three++;
                        Four++;
                        Five++;
                        Sex++;
                        Seven++;
                        vo.One=One;
                        vo.Two=Two;
                        vo.Three=Three;
                        vo.Four=Four;
                        vo.Five=Five;
                        vo.Sex=Sex;
                        vo.Seven=Seven;
                    }else if(Hk6EnumHelp.getRegion(vo.getOpenCode()).equals(Region.Two)){
                        One++;
                        Two=0;
                        Three++;
                        Four++;
                        Five++;
                        Sex++;
                        Seven++;
                        vo.One=One;
                        vo.Two=Two;
                        vo.Three=Three;
                        vo.Four=Four;
                        vo.Five=Five;
                        vo.Sex=Sex;
                        vo.Seven=Seven;
                    }else if(Hk6EnumHelp.getRegion(vo.getOpenCode()).equals(Region.Three)){
                        One++;
                        Two++;
                        Three=0;
                        Four++;
                        Five++;
                        Sex++;
                        Seven++;
                        vo.One=One;
                        vo.Two=Two;
                        vo.Three=Three;
                        vo.Four=Four;
                        vo.Five=Five;
                        vo.Sex=Sex;
                        vo.Seven=Seven;
                    }else if(Hk6EnumHelp.getRegion(vo.getOpenCode()).equals(Region.Four)){
                        One++;
                        Two++;
                        Three++;
                        Four=0;
                        Five++;
                        Sex++;
                        Seven++;
                        vo.One=One;
                        vo.Two=Two;
                        vo.Three=Three;
                        vo.Four=Four;
                        vo.Five=Five;
                        vo.Sex=Sex;
                        vo.Seven=Seven;
                    }else if(Hk6EnumHelp.getRegion(vo.getOpenCode()).equals(Region.Five)){
                        One++;
                        Two++;
                        Three++;
                        Four++;
                        Five=0;
                        Sex++;
                        Seven++;
                        vo.One=One;
                        vo.Two=Two;
                        vo.Three=Three;
                        vo.Four=Four;
                        vo.Five=Five;
                        vo.Sex=Sex;
                        vo.Seven=Seven;
                    }else if(Hk6EnumHelp.getRegion(vo.getOpenCode()).equals(Region.Six)){
                        One++;
                        Two++;
                        Three++;
                        Four++;
                        Five++;
                        Sex=0;
                        Seven++;
                        vo.One=One;
                        vo.Two=Two;
                        vo.Three=Three;
                        vo.Four=Four;
                        vo.Five=Five;
                        vo.Sex=Sex;
                        vo.Seven=Seven;
                    }else if(Hk6EnumHelp.getRegion(vo.getOpenCode()).equals(Region.Seven)){
                        One++;
                        Two++;
                        Three++;
                        Four++;
                        Five++;
                        Sex++;
                        Seven=0;
                        vo.One=One;
                        vo.Two=Two;
                        vo.Three=Three;
                        vo.Four=Four;
                        vo.Five=Five;
                        vo.Sex=Sex;
                        vo.Seven=Seven;
                    }
                    list.add(vo);
                }
                Collections.reverse(list);
                return list;
            }
        });
    }
}
