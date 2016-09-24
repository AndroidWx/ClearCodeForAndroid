package com.joye.hk6data.net;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/20.
 * 304622254@qq.com
 * Remeark:彩票数据api
 */

public class BaseApiConstants {
    /**
     * 令牌
     */
    public static final  String TOKEN="token";

    /**
     * 代码
     */
    public static final String CODE="code";

    /**
     * 时间
     */
    public static final  String DATE="date";

    /**
     * 转换格式
     */
    public static final   String FORMAT="format";
    /**
     * json 格式
     */
    public static final   String FORMAT_JSON = "json";
    /**
     * XML 格式
     */
    public static final  String  FORMAT_XML ="xml";

    @StringDef({FORMAT_JSON,FORMAT_XML})
    @Retention(RetentionPolicy.SOURCE)
    @interface FORMAT_THEME {

    }
}
