package com.ninegor.sdk.net;

import android.content.Context;

import com.joye.basedata.net.BaseRestApiImpl;
import com.ninegor.sdk.NinegorManager;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by joye on 2017/1/17.
 */

public class SdkNetApiImpl extends BaseRestApiImpl<SdkNetApi> implements  SdkNetApi {
    /**
     * Constructor of the class
     *
     * @param context {@link Context}.
     */
    public SdkNetApiImpl(Context context) {
        super(context);
    }

    @Override
    protected List<Interceptor> getListInterceptors() {
        List<Interceptor>interceptors=super.getListInterceptors();
        interceptors.add(appIdIMEIInterceptor);
        return interceptors;
    }

    private final Interceptor appIdIMEIInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            HttpUrl.Builder builder = chain.request().url()
                    .newBuilder()
                    .setEncodedQueryParameter("IMEI", NinegorManager.getIMEI(getContext()))
                    .setEncodedQueryParameter("appId", NinegorManager.getAppId(getContext()));
            request = request.newBuilder().url(builder.build()).build();
            Response response = chain.proceed(request);
            return response;
        }
    };

//
//    @Override
//    public Observable<String> activateUseCase() {
//        return create().activateUseCase();
//    }

    @Override
    public Observable<String> activateUseCase(@Query(TOKEN) String token, @Query(CODE) String code, @Query(DATE) String date, @Query(FORMAT) String format) {
        return create().activateUseCase(token,code,date,format);
    }

    @Override
    public Observable<String> retentionRateUseCase(String date) {
        return create().retentionRateUseCase(date);
    }

    @Override
    protected String BaseUrl() {
        return "http://c.apiplus.cn/";
    }

    @Override
    protected Class<SdkNetApi> getApiClass() {
        return SdkNetApi.class;
    }
}
