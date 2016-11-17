package com.skyzone.netdemomvp;

/**
 * Created by Skyzone on 10/31/2016.
 */
public interface BaseView<T> {

    void setPresenter(T presenter);

    void showLoading(boolean loading);
}
