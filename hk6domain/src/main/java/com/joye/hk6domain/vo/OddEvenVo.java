package com.joye.hk6domain.vo;

import com.joye.hk6domain.constants.Formula;
import com.joye.hk6domain.constants.IDcValue;
import com.joye.hk6domain.constants.OddEven;
import com.joye.hk6domain.constants.Probalility;
import com.joye.hk6domain.constants.Vigilant;
import com.joye.hk6domain.entity.Hk6UiData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by W,x (JoyeWang)
 * on 2016/12/28.
 * 304622254@qq.com
 * Remeark:
 */

public class OddEvenVo extends Hk6UiData {
    public OddEvenVo(Hk6UiData sup) {
        setOpentime(sup.getOpentime());
        setOpentimestamp(sup.getOpentimestamp());
        setEvictors(sup.getEvictors());
        setExpect(sup.getExpect());
        setOpenCode(sup.getOpenCode());
    }

    public int Odd, Even;


    public Vigilant oddVigilant() {
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( Odd >= Formula.lotteryDobule(vigilant.getDcValue(), OddEven.Odd.getTheoryProbability())
                    && Odd >Formula.lotteryDobule(IDcValue.DefaultValue,OddEven.Odd.getTheoryProbability())) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant evenVigilant() {
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
//        Collections.reverse(datas);
        for (Vigilant vigilant : values) {
            if ( Even >=Formula.lotteryDobule(vigilant.getDcValue(), OddEven.Even.getTheoryProbability())  &&
                    Even >Formula.lotteryDobule(IDcValue.DefaultValue, OddEven.Even.getTheoryProbability())) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
}
