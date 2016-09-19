package com.joye.basedata.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.joye.basedata.BuildConfig;
import com.joye.basedata.entity.UserEntity;
import com.joye.basedata.exception.NetworkConnectionException;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/18.
 * 304622254@qq.com
 * Remeark:
 */

public class RestApiImpl implements RestApi {

    private final Context context;

    private static OkHttpClient okHttpClient;

    /**
     * Constructor of the class
     *
     * @param context {@link android.content.Context}.
     */
    public RestApiImpl(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }
        this.context = context.getApplicationContext();
    }

    @Override public Observable<List<UserEntity>> userEntityList() {
        return isThereInternetConnection() ?
                getRetrofit().create(RestApi.class).userEntityList() :
                Observable.error(new NetworkConnectionException());
    }

    @Override public Observable<UserEntity> userEntityById(final int userId) {
        return isThereInternetConnection() ?
                getRetrofit().create(RestApi.class).userEntityById(userId) :
                Observable.error(new NetworkConnectionException());
    }
    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(getOkHttpClient())
                .build();
    }
    private OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder().readTimeout(10000, TimeUnit.MILLISECONDS).connectTimeout(15000, TimeUnit.MILLISECONDS).build();
        }
        return okHttpClient;
    }

    /**
     * Checks if the device has any active internet connection.
     *
     * @return true device with internet connection, otherwise false.
     */
    private boolean isThereInternetConnection() {
        boolean isConnected;

        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());
        return isConnected;
    }
}
