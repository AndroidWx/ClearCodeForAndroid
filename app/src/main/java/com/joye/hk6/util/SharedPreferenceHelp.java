package com.joye.hk6.util;

import net.nashlegend.anypref.annotations.PrefField;

/**
 * Created by W,x (JoyeWang)
 * on 2016/11/5.
 * 304622254@qq.com
 * Remeark:
 */

public class SharedPreferenceHelp {
    @PrefField(boolDef = true)
    public boolean needCacheToFile = true;

    @PrefField
    public boolean  CacheToFileFetchDataSuccess = false;

}
