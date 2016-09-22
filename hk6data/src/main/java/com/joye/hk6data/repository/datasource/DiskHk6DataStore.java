package com.joye.hk6data.repository.datasource;

import com.joye.hk6data.cache.impl.Hk6Cache;
import com.joye.hk6data.entity.Hk6Entity;

import java.util.List;

import rx.Observable;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/20.
 * 304622254@qq.com
 * Remeark: 香港六合彩文件存储库
 */

public class DiskHk6DataStore implements Hk6DataStore {
    private final Hk6Cache hk6Cache;

    public DiskHk6DataStore(Hk6Cache hk6Cache) {
        this.hk6Cache = hk6Cache;
    }

    @Override
    public Observable<List<Hk6Entity>> getHk6ListData(String date) {
        return  hk6Cache.getHk6ListData(date);
    }
}
