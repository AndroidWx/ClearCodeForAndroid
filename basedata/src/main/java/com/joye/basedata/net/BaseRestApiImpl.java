package com.joye.basedata.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.joye.basedata.BuildConfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/18.
 * 304622254@qq.com
 * Remeark:
 */

public abstract  class BaseRestApiImpl<API>   {
    public static final String TAG="BaseRestApiImpl";
    private   Context context;
    public Context getContext(){
        return  context;
    }
    private static OkHttpClient okHttpClient;
    /**
     * 响应超时
     */
    private static final int OkHttpReadTimeoutInt=10000;

    /**
     * 链接超时
     */

    private static final int OkHttpConnectTimeout=15000;

    public BaseRestApiImpl(){
    }

    /**
     * Constructor of the class
     *
     * @param context {@link android.content.Context}.
     */

    public BaseRestApiImpl(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }
        this.context = context.getApplicationContext();
    }


    protected String BaseUrl(){
        return BuildConfig.BASE_URL;
    }

    protected int okHttpReadTimeout(){
        return OkHttpReadTimeoutInt;
    }

    protected int okHttpConnectTimeout(){
        return OkHttpConnectTimeout;
    }

    protected abstract Class<API> getApiClass();

    private final Interceptor LoggingInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            long t1 = System.nanoTime();
//            Logger.t(TAG).i(String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()));
//            Logger.t(TAG).d(request);
            Response response = chain.proceed(request);
            long t2 = System.nanoTime();
//            Logger.t(TAG).i(String.format("Received response for %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, response.code()));
//            Logger.t(TAG).d(response);
//            Logger.t(TAG).i(response.body().toString());
            return response;
        }
    };

    protected Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(getOkHttpClient())
                .build();
    }
    private OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            OkHttpClient.Builder builder=new OkHttpClient.Builder().
                    readTimeout(okHttpReadTimeout(), TimeUnit.MILLISECONDS).
                    connectTimeout(okHttpConnectTimeout(), TimeUnit.MILLISECONDS);
            List<Interceptor> interceptors=getListInterceptors();
            if(interceptors!=null &&interceptors.size()>0){
                for (Interceptor item:interceptors){
                    builder.addInterceptor(item);
                }
            }
            if(BuildConfig.DEBUG) {
                builder.addInterceptor(LoggingInterceptor);
            }
            return builder.build();
        }
        return okHttpClient;
    }

    protected List<Interceptor> getListInterceptors(){
        List<Interceptor> datas=new ArrayList<>();
        return datas;
    }


    /**
     * Checks if the device has any active internet connection.
     *
     * @return true device with internet connection, otherwise false.
     */
    protected boolean isThereInternetConnection() {
        boolean isConnected;

        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());
        return isConnected;
    }

   public  <T extends API> API create(){
      return getRetrofit().create(getApiClass());
   }

}
