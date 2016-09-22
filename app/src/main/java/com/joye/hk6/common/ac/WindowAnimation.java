package com.joye.hk6.common.ac;

import android.os.Build;

import com.fernandocejas.frodo.core.strings.Strings;
import com.joye.hk6.R;
import com.joye.hk6.common.JoyeEnvironment;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/22.
 * 304622254@qq.com
 * Remeark:
 */

public class WindowAnimation {
    public static int activityOpenEnterAnimation;
    public static int activityOpenExitAnimation;
    public static int activityCloseEnterAnimation;
    public static int activityCloseExitAnimation;

    public int openEnter = activityOpenEnterAnimation;
    public int openExit = activityOpenExitAnimation;
    public int closeEnter = activityCloseEnterAnimation;
    public int closeExit = activityCloseExitAnimation;

    static {
        if (!(JoyeEnvironment.Instance.getBuildSdk()>=19. && isEnable())) {
            activityOpenEnterAnimation = R.anim.slide_right_in;
            activityOpenExitAnimation = R.anim.slide_left_out;
            activityCloseEnterAnimation = R.anim.slide_left_in;
            activityCloseExitAnimation = R.anim.slide_right_out;
        } else {
            activityOpenEnterAnimation = R.anim.slide_right_in;
            activityOpenExitAnimation = R.anim.slide_left_out;
            activityCloseEnterAnimation = R.anim.slide_left_in;
            activityCloseExitAnimation = R.anim.slide_right_out;
//                activityOpenEnterAnimation = R.anim.pop_in;
//                activityOpenExitAnimation  = R.anim.anim_not_change;
//                activityCloseEnterAnimation = R.anim.anim_not_change;
//                activityCloseExitAnimation = R.anim.pop_out;
        }
    }

    public static boolean isEnable(){
        if(JoyeEnvironment.Instance.getBuildIncremental().toLowerCase().equals("flyme")||
                Build.DISPLAY.toLowerCase().equals("flyme")
                ){
            return false;
        }
        return true;
    }
}
