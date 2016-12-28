package com.joye.hk6domain.interactor;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.constants.Hk6Size;
import com.joye.hk6domain.constants.OddEven;
import com.joye.hk6domain.entity.Hk6UiData;
import com.joye.hk6domain.repository.Hk6Repository;
import com.joye.hk6domain.vo.OddEvenVo;
import com.joye.hk6domain.vo.SizeVo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark:
 */

public class GetOddEvenUseCase extends GetHk6Data {
    public GetOddEvenUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, Hk6Repository hk6Repository, String date) {
        super(threadExecutor, postExecutionThread, hk6Repository, date);
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return  getHistory().map(new Func1<List<Hk6UiData>, List<OddEvenVo>>() {
            @Override
            public List<OddEvenVo> call(List<Hk6UiData> hk6UiDatas) {
                List<OddEvenVo> list = new ArrayList<OddEvenVo>(hk6UiDatas.size());
                Map<String,Integer> map=null;
                Collections.reverse(hk6UiDatas);
                int Odd = 0,Even=0;
                OddEvenVo vo;
                for (Hk6UiData itemVo:hk6UiDatas){
                      vo = new OddEvenVo(itemVo);
                    if(Hk6EnumHelp.getOddEven(vo.getOpenCode()).equals(OddEven.Even)){
                        Even++;
                        Odd=0;
                        vo.Odd=Odd;
                        vo.Even=Even;
                    }else{
                        Odd++;
                        Even=0;
                        vo.Odd=Odd;
                        vo.Even=Even;
                    }
                    list.add(vo);
                }
                Collections.reverse(list);
                return list;
            }
        });
    }
}
