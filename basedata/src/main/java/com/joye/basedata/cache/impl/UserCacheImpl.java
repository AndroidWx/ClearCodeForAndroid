package com.joye.basedata.cache.impl;

import android.content.Context;

import com.google.gson.Gson;
import com.joye.basedata.cache.CacheEvictor;
import com.joye.basedata.cache.CacheWriter;
import com.joye.basedata.cache.FileManager;
import com.joye.basedata.entity.UserEntity;
import com.joye.basedata.exception.UserNotFoundException;
import com.joye.basedomain.executor.ThreadExecutor;

import java.io.File;

import rx.Observable;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/20.
 * 304622254@qq.com
 * Remeark:
 */

public class UserCacheImpl implements UserCache {
    private final FileManager fileManager;
    private final Context context;
    private final File cacheDir;
    private static final String SETTINGS_FILE_NAME = "com.joye.basedata.SETTINGS";
    private static final String SETTINGS_KEY_LAST_CACHE_UPDATE = "last_cache_update";

    private static final String DEFAULT_FILE_NAME = "user_";
    private static final long EXPIRATION_TIME = 60 * 10 * 1000;
    private ThreadExecutor threadExecutor;

    public UserCacheImpl(FileManager fileManager, Context context, File cacheDir) {
        this.fileManager = fileManager;
        this.context = context;
        this.cacheDir = cacheDir;
    }

    @Override
    public Observable<UserEntity> get(int userId) {
        Observable.create(subscriber -> {
            File userEntityFile = UserCacheImpl.this.buildFile(userId);
            String fileContent = fileManager.readFileContent(userEntityFile);
            Gson gson = new Gson();
            UserEntity userEntity = gson.fromJson(fileContent, UserEntity.class);
            if(userEntity!=null){
                subscriber.onNext(userEntity);
                subscriber.onCompleted();
            }else{
                subscriber.onError(new UserNotFoundException());
            }
        });
        return null;
    }

    @Override
    public void put(UserEntity userEntity) {
        if (userEntity != null) {
            File userEntitiyFile = this.buildFile(userEntity.getUserId());
            if (!isCached(userEntity.getUserId())) {
                Gson gson=new Gson();

                String jsonString = gson.toJson(userEntity);
                this.executeAsynchronously(new CacheWriter(this.fileManager, userEntitiyFile,
                        jsonString));
                setLastCacheUpdateTimeMillis();
            }
        }
    }

    @Override
    public boolean isCached(int userId) {
        File userEntitiyFile = this.buildFile(userId);
        return this.fileManager.exists(userEntitiyFile);
    }

    @Override
    public boolean isExpired() {
        long currentTime = System.currentTimeMillis();
        long lastUpdateTime = this.getLastCacheUpdateTimeMillis();

        boolean expired = ((currentTime - lastUpdateTime) > EXPIRATION_TIME);

        if (expired) {
            this.evictAll();
        }

        return expired;
    }

    @Override
    public void evictAll() {
        this.executeAsynchronously(new CacheEvictor(this.fileManager, this.cacheDir));
    }
    /**
     * Executes a {@link Runnable} in another Thread.
     *
     * @param runnable {@link Runnable} to execute
     */
    private void executeAsynchronously(Runnable runnable) {
        this.threadExecutor.execute(runnable);
    }
    /**
     * Build a file, used to be inserted in the disk cache.
     *
     * @param userId The id user to build the file.
     * @return A valid file.
     */
    private File buildFile(int userId) {
        StringBuilder fileNameBuilder = new StringBuilder();
        fileNameBuilder.append(this.cacheDir.getPath());
        fileNameBuilder.append(File.separator);
        fileNameBuilder.append(DEFAULT_FILE_NAME);
        fileNameBuilder.append(userId);

        return new File(fileNameBuilder.toString());
    }
    /**
     * Set in millis, the last time the cache was accessed.
     */
    private void setLastCacheUpdateTimeMillis() {
        long currentMillis = System.currentTimeMillis();
        this.fileManager.writeToPreferences(this.context, SETTINGS_FILE_NAME,
                SETTINGS_KEY_LAST_CACHE_UPDATE, currentMillis);
    }

    /**
     * Get in millis, the last time the cache was accessed.
     */
    private long getLastCacheUpdateTimeMillis() {
        return this.fileManager.getFromPreferences(this.context, SETTINGS_FILE_NAME,
                SETTINGS_KEY_LAST_CACHE_UPDATE);
    }
}
