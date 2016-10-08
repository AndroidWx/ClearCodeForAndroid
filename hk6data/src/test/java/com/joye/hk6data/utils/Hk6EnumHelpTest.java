package com.joye.hk6data.utils;

import com.joye.hk6domain.constants.CompositeMantissa;
import com.joye.hk6domain.constants.Formula;
import com.joye.hk6domain.constants.HeadTwos;
import com.joye.hk6domain.constants.Hk6Color;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.constants.Modular3;
import com.joye.hk6domain.constants.Modular4;
import com.joye.hk6domain.constants.Modular5;
import com.joye.hk6domain.constants.Modular6;
import com.joye.hk6domain.constants.Modular7;
import com.joye.hk6domain.constants.PrimeCompositeNumber;
import com.joye.hk6domain.constants.Vigilant;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/21.
 * 304622254@qq.com
 * Remeark:
 */

public class Hk6EnumHelpTest {
    Hk6EnumHelp hk6EnumHelp;

    @Before
    public void setUp() throws Exception {
        hk6EnumHelp=new Hk6EnumHelp();
    }

    @Test
    public void mo() throws Exception {
        assertEquals(PrimeCompositeNumber.Prime, hk6EnumHelp.getPrimeCompositeNumber(5));
    }



    @Test
    public void testColor() throws Exception {
        assertEquals(Hk6Color.Red, hk6EnumHelp.getHk6Color(5));
        for (int i=1; i<50;i++ ) {
             System.out.println("<item name=\"tv_item\""+i+"\"type\"=\"id\"/>");
        }
    }
    @Test
    public void testColorTwos()throws Exception {
        for (Modular7 colorTwos : Modular7.values()) {
            for (Vigilant vigilant:Vigilant.values()) {
                if(vigilant.equals(Vigilant.Default)){
                    continue;
                }
                System.out.println(vigilant.getDcValue()+"--"+colorTwos.name()+"--"+ Formula.lottery(vigilant.getDcValue(), colorTwos.getTheoryProbability()));
            }

            System.out.println("\n\n");
        }
    }

    @Test
    public void testHeadAge() throws Exception {
//       double b=7;double p=10/19;double q=1-10/19;
        BigDecimal b=new BigDecimal(7.00);
        BigDecimal p=new BigDecimal((double)11/19*0.99);
        BigDecimal q=new BigDecimal(1-(double)11/19*0.99);
        BigDecimal f=(b.multiply(p).subtract(q)).divide(b,2);
        System.out.println((2000-547-484-380-266-301));


    }
}
