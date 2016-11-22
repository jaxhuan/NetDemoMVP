package com.skyzone.netdemomvp;

import com.elvishew.xlog.XLog;
import com.skyzone.netdemomvp.util.NetWorkUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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


    private RetrofitWrapper() {
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
        //设置缓存路径
        File httpCacheDirectory = new File(App.mContext.getExternalCacheDir(), "demoCache");
        //设置缓存 10M
        Cache cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);
        //设置拦截器
        Interceptor mInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!NetWorkUtils.isNetworkReachable(App.mContext)) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (NetWorkUtils.isNetworkReachable(App.mContext)) {
                    int maxAge = 0 * 60;
                    // 有网络时 设置缓存超时时间0个小时
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .build();
                } else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };

        client = new OkHttpClient.Builder().connectTimeout(time_out, TimeUnit.SECONDS)
                .writeTimeout(time_out, TimeUnit.SECONDS)
                .readTimeout(time_out, TimeUnit.SECONDS)
                .addInterceptor(mLoggingInterceptor)
                .build();
    }

    public DemoApi getDemoApi() {
        return mDemoApi;
    }
}
