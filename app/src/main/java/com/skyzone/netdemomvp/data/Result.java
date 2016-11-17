package com.skyzone.netdemomvp.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Skyzone on 11/4/2016.
 */
public class Result<T> {

    @SerializedName(value = "error")
    public boolean error;

    @SerializedName(value = "results")
    public T results;
}
