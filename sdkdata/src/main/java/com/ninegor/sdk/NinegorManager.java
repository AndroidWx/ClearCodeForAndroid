package com.ninegor.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;




import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;



/**
 * Created by joye on 2017/1/17.
 */

public class NinegorManager {

    public static final String AppIdMetaKey = "NinegorAppId";
    public static final String IS_REGISTER = "isRegister";
    public static final String IS_REGISTER_SUCCESS = "isRegisterSuccess";
    public static final String IS_TODAY_COMMIT="isTodayCommit";
    public static final String IMIE_KEY="mIMIE";


    private static SharedPreferences.Editor putSharedPrefsEditor(Context ctx){
        SharedPreferences sp = getSharedPrefs(ctx);
        return sp.edit();
    }
    private static SharedPreferences  getSharedPrefs(Context ctx){
        return ctx.getSharedPreferences(NinegorManager.class.getName(), Context.MODE_PRIVATE);
    }

    public static void register2(Context context){
        final SharedPreferences prefs =getSharedPrefs(context);
        if (!prefs.getBoolean(IS_REGISTER, false) ||(prefs.getBoolean(IS_REGISTER, false)&&!prefs.getBoolean(IS_REGISTER_SUCCESS, false))) {
            NetWorkAsyncTask task1 = new NetWorkAsyncTask(context, new NetWorkAsyncTask.ICallBack() {
                @Override
                public void issuccess(boolean b) {
                    if(b){
                        putSharedPrefsEditor(context).putBoolean(IS_REGISTER,true).putBoolean(IS_REGISTER_SUCCESS,true).commit();
                    }else{
                        putSharedPrefsEditor(context).putBoolean(IS_REGISTER,true).putBoolean(IS_REGISTER_SUCCESS,false).commit();
                    }
                }
            });
            task1.execute(getChannel(context), "1");
        }
        //如果今天没有提交留存
        if(!(prefs.getString(IS_TODAY_COMMIT,"").equals(getToday()))){
            NetWorkAsyncTask task1 = new NetWorkAsyncTask(context, new NetWorkAsyncTask.ICallBack() {
                @Override
                public void issuccess(boolean b) {
                    if(b){
                        putSharedPrefsEditor(context).putString(IS_TODAY_COMMIT,getToday()).commit();
                    }
                }
            });
            task1.execute(getChannel(context), "2");
        }
    }

    private static String getToday(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale = Calendar.getInstance();
        try {
            return sdf.format(cale.getTime());
        } catch (Exception e) {
            return "";
        }
    }

    private static String getApplicationMetaData(Context context,String metaKey)
    {
        try {
            ApplicationInfo appInfo =context.getPackageManager().getApplicationInfo(context.getPackageName(),
                    PackageManager.GET_META_DATA);
            return appInfo.metaData.getString(metaKey);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getAppId(Context context){
        //获取配置文件
        String data = getApplicationMetaData(context, AppIdMetaKey);
        if (isBlank(data)) {
             isTrue(false, "please check Mainfest have NinegorAppId");
        }
        return data;
    }

    private static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }


    private static void isTrue(final boolean expression, final String message, final Object... values) {
        if (expression == false) {
            throw new IllegalArgumentException(String.format(message, values));
        }
    }
    private static String channel = null;

    private static String getChannel(Context context) {
        if (channel != null) {
            return channel;
        }

        final String start_flag = "META-INF/channel_";
        ApplicationInfo appinfo = context.getApplicationInfo();
        String sourceDir = appinfo.sourceDir;
        ZipFile zipfile = null;
        try {
            zipfile = new ZipFile(sourceDir);
            Enumeration<?> entries = zipfile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = ((ZipEntry) entries.nextElement());
                String entryName = entry.getName();
                if (entryName.contains(start_flag)) {
                    channel = entryName.replace(start_flag, "");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (zipfile != null) {
                try {
                    zipfile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (channel == null || channel.length() <= 0) {
            channel = "";//读不到渠道号就默认官方渠道
        }
        return channel;
    }




    /**
     * 获取设备唯一标示码
     * @param context 上下文对象
     * @return
     */
    public static String getIMEI(Context context) {
        SharedPreferences sp=getSharedPrefs(context);
        if(sp.contains(IMIE_KEY)&&!isBlank(sp.getString(IMIE_KEY,""))){
            return sp.getString(IMIE_KEY,"");
        }
        String deviceId="";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            deviceId=telephonyManager.getDeviceId();
        }finally {
            sp.edit().putString(IMIE_KEY,deviceId).commit();
        }
        return deviceId;
    }


//    /**
//     * 注册
//     * @param context
//     *
//     */
//    public static void register(Context context) {
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
////                Logger.i("register");
////                AnyPref.init(context);
//                final SharedPreferences prefs =getSharedPrefs(context);//SharedPreferenceHelp.class);
//                SdkNetApiImpl sdkNetApi=new SdkNetApiImpl(context);
//                //是否启用注册，并注册成功  如果没有注册 或者 没有注册成功
//                if (!prefs.getBoolean(IS_REGISTER, false) ||(prefs.getBoolean(IS_REGISTER, false)&&!prefs.getBoolean(IS_REGISTER_SUCCESS, false))) {
////                    Logger.i("sdkNetApi init");
//                    //激活
//                    sdkNetApi.activateUseCase("1",getChannel(context)).subscribeOn(Schedulers.io()).subscribeOn(Schedulers.newThread()).subscribe(new Observer<SDKResponse>() {
//                        @Override
//                        public void onCompleted() {
//
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//
//                            putSharedPrefsEditor(context).putBoolean(IS_REGISTER,true).putBoolean(IS_REGISTER_SUCCESS,false).commit();
//                            if( e instanceof  IllegalArgumentException){
//                                if(e.getMessage().equals("please check Mainfest have NinegorAppId")){
//                                    try {
////                                        Toast.makeText(context, "please check Mainfest have NinegorAppId", Toast.LENGTH_SHORT).show();
//                                    } catch (Exception e1) {
//                                        e.printStackTrace();
//                                    }
//                                    return;
//                                }
//                            }
////                            Logger.i("sdkNetApi error"+e.getMessage());
//                            if(e.getMessage().contains("Expected a string but was BEGIN_OBJECT at line 1 column 2 path $")){
//                                putSharedPrefsEditor(context).putBoolean(IS_REGISTER,true).putBoolean(IS_REGISTER_SUCCESS,true).commit();
////                                Logger.i("JsonSyntaxException");
//                            }
//                            if(e instanceof  SecurityException){
//                                if(e.getMessage().contains("READ_PHONE_STATE")){
//                                    try {
//                                        Toast.makeText(context, "检查下权限READ_PHONE_STATE ", Toast.LENGTH_SHORT).show();
//                                    } catch (Exception e1) {
//                                        e.printStackTrace();
//                                    }
//                                }
//                            }
//                        }
//
//                        @Override
//                        public void onNext(SDKResponse s) {
//                            if(s.isSuccess()){
//                                putSharedPrefsEditor(context).putBoolean(IS_REGISTER,true).putBoolean(IS_REGISTER_SUCCESS,true).commit();
//                            }
//
//                        }
//                    });
////                    Logger.i("sdkNetApi end");
//                }
//                //如果今天没有提交留存
//                if(!StringUtils.equals(prefs.getString(IS_TODAY_COMMIT,""),getToday())){
//                    //提交留存
//                    sdkNetApi.activateUseCase("2",getChannel(context)).subscribeOn(Schedulers.io()).subscribeOn(Schedulers.newThread()).subscribe(new Observer<SDKResponse>() {
//                        @Override
//                        public void onCompleted() {
//
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//                            if(e instanceof  SecurityException){
//                                if(e.getMessage().contains("READ_PHONE_STATE")){
//                                    try {
//                                        Toast.makeText(context, "检查下权限READ_PHONE_STATE ", Toast.LENGTH_SHORT).show();
//                                    } catch (Exception e1) {
//                                        e.printStackTrace();
//                                    }
//                                }
//                            }
//                        }
//
//                        @Override
//                        public void onNext(SDKResponse s) {
//                            if(s.isSuccess()){
//                                putSharedPrefsEditor(context).putString(IS_TODAY_COMMIT,getToday()).commit();
//                            }
//                        }
//                    });
//                }
//
//            }
//        }.start();
//
//    }

}
