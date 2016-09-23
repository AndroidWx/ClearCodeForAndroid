package com.joye.hk6data;

import com.joye.hk6data.entity.Hk6Entity;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/23.
 * 304622254@qq.com
 * Remeark:
 */
public class Hk6EntityTest {
    Hk6Entity hk6Entity;
    @Before
    public void setUp() throws Exception {
        hk6Entity=new Hk6Entity();
        hk6Entity.setExpect("2016001");
        hk6Entity.setOpencode("**,34,08,41,32,11+47");
        hk6Entity.setOpentime("2016-01-02 21:35:06");
        hk6Entity.setOpentimestamp(1451741706);

    }

    @Test
    public void testGetDataTransformerEntity() throws Exception {
//        hk6Entity.getDataTransformerEntity();
        System.out.println(hk6Entity.getExpect().substring(0,4)+"期");
    }
}
