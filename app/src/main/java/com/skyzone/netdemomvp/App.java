package com.skyzone.netdemomvp;

import android.app.Application;
import android.content.Context;

import com.skyzone.netdemomvp.util.Toasts;

/**
 * Created by Skyzone on 11/3/2016.
 */
public class App extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext = this;
        Toasts.register(mContext);
    }
}
