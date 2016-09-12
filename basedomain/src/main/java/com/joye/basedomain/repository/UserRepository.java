package com.joye.basedomain.repository;

import com.joye.basedomain.IUser;

import rx.Observer;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/8.
 * 304622254@qq.com
 * Remeark: 用户存储库规范
 *
 */

public interface UserRepository {
    Observer<IUser> user();
}
