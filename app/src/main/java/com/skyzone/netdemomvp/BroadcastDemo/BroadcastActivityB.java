package com.skyzone.netdemomvp.BroadcastDemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.elvishew.xlog.XLog;

import static com.skyzone.netdemomvp.App.mContext;

/**
 * Created by Skyzone on 2/20/2017.
 */

public class BroadcastActivityB extends AppCompatActivity {

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(BroadcastActivityA.ACTION_DEMO)) {
                XLog.d("Activity B get msg:" + intent.getStringExtra("msg"));
            }

            if (isOrderedBroadcast()) {
                Bundle b = new Bundle();
                b.putString("msg", intent.getStringExtra("msg") + "from Activity B");
                setResultExtras(b);

//                abortBroadcast();  //取消broadcast的继续发送
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView tv_a = new TextView(this);
        tv_a.setText("Activity B");
        tv_a.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        tv_a.setBackgroundColor(Color.WHITE);
        tv_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, BroadcastActivityC.class));
            }
        });
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
