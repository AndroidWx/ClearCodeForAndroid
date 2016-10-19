package com.joye.hk6data.utils;

import com.joye.hk6domain.constants.ChineseZodiac;
import com.joye.hk6domain.constants.ColorTwos;
import com.joye.hk6domain.constants.Formula;
import com.joye.hk6domain.constants.Hk6Color;
import com.joye.hk6domain.constants.Hk6EnumHelp;
import com.joye.hk6domain.constants.Modular7;
import com.joye.hk6domain.constants.NumberProperty;
import com.joye.hk6domain.constants.PrimeCompositeNumber;
import com.joye.hk6domain.constants.Probalility;
import com.joye.hk6domain.constants.Vigilant;

import org.assertj.core.internal.cglib.core.DefaultNamingPolicy;
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
        for (NumberProperty colorTwos : NumberProperty.values()) {
            for (Vigilant vigilant:Vigilant.values()) {
                if(vigilant.equals(Vigilant.Default)){
                    continue;
                }
                System.out.println(vigilant.getDcValue()+"--"+colorTwos.name()+"--"+ Formula.lottery(vigilant.getDcValue(), Probalility.DefaultNumber.Defult));
            }

            System.out.println("\n\n");
        }
    }


    @Test
    public void testChineseZodiac() throws Exception {
        for (ChineseZodiac chi:ChineseZodiac.values()){
            System.out.println("   TextView.class.cast(view.findViewById(R.id."+chi.name()+")).setText(view.getResources().getString(R.string."+chi.name()+","+chi.name()+"));");
        }
    }

    @Test
    public void testColorTwos1() throws Exception {
        for (ColorTwos chi:ColorTwos.values()){
            System.out.println("   TextView.class.cast(view.findViewById(R.id.report_left_"+chi.name()+")).setText(view.getResources().getString(R.string."+chi.name()+","+chi.name()+"));");
        }

    }

    @Test
    public void testHeadAge() throws Exception {
//       double b=7;double p=10/19;double q=1-10/19;
        double total=4000;
        double bValue=7.00;
        double pValue=(double)1.00/19.00;
        double proValue=0.99;
        //f*=(bp-q)/b
        //f* 为现有资金应进行下次投注的比例，b 为投注可得的赔率，p 为获胜率，q 为落败率。
        BigDecimal b=new BigDecimal(bValue);
        BigDecimal p=new BigDecimal(pValue*proValue);
        BigDecimal q=new BigDecimal(1-proValue);
        double value=b.doubleValue()*p.doubleValue()-q.doubleValue();
        System.out.println(value);
        System.out.println((double)value/bValue+"--"+(total-(double)value/bValue*total));
//        System.out.println(total-total*f.doubleValue() );
        int tttt=0;
        for (int i=1;i<=19;i++){
            pValue=(double)i/19;
            p=new BigDecimal(pValue*proValue);
            q=new BigDecimal(1-proValue);
              value=b.doubleValue()*p.doubleValue()-q.doubleValue();
            System.out.println("第"+i+"次投入");
            System.out.println(value/bValue*total);
            tttt+=value/bValue*total;
            System.out.println(tttt);
            total=total-value/bValue*total;
        }

    }
}
