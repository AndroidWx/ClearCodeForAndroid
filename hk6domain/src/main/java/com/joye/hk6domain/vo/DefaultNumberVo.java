package com.joye.hk6domain.vo;


import com.joye.hk6domain.constants.Formula;
import com.joye.hk6domain.constants.IDcValue;
import com.joye.hk6domain.constants.NumberProperty;
import com.joye.hk6domain.constants.Probalility;
import com.joye.hk6domain.constants.Vigilant;
import com.joye.hk6domain.entity.Hk6UiData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/23.
 * 304622254@qq.com
 * Remeark: 默认走势图的vo
 */

public class DefaultNumberVo extends Hk6UiData implements ReportRightI {
    public DefaultNumberVo(Hk6UiData sup) {
        setOpentime(sup.getOpentime());
        setOpentimestamp(sup.getOpentimestamp());
        setEvictors(sup.getEvictors());
        setExpect(sup.getExpect().substring(2));
        setOpenCode(sup.getOpenCode());
    }

    public int N1 = 0, N2 = 0, N3 = 0, N4 = 0, N5 = 0, N6 = 0, N7 = 0,
            N8 = 0, N9 = 0, N10 = 0, N11 = 0, N12 = 0, N13 = 0, N14 = 0,
            N15 = 0, N16 = 0, N17 = 0, N18 = 0, N19 = 0, N20 = 0, N21 = 0,
            N22 = 0, N23 = 0, N24 = 0, N25 = 0, N26 = 0, N27 = 0, N28 = 0,
            N29 = 0, N30 = 0, N31 = 0, N32 = 0, N33 = 0, N34 = 0, N35 = 0,
            N36 = 0, N37 = 0, N38 = 0, N39 = 0, N40 = 0, N41 = 0, N42 = 0,
            N43 = 0, N44 = 0, N45 = 0, N46 = 0, N47 = 0, N48 = 0, N49 = 0;

    public Vigilant getVigilant(NumberProperty numberProperty) {
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        int number = 0;
        switch (numberProperty) {
            case N1:
                number = N1;
                break;
            case N2:
                number = N2;
                break;
            case N3:
                number = N3;
                break;
            case N4:
                number = N4;
                break;
            case N5:
                number = N5;
                break;
            case N6:
                number = N6;
                break;
            case N7:
                number = N7;
                break;
            case N8:
                number = N8;
                break;
            case N9:
                number = N9;
                break;
            case N10:
                number = N10;
                break;
            case N11:
                number = N11;
                break;
            case N12:
                number = N12;
                break;
            case N13:
                number = N13;
                break;
            case N14:
                number = N14;
                break;
            case N15:
                number = N15;
                break;
            case N16:
                number = N16;
                break;
            case N17:
                number = N17;
                break;
            case N18:
                number = N18;
                break;
            case N19:
                number = N19;
                break;
            case N20:
                number = N20;
                break;
            case N21:
                number = N21;
                break;
            case N22:
                number = N22;
                break;
            case N23:
                number = N23;
                break;
            case N24:
                number = N24;
                break;
            case N25:
                number = N25;
                break;
            case N26:
                number = N26;
                break;
            case N27:
                number = N27;
                break;
            case N28:
                number = N28;
                break;
            case N29:
                number = N29;
                break;
            case N30:
                number = N30;
                break;
            case N31:
                number = N31;
                break;
            case N32:
                number = N32;
                break;
            case N33:
                number = N33;
                break;
            case N34:
                number = N34;
                break;
            case N35:
                number = N35;
                break;
            case N36:
                number = N36;
                break;
            case N37:
                number = N37;
                break;
            case N38:
                number = N38;
                break;
            case N39:
                number = N39;
                break;
            case N40:
                number = N40;
                break;
            case N41:
                number = N41;
                break;
            case N42:
                number = N42;
                break;
            case N43:
                number = N43;
                break;
            case N44:
                number = N44;
                break;
            case N45:
                number = N45;
                break;
            case N46:
                number = N46;
                break;
            case N47:
                number = N47;
                break;
            case N48:
                number = N48;
                break;
            case N49:
                number = N49;
                break;
        }
        for (Vigilant vigilant : values) {
            if (number >= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.DefaultNumber.Defult)
                    && number > Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.DefaultNumber.Defult)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }


}
