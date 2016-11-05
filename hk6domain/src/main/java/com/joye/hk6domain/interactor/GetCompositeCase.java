package com.joye.hk6domain.interactor;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.hk6domain.constants.Composite;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.entity.Hk6UiData;
import com.joye.hk6domain.repository.Hk6Repository;
import com.joye.hk6domain.vo.CompositeVo;

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

public class GetCompositeCase extends GetHk6Data {
    public GetCompositeCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, Hk6Repository hk6Repository, String date) {
        super(threadExecutor, postExecutionThread, hk6Repository, date);
    }
        int composite1 = 0,
            composite2=0,
            composite3=0,
            composite4=0,
            composite5=0,
            composite6=0,
            composite7=0,
            composite8=0,
            composite9=0,
            composite10=0,
            composite11=0,
            composite12=0,
            composite13=0;
    private void addNumber(){
        composite1++;
        composite2++;
        composite3++;
        composite4++;
        composite5++;
        composite6++;
        composite7++;
        composite8++;
        composite9++;
        composite10++;
        composite11++;
        composite12++;
        composite13++;
    }
    @Override
    protected Observable buildUseCaseObservable() {
        Observable observable=Observable.zip(
                super.buildUseCaseObservable("2008-12-31"),
                super.buildUseCaseObservable("2009-12-31"),
                super.buildUseCaseObservable("2010-12-31"),
                super.buildUseCaseObservable("2011-12-31"),
                super.buildUseCaseObservable("2012-12-31"),
                super.buildUseCaseObservable("2013-12-31"),
                super.buildUseCaseObservable("2014-12-31"),
                super.buildUseCaseObservable("2015-12-31"),
                super.buildUseCaseObservable(),
                new Func9<List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>,
                        List<Hk6UiData>>() {
                    @Override
                    public List<Hk6UiData> call(List<Hk6UiData> o, List<Hk6UiData> o2, List<Hk6UiData> o3,List<Hk6UiData> o4,List<Hk6UiData> o5, List<Hk6UiData> o6,List<Hk6UiData> o7,List<Hk6UiData> o8,List<Hk6UiData>o9) {
                        List<Hk6UiData> datas=new ArrayList<Hk6UiData>();
                        datas.addAll(o9);
                        datas.addAll(o8);
                        datas.addAll(o7);
                        datas.addAll(o6);
                        datas.addAll(o5);
                        datas.addAll(o4);
                        datas.addAll(o3);
                        datas.addAll(o2);
                        datas.addAll(o);
                        return datas;
                    }
                });
        Observable<List<CompositeVo>> mapValue = observable.map(new Func1<List<Hk6UiData>, List<CompositeVo>>() {

            @Override
            public List<CompositeVo> call(List<Hk6UiData> hk6UiDatas) {
                List<CompositeVo> list = new ArrayList<CompositeVo>(hk6UiDatas.size());
                Collections.reverse(hk6UiDatas);
                CompositeVo vo;
                for (Hk6UiData itemVo : hk6UiDatas) {
                    vo = new CompositeVo(itemVo);
                    if (Hk6EnumHelp.getComposite(vo.getOpenCode()).equals(Composite.C1)) {
                        addNumber();
                        composite1 = 0;
                        initValue(composite1, composite2, composite3, composite4, composite5, composite6, composite7, composite8, composite9, composite10, composite11, composite12, composite13, vo);
                    } else if (Hk6EnumHelp.getComposite(vo.getOpenCode()).equals(Composite.C2)) {
                        addNumber();
                        composite2 = 0;
                        initValue(composite1, composite2, composite3, composite4, composite5, composite6, composite7, composite8, composite9, composite10, composite11, composite12, composite13, vo);
                    } else if (Hk6EnumHelp.getComposite(vo.getOpenCode()).equals(Composite.C3)) {
                        addNumber();
                        composite3 = 0;
                        initValue(composite1, composite2, composite3, composite4, composite5, composite6, composite7, composite8, composite9, composite10, composite11, composite12, composite13, vo);
                    } else if (Hk6EnumHelp.getComposite(vo.getOpenCode()).equals(Composite.C4)) {
                        addNumber();
                        composite4 = 0;
                        initValue(composite1, composite2, composite3, composite4, composite5, composite6, composite7, composite8, composite9, composite10, composite11, composite12, composite13, vo);
                    } else if (Hk6EnumHelp.getComposite(vo.getOpenCode()).equals(Composite.C5)) {
                        addNumber();
                        composite5 = 0;
                        initValue(composite1, composite2, composite3, composite4, composite5, composite6, composite7, composite8, composite9, composite10, composite11, composite12, composite13, vo);
                    } else if (Hk6EnumHelp.getComposite(vo.getOpenCode()).equals(Composite.C6)) {
                        addNumber();
                        composite6 = 0;
                        initValue(composite1, composite2, composite3, composite4, composite5, composite6, composite7, composite8, composite9, composite10, composite11, composite12, composite13, vo);
                    } else if (Hk6EnumHelp.getComposite(vo.getOpenCode()).equals(Composite.C7)) {
                        addNumber();
                        composite7 = 0;
                        initValue(composite1, composite2, composite3, composite4, composite5, composite6, composite7, composite8, composite9, composite10, composite11, composite12, composite13, vo);
                    } else if (Hk6EnumHelp.getComposite(vo.getOpenCode()).equals(Composite.C8)) {
                        addNumber();
                        composite8 = 0;
                        initValue(composite1, composite2, composite3, composite4, composite5, composite6, composite7, composite8, composite9, composite10, composite11, composite12, composite13, vo);
                    } else if (Hk6EnumHelp.getComposite(vo.getOpenCode()).equals(Composite.C9)) {
                        addNumber();
                        composite9 = 0;
                        initValue(composite1, composite2, composite3, composite4, composite5, composite6, composite7, composite8, composite9, composite10, composite11, composite12, composite13, vo);
                    } else if (Hk6EnumHelp.getComposite(vo.getOpenCode()).equals(Composite.C10)) {
                        addNumber();
                        composite10 = 0;
                        initValue(composite1, composite2, composite3, composite4, composite5, composite6, composite7, composite8, composite9, composite10, composite11, composite12, composite13, vo);
                    } else if (Hk6EnumHelp.getComposite(vo.getOpenCode()).equals(Composite.C11)) {
                        addNumber();
                        composite11 = 0;
                        initValue(composite1, composite2, composite3, composite4, composite5, composite6, composite7, composite8, composite9, composite10, composite11, composite12, composite13, vo);
                    } else if (Hk6EnumHelp.getComposite(vo.getOpenCode()).equals(Composite.C12)) {
                        addNumber();
                        composite12 = 0;
                        initValue(composite1, composite2, composite3, composite4, composite5, composite6, composite7, composite8, composite9, composite10, composite11, composite12, composite13, vo);
                    } else if (Hk6EnumHelp.getComposite(vo.getOpenCode()).equals(Composite.C13)) {
                        addNumber();
                        composite13 = 0;
                        initValue(composite1, composite2, composite3, composite4, composite5, composite6, composite7, composite8, composite9, composite10, composite11, composite12, composite13, vo);
                    }
                    list.add(vo);
                }
                Collections.reverse(list);
                return list;
            }
        });
        return mapValue;
    }

    private void initValue(int composite1, int composite2, int composite3, int composite4, int composite5, int composite6, int composite7, int composite8, int composite9, int composite10, int composite11, int composite12, int composite13, CompositeVo vo) {
        vo.composite1=composite1;
        vo.composite2=composite2;
        vo.composite3=composite3;
        vo.composite4=composite4;
        vo.composite5=composite5;
        vo.composite6=composite6;
        vo.composite7=composite7;
        vo.composite8=composite8;
        vo.composite9=composite9;
        vo.composite10=composite10;
        vo.composite11=composite11;
        vo.composite12=composite12;
        vo.composite13=composite13;
    }
}
