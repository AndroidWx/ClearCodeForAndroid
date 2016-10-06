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
 * Remeark: 尾数大小走势图的vo
 */

public class MantissaSizeVo extends Hk6UiData implements ReportRightI {

    public MantissaSizeVo(Hk6UiData sup) {
        setOpentime(sup.getOpentime());
        setOpentimestamp(sup.getOpentimestamp());
        setEvictors(sup.getEvictors());
        setExpect(sup.getExpect());
        setOpenCode(sup.getOpenCode());
    }

    public int Big, Small;


    public Vigilant bigVigilant() {
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( Big>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.MantissaSize.Big)
                    &&Big>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.MantissaSize.Big)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant smallVigilant() {
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( Small >=Formula.lotteryDobule(vigilant.getDcValue(), Probalility.MantissaSize.Small)  &&
                    Small>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.MantissaSize.Small)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }


}
