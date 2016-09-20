package com.joye.basedata.repository.datasource;

import com.joye.basedata.cache.impl.UserCache;
import com.joye.basedata.entity.UserEntity;
import com.joye.basedata.net.UserRestApi;

import java.util.List;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/18.
 * 304622254@qq.com
 * Remeark:
 */

public class CloudUserDataStore implements UserDataStore{
    private final UserRestApi userRestApi;
    private final UserCache userCache;
    private final Action1<UserEntity> saveToCacheAction = userEntity -> {
        if (userEntity != null) {
            CloudUserDataStore.this.userCache.put(userEntity);
        }
    };
    /**
     * Construct a {@link UserDataStore} based on connections to the api (Cloud).
     *
     * @param userRestApi The {@link UserRestApi} implementation to use.
     * @param userCache A {@link UserCache} to cache data retrieved from the api.
     */
    public CloudUserDataStore(UserRestApi userRestApi, UserCache userCache) {
        this.userRestApi = userRestApi;
        this.userCache = userCache;
    }

    @Override public Observable<List<UserEntity>> userEntityList() {
        return this.userRestApi.userEntityList();
    }

    @Override public Observable<UserEntity> userEntityDetails(final int userId) {
        return this.userRestApi.userEntityById(userId).doOnNext(saveToCacheAction);
    }

}

