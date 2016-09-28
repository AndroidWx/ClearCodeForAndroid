package com.joye.hk6data;

import com.joye.hk6domain.constants.Formula;
import com.joye.hk6domain.constants.IDcValue;
import com.joye.hk6domain.constants.Probalility;
import com.joye.hk6domain.constants.Vigilant;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/28.
 * 304622254@qq.com
 * Remeark:
 */

public class BigTest {
    double Big,Small;

    @Before
    public void setUp() throws Exception {
        Big=4.2;


    }

    @Test
    public void testBigVigilant() throws Exception {
        System.out.print(bigVigilant().name());

    }

    public Vigilant bigVigilant() {
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
        for (Vigilant vigilant : values) {
            if ( Big>= Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Size.Big)
                    &&Big>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Size.Big)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

    @Test
    public void testsmallVigilant() throws Exception {
        Small=3;
        System.out.print(smallVigilant().name());

    }
    public Vigilant smallVigilant() {
        Vigilant[] values = Vigilant.values();
        List<Vigilant> datas = new ArrayList<>();
//        Collections.reverse(datas);
        for (Vigilant vigilant : values) {
            if ( Small >=Formula.lotteryDobule(vigilant.getDcValue(), Probalility.Size.Small)  &&
                    Small>Formula.lotteryDobule(IDcValue.DefaultValue, Probalility.Size.Small)) {
                datas.add(vigilant);
            }
        }
        if (datas.size() > 1) {
            return datas.get(datas.size() - 1);
        }
        return Vigilant.Default;
    }

}
