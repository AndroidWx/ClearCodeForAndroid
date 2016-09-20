package com.joye.hk6domain.repository;

import com.joye.hk6domain.entity.Hk6UiData;

import java.util.List;

import rx.Observable;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/20.
 * 304622254@qq.com
 * Remeark:
 */

public interface Hk6Repository {
    /**
     *
     * @param date 截止时间
     * @return 获取六合彩数据
     */
    Observable<List<Hk6UiData>> getHk6Data(String date);
}
