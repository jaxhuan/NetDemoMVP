package com.skyzone.netdemomvp.util.RxJava;

import com.skyzone.netdemomvp.data.Result;

import rx.functions.Action1;

/**
 * Created by Skyzone on 2/22/2017.
 */

public abstract class WebTrueActionUI<T extends Result> implements Action1<T> {

    @Override
    public void call(T t) {
        if (t.error)
            fail(t);
        else
            success(t);
    }

    public abstract void success(T t);

    public abstract void fail(T t);
}
