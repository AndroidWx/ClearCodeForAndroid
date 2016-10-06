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
 * Remeark: 拌蛋双走势图的vo
 */

public class SizeTwosVo extends Hk6UiData implements ReportRightI {

    public SizeTwosVo(Hk6UiData sup) {
        setOpentime(sup.getOpentime());
        setOpentimestamp(sup.getOpentimestamp());
        setEvictors(sup.getEvictors());
        setExpect(sup.getExpect());
        setOpenCode(sup.getOpenCode());
    }

    public int SmallOdd,SmallEven,BigOdd,BigEven;


    public Vigilant smallOddVigilant() {
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( SmallOdd>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.SizeTwos.SmallOdd)
                    &&SmallOdd>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.SizeTwos.SmallOdd)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant smallEvenVigilant() {
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( SmallEven >=Formula.lotteryDobule(vigilant.getDcValue(), Probalility.SizeTwos.SmallEven)  &&
                    SmallEven>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.SizeTwos.SmallEven)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant bigOddVigilant() {
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( BigOdd>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.SizeTwos.BigOdd)
                    &&BigOdd>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.SizeTwos.BigOdd)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant bigEvenVigilant() {
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( BigEven >=Formula.lotteryDobule(vigilant.getDcValue(), Probalility.SizeTwos.BigEven)  &&
                    BigEven>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.SizeTwos.BigEven)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
}
