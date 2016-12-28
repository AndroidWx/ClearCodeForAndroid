package com.joye.hk6domain.interactor;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.hk6domain.constants.ColorTwos;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.entity.Hk6UiData;
import com.joye.hk6domain.repository.Hk6Repository;
import com.joye.hk6domain.vo.ColorTwosVo;

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

public class GetColorTwosUseCase extends GetHk6Data {
    public GetColorTwosUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, Hk6Repository hk6Repository, String date) {
        super(threadExecutor, postExecutionThread, hk6Repository, date);
    }
    int redEven = 0,redOdd=0,blueEven=0,blueOdd=0,greenEven=0,greenOdd=0;
    public void addNumber(){
        redEven ++;
        redOdd++;
        blueEven++;
        blueOdd++;
        greenEven++;
        greenOdd++;
    }
    @Override
    protected Observable buildUseCaseObservable() {
        return getHistory().map(new Func1<List<Hk6UiData>, List<ColorTwosVo>>() {
            @Override
            public List<ColorTwosVo> call(List<Hk6UiData> hk6UiDatas) {
                List<ColorTwosVo> list = new ArrayList<ColorTwosVo>(hk6UiDatas.size());
                Collections.reverse(hk6UiDatas);
                ColorTwosVo vo;
                for (Hk6UiData itemVo:hk6UiDatas){
                      vo = new ColorTwosVo(itemVo);
                    if(Hk6EnumHelp.getColorTwos(vo.getOpenCode()).equals(ColorTwos.RedEven)){
                        addNumber();
                        redEven=0;
                        vo.redEven=redEven;
                        vo.redOdd=redOdd;
                        vo.blueEven=blueEven;
                        vo.blueOdd=blueOdd;
                        vo.greenEven=greenEven;
                        vo.greenOdd=greenOdd;
                    }else if(Hk6EnumHelp.getColorTwos(vo.getOpenCode()).equals(ColorTwos.RedOdd)){
                        addNumber();
                        redOdd=0;
                        vo.redEven=redEven;
                        vo.redOdd=redOdd;
                        vo.blueEven=blueEven;
                        vo.blueOdd=blueOdd;
                        vo.greenEven=greenEven;
                        vo.greenOdd=greenOdd;
                    }else if(Hk6EnumHelp.getColorTwos(vo.getOpenCode()).equals(ColorTwos.BlueEven)){
                        addNumber();
                        blueEven=0;
                        vo.redEven=redEven;
                        vo.redOdd=redOdd;
                        vo.blueEven=blueEven;
                        vo.blueOdd=blueOdd;
                        vo.greenEven=greenEven;
                        vo.greenOdd=greenOdd;
                    }else if(Hk6EnumHelp.getColorTwos(vo.getOpenCode()).equals(ColorTwos.BlueOdd)){
                        addNumber();
                        blueOdd=0;
                        vo.redEven=redEven;
                        vo.redOdd=redOdd;
                        vo.blueEven=blueEven;
                        vo.blueOdd=blueOdd;
                        vo.greenEven=greenEven;
                        vo.greenOdd=greenOdd;
                    }else if(Hk6EnumHelp.getColorTwos(vo.getOpenCode()).equals(ColorTwos.GreenEven)){
                        addNumber();
                        greenEven=0;
                        vo.redEven=redEven;
                        vo.redOdd=redOdd;
                        vo.blueEven=blueEven;
                        vo.blueOdd=blueOdd;
                        vo.greenEven=greenEven;
                        vo.greenOdd=greenOdd;
                    }else if(Hk6EnumHelp.getColorTwos(vo.getOpenCode()).equals(ColorTwos.GreenOdd)){
                        addNumber();
                        greenOdd=0;
                        vo.redEven=redEven;
                        vo.redOdd=redOdd;
                        vo.blueEven=blueEven;
                        vo.blueOdd=blueOdd;
                        vo.greenEven=greenEven;
                        vo.greenOdd=greenOdd;
                    }
                    list.add(vo);
                }
                Collections.reverse(list);
                return list;
            }
        });
    }
}
