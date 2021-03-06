package com.joye.hk6data.net;

import android.content.Context;

import com.joye.basedata.net.BaseRestApiImpl;
import com.joye.hk6data.BuildConfig;
import com.joye.hk6data.entity.Hk6DataSourceBean;

import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/20.
 * 304622254@qq.com
 * Remeark:六合彩接口请求实现
 */

public class Hk6RestApiImpl extends BaseRestApiImpl<Hk6RestApi>implements Hk6RestApi {
    /**
     * Constructor of the class
     *
     * @param context {@link Context}.
     */
    public Hk6RestApiImpl(Context context) {
        super(context);
    }

    @Override
    public Observable<Hk6DataSourceBean> getHk6ListData(@Query(BaseApiConstants.TOKEN) String token, @Query(BaseApiConstants.CODE) String code, @Query(BaseApiConstants.DATE) String date, @BaseApiConstants.FORMAT_THEME @Query(BaseApiConstants.FORMAT) String format) {
        return create().getHk6ListData(token,code,date, BaseApiConstants.FORMAT_JSON);
    }

    @Override
    protected Class<Hk6RestApi> getApiClass() {
        return Hk6RestApi.class;
    }

    @Override
    protected String BaseUrl() {
        return BuildConfig.API_URL;
    }
}
