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

public class HeadTwosVo extends Hk6UiData implements ReportRightI {

    public HeadTwosVo(Hk6UiData sup) {
        setOpentime(sup.getOpentime());
        setOpentimestamp(sup.getOpentimestamp());
        setEvictors(sup.getEvictors());
        setExpect(sup.getExpect().substring(2));
        setOpenCode(sup.getOpenCode());
    }

    public int HeadEven0, HeadEven1, HeadEven2, HeadEven3, HeadEven4;
    public int HeadOdd0, HeadOdd1, HeadOdd2, HeadOdd3, HeadOdd4;
    public Vigilant headEven0Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( HeadEven0 >= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.HeadTows.HeadEven0)
                    && HeadEven0 >Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.HeadTows.HeadEven0)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant headEven1Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( HeadEven1 >= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.HeadTows.Default)
                    && HeadEven1 >Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.HeadTows.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant headEven2Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( HeadEven2 >= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.HeadTows.Default)
                    && HeadEven2 >Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.HeadTows.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant headEven3Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( HeadEven3 >= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.HeadTows.Default)
                    && HeadEven3 >Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.HeadTows.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant headEven4Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( HeadEven4 >= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.HeadTows.Default)
                    && HeadEven4 >Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.HeadTows.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant headOdd0Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( HeadOdd0 >= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.HeadTows.Default)
                    && HeadOdd0 >Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.HeadTows.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant headOdd1Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( HeadOdd1 >= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.HeadTows.Default)
                    && HeadOdd1 >Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.HeadTows.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant headOdd2Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( HeadOdd2 >= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.HeadTows.Default)
                    && HeadOdd2 >Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.HeadTows.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant headOdd3Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( HeadOdd3 >= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.HeadTows.Default)
                    && HeadOdd3 >Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.HeadTows.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant headOdd4Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( HeadOdd4 >= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.HeadTows.Default)
                    && HeadOdd4 >Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.HeadTows.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
}
