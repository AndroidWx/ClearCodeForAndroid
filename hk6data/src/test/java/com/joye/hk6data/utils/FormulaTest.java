package com.joye.hk6data.utils;


import com.joye.hk6domain.constants.Formula;
import com.joye.hk6domain.constants.Hk6EnumHelp;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/21.
 * 304622254@qq.com
 * Remeark:
 */

public class FormulaTest {
    private Formula mFormula;

    @Before
    public void setUp() throws Exception {
        mFormula=new Formula();
    }

    @Test
    public void testFormula() throws Exception {
//       System.out.println( mFormula.lottery(0.999, Probalility.Region.Default));
     for(int i=1;i<=49;i++){
         System.out.println(i+" = "+ Hk6EnumHelp.getRegion(i));
     }
    }

}
