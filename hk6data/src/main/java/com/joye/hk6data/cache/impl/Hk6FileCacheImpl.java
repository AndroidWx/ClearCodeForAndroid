package com.joye.hk6data.cache.impl;

import android.content.Context;

import com.google.gson.reflect.TypeToken;
import com.joye.basedata.cache.CacheEvictor;
import com.joye.basedata.cache.CacheWriter;
import com.joye.basedata.cache.FileManager;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.hk6data.entity.Hk6Entity;
import com.joye.hk6data.utils.CollectionUtils;
import com.joye.hk6data.utils.GsonFactory;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/20.
 * 304622254@qq.com
 * Remeark:六合彩数据文件存储
 */
@Singleton
public class Hk6FileCacheImpl implements Hk6Cache {
    private static final String DEFAULT_FILE_NAME = "com.joye.hk6data.hk6cache";
    private static final String SETTINGS_KEY_LAST_CACHE_UPDATE = "last_cache_update";
    //与上期开奖时期的opentimestamp间隔两天 10分钟就去拿开奖数去
    private static final long EXPIRATION_TIME = 60 * 60 * 48-800;
    private final  FileManager fileManager;
    private final File cacheDir;
    private final Context context;
    private final ThreadExecutor threadExecutor;
    private static final TypeToken<List<Hk6Entity>> typeToken=new TypeToken<List<Hk6Entity>>(){} ;
    @Inject
    public Hk6FileCacheImpl(FileManager fileManager , Context context, ThreadExecutor threadExecutor) {
        this.fileManager = fileManager;
        this.context = context;
        this.cacheDir = this.context.getCacheDir();
        this.threadExecutor = threadExecutor;
    }

    @Override
    public Observable<List<Hk6Entity>> getHk6ListData(String date) {
        return Observable.create(subscriber -> {
            File file=buildFile(date);
            String fileContent=fileManager.readFileContent(file);
            List<Hk6Entity> dataList= GsonFactory.SingleTon.create().fromJson(fileContent,typeToken.getType());
            if(!CollectionUtils.isEmpty(dataList)){
                subscriber.onNext(dataList);
                subscriber.onCompleted();
            }else{
                subscriber.onError(new NullPointerException());
            }

        });
    }

    @Override
    public void put(List<Hk6Entity> hk6EntityList,String date) {
        if(CollectionUtils.isEmpty(hk6EntityList)){
            return;
        }
        File hk6EntityListFile=this.buildFile(date);
        if(!isCached(date)){
            String jsonContent=GsonFactory.SingleTon.create().toJson(hk6EntityList,typeToken.getType());
            this.executeAsynchronously(new CacheWriter(fileManager,hk6EntityListFile,jsonContent));
            setLastCacheUpdateTimeMillis( hk6EntityList.get(0).getOpentimestamp());
        }

    }

    @Override
    public boolean isCached(String date) {
        File userEntitiyFile = this.buildFile(date);
        return this.fileManager.exists(userEntitiyFile);
    }

    @Override
    public boolean isExpired() {
        long currentTime = System.currentTimeMillis()/1000;
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
     * Build a file, used to be inserted in the disk cache.
     *
     * @param date The date   to build the file.
     * @return A valid file.
     */
    private File buildFile(String date) {
        date=date.substring(0,4);
        StringBuilder fileNameBuilder = new StringBuilder();
        fileNameBuilder.append(this.cacheDir.getPath());
        fileNameBuilder.append(File.separator);
        fileNameBuilder.append(DEFAULT_FILE_NAME);
        fileNameBuilder.append(date);

        return new File(fileNameBuilder.toString());
    }
    /**
     * Get in millis, the last time the cache was accessed.
     */
    private long getLastCacheUpdateTimeMillis() {
        return this.fileManager.getFromPreferences(this.context, DEFAULT_FILE_NAME,
                SETTINGS_KEY_LAST_CACHE_UPDATE);
    }

    /**
     * Set in millis, the last time the cache was accessed.
     * @param currentMillis
     */
    private void setLastCacheUpdateTimeMillis(long currentMillis) {
        this.fileManager.writeToPreferences(this.context, DEFAULT_FILE_NAME,
                SETTINGS_KEY_LAST_CACHE_UPDATE, currentMillis);
    }

    /**
     * Executes a {@link Runnable} in another Thread.
     *
     * @param runnable {@link Runnable} to execute
     */
    private void executeAsynchronously(Runnable runnable) {
        this.threadExecutor.execute(runnable);
    }

}
