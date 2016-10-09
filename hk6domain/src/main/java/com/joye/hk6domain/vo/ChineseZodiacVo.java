package com.joye.hk6domain.vo;


import com.joye.hk6domain.constants.ChineseZodiac;
import com.joye.hk6domain.constants.Formula;
import com.joye.hk6domain.constants.IDcValue;
import com.joye.hk6domain.constants.Probalility;
import com.joye.hk6domain.constants.Vigilant;
import com.joye.hk6domain.entity.Hk6UiData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/23.
 * 304622254@qq.com
 * Remeark: 生肖走势图的vo
 */

public class ChineseZodiacVo extends Hk6UiData implements ReportRightI {

    public ChineseZodiacVo(Hk6UiData sup){
        setOpentime(sup.getOpentime());
        setOpentimestamp(sup.getOpentimestamp());
        setEvictors(sup.getEvictors());
        setExpect(sup.getExpect());
        setOpenCode(sup.getOpenCode());
    }

    public int Mouse, Cow, Tiger, Rabbit, Dragon, Snake,Horse,Sheep,Monkey,Chook,Dog,Pig;

    public Vigilant MouseVigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( Mouse>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.ChineseZodiac.Default)
                    &&Mouse>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.ChineseZodiac.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant CowVigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( Cow>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.ChineseZodiac.Default)
                    &&Cow>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.ChineseZodiac.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant TigerVigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( Tiger>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.ChineseZodiac.Default)
                    &&Tiger>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.ChineseZodiac.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant RabbitVigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( Rabbit>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.ChineseZodiac.Default)
                    &&Rabbit>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.ChineseZodiac.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant DragonVigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( Dragon>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.ChineseZodiac.Default)
                    &&Dragon>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.ChineseZodiac.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    public Vigilant SnakeVigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( Snake>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.ChineseZodiac.Default)
                    &&Snake>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.ChineseZodiac.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant HorseVigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( Horse>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.ChineseZodiac.Default)
                    &&Horse>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.ChineseZodiac.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant SheepVigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( Sheep>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.ChineseZodiac.Default)
                    &&Sheep>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.ChineseZodiac.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant MonkeyVigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( Monkey>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.ChineseZodiac.Default)
                    &&Monkey>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.ChineseZodiac.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant ChookVigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( Chook>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.ChineseZodiac.Default)
                    &&Chook>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.ChineseZodiac.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant DogVigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( Dog>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.ChineseZodiac.Default)
                    &&Dog>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.ChineseZodiac.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }
    public Vigilant PigVigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( Pig>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.ChineseZodiac.Default)
                    &&Pig>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.ChineseZodiac.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

}
