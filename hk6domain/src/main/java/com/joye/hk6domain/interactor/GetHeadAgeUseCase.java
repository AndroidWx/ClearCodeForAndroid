package com.joye.hk6domain.interactor;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.hk6domain.constants.HeadAge;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.entity.Hk6UiData;
import com.joye.hk6domain.repository.Hk6Repository;
import com.joye.hk6domain.vo.HeadAgeVo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func9;

/**
 * Created by Wx on 2016/9/25.
 * QQ:304622254;
 * remark: ͷ��
 */

public class GetHeadAgeUseCase extends GetHk6Data {
    public GetHeadAgeUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, Hk6Repository hk6Repository, String date) {
        super(threadExecutor, postExecutionThread, hk6Repository, date);
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return  getHistory().map(new Func1<List<Hk6UiData>, List<HeadAgeVo>>() {

            @Override
            public List<HeadAgeVo> call(List<Hk6UiData> hk6UiDatas) {
                List<HeadAgeVo> list = new ArrayList<HeadAgeVo>(hk6UiDatas.size());
                Collections.reverse(hk6UiDatas);
                int h0 = 0,h1=0,h2=0,h3=0,h4=0;
                HeadAgeVo vo;
                for (Hk6UiData itemVo:hk6UiDatas){
                      vo = new HeadAgeVo(itemVo);
                    if(Hk6EnumHelp.getHeadAge(vo.getOpenCode()).equals(HeadAge.Headage0)){
                        h0=0;
                        h1++;
                        h2++;
                        h3++;
                        h4++;
                        vo.headage0=h0;
                        vo.headage1=h1;
                        vo.headage2=h2;
                        vo.headage3=h3;
                        vo.headage4=h4;

                    }else if(Hk6EnumHelp.getHeadAge(vo.getOpenCode()).equals(HeadAge.Headage1)){
                        h0++;
                        h1=0;
                        h2++;
                        h3++;
                        h4++;
                        vo.headage0=h0;
                        vo.headage1=h1;
                        vo.headage2=h2;
                        vo.headage3=h3;
                        vo.headage4=h4;

                    }
                    else if(Hk6EnumHelp.getHeadAge(vo.getOpenCode()).equals(HeadAge.Headage2)){
                        h0++;
                        h1++;
                        h2=0;
                        h3++;
                        h4++;
                        vo.headage0=h0;
                        vo.headage1=h1;
                        vo.headage2=h2;
                        vo.headage3=h3;
                        vo.headage4=h4;

                    }else  if(Hk6EnumHelp.getHeadAge(vo.getOpenCode()).equals(HeadAge.Headage3)){
                        h0++;
                        h1++;
                        h2++;
                        h3=0;
                        h4++;
                        vo.headage0=h0;
                        vo.headage1=h1;
                        vo.headage2=h2;
                        vo.headage3=h3;
                        vo.headage4=h4;

                    }else if(Hk6EnumHelp.getHeadAge(vo.getOpenCode()).equals(HeadAge.Headage4)){
                        h0++;
                        h1++;
                        h2++;
                        h3++;
                        h4=0;
                        vo.headage0=h0;
                        vo.headage1=h1;
                        vo.headage2=h2;
                        vo.headage3=h3;
                        vo.headage4=h4;

                    }
                    list.add(vo);
                }
                Collections.reverse(list);
                return list;
            }
        });
    }
}
