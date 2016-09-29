package com.joye.hk6domain.vo;


import com.joye.hk6domain.constants.Formula;
import com.joye.hk6domain.constants.IDcValue;
import com.joye.hk6domain.constants.Probalility;
import com.joye.hk6domain.constants.Region;
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

public class RegionVo extends Hk6UiData implements ReportRightI {

    public RegionVo(Hk6UiData sup) {
        setOpentime(sup.getOpentime());
        setOpentimestamp(sup.getOpentimestamp());
        setEvictors(sup.getEvictors());
        setExpect(sup.getExpect());
        setOpenCode(sup.getOpenCode());
    }

    public int One, Two, Three, Four, Five, Sex, Seven;





    public Vigilant regionVigilant(Region region){
        int regionNum=0;
        switch (region){
            case One:
                regionNum= One;
                break;
            case Two:
                regionNum= Two;
                break;
            case Three:
                regionNum= Three;
                break;
            case Four:
                regionNum= Four;
                break;
            case Five:
                regionNum= Five;
                break;
            case Six:
                regionNum= Sex;
                break;
            default:
                regionNum= Seven;
                break;
        }
        return regionVigilant(regionNum);
    }

    public Vigilant regionVigilant(int num) {
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( num>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Region.Default)
                    &&num>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Region.Default)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

}
