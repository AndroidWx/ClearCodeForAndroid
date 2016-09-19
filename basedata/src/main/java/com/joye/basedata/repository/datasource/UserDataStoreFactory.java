package com.joye.basedata.repository.datasource;

import android.content.Context;

import com.joye.basedata.cache.UserCache;
import com.joye.basedata.net.RestApi;
import com.joye.basedata.net.RestApiImpl;
import com.joye.basedomain.IUser;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

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
        RestApi restApi = new RestApiImpl(this.context);
        return new CloudUserDataStore(restApi, this.userCache);
    }
}
