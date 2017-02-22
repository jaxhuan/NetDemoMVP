package com.skyzone.netdemomvp;

import com.elvishew.xlog.XLog;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Skyzone on 11/22/2016.
 */
public enum RetrofitWrapper {

    Instance;

    private DemoApi mDemoApi;

    private OkHttpClient client;
    private Retrofit retrofit;

    protected static final int time_out = 10;


    RetrofitWrapper() {
        XLog.d("RetrofitWrapper Constructor");
        initClient();
        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_SERVER_URL)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mDemoApi = retrofit.create(DemoApi.class);
    }

    private void initClient() {

        //打印网络请求日志
        HttpLoggingInterceptor mLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS);
        client = new OkHttpClient.Builder().connectTimeout(time_out, TimeUnit.SECONDS)
                .writeTimeout(time_out, TimeUnit.SECONDS)
                .readTimeout(time_out, TimeUnit.SECONDS)
                .addInterceptor(mLoggingInterceptor)
                .addInterceptor(new HttpTokenInterceptor())
                .build();
    }

    public DemoApi getDemoApi() {
        return mDemoApi;
    }
}
