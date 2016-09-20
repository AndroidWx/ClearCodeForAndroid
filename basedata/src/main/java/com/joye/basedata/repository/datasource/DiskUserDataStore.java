package com.joye.basedata.repository.datasource;

import com.joye.basedata.cache.impl.UserCache;
import com.joye.basedata.entity.UserEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/19.
 * 304622254@qq.com
 * Remeark:
 */

public class DiskUserDataStore implements UserDataStore {
    private final UserCache userCache;

    public DiskUserDataStore(UserCache userCache) {
        this.userCache = userCache;
    }

    @Override
    public Observable<List<UserEntity>> userEntityList() {
        throw new UnsupportedOperationException("Operation is not available!!!");
    }

    @Override
    public Observable<UserEntity> userEntityDetails(int userId) {
        return this.userCache.get(userId);
    }
}
