package com.ninegor.sdk.net;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by joye on 2017/1/17.
 */

public interface SdkNetApi {
    /**
     * 令牌
     */
    String ACTION ="action";

    /**
     * 代码
     */
    String CHANNEL ="channel";


    /**
     *
     * 激活留存
     *
     * @param action 1 激活 2留存
     * @param channel 平台号
     * @return
     */
    @POST("get_active")
    Observable<SDKResponse> activateUseCase(@Query(ACTION) String action,
                                            @Query(CHANNEL) String channel);





}
