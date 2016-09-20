package com.joye.basedata.repository.datasource;

import com.joye.basedata.entity.UserEntity;
import com.joye.basedomain.IUser;

import java.util.List;

import rx.Observable;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/18.
 * 304622254@qq.com
 * Remeark: 用户数据库的函数
 */

public interface UserDataStore {
    /**
     * Get an {@link rx.Observable} which will emit a List of {@link UserEntity}.
     */
    Observable<List<UserEntity>> userEntityList();

    /**
     * Get an {@link rx.Observable} which will emit a {@link UserEntity} by its id.
     *
     * @param userId The id to retrieve user data.
     */
    Observable<UserEntity> userEntityDetails(final int userId);
}
