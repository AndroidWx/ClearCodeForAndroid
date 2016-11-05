package com.joye.hk6;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import com.joye.hk6.util.JoyeStatusBarUtil;

import javax.inject.Inject;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/22.
 * 304622254@qq.com
 * Remeark:
 */
public class StatusBarHelp {
    private final Activity activity;
    private JoyeStatusBarUtil joyeStatusBarUtil;
    @Inject
    public StatusBarHelp(Activity activity) {
        this.activity = activity;
        joyeStatusBarUtil=new JoyeStatusBarUtil(activity);
    }


    public JoyeStatusBarUtil getJoyeStatusBarUtil() {
        return joyeStatusBarUtil;
    }
    public JoyeStatusBarUtil   mTintManager = null;

    public void setStatusBarTintEnable(boolean on, int colorResourceID) {

        JoyeStatusBarUtil.setTranslucentStatus(activity, on);
        if (mTintManager == null) {
            mTintManager = new JoyeStatusBarUtil(activity);
        }
        mTintManager.setStatusBarTintEnabled(on);
        mTintManager.setNavigationBarTintEnabled(true);
        //使用颜色资源
        mTintManager.setStatusBarTintResource(colorResourceID);
    }

    public void setStatusBarTintEnable(boolean on, Drawable mDrawable) {
        try {
            JoyeStatusBarUtil.setTranslucentStatus(activity, on);
            if (mTintManager == null) {
                mTintManager = new JoyeStatusBarUtil(activity);
            }
            mTintManager.setStatusBarTintEnabled(on);
            //使用颜色资源
            mTintManager.setStatusBarTintDrawable(mDrawable);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
