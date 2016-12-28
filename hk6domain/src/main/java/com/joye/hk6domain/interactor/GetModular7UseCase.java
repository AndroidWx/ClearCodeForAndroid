package com.joye.hk6domain.interactor;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.constants.Modular7;
import com.joye.hk6domain.entity.Hk6UiData;
import com.joye.hk6domain.repository.Hk6Repository;
import com.joye.hk6domain.vo.Modular7Vo;

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

public class GetModular7UseCase extends GetHk6Data {
    public GetModular7UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, Hk6Repository hk6Repository, String date) {
        super(threadExecutor, postExecutionThread, hk6Repository, date);
    }

    @Override
    protected Observable buildUseCaseObservable() {
       return getHistory().map(new Func1<List<Hk6UiData>, List<Modular7Vo>>() {

            @Override
            public List<Modular7Vo> call(List<Hk6UiData> hk6UiDatas) {
                List<Modular7Vo> list = new ArrayList<Modular7Vo>(hk6UiDatas.size());
                Collections.reverse(hk6UiDatas);
                int M0 = 0, M1 = 0, M2 = 0, M3 = 0, M4 = 0, M5 = 0, M6 = 0;
                Modular7Vo vo;
                for (Hk6UiData itemVo : hk6UiDatas) {
                      vo = new Modular7Vo(itemVo);
                    if (Hk6EnumHelp.getModular7(vo.getOpenCode()).equals(Modular7.M0)) {
                        M0 = 0;
                        M1++;
                        M2++;
                        M3++;
                        M4++;
                        M5++;
                        M6++;
                        vo.M0 = M0;
                        vo.M1 = M1;
                        vo.M2 = M2;
                        vo.M3 = M3;
                        vo.M4 = M4;
                        vo.M5 = M5;
                        vo.M6 = M6;
                    } else if (Hk6EnumHelp.getModular7(vo.getOpenCode()).equals(Modular7.M1)) {
                        M0++;
                        M1 = 0;
                        M2++;
                        M3++;
                        M4++;
                        M5++;
                        M6++;
                        vo.M0 = M0;
                        vo.M1 = M1;
                        vo.M2 = M2;
                        vo.M3 = M3;
                        vo.M4 = M4;
                        vo.M5 = M5;
                        vo.M6 = M6;
                    } else if (Hk6EnumHelp.getModular7(vo.getOpenCode()).equals(Modular7.M2)) {
                        M0++;
                        M1++;
                        M2 = 0;
                        M3++;
                        M4++;
                        M5++;
                        M6++;
                        vo.M0 = M0;
                        vo.M1 = M1;
                        vo.M2 = M2;
                        vo.M3 = M3;
                        vo.M4 = M4;
                        vo.M5 = M5;
                        vo.M6 = M6;
                    } else if (Hk6EnumHelp.getModular7(vo.getOpenCode()).equals(Modular7.M3)) {
                        M0++;
                        M1++;
                        M2++;
                        M3 = 0;
                        M4++;
                        M5++;
                        M6++;
                        vo.M0 = M0;
                        vo.M1 = M1;
                        vo.M2 = M2;
                        vo.M3 = M3;
                        vo.M4 = M4;
                        vo.M5 = M5;
                        vo.M6 = M6;
                    } else if (Hk6EnumHelp.getModular7(vo.getOpenCode()).equals(Modular7.M4)) {
                        M0++;
                        M1++;
                        M2++;
                        M3++;
                        M4 = 0;
                        M5++;
                        M6++;
                        vo.M0 = M0;
                        vo.M1 = M1;
                        vo.M2 = M2;
                        vo.M3 = M3;
                        vo.M4 = M4;
                        vo.M5 = M5;
                        vo.M6 = M6;
                    } else if (Hk6EnumHelp.getModular7(vo.getOpenCode()).equals(Modular7.M5)) {
                        M0++;
                        M1++;
                        M2++;
                        M3++;
                        M4++;
                        M5 = 0;
                        M6++;
                        vo.M0 = M0;
                        vo.M1 = M1;
                        vo.M2 = M2;
                        vo.M3 = M3;
                        vo.M4 = M4;
                        vo.M5 = M5;
                        vo.M6 = M6;
                    }else if (Hk6EnumHelp.getModular7(vo.getOpenCode()).equals(Modular7.M6)) {
                        M0++;
                        M1++;
                        M2++;
                        M3++;
                        M4++;
                        M5++;
                        M6=0;
                        vo.M0 = M0;
                        vo.M1 = M1;
                        vo.M2 = M2;
                        vo.M3 = M3;
                        vo.M4 = M4;
                        vo.M5 = M5;
                        vo.M6 = M6;
                    }
                    list.add(vo);
                }
                Collections.reverse(list);
                return list;
            }
        });
    }
}
