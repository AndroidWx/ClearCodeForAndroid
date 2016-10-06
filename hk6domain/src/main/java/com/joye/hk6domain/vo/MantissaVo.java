package com.joye.hk6domain.vo;


import com.joye.hk6domain.constants.Formula;
import com.joye.hk6domain.constants.Mantissa;
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

public class MantissaVo extends Hk6UiData implements ReportRightI {

    public MantissaVo(Hk6UiData sup) {
        setOpentime(sup.getOpentime());
        setOpentimestamp(sup.getOpentimestamp());
        setEvictors(sup.getEvictors());
        setExpect(sup.getExpect());
        setOpenCode(sup.getOpenCode());
    }

    public int Mantissa0, Mantissa1, Mantissa2, Mantissa3, Mantissa4,Mantissa5,Mantissa6,Mantissa7,Mantissa8,Mantissa9;

    public Vigilant Mantissa0Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( Mantissa0>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Mantissa.Mantissa0)
                    &&Mantissa0>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Mantissa.Mantissa0)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant MantissaVigilant(Mantissa Mantissa){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            int number=0;
            switch (Mantissa){
                case Mantissa1:
                    number=Mantissa1;
                    break;
                case Mantissa2:
                    number=Mantissa2;
                    break;
                case Mantissa3:
                    number=Mantissa3;
                    break;
                case Mantissa4:
                    number=Mantissa4;
                    break;
                case Mantissa5:
                    number=Mantissa5;
                    break;
                case Mantissa6:
                    number=Mantissa6;
                    break;
                case Mantissa7:
                    number=Mantissa7;
                    break;
                case Mantissa8:
                    number=Mantissa8;
                    break;
                case Mantissa9:
                    number=Mantissa9;
                    break;
            }
            if ( number>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Mantissa.Default)
                    &&number>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Mantissa.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }




}
