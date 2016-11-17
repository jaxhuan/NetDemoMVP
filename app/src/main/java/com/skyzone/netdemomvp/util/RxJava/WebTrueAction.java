package com.skyzone.netdemomvp.util.RxJava;


import com.skyzone.netdemomvp.data.Result;

import rx.functions.Action1;

/**
 * Created by Skyzone on 11/10/2016.
 */
public abstract class WebTrueAction<T extends Result> implements Action1<T> {

    @Override
    public void call(T t) {
        if (t.error)
            throw new ResultCodeError("result err");
        onSuccess(t);
    }

    public abstract void onSuccess(T t);

//    class ResultCodeError extends RuntimeException {
//
//        public ResultCodeError(String detailMessage) {
//            super(detailMessage);
//        }
//    }
}
