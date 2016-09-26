package com.joye.basedomain.repository;

import com.joye.basedomain.User;

import java.util.List;

import rx.Observable;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/8.
 * 304622254@qq.com
 * Remeark: ”√ªß¥Ê¥¢ø‚πÊ∑∂
 *
 */

public interface UserRepository {
    /**
     * Get an {@link rx.Observable} which will emit a List of {@link User}.
     */
    Observable<List<User>> users();

    /**
     * Get an {@link rx.Observable} which will emit a {@link User}.
     *
     * @param userId The user id used to retrieve user data.
     */
    Observable<User> user(final int userId);
}
