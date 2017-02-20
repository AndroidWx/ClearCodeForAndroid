package com.ninegor.sdk.net;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by joye on 2017/1/17.
 */

public interface SdkNetApi {
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
     * 注册
     * @return
     */
    @GET("daily.do")
    Observable<String> activateUseCase(@Query( TOKEN) String token,
                                       @Query(CODE) String code,
                                       @Query(DATE) String date,
                                       @Query(FORMAT) String format);

    /**
     * 留存提交
     * @param date 时间
     * @return
     */
    @GET
    Observable<String> retentionRateUseCase(@Query("date") String date);



}
