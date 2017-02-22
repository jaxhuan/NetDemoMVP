package com.skyzone.netdemomvp.ServiceDemo;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.annotation.Nullable;

import com.skyzone.netdemomvp.util.Toasts;

/**
 * Created by Skyzone on 2/20/2017.
 */

public class ServiceAsSameAsIntentService extends Service {

    private Looper mLooper;
    private ServiceHandler mServiceHandler;

    private final class ServiceHandler extends Handler {

        public ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stopSelf(msg.arg1);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();

        HandlerThread mThread = new HandlerThread("service_handler_thread", Process.THREAD_PRIORITY_BACKGROUND);
        mThread.start();
        mLooper = mThread.getLooper();
        mServiceHandler = new ServiceHandler(mLooper);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toasts.showLong("service is start...");

        Message msg = mServiceHandler.obtainMessage();
        msg.arg1 = startId;
        mServiceHandler.sendMessage(msg);

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Toasts.showLong("service is destroy");
    }
}
