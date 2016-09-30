package com.joye.hk6domain.vo;


import com.joye.hk6domain.constants.Formula;
import com.joye.hk6domain.constants.HeadAge;
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

public class HeadAgeVo extends Hk6UiData implements ReportRightI {

    public HeadAgeVo(Hk6UiData sup) {
        setOpentime(sup.getOpentime());
        setOpentimestamp(sup.getOpentimestamp());
        setEvictors(sup.getEvictors());
        setExpect(sup.getExpect());
        setOpenCode(sup.getOpenCode());
    }

    public int headage0, headage1, headage2, headage3, headage4;

    public Vigilant headage0Vigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( headage0>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.HeadAge.H_0)
                    &&headage0>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.HeadAge.H_0)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant headageVigilant(HeadAge headAge){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            int number=0;
            switch (headAge){
                case Headage1:
                    number=headage1;
                    break;
                case Headage2:
                    number=headage2;
                    break;
                case Headage3:
                    number=headage3;
                    break;
                case Headage4:
                    number=headage4;
                    break;
            }
            if ( number>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.HeadAge.Default)
                    &&number>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.ColorTwos.RedEven)) {
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
