package com.joye.basedata.repository.datasource;

import android.content.Context;

import com.joye.basedata.cache.impl.UserCache;
import com.joye.basedata.net.UserRestApi;
import com.joye.basedata.net.BaseRestApiImpl;
import com.joye.basedata.net.UserRestApiImpl;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/19.
 * 304622254@qq.com
 * Remeark:
 */
@Singleton
public class UserDataStoreFactory  {
    private final Context context;
    private final UserCache userCache;
    @Inject
    public UserDataStoreFactory(Context context, UserCache userCache) {
        if (context == null || userCache == null) {
            throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
        }
        this.context = context;
        this.userCache = userCache;
    }
    /**
     * Create {@link UserDataStore} from a user id.
     */
    public UserDataStore create(int userId) {
        UserDataStore userDataStore;

        if (!this.userCache.isExpired() && this.userCache.isCached(userId)) {
            userDataStore = new DiskUserDataStore(this.userCache);
        } else {
            userDataStore = createCloudDataStore();
        }

        return userDataStore;
    }

    /**
     * Create {@link UserDataStore} to retrieve data from the Cloud.
     */
    public UserDataStore createCloudDataStore() {
        UserRestApi userRestApi = new UserRestApiImpl(this.context);
        return new CloudUserDataStore(userRestApi, this.userCache);
    }
}
