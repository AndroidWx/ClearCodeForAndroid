package com.joye.hk6data;


import com.joye.hk6data.entity.Hk6Entity;
import com.joye.hk6domain.constants.ChineseZodiac;

import org.bouncycastle.util.encoders.Base64;
import org.junit.Before;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
        System.out.println(getYear(2017));

    }
    public String getYear(Integer year){
        if(year<1900){
            return "未知";
        }
        Integer start=1900;
        String [] years=new String[]{
                "鼠","牛","虎","兔",
                "龙","蛇","马","羊",
                "猴","鸡","狗","猪"
        };

        return years[(year-start)%years.length];
    }


    @Test
    public void testA() throws Exception {
        System.out.println(getPwd("123456abcdefOldManWong"));
    }


    /**
     * 获取MD5加密
     *
     * @param pwd
     *            需要加密的字符串
     * @return String字符串 加密后的字符串
     */
    public static String getPwd(String pwd) {
        try {
            // 创建加密对象
            MessageDigest digest = MessageDigest.getInstance("md5");

            // 调用加密对象的方法，加密的动作已经完成
            byte[] bs = digest.digest(pwd.getBytes());
            // 接下来，我们要对加密后的结果，进行优化，按照mysql的优化思路走
            // mysql的优化思路：
            // 第一步，将数据全部转换成正数：
            String hexString = "";
            for (byte b : bs) {
                // 第一步，将数据全部转换成正数：
                // 解释：为什么采用b&255
                /*
                 * b:它本来是一个byte类型的数据(1个字节) 255：是一个int类型的数据(4个字节)
                 * byte类型的数据与int类型的数据进行运算，会自动类型提升为int类型 eg: b: 1001 1100(原始数据)
                 * 运算时： b: 0000 0000 0000 0000 0000 0000 1001 1100 255: 0000
                 * 0000 0000 0000 0000 0000 1111 1111 结果：0000 0000 0000 0000
                 * 0000 0000 1001 1100 此时的temp是一个int类型的整数
                 */
                int temp = b & 255;
                // 第二步，将所有的数据转换成16进制的形式
                // 注意：转换的时候注意if正数>=0&&<16，那么如果使用Integer.toHexString()，可能会造成缺少位数
                // 因此，需要对temp进行判断
                if (temp < 16 && temp >= 0) {
                    // 手动补上一个“0”
                    hexString = hexString + "0" + Integer.toHexString(temp);
                } else {
                    hexString = hexString + Integer.toHexString(temp);
                }
            }
            return hexString;
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }
}
