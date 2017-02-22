package com.skyzone.netdemomvp.util.RxJava;

import com.google.gson.JsonParseException;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by Skyzone on 2/22/2017.
 */

public class ResponseError {

    public static final int HTTP_SERVER_ERROR = 1;
    public static final int HTTP_NO_NETWORK = 2;
    public static final int HTTP_UNKNOWN_ERROR = 3;

    public int status;
    public String message;

    public ResponseError(int status, String message) {
        this.status = status;
        this.message = message;
    }

    //处理异常
    public static ResponseError handle(Throwable throwable) {
        ResponseError error = null;
        if (throwable instanceof HttpException) {
            HttpException exception = (HttpException) throwable;
            try {
                error = new ResponseError(exception.code(), exception.message());
            } catch (Exception e) {
                if (e instanceof JsonParseException)
                    error = new ResponseError(HTTP_SERVER_ERROR, "服务器出错");
                else
                    error = new ResponseError(HTTP_UNKNOWN_ERROR, "未知错误");
            }
        } else if (throwable instanceof IOException) {
            error = new ResponseError(HTTP_NO_NETWORK, "请检查网络");
        } else {
            error = new ResponseError(HTTP_UNKNOWN_ERROR, "未知错误");
        }
        return error;
    }

}
