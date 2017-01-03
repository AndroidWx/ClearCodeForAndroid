package com.joye.hk6;


import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;

import com.joye.hk6.view.ColorActivity;
import com.joye.hk6domain.constants.Formula;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/21.
 * 304622254@qq.com
 * Remeark:
 */

public class TestColorReport extends ActivityInstrumentationTestCase2<ColorActivity> {
    private Formula mFormula;
    ColorActivity mActivity;
    private Instrumentation mInstrumentation;



    public TestColorReport(String pkg, Class<ColorActivity> activityClass) {
        super("com.joye.hk6.view", activityClass);
    }

    @Before
    public void setUp() throws Exception {
        //避免手动触摸的情况，关闭TouchMode
        setActivityInitialTouchMode(false);
        mInstrumentation = getInstrumentation();
        //获取被测的Activity
        mActivity = getActivity();

    }
    @Test
    public void testInitalize() throws Exception {
        mActivity.mRegionPresenter.initalize(mActivity);
    }

    /* @Test
    public void testFormula() throws Exception {
//       System.out.println( mFormula.lottery(0.999, Probalility.Region.Default));
        mFormula=new Formula();
     for(int i=1;i<=49;i++){
         System.out.println(i+" = "+ Hk6EnumHelp.getRegion(i));
     }
    }*/
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
}
