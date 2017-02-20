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

/**
 * Created by Skyzone on 2/20/2017.
 */

public class BroadcastActivityA extends AppCompatActivity {

    public static final String ACTION_DEMO = "action_demo";

    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView tv_a = new TextView(this);
        tv_a.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        tv_a.setBackgroundColor(Color.WHITE);
        tv_a.setText("Activity A");
        tv_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mintent = new Intent();
                mintent.setAction("intent_filter_action_demo");
                if (mintent.resolveActivity(getPackageManager()) != null)
                    startActivity(mintent);
            }
        });
        setContentView(tv_a);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter mFilter = new IntentFilter();
        mFilter.addAction(ACTION_DEMO);
        registerReceiver(mReceiver, mFilter);
        mContext = this;

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        //发送普通广播(优点：完全异步，消息传递效率高；缺点：不能中断，不能只传给一个接受者)
                        Intent mIntent = new Intent();
                        mIntent.setAction(ACTION_DEMO);
                        mIntent.putExtra("msg", "msg from normal broadcast");
                        mContext.sendBroadcast(mIntent);

                        //发送有序广播(优点：可以设置优先级接受广播，可以中断广播，可以处理后再传送给下一层)
                        Intent mIntent_order = new Intent();
                        mIntent_order.setAction(ACTION_DEMO);
                        mIntent_order.setPackage(getPackageName());
                        mIntent_order.putExtra("msg", "msg from ordered broadcast");
                        mContext.sendOrderedBroadcast(mIntent_order, null);
                    }
                }
        ).start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);
    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(ACTION_DEMO)) {
                String msg = intent.getStringExtra("msg");
                XLog.d("received broadcast:" + msg + " in main thread:" + Thread.currentThread());
            }
        }
    };
}
