package com.joye.basedata.repository;

import com.joye.basedata.entity.mapper.UserEntityDataMapper;
import com.joye.basedata.repository.datasource.UserDataStore;
import com.joye.basedata.repository.datasource.UserDataStoreFactory;
import com.joye.basedomain.User;
import com.joye.basedomain.repository.UserRepository;

import java.util.List;

import rx.Observable;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/18.
 * 304622254@qq.com
 * Remeark: 用户信息仓库
 */

public class UserDataRepository implements UserRepository{

    private final UserDataStoreFactory userDataStoreFactory;
    private final UserEntityDataMapper userEntityDataMapper;
    public UserDataRepository(UserDataStoreFactory userDataStoreFactory, UserEntityDataMapper userEntityDataMapper) {
        this.userDataStoreFactory = userDataStoreFactory;
        this.userEntityDataMapper = userEntityDataMapper;
    }

    @Override
    public Observable<List<User>> users() {
        UserDataStore userDataStore=this.userDataStoreFactory.createCloudDataStore();
        return userDataStore.userEntityList().map(userEntities -> this.userEntityDataMapper.transform(userEntities));
    }
    @SuppressWarnings("Convert2MethodRef")
    @Override
    public Observable<User> user(int userId) {
        final UserDataStore userDataStore = this.userDataStoreFactory.create(userId);
        return userDataStore.userEntityDetails(userId).map(userEntity -> this.userEntityDataMapper.transform(userEntity));
    }


}
