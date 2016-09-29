package com.joye.hk6.util;

import android.graphics.drawable.Drawable;
import android.widget.Switch;

import com.joye.hk6.R;
import com.joye.hk6domain.constants.Region;
import com.joye.hk6domain.constants.Vigilant;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/28.
 * 304622254@qq.com
 * Remeark:
 */

public class VigilantHelp {
    public static int getDrawable(Vigilant vigilant){
        return getDrawable(vigilant,true);
    }

    public static int getDrawable(Vigilant vigilant,boolean vigilantBaseIsShow){
        switch (vigilant){
            case Base:
                if(vigilantBaseIsShow)
                return R.drawable.ic_warning_blue_200_18dp;
                else {
                    return android.R.drawable.screen_background_light_transparent;
                }
            case Blue:
                return R.drawable.ic_warning_light_blue_500_18dp;
            case Blue_1:
                return R.drawable.ic_warning_blue_1_18dp;
            case Yellow:
                return R.drawable.ic_warning_yellow_18dp;
            case Yellow_1:
                return R.drawable.ic_warning_yellow_1_18dp;
            case Orange:
                return R.drawable.ic_warning_orange_18dp;
            case Orange_1:
                return R.drawable.ic_warning_orange_1_18dp;
            case Red:
                return R.drawable.ic_warning_red_1_18dp;
            case Red_1:
                return R.drawable.ic_warning_red_2_18dp;
            default:
                return android.R.drawable.screen_background_light_transparent;
        }
    }
}
