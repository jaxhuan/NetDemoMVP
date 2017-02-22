package com.skyzone.netdemomvp.util.RxJava;

import rx.functions.Action1;

/**
 * Created by Skyzone on 11/10/2016.
 */
public abstract class WebErrorActionUI implements Action1<Throwable> {

    @Override
    public void call(Throwable throwable) {
        onFailed(ResponseError.handle(throwable));
    }

    public abstract void onFailed(ResponseError error);
}
