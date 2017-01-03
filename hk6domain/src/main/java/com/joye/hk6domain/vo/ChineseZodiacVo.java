package com.joye.hk6domain.vo;


import com.joye.hk6domain.constants.ChineseZodiac;
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

public class ChineseZodiacVo extends Hk6UiData implements ReportRightI {

    public ChineseZodiacVo(Hk6UiData sup){
        setOpentime(sup.getOpentime());
        setOpentimestamp(sup.getOpentimestamp());
        setEvictors(sup.getEvictors());
        setExpect(sup.getExpect());
        setOpenCode(sup.getOpenCode());
    }

    public int Mouse, Cow, Tiger, Rabbit, Dragon, Snake,Horse,Sheep,Monkey,Chook,Dog,Pig;

    public static double getProbalility(ChineseZodiac chineseZodiac,String expect  ){
        return chineseZodiac.getYear(Integer.valueOf(expect.substring(0,4))).equals(chineseZodiac)?Probalility.ChineseZodiac.OnlyOne:Probalility.ChineseZodiac.Default;
    }

    public Vigilant MouseVigilant(){
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( Mouse>= Formula.lotteryDobule(vigilant.getDcValue(),  getProbalility(ChineseZodiac.Mouse,getOpentime()))
                    &&Mouse>Formula.lotteryDobule(IDcValue.DefaultValue,  getProbalility(ChineseZodiac.Mouse,getOpentime()))) {
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
            if ( Cow>= Formula.lotteryDobule(vigilant.getDcValue(),  getProbalility(ChineseZodiac.Cow,getOpentime()))
                    &&Cow>Formula.lotteryDobule(IDcValue.DefaultValue,  getProbalility(ChineseZodiac.Cow,getOpentime()))) {
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
            if ( Tiger>= Formula.lotteryDobule(vigilant.getDcValue(), getProbalility(ChineseZodiac.Tiger,getOpentime()))
                    &&Tiger>Formula.lotteryDobule(IDcValue.DefaultValue, getProbalility(ChineseZodiac.Tiger,getOpentime()))) {
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
            if ( Rabbit>= Formula.lotteryDobule(vigilant.getDcValue(), getProbalility(ChineseZodiac.Rabbit,getOpentime()))
                    &&Rabbit>Formula.lotteryDobule(IDcValue.DefaultValue, getProbalility(ChineseZodiac.Rabbit,getOpentime()))) {
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
            if ( Dragon>= Formula.lotteryDobule(vigilant.getDcValue(), getProbalility(ChineseZodiac.Dragon,getOpentime()))
                    &&Dragon>Formula.lotteryDobule(IDcValue.DefaultValue, getProbalility(ChineseZodiac.Dragon,getOpentime()))) {
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
            if ( Snake>= Formula.lotteryDobule(vigilant.getDcValue(), getProbalility(ChineseZodiac.Snake,getOpentime()))
                    &&Snake>Formula.lotteryDobule(IDcValue.DefaultValue, getProbalility(ChineseZodiac.Snake,getOpentime()))) {
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
            if ( Horse>= Formula.lotteryDobule(vigilant.getDcValue(), getProbalility(ChineseZodiac.Horse,getOpentime()))
                    &&Horse>Formula.lotteryDobule(IDcValue.DefaultValue, getProbalility(ChineseZodiac.Horse,getOpentime()))) {
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
            if ( Sheep>= Formula.lotteryDobule(vigilant.getDcValue(), getProbalility(ChineseZodiac.Sheep,getOpentime()))
                    &&Sheep>Formula.lotteryDobule(IDcValue.DefaultValue, getProbalility(ChineseZodiac.Sheep,getOpentime()))) {
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
            if ( Monkey>= Formula.lotteryDobule(vigilant.getDcValue(), getProbalility(ChineseZodiac.Monkey,getOpentime()))
                    &&Monkey>Formula.lotteryDobule(IDcValue.DefaultValue,getProbalility(ChineseZodiac.Monkey,getOpentime()))) {
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
            if ( Chook>= Formula.lotteryDobule(vigilant.getDcValue(),getProbalility(ChineseZodiac.Chook,getOpentime()))
                    &&Chook>Formula.lotteryDobule(IDcValue.DefaultValue, getProbalility(ChineseZodiac.Chook,getOpentime()))) {
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
            if ( Dog>= Formula.lotteryDobule(vigilant.getDcValue(), getProbalility(ChineseZodiac.Dog,getOpentime()))
                    &&Dog>Formula.lotteryDobule(IDcValue.DefaultValue, getProbalility(ChineseZodiac.Dog,getOpentime()))) {
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
            if ( Pig>= Formula.lotteryDobule(vigilant.getDcValue(), getProbalility(ChineseZodiac.Pig,getOpentime()))
                    &&Pig>Formula.lotteryDobule(IDcValue.DefaultValue, getProbalility(ChineseZodiac.Pig,getOpentime()))) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

}
