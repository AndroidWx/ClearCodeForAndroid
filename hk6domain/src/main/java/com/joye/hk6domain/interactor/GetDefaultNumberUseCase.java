package com.joye.hk6domain.interactor;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.constants.NumberProperty;
import com.joye.hk6domain.entity.Hk6UiData;
import com.joye.hk6domain.repository.Hk6Repository;
import com.joye.hk6domain.vo.DefaultNumberVo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/24.
 * 304622254@qq.com
 * Remeark:
 */

public class GetDefaultNumberUseCase extends GetHk6Data {


    public GetDefaultNumberUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, Hk6Repository hk6Repository, String date) {
        super(threadExecutor, postExecutionThread, hk6Repository, date);
    }

    @Override
    protected Observable buildUseCaseObservable() {
        Observable observable = Observable.zip(
//                super.buildUseCaseObservable("2008-12-31"),
//                super.buildUseCaseObservable("2009-12-31"),
//                super.buildUseCaseObservable("2010-12-31"),
//                super.buildUseCaseObservable("2011-12-31"),
//                super.buildUseCaseObservable("2012-12-31"),
//                super.buildUseCaseObservable("2013-12-31"),
//                super.buildUseCaseObservable("2014-12-31"),
                super.buildUseCaseObservable("2015-12-31"),
                super.buildUseCaseObservable(),
                new Func2<List<Hk6UiData>,List<Hk6UiData>, List<Hk6UiData>>() {
                    @Override
                    public List<Hk6UiData> call(List<Hk6UiData> hk6UiDatas, List<Hk6UiData> hk6UiDatas2) {
                        hk6UiDatas2.addAll(hk6UiDatas);
                        return hk6UiDatas2;
                    }
                });
        return observable.map(new Func1<List<Hk6UiData>, List<DefaultNumberVo>>() {
            int N1 = 0, N2 = 0, N3 = 0, N4 = 0, N5 = 0, N6 = 0, N7 = 0,
                    N8 = 0, N9 = 0, N10 = 0, N11 = 0, N12 = 0, N13 = 0, N14 = 0,
                    N15 = 0, N16 = 0, N17 = 0, N18 = 0, N19 = 0, N20 = 0, N21 = 0,
                    N22 = 0, N23 = 0, N24 = 0, N25 = 0, N26 = 0, N27 = 0, N28 = 0,
                    N29 = 0, N30 = 0, N31 = 0, N32 = 0, N33 = 0, N34 = 0, N35 = 0,
                    N36 = 0, N37 = 0, N38 = 0, N39 = 0, N40 = 0, N41 = 0, N42 = 0,
                    N43 = 0, N44 = 0, N45 = 0, N46 = 0, N47 = 0, N48 = 0, N49 = 0;

            private void dateAdd() {
                N1++;
                N2++;
                N3++;
                N4++;
                N5++;
                N6++;
                N7++;
                N8++;
                N9++;
                N10++;
                N11++;
                N12++;
                N13++;
                N14++;
                N15++;
                N16++;
                N17++;
                N18++;
                N19++;
                N20++;
                N21++;
                N22++;
                N23++;
                N24++;
                N25++;
                N26++;
                N27++;
                N28++;
                N29++;
                N30++;
                N31++;
                N32++;
                N33++;
                N34++;
                N35++;
                N36++;
                N37++;
                N38++;
                N39++;
                N40++;
                N41++;
                N42++;
                N43++;
                N44++;
                N45++;
                N46++;
                N47++;
                N48++;
                N49++;

            }

            public void initValue(int n1, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, int n18, int n19, int n20, int n21, int n22, int n23, int n24, int n25, int n26, int n27, int n28, int n29, int n30, int n31, int n32, int n33, int n34, int n35, int n36, int n37, int n38, int n39, int n40, int n41, int n42, int n43, int n44, int n45, int n46, int n47, int n48, int n49, DefaultNumberVo vo) {
                vo.N1 = n1;
                vo.N2 = n2;
                vo.N3 = n3;
                vo.N4 = n4;
                vo.N5 = n5;
                vo.N6 = n6;
                vo.N7 = n7;
                vo.N8 = n8;
                vo.N9 = n9;
                vo.N10 = n10;
                vo.N11 = n11;
                vo.N12 = n12;
                vo.N13 = n13;
                vo.N14 = n14;
                vo.N15 = n15;
                vo.N16 = n16;
                vo.N17 = n17;
                vo.N18 = n18;
                vo.N19 = n19;
                vo.N20 = n20;
                vo.N21 = n21;
                vo.N22 = n22;
                vo.N23 = n23;
                vo.N24 = n24;
                vo.N25 = n25;
                vo.N26 = n26;
                vo.N27 = n27;
                vo.N28 = n28;
                vo.N29 = n29;
                vo.N30 = n30;
                vo.N31 = n31;
                vo.N32 = n32;
                vo.N33 = n33;
                vo.N34 = n34;
                vo.N35 = n35;
                vo.N36 = n36;
                vo.N37 = n37;
                vo.N38 = n38;
                vo.N39 = n39;
                vo.N40 = n40;
                vo.N41 = n41;
                vo.N42 = n42;
                vo.N43 = n43;
                vo.N44 = n44;
                vo.N45 = n45;
                vo.N46 = n46;
                vo.N47 = n47;
                vo.N48 = n48;
                vo.N49 = n49;
            }

            public void initValue(DefaultNumberVo vo) {
                initValue(N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19, N20, N21, N22, N23, N24, N25, N26, N27, N28, N29, N30, N31, N32, N33, N34, N35, N36, N37, N38, N39, N40, N41, N42, N43, N44, N45, N46, N47, N48, N49, vo);
            }

            @Override
            public List<DefaultNumberVo> call(List<Hk6UiData> hk6UiDatas) {
                List<DefaultNumberVo> list = new ArrayList<DefaultNumberVo>(hk6UiDatas.size());
                Collections.reverse(hk6UiDatas);
                DefaultNumberVo vo;
                for (Hk6UiData itemVo : hk6UiDatas) {
                    vo= new DefaultNumberVo(itemVo);
                    dateAdd();
                    if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N1)){
                        N1=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N2)){
                        N2=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N3)){
                        N3=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N4)){
                        N4=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N5)){
                        N5=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N6)){
                        N6=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N7)){
                        N7=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N8)){
                        N8=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N9)){
                        N9=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N10)){
                        N10=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N11)){
                        N11=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N12)){
                        N12=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N13)){
                        N13=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N14)){
                        N14=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N15)){
                        N15=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N16)){
                        N16=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N17)){
                        N17=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N18)){
                        N18=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N19)){
                        N19=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N20)){
                        N20=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N21)){
                        N21=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N22)){
                        N22=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N23)){
                        N23=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N24)){
                        N24=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N25)){
                        N25=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N26)){
                        N26=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N27)){
                        N27=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N28)){
                        N28=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N29)){
                        N29=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N30)){
                        N30=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N31)){
                        N31=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N32)){
                        N32=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N33)){
                        N33=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N34)){
                        N34=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N35)){
                        N35=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N36)){
                        N36=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N37)){
                        N37=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N38)){
                        N38=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N39)){
                        N39=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N40)){
                        N40=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N41)){
                        N41=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N42)){
                        N42=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N43)){
                        N43=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N44)){
                        N44=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N45)){
                        N45=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N46)){
                        N46=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N47)){
                        N47=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N48)){
                        N48=0;
                    }
                    else if(Hk6EnumHelp.getNumberProperty(vo.getOpenCode()).equals(NumberProperty.N49)){
                        N49=0;
                    }
                    initValue(vo);

                    list.add(vo);
                }
                Collections.reverse(list);
                return list;
            }
        });
    }


}
