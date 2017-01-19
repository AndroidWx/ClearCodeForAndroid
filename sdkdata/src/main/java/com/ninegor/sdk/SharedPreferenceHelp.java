package com.ninegor.sdk;

import net.nashlegend.anypref.annotations.PrefField;

/**
 * Created by joye on 2017/1/17.
 */

public class SharedPreferenceHelp {
    @PrefField(boolDef = true)
    public boolean isRegister = true;

    @PrefField
    public boolean  isRegisterSuccess = false;

    @PrefField
    public String mIMIE="";

    public static final String IMIE_KEY="mIMIE";

}
