package com.skyzone.netdemomvp.util.RxJava;


import com.skyzone.netdemomvp.data.Result;

import rx.functions.Action1;

/**
 * Created by Skyzone on 11/10/2016.
 */
public abstract class WebTrueAction<T extends Result> implements Action1<T> {

    @Override
    public void call(T t) {
        onSuccess(t);
    }

    public abstract void onSuccess(T t);
}
