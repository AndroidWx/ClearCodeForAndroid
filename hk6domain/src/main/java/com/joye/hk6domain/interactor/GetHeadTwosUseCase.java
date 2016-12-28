package com.joye.hk6domain.interactor;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.hk6domain.constants.HeadTwos;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.entity.Hk6UiData;
import com.joye.hk6domain.repository.Hk6Repository;
import com.joye.hk6domain.vo.HeadTwosVo;

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

public class GetHeadTwosUseCase extends GetHk6Data {
    public GetHeadTwosUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, Hk6Repository hk6Repository, String date) {
        super(threadExecutor, postExecutionThread, hk6Repository, date);
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return getHistory().map(new Func1<List<Hk6UiData>, List<HeadTwosVo>>() {
            int HeadEven0 = 0, HeadEven1 = 0, HeadEven2 = 0,
                    HeadEven3 = 0, HeadEven4 = 0, HeadOdd0 = 0, HeadOdd1 = 0, HeadOdd2 = 0, HeadOdd3 = 0, HeadOdd4 = 0;

            @Override
            public List<HeadTwosVo> call(List<Hk6UiData> hk6UiDatas) {
                List<HeadTwosVo> list = new ArrayList<HeadTwosVo>(hk6UiDatas.size());
                Collections.reverse(hk6UiDatas);
                for (Hk6UiData itemVo : hk6UiDatas) {
                    HeadTwosVo vo = new HeadTwosVo(itemVo);
                    if (Hk6EnumHelp.getHeadTwos(vo.getOpenCode()).equals(HeadTwos.HeadEven0)) {
                        addData();
                        HeadEven0 = 0;
                        initvalue(HeadEven0, HeadEven1, HeadEven2, HeadEven3, HeadEven4, HeadOdd0, HeadOdd1, HeadOdd2, HeadOdd3, HeadOdd4, vo);
                    } else if (Hk6EnumHelp.getHeadTwos(vo.getOpenCode()).equals(HeadTwos.HeadEven1)) {
                        addData();
                        HeadEven1 = 0;
                        initvalue(HeadEven0, HeadEven1, HeadEven2, HeadEven3, HeadEven4, HeadOdd0, HeadOdd1, HeadOdd2, HeadOdd3, HeadOdd4, vo);
                    } else if (Hk6EnumHelp.getHeadTwos(vo.getOpenCode()).equals(HeadTwos.HeadEven2)) {
                        addData();
                        HeadEven2 = 0;
                        initvalue(HeadEven0, HeadEven1, HeadEven2, HeadEven3, HeadEven4, HeadOdd0, HeadOdd1, HeadOdd2, HeadOdd3, HeadOdd4, vo);
                    } else if (Hk6EnumHelp.getHeadTwos(vo.getOpenCode()).equals(HeadTwos.HeadEven3)) {
                        addData();
                        HeadEven3 = 0;
                        initvalue(HeadEven0, HeadEven1, HeadEven2, HeadEven3, HeadEven4, HeadOdd0, HeadOdd1, HeadOdd2, HeadOdd3, HeadOdd4, vo);
                    } else if (Hk6EnumHelp.getHeadTwos(vo.getOpenCode()).equals(HeadTwos.HeadEven4)) {
                        addData();
                        HeadEven4 = 0;
                        initvalue(HeadEven0, HeadEven1, HeadEven2, HeadEven3, HeadEven4, HeadOdd0, HeadOdd1, HeadOdd2, HeadOdd3, HeadOdd4, vo);
                    } else if (Hk6EnumHelp.getHeadTwos(vo.getOpenCode()).equals(HeadTwos.HeadOdd0)) {
                        addData();
                        HeadOdd0 = 0;
                        initvalue(HeadEven0, HeadEven1, HeadEven2, HeadEven3, HeadEven4, HeadOdd0, HeadOdd1, HeadOdd2, HeadOdd3, HeadOdd4, vo);
                    } else if (Hk6EnumHelp.getHeadTwos(vo.getOpenCode()).equals(HeadTwos.HeadOdd1)) {
                        addData();
                        HeadOdd1 = 0;
                        initvalue(HeadEven0, HeadEven1, HeadEven2, HeadEven3, HeadEven4, HeadOdd0, HeadOdd1, HeadOdd2, HeadOdd3, HeadOdd4, vo);
                    } else if (Hk6EnumHelp.getHeadTwos(vo.getOpenCode()).equals(HeadTwos.HeadOdd2)) {
                        addData();
                        HeadOdd2 = 0;
                        initvalue(HeadEven0, HeadEven1, HeadEven2, HeadEven3, HeadEven4, HeadOdd0, HeadOdd1, HeadOdd2, HeadOdd3, HeadOdd4, vo);
                    } else if (Hk6EnumHelp.getHeadTwos(vo.getOpenCode()).equals(HeadTwos.HeadOdd3)) {
                        addData();
                        HeadOdd3 = 0;
                        initvalue(HeadEven0, HeadEven1, HeadEven2, HeadEven3, HeadEven4, HeadOdd0, HeadOdd1, HeadOdd2, HeadOdd3, HeadOdd4, vo);
                    } else if (Hk6EnumHelp.getHeadTwos(vo.getOpenCode()).equals(HeadTwos.HeadOdd4)) {
                        addData();
                        HeadOdd4 = 0;
                        initvalue(HeadEven0, HeadEven1, HeadEven2, HeadEven3, HeadEven4, HeadOdd0, HeadOdd1, HeadOdd2, HeadOdd3, HeadOdd4, vo);
                    }
                    list.add(vo);
                }
                Collections.reverse(list);
                return list;
            }

            private void addData() {
                HeadEven0++;
                HeadEven1++;
                HeadEven2++;
                HeadEven3++;
                HeadEven4++;
                HeadOdd0++;
                HeadOdd1++;
                HeadOdd2++;
                HeadOdd3++;
                HeadOdd4++;
            }

            private void initvalue(int headEven0, int headEven1, int headEven2, int headEven3, int headEven4, int headOdd0, int headOdd1, int headOdd2, int headOdd3, int headOdd4, HeadTwosVo vo) {
                vo.HeadEven0 = headEven0;
                vo.HeadEven1 = headEven1;
                vo.HeadEven2 = headEven2;
                vo.HeadEven3 = headEven3;
                vo.HeadEven4 = headEven4;
                vo.HeadOdd0 = headOdd0;
                vo.HeadOdd1 = headOdd1;
                vo.HeadOdd2 = headOdd2;
                vo.HeadOdd3 = headOdd3;
                vo.HeadOdd4 = headOdd4;
            }
        });
    }
}
