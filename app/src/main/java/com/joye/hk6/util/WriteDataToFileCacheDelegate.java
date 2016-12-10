package com.joye.hk6.util;

import android.content.Context;

import com.google.common.reflect.TypeToken;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.hk6data.cache.impl.Hk6Cache;
import com.joye.hk6data.entity.Hk6DataSourceBean;
import com.joye.hk6data.entity.Hk6Entity;
import com.joye.hk6data.utils.GsonFactory;
import com.orhanobut.logger.Logger;

import net.nashlegend.anypref.AnyPref;
import net.nashlegend.anypref.SharedPrefs;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.Observer;
import rx.schedulers.Schedulers;

/**
 * Created by W,x (JoyeWang)
 * on 2016/11/5.
 * 304622254@qq.com
 * Remeark:
 */
@Singleton
public class WriteDataToFileCacheDelegate {
    public static final String[] overYears = new String[]{"1990.json", "1991.json", "1992.json", "1993.json", "1994.json", "1995.json", "1996.json", "1997.json",
            "1998.json", "1999.json", "2000.json", "2001.json", "2002.json", "2003.json",
            "2004.json", "2005.json", "2006.json", "2007.json", "2008.json", "2009.json", "2010.json", "2011.json", "2012.json", "2013.json", "2014.json", "2015.json","2016.json"};
    public final Hk6Cache hk6Cache;
    public final  Context context;
    public final  ThreadExecutor mJobExecutor;
    @Inject
    public WriteDataToFileCacheDelegate(Hk6Cache hk6Cache, Context context, ThreadExecutor mJobExecutor){
        this.hk6Cache = hk6Cache;
        this.context = context;
        this.mJobExecutor = mJobExecutor;
    }
    public static TypeToken<Hk6DataSourceBean> typeToken = new TypeToken<Hk6DataSourceBean>() {
    };

    public void wirteData() {
        final SharedPrefs prefs = AnyPref.getPrefs(SharedPreferenceHelp.class);
        Observable.from(overYears).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Logger.e("判断是否需要缓存失败",e);
            }

            @Override
            public void onNext(String s) {
                if(!hk6Cache.isCached(s.substring(0,4))){
                    prefs.beginTransaction().putBoolean("needCacheToFile",true).putBoolean("CacheToFileFetchDataSuccess",false).commit();
                }
            }
        });


        //是否需要缓存到文件  并且 缓存文件失败
        if (prefs.getBoolean("needCacheToFile", true)&&!prefs.getBoolean("CacheToFileFetchDataSuccess",false)) {
            Observable.from(overYears).subscribeOn(Schedulers.from(mJobExecutor)).observeOn(Schedulers.from(mJobExecutor)).subscribe(new Observer<String>() {
                @Override
                public void onCompleted() {
                    Logger.i("load all cache completed ");
                    prefs.beginTransaction().putBoolean("CacheToFileFetchDataSuccess", true).putBoolean("needCacheToFile",false).commit();
                }

                @Override
                public void onError(Throwable e) {
                    Logger.e(e.getMessage());
                    prefs.beginTransaction().putBoolean("CacheToFileFetchDataSuccess", false).putBoolean("needCacheToFile",true).commit();
                }
                @Override
                public void onNext(String s) {
                    String josn = Helper.readAssertResource(context, s);
                    List<Hk6Entity> retHk6Entitys = new ArrayList();
                    Hk6Entity item;
                    for (Hk6DataSourceBean.DataBean dataBean : Hk6DataSourceBean.class.cast(GsonFactory.SingleTon.create().fromJson(josn, typeToken.getType())).getData()) {
                        item = new Hk6Entity();
                        item.setValueFormSource(dataBean);
                        retHk6Entitys.add(item);
                    }
                    hk6Cache.put(retHk6Entitys, s.substring(0, 4));
                }
            });
        }

    }

}
