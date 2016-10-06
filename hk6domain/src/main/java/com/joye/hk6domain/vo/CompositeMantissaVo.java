package com.joye.hk6domain.vo;

import com.joye.hk6domain.constants.Formula;
import com.joye.hk6domain.constants.IDcValue;
import com.joye.hk6domain.constants.Probalility;
import com.joye.hk6domain.constants.Vigilant;
import com.joye.hk6domain.entity.Hk6UiData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiang on 16/10/1.
 */

public class CompositeMantissaVo extends Hk6UiData implements ReportRightI {

    public CompositeMantissaVo(Hk6UiData sup) {
        setOpentime(sup.getOpentime());
        setOpentimestamp(sup.getOpentimestamp());
        setEvictors(sup.getEvictors());
        setExpect(sup.getExpect().substring(2));
        setOpenCode(sup.getOpenCode());
    }

    public int composite0,composite1, composite2, composite3, composite4, composite5;
    public int composite6, composite7, composite8, composite9;
    public Vigilant composite0Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( composite1>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.CompositeMantissa.Mantissa0)
                    &&composite1>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.CompositeMantissa.Mantissa0)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant composite1Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( composite1>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.CompositeMantissa.Default)
                    &&composite1>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.CompositeMantissa.Default)) {
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
            if ( composite2>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.CompositeMantissa.Default)
                    &&composite2>Formula.lotteryDobule(IDcValue.DefaultValue,Probalility.CompositeMantissa.Default)) {
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
            if ( composite3>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.CompositeMantissa.Default)
                    &&composite3>Formula.lotteryDobule(IDcValue.DefaultValue,Probalility.CompositeMantissa.Default)) {
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
            if ( composite4>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.CompositeMantissa.Default)
                    &&composite4>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.CompositeMantissa.Default)) {
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
            if ( composite5>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.CompositeMantissa.Default)
                    &&composite5>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.CompositeMantissa.Default)) {
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
            if ( composite6>= Formula.lotteryDobule(vigilant.getDcValue(),Probalility.CompositeMantissa.Default)
                    &&composite6>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.CompositeMantissa.Default)) {
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
            if ( composite7>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.CompositeMantissa.Default)
                    &&composite7>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.CompositeMantissa.Default)) {
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
            if ( composite8>= Formula.lotteryDobule(vigilant.getDcValue(),Probalility.CompositeMantissa.Default)
                    &&composite8>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.CompositeMantissa.Default)) {
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
            if ( composite9>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.CompositeMantissa.Default)
                    &&composite9>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.CompositeMantissa.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

}
