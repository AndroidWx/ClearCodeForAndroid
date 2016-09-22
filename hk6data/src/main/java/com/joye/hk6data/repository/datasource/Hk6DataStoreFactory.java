package com.joye.hk6data.repository.datasource;

import android.content.Context;

import com.joye.hk6data.cache.impl.Hk6Cache;
import com.joye.hk6data.net.Hk6RestApiImpl;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/22.
 * 304622254@qq.com
 * Remeark:
 */
@Singleton
public class Hk6DataStoreFactory {
    private final Context context;
    private final Hk6Cache hk6Cache;
    @Inject
    public Hk6DataStoreFactory(Context context, Hk6Cache hk6Cache) {
        if(context==null ||hk6Cache==null){
            throw new IllegalArgumentException("Construtor parameters cannot be null!!!");
        }
        this.context = context;
        this.hk6Cache = hk6Cache;
    }

    public Hk6DataStore create(String date){
        Hk6DataStore hk6DataStore;
        //如果缓存了，并且没有过期
        if(hk6Cache.isCached(date)&&!hk6Cache.isExpired()){
            hk6DataStore=new DiskHk6DataStore(hk6Cache);
        }else{
            hk6DataStore=createCloutDataStore();
        }
        return hk6DataStore;
    }

    private Hk6DataStore createCloutDataStore() {
        return new CloudHk6DataStore(new Hk6RestApiImpl(this.context),this.hk6Cache);
    }
}
