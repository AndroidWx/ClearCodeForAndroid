package com.joye.hk6data.utils;


import com.joye.hk6domain.constants.Formula;

import org.bouncycastle.util.encoders.Base64;
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
//     for(int i=1;i<=49;i++){
//         System.out.println(i+" = "+ Hk6EnumHelp.getRegion(i));
//     }
         String auth="api:NMrq7srswRm9J6Wlflm0TmjMKH8Bq56D";
         String value="Basic "+new String(Base64.encode(auth.getBytes()));
        System.out.println(value);
    }

}
