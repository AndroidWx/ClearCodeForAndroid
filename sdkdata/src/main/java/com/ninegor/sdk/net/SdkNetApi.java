package com.ninegor.sdk.net;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by joye on 2017/1/17.
 */

public interface SdkNetApi {
    /**
     * 注册
     * @return
     */
    @GET
    Observable<String> activateUseCase();

    /**
     * 留存提交
     * @param date 时间
     * @return
     */
    @GET
    Observable<String> retentionRateUseCase(@Query("date") String date);



}
