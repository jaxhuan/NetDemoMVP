package com.skyzone.netdemomvp.util.RxJava;

import com.skyzone.netdemomvp.util.Toasts;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;
import rx.functions.Action1;

/**
 * Created by Skyzone on 11/10/2016.
 */
public class WebFalseAction implements Action1<Throwable> {

    @Override
    public void call(Throwable throwable) {
        String errorMsg = "";
        if (throwable instanceof IOException) {
            errorMsg = "Please check your network status";
        } else if (throwable instanceof HttpException) {
            HttpException httpException = (HttpException) throwable;
            // such as: "server internal error".
            errorMsg = httpException.response().message();
        } else {
            errorMsg = "unknown error";
        }
        Toasts.showShort(errorMsg);
    }
}
