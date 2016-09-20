package com.joye.basedata.net;

import android.content.Context;

import com.joye.basedata.entity.UserEntity;
import com.joye.basedata.exception.NetworkConnectionException;

import java.util.List;

import rx.Observable;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/20.
 * 304622254@qq.com
 * Remeark:
 */

public class UserRestApiImpl extends BaseRestApiImpl<UserRestApi> implements UserRestApi {
    /**
     * Constructor of the class
     *
     * @param context {@link Context}.
     */
    public UserRestApiImpl(Context context) {
        super(context);
    }

    @Override
    protected Class<UserRestApi> getApiClass() {
        return UserRestApi.class;
    }

    @Override public Observable<List<UserEntity>> userEntityList() {
        return isThereInternetConnection() ?
                create().userEntityList() :
                Observable.error(new NetworkConnectionException());
    }

    @Override public Observable<UserEntity> userEntityById(final int userId) {
        return isThereInternetConnection() ?
                create().userEntityById(userId) :
                Observable.error(new NetworkConnectionException());
    }
}
