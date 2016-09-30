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

public class CompositeVo extends Hk6UiData implements ReportRightI {

    public CompositeVo(Hk6UiData sup) {
        setOpentime(sup.getOpentime());
        setOpentimestamp(sup.getOpentimestamp());
        setEvictors(sup.getEvictors());
        setExpect(sup.getExpect().substring(2));
        setOpenCode(sup.getOpenCode());
    }

    public int composite1, composite2, composite3, composite4, composite5;
    public int composite6, composite7, composite8, composite9, composite10;
    public int composite11, composite12, composite13;
    public Vigilant composite1Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( composite1>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Composite.C_1)
                    &&composite1>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Composite.C_1)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant composite2Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( composite2>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Composite.C_2)
                    &&composite2>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Composite.C_2)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant composite3Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( composite3>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Composite.C_3)
                    &&composite3>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Composite.C_3)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant composite4Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( composite4>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Composite.C_4)
                    &&composite4>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Composite.C_4)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant composite5Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( composite5>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Composite.C_5)
                    &&composite5>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Composite.C_5)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant composite6Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( composite6>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Composite.C_6)
                    &&composite6>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Composite.C_6)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant composite7Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( composite7>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Composite.C_7)
                    &&composite7>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Composite.C_7)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant composite8Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( composite8>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Composite.C_8)
                    &&composite8>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Composite.C_8)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant composite9Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( composite9>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Composite.C_9)
                    &&composite9>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Composite.C_9)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant composite10Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( composite10>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Composite.C_10)
                    &&composite10>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Composite.C_10)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant composite11Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( composite11>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Composite.C_11)
                    &&composite11>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Composite.C_11)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant composite12Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( composite12>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Composite.C_12)
                    &&composite12>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Composite.C_12)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant composite13Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( composite13>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Composite.C_13)
                    &&composite13>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Composite.C_13)) {
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
