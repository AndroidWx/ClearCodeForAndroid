package com.ninegor.sdk.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;

/**
 * Created by joye on 2017/1/17.
 * 获取manifestMeta数据类
 */

public class AndroidMetaDataUtil {
    public static String getApplicationMetaData(Context context,String metaKey)
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

    public static int getActivityMetaData(Activity context, String metaKey)
    {
        try {
            ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(context.getComponentName(),
                    PackageManager.GET_META_DATA);
            // 获取到的是 @string/ice 对应的资源id值
            return activityInfo.metaData.getInt(metaKey);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static String getRecevierMetaData(Context context,Class targetClass ,String metaKey)
    {
        try {
            ComponentName cn=new ComponentName(context, targetClass);
            ActivityInfo info=context.getPackageManager()
                    .getReceiverInfo(cn, PackageManager.GET_META_DATA);
            return info.metaData.getString(metaKey);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String getServiceMetaData(Context context,Class targetClass ,String metaKey)
    {
        try {
            ComponentName cn=new ComponentName(context, targetClass);
            ServiceInfo info=context.getPackageManager()
                    .getServiceInfo(cn, PackageManager.GET_META_DATA);
            return info.metaData.getString(metaKey);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }






}
