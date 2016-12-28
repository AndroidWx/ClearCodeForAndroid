package com.joye.hk6data;


import com.joye.hk6data.entity.Hk6Entity;

import org.bouncycastle.util.encoders.Base64;
import org.junit.Before;
import org.junit.Test;

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
    public void testUrlIsPic() throws Exception {
        String[] sources=new String[]{"picture1.JPG","picture2.gif","picture3.BMP","http://xueban-uat.oss-cn-shenzhen.aliyuncs.com/3b3de33e-149a-4a2c-9bd0-fb128f300e38.doc"};
        String reg="(?i).+?\\.(jpg|gif|bmp|pcx|jpeg|tiff)";
        for(int i=0; i <sources.length;i++) {
            System.out.println(sources[i].matches(reg));
        }
    }

    @Test
    public void testGetDataTransformerEntity() throws Exception {
//        hk6Entity.getDataTransformerEntity();
        System.out.println(hk6Entity.getExpect().substring(0,4)+"期");
        String auth="api:NMrq7srswRm9J6Wlflm0TmjMKH8Bq56D";
        byte[] mbyte = auth.getBytes();
        byte[] newByte= Base64.encode(mbyte);//,Base64.NO_PADDING);
        String basevalue = new String(newByte);
        String value="Basic "+basevalue;
        System.out.println(value);
    }
}
