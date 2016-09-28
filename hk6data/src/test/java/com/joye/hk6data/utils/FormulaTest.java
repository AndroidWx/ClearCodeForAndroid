package com.joye.hk6data.utils;

import com.joye.hk6domain.constants.Formula;
import com.joye.hk6domain.constants.Probalility;
import com.joye.hk6domain.constants.Vigilant;

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
       System.out.println( mFormula.lottery(Vigilant.Base.getDcValue(), Probalility.Size.Small));
       System.out.println((double)(4/49));

    }
}
