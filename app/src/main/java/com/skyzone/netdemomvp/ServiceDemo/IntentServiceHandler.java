package com.skyzone.netdemomvp.ServiceDemo;

import android.app.IntentService;
import android.content.Intent;

/**
 * IntentService创建一个独立的工作线程，并维护其中的工作队列，完成之后自动停止，因此不用担心ANR,也不用
 *
 * Created by Skyzone on 2/20/2017.
 */

public class IntentServiceHandler extends IntentService {

    public IntentServiceHandler(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //do something my modify
        return super.onStartCommand(intent, flags, startId);
    }
}
