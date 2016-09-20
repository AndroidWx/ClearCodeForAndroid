package com.joye.basedata.net;

import com.joye.basedata.entity.UserEntity;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/18.
 * 304622254@qq.com
 * Remeark:
 */

public interface UserRestApi {
//    String API_BASE_URL = "http://www.android10.org/myapi/";

    String CONTENT_TYPE_JSON_HEADER = "Content-Type: application/json; charset=utf-8";

    /**
     * Retrieves an {@link rx.Observable} which will emit a List of {@link UserEntity}.
     */
   @Headers(CONTENT_TYPE_JSON_HEADER)
    @GET("users.json")
    Observable<List<UserEntity>> userEntityList();

    /**
     * Retrieves an {@link rx.Observable} which will emit a {@link UserEntity}.
     *
     * @param userId The user id used to get user data.
     */
    @Headers(CONTENT_TYPE_JSON_HEADER)
    @GET("user_{id}.json")
    Observable<UserEntity> userEntityById(@Path("id") final int userId);
}

