package com.ninegor.sdk;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.ninegor.sdk.net.SdkNetApiImpl;
import com.ninegor.sdk.utils.AndroidMetaDataUtil;
import com.orhanobut.logger.Logger;

import net.nashlegend.anypref.AnyPref;
import net.nashlegend.anypref.SharedPrefs;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import rx.Observer;
import rx.schedulers.Schedulers;

import static com.ninegor.sdk.SharedPreferenceHelp.IMIE_KEY;

/**
 * Created by joye on 2017/1/17.
 */

public class NinegorManager {

    public static final String AppIdMetaKey = "NinegorAppId";

    public static void register(Context context) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                Logger.i("register");
                AnyPref.init(context);
                final SharedPrefs prefs = AnyPref.getDefault();//SharedPreferenceHelp.class);
                //是否启用注册，并注册成功
                if (prefs.getBoolean("isRegister", false) || prefs.getBoolean("isRegisterSuccess", false)) {
                    SdkNetApiImpl sdkNetApi=new SdkNetApiImpl(context);
                    Logger.i("sdkNetApi init");

                    sdkNetApi.activateUseCase("aa048d6b58015ba5","hk6","2017-12-31","json").subscribeOn(Schedulers.io()).subscribeOn(Schedulers.newThread()).subscribe(new Observer<String>() {
                        @Override
                        public void onCompleted() {
                            prefs.beginTransaction().putBoolean("isRegister",true).putBoolean("isRegisterSuccess",true).commit();
                        }

                        @Override
                        public void onError(Throwable e) {
                            prefs.beginTransaction().putBoolean("isRegister",true).putBoolean("isRegisterSuccess",false).commit();
                            if( e instanceof  IllegalArgumentException){
                                if(e.getMessage().equals("please check Mainfest have NinegorAppId")){
                                    Toast.makeText(context, "please check Mainfest have NinegorAppId", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                            Logger.i("sdkNetApi error"+e.getMessage());
                            if(e.getMessage().contains("Expected a string but was BEGIN_OBJECT at line 1 column 2 path $")){
                                prefs.beginTransaction().putBoolean("isRegister",true).putBoolean("isRegisterSuccess",true).commit();
                                Logger.i("JsonSyntaxException");
                            }
                        }

                        @Override
                        public void onNext(String s) {
                            Logger.i(s);
                        }
                    });
                    Logger.i("sdkNetApi end");
                }
            }
        }.start();

    }

    public static String getAppId(Context context){
        //获取配置文件
        String data = AndroidMetaDataUtil.getApplicationMetaData(context, AppIdMetaKey);
        if (StringUtils.isBlank(data)) {
            Validate.isTrue(false, "please check Mainfest have NinegorAppId");
        }
        return data;
    }

    /**
     * 留存率
     */
    private static void retentionRateRequest(){
        //处理留存率

    }

    /**
     * 获取设备唯一标示码
     * @param context 上下文对象
     * @return
     */
    public static String getIMEI(Context context) {
        final SharedPrefs prefs = AnyPref.getPrefs(SharedPreferenceHelp.class);
        if(prefs.contains(IMIE_KEY)&&!StringUtils.isBlank(prefs.getString(IMIE_KEY,""))){
            return prefs.getString(IMIE_KEY,"");
        }
        String deviceId="";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            deviceId=telephonyManager.getDeviceId();
        }finally {
            prefs.beginTransaction().putString(IMIE_KEY,deviceId);
        }
        return deviceId;
    }
}
