package report;


import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;

import com.joye.hk6.view.ColorActivity;
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

}
