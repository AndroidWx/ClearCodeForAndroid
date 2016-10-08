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
 * Remeark: 生肖走势图的vo
 */

public class Modular7Vo extends Hk6UiData implements ReportRightI {

    public Modular7Vo(Hk6UiData sup) {
        setOpentime(sup.getOpentime());
        setOpentimestamp(sup.getOpentimestamp());
        setEvictors(sup.getEvictors());
        setExpect(sup.getExpect());
        setOpenCode(sup.getOpenCode());
    }

    public int M0, M1, M2,M3,M4,M5,M6;

    public Vigilant M0Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( M0 >= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Modular7.M0)
                    && M0 >Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Modular7.M0)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant M1Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( M1 >= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Modular7.M1)
                    && M1 >Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Modular7.M1)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant M2Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( M2 >= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Modular7.M2)
                    && M2 >Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Modular7.M2)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant M3Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( M3 >= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Modular7.M3)
                    && M3 >Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Modular7.M3)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant M4Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( M4 >= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Modular7.M4)
                    && M4 >Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Modular7.M4)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant M5Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( M5 >= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Modular7.M5)
                    && M5 >Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Modular7.M5)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant M6Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( M6 >= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Modular7.M6)
                    && M6 >Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Modular7.M6)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
}
