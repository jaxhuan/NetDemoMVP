package com.skyzone.netdemomvp.BroadcastDemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.elvishew.xlog.XLog;

/**
 * Created by Skyzone on 2/20/2017.
 */

public class BroadcastActivityC extends AppCompatActivity {

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(BroadcastActivityA.ACTION_DEMO)) {
                XLog.d("Activity C get msg:" + intent.getStringExtra("msg"));

            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView tv_a = new TextView(this);
        tv_a.setText("Activity C");
        tv_a.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        tv_a.setBackgroundColor(Color.WHITE);
        setContentView(tv_a);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter mFilter = new IntentFilter();
        mFilter.addAction(BroadcastActivityA.ACTION_DEMO);
        registerReceiver(mReceiver, mFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);
    }
}
