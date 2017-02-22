package com.skyzone.netdemomvp;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Skyzone on 2/22/2017.
 */

public class HttpTokenInterceptor implements Interceptor {

    private volatile String TOKEN = "demo_token";

    public HttpTokenInterceptor() {
    }

    public void setTOKEN(String TOKEN) {
        this.TOKEN = TOKEN;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        //set default Auth
        Headers headers = request.headers();
        Headers.Builder builder = new Headers.Builder();
        builder.add("Auth-Type", "No");
        for (String name : headers.names()) {
            if (!name.equals("Auth-Type")) {
                builder.add(name, headers.get(name));
            } else {
                builder.set(name, headers.get(name));
            }
        }
        //set url add token
        HttpUrl.Builder builder_url = request.url()
                .newBuilder();
        if ("Token".equals(headers.get("Auth-Type"))) {
            builder_url.addQueryParameter("token", TOKEN);
        }

        Request newRequest = request.newBuilder()
                .url(builder_url.build())
                .headers(builder.build())
                .build();
        return chain.proceed(newRequest);
    }
}
