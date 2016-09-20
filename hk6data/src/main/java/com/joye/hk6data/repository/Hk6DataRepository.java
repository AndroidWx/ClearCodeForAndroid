package com.joye.hk6data.repository;

import com.joye.hk6domain.entity.Hk6UiData;
import com.joye.hk6domain.repository.Hk6Repository;

import java.util.List;

import rx.Observable;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/20.
 * 304622254@qq.com
 * Remeark:
 */

public class Hk6DataRepository  implements Hk6Repository {

    @Override
    public Observable<List<Hk6UiData>> getHk6Data(String date) {
        return null;
    }
}
