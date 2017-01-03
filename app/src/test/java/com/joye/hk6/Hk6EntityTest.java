package com.joye.hk6;


import com.joye.hk6data.entity.Hk6Entity;
import com.joye.hk6domain.constants.ChineseZodiac;

import org.bouncycastle.util.encoders.Base64;
import org.junit.Before;
import org.junit.Test;

import static com.joye.hk6domain.constants.ChineseZodiac.Chook;
import static com.joye.hk6domain.constants.ChineseZodiac.Cow;
import static com.joye.hk6domain.constants.ChineseZodiac.Dog;
import static com.joye.hk6domain.constants.ChineseZodiac.Dragon;
import static com.joye.hk6domain.constants.ChineseZodiac.Horse;
import static com.joye.hk6domain.constants.ChineseZodiac.Monkey;
import static com.joye.hk6domain.constants.ChineseZodiac.Mouse;
import static com.joye.hk6domain.constants.ChineseZodiac.Pig;
import static com.joye.hk6domain.constants.ChineseZodiac.Rabbit;
import static com.joye.hk6domain.constants.ChineseZodiac.Sheep;
import static com.joye.hk6domain.constants.ChineseZodiac.Snake;
import static com.joye.hk6domain.constants.ChineseZodiac.Tiger;


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

    @Test
    public void testChineseZodiac() throws Exception {
        int year=2013;
        if(getYear(year)==Mouse){

        }else{
            int a[]=new int[]{1,13,25,37,49};
            int c=getYear(year).ordinal()-Monkey.ordinal();
//            System.out.println(c);
            for (int b:a){
                System.out.println(String.valueOf(b+c));
            }
        }


    }

    @Test
    public void testA() throws Exception {
        int n=2017001;
        int k=4;
        System.out.print (n>>4);

    }

    public ChineseZodiac getYear(Integer year){
        Integer start=1900;
        ChineseZodiac [] years=new ChineseZodiac[]{
                Mouse,Cow,Tiger,Rabbit,
                Dragon,Snake,Horse,Sheep,
                Monkey,Chook,Dog,Pig
        };
        return years[(year-start)%years.length];
    }
}
