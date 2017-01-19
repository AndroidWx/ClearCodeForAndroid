package com.ninegor.sdk;

import android.content.Context;

import com.orhanobut.logger.Logger;

/**
 * Created by joye on 2017/1/18.
 */

public class NinegorSDK {
    public static void register(Context context){
        Logger.i("sdk register");
        NinegorManager.register(context);
    }
}
