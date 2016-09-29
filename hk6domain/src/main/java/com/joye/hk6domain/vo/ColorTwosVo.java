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

public class ColorTwosVo extends Hk6UiData implements ReportRightI {

    public ColorTwosVo(Hk6UiData sup) {
        setOpentime(sup.getOpentime());
        setOpentimestamp(sup.getOpentimestamp());
        setEvictors(sup.getEvictors());
        setExpect(sup.getExpect());
        setOpenCode(sup.getOpenCode());
    }

    public int redEven, redOdd, blueEven, blueOdd, greenEven, greenOdd;

    public Vigilant greenOddVigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( greenOdd>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.ColorTwos.GreenOdd)
                    &&greenOdd>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.ColorTwos.GreenOdd)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant greenEvenVigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( greenEven>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.ColorTwos.GreenEven)
                    &&greenEven>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.ColorTwos.GreenEven)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant blueOddVigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( blueOdd>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.ColorTwos.BlueOdd)
                    &&blueOdd>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.ColorTwos.BlueOdd)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant blueEvenVigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( blueEven>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.ColorTwos.BlueEven)
                    &&blueEven>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.ColorTwos.BlueEven)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant redEvenVigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( redEven>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.ColorTwos.RedEven)
                    &&redEven>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.ColorTwos.RedEven)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant redOddVigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( redOdd>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.ColorTwos.RedOdd)
                    &&redOdd>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.ColorTwos.RedOdd)) {
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
