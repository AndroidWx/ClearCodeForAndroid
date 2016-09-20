package com.joye.hk6data.cache.impl;

import com.joye.hk6data.entity.Hk6Entity;

import java.util.List;

import rx.Observable;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/20.
 * 304622254@qq.com
 * Remeark: 六合彩缓存规则
 */

public interface Hk6Cache {
    /**
     *
     * @param date 时间
     * @return 获取六合彩历史数据
     */
    Observable<List<Hk6Entity>> getHk6ListData(String date);

    /**
     * 存储六合彩历史数据
     * @param hk6EntityList
     */
    void put(List<Hk6Entity> hk6EntityList,String date);

    /**
     * Checks if an element (list<Hk6Entity></Hk6Entity>) exists in the cache.
     * @param date
     */
    boolean isCached(String date);

    /**
     * Checks if the cache is expired.
     *
     * @return true, the cache is expired, otherwise false.
     */
    boolean isExpired();

    /**
     * Evict all elements of the cache.
     */
    void evictAll();
}
