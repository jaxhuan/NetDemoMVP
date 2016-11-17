package com.skyzone.netdemomvp;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Skyzone on 11/3/2016.
 */
public class DemoRetrofit {

    protected static final Object monitor = new Object();

    private static final int time_out = 10;

    static DemoApi mDemoApi;

    private static HttpLoggingInterceptor mLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE);


    private static OkHttpClient client = new OkHttpClient.Builder().connectTimeout(time_out, TimeUnit.SECONDS)
            .writeTimeout(time_out, TimeUnit.SECONDS)
            .readTimeout(time_out, TimeUnit.SECONDS)
            .addInterceptor(mLoggingInterceptor)
            .build();


    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://gank.io/api/")
            .client(client)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static DemoApi getDemoApiInstance() {
        synchronized (monitor) {
            if (null == mDemoApi)
                mDemoApi = retrofit.create(DemoApi.class);
            return mDemoApi;
        }
    }
}
