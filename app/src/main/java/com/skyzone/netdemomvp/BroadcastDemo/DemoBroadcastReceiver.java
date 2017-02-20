package com.skyzone.netdemomvp.BroadcastDemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.elvishew.xlog.XLog;

/**
 * Created by Skyzone on 2/20/2017.
 */

public class DemoBroadcastReceiver extends BroadcastReceiver {

    public static final String TAG = DemoBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(BroadcastActivityA.ACTION_DEMO)) {
            XLog.d("get broadcast from single class:" + TAG + " msg:" + intent.getStringExtra("msg"));

            //接受来自上一层修改后的信息
            if (isOrderedBroadcast()) {
                Bundle b = getResultExtras(true);
                XLog.d("get modify info:" + b.getString("msg"));
            }
        }
    }
}
