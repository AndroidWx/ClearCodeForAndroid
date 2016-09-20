package com.joye.basedata.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.joye.basedata.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
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

    private final Context context;

    private static OkHttpClient okHttpClient;
    /**
     * 响应超时
     */
    private static final int OkHttpReadTimeoutInt=10000;

    /**
     * 链接超时
     */
    private static final int OkHttpConnectTimeout=15000;
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
            okHttpClient = new OkHttpClient.Builder().readTimeout(okHttpReadTimeout(), TimeUnit.MILLISECONDS).connectTimeout(okHttpConnectTimeout(), TimeUnit.MILLISECONDS).build();
        }
        return okHttpClient;
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
