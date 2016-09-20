package com.joye.hk6data.repository.datasource;

import com.joye.hk6data.entity.Hk6Entity;

import java.util.List;

import rx.Observable;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/20.
 * 304622254@qq.com
 * Remeark:
 */

public interface Hk6DataStore {
    /**
     *
     * @param date 时间
     * @return 获取香港六合彩数据
     */
    Observable<List<Hk6Entity>> getHk6ListData(String date);
}
