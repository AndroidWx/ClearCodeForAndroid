package com.joye.hk6domain.vo;


import com.joye.hk6domain.constants.Formula;
import com.joye.hk6domain.constants.IDcValue;
import com.joye.hk6domain.constants.Probalility;
import com.joye.hk6domain.constants.Vigilant;
import com.joye.hk6domain.entity.Hk6UiData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/23.
 * 304622254@qq.com
 * Remeark: 头数的vo
 */

public class GateCountVo extends Hk6UiData implements ReportRightI {

    public GateCountVo(Hk6UiData sup) {
        setOpentime(sup.getOpentime());
        setOpentimestamp(sup.getOpentimestamp());
        setEvictors(sup.getEvictors());
        setExpect(sup.getExpect());
        setOpenCode(sup.getOpenCode());
    }

    public int gateCount5, gateCount1, gateCount2, gateCount3, gateCount4;



    public Vigilant gateCount1Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( gateCount1>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.GateCount.GateCount_1)
                    &&gateCount1>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.GateCount.GateCount_1)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }


    public Vigilant gateCount2Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( gateCount2>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.GateCount.GateCount_2)
                    &&gateCount2>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.GateCount.GateCount_2)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }


    public Vigilant gateCount3Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( gateCount3>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.GateCount.GateCount_3)
                    &&gateCount3>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.GateCount.GateCount_3)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant gateCount4Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( gateCount4>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.GateCount.GateCount_4)
                    &&gateCount4>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.GateCount.GateCount_4)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant gateCount5Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( gateCount5>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.GateCount.GateCount_5)
                    &&gateCount5>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.GateCount.GateCount_5)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }



//    public ColorTwos regionVigilant(int num) {
//        Vigilant[] values = Vigilant.values();
//        List<Vigilant> datas = new ArrayList<>();
//        for (Vigilant vigilant : values) {
//            if ( num>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Region.Default)
//                    &&num>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Region.Default)) {
//                datas.add(vigilant);
//            }
//        }
//        if (datas.size() > 1) {
//            return datas.get(datas.size() - 1);
//        }
//        return Vigilant.Default;
//    }

}
