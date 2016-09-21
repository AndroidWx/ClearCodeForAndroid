package com.joye.hk6data.utils;

import com.joye.hk6data.constants.Hk6Color;
import com.joye.hk6data.constants.PrimeCompositeNumber;
import com.joye.hk6data.utils.Hk6EnumHelp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

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

    }
}
