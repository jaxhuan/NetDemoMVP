package com.skyzone.netdemomvp.util.RxJava;

import com.skyzone.netdemomvp.util.Toasts;

import rx.functions.Action1;

/**
 * Created by Skyzone on 11/10/2016.
 */
public class WebErrorAction implements Action1<Throwable> {

    @Override
    public void call(Throwable throwable) {
        ResponseError error = ResponseError.handle(throwable);
        Toasts.showShort(error.status + ":" + error.message);
    }
}
