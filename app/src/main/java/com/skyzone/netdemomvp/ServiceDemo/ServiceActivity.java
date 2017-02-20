package com.skyzone.netdemomvp.ServiceDemo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.skyzone.netdemomvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Skyzone on 2/20/2017.
 */

public class ServiceActivity extends AppCompatActivity {

    @BindView(R.id.activity_service_bt_down_load)
    Button mActivityServiceBtDownLoad;
    @BindView(R.id.activity_service_bt_cancel)
    Button mActivityServiceBtCancel;

    private Context mContext;
    private Intent mIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        ButterKnife.bind(this);

        this.mContext = this;
    }

    @OnClick({R.id.activity_service_bt_down_load, R.id.activity_service_bt_cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_service_bt_down_load:
                mIntent = new Intent(mContext, DownLoadService.class);
                mIntent.setData(Uri.parse(""));
                mContext.startActivity(mIntent);
                break;
            case R.id.activity_service_bt_cancel:
                break;
        }
    }
}
